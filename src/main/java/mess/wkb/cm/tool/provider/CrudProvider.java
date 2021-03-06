package mess.wkb.cm.tool.provider;





import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mess.wkb.cm.tool.annotation.Column;
import mess.wkb.cm.tool.annotation.Id;
import mess.wkb.cm.tool.annotation.PrimaryKey;
import mess.wkb.cm.tool.annotation.SortColumn;
import mess.wkb.cm.tool.annotation.Table;
import mess.wkb.cm.tool.annotation.UnColumn;
import mess.wkb.cm.tool.bean.Query;
import mess.wkb.cm.tool.util.ClassUtil;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.tool.util.StringUtil;
import mess.wkb.cm.tool.util.UUIDUtil;

/**
 * 默认的CRUD
 * User: wangj
 * Date: 13-11-8
 * Time: 上午9:32
 */
public class CrudProvider<T> {
    private static final Logger logger = LoggerFactory.getLogger(CrudProvider.class);


    /**
     * 执行查询
     * @param query
     * @return
     * @throws Exception
     */
    public String findByQuery(Query<T> query) throws Exception {
        T obj = ObjectUtil.toBean(query.getType(), query.getParams());
        ObjectUtil.addToBean(obj ,query.getType()  ,query.getParamLikes());
        ObjectUtil.addToBean(obj ,query.getType()  ,query.getLtParams());
        ObjectUtil.addToBean(obj ,query.getType()  ,query.getGtParams());
        return findPageByObject(obj ,query);
    }


    /**
     * 执行删除操作
     */
    public String deleteByQuery(Query<T> query)throws Exception  {
        T obj = ObjectUtil.toBean(query.getType() , query.getParams());
        ObjectUtil.addToBean(obj ,query.getType()  ,query.getParamLikes());
        ObjectUtil.addToBean(obj ,query.getType()  ,query.getLtParams());
        ObjectUtil.addToBean(obj ,query.getType()  ,query.getGtParams());

        SQL sql = new SQL();
        sql.DELETE_FROM(obtainTableName(obj.getClass()));

        List<String> whereConditions = buildWhereCommands(obj , query);
        if (whereConditions.size() == 0) {
            throw new RuntimeException("condition is empty,can't delete");
        }

        for (String str : whereConditions) {
            sql.WHERE(str);
        }
        if (logger.isDebugEnabled()) {
            logger.debug("sql is:" +sql.toString());
        }
        return sql.toString();
    }

    /**
     * 执行统计,用于分页
     * @param query
     * @return
     * @throws Exception
     */
    public String count(Query<T> query) throws Exception {
        T obj = ObjectUtil.toBean(query.getType() , query.getParams());
        ObjectUtil.addToBean(obj ,query.getType()  ,query.getParamLikes());
        ObjectUtil.addToBean(obj ,query.getType()  ,query.getLtParams());
        ObjectUtil.addToBean(obj ,query.getType()  ,query.getGtParams());

        return count(obj ,query);

    }



    protected String buildColumnCommand(Query<T> query , Field field) {
        String expression = query.getExpression(field.getName());
        String objPrefix = query.getExpressionParam(field.getName());
        if (objPrefix == null) {
            return (getColumnName(field)  + expression +"#{" + field.getName() + "}");
        }else {
            return (getColumnName(field)  + expression +"#{" +objPrefix+"."+ field.getName() + "}");
        }
    }

    protected List<String> buildInCommands(Query<T> query) {
        List<String> list = new ArrayList<String>();

        for (String fieldName : query.getInArrayParams().keySet()) {
            if (ObjectUtil.isEmpty(query.getInArrayParams().get(fieldName))) {
                continue;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(getColName(query.getType(), fieldName));
            sb.append(" in (");

            StringBuilder innerStr = new StringBuilder();
            for (int i = 0; i< query.getInArrayParams().get(fieldName).size();i++) {
                innerStr.append("#{").append("inArrayParams.").append(fieldName).append("[").append(i).append("]}") .append(",");
            }
            sb.append(innerStr.substring(0 , innerStr.length() -1)).append(")");
            list.add(sb.toString());
        }

        return list;
    }

    protected List<String> buildBetweenCommands(Query<T> query) {
        List<String> list = new ArrayList<String>();

        for (String fieldName : query.getBetweens().keySet()) {
            if (query.getBetweens().get(fieldName).getBegin() == null ||
                    query.getBetweens().get(fieldName).getEnd() == null) {
                continue;
            }

            StringBuilder sb = new StringBuilder();
            sb.append(getColName(query.getType(), fieldName));
            sb.append(" between ");
            sb.append(" #{").append("betweens.").append(fieldName).append(".begin}");
            sb.append(" and ");
            sb.append(" #{").append("betweens.").append(fieldName).append(".end}");
            list.add(sb.toString());
        }

        return list;
    }

    protected List<String> buildWhereCommands (T obj ,Query<T> query) throws Exception {
        List<String> list = new ArrayList<String>();
        list.addAll(buildBetweenCommands(query));
        list.addAll(buildInCommands(query));

        if (obj == null) {
            return list;
        }

        for(Field field : obj.getClass().getDeclaredFields()) {
            if (skipField(obj , field)) {
                continue;
            }
            String columnCommand = buildColumnCommand(query, field);
            if (StringUtil.isNotEmpty(columnCommand)) {
                list.add(buildColumnCommand(query, field));
            }
        }
        return list;
    }


    public String count(T obj ,Query<T> query) throws Exception {
        SQL sql = new SQL();

        sql.SELECT("count(1)");
        sql.FROM(obtainTableName(obj.getClass()));

        for (String str : buildWhereCommands(obj ,query)) {
            sql.WHERE(str);
        }

        if (logger.isDebugEnabled()) {
            logger.debug(sql.toString());
        }
        return sql.toString();
    }

    /**
     * 查询对象
     * @param obj
     * @return
     * @throws Exception
     */
    public String findPageByObject(T obj ,Query<T> query)  throws Exception{
        SQL sql = new SQL();

        StringBuilder cols = new StringBuilder();
        for(Field field : obj.getClass().getDeclaredFields()) {
            if (!ClassUtil.isProperty(obj.getClass(), field.getName())) {
                continue;
            }

            if (field.getAnnotation(UnColumn.class) != null) {
                continue;
            }


            if (!query.hasOrder()) {
                String sortField = getSortColumnName(field);
                if (sortField != null) {
                    sql.ORDER_BY(sortField + " DESC");
                }
            } else {
                Query.DBOrder dbOrder = query.getOrders().get(field.getName());
                if (dbOrder != null) {
                    sql.ORDER_BY(getColumnName(field)+ " " +dbOrder.getName());
                }
            }

            if (query.isSearchAllField() || query.isFieldSearch(field.getName())) {
                String columnName = getColumnName(field);
                cols.append(columnName + " as "+field.getName() + ",");
            }

        }

        sql.SELECT(cols.toString().substring(0,cols.length()-1));
        sql.FROM(obtainTableName(obj.getClass()));

        for (String str : buildWhereCommands(obj ,query)) {
            sql.WHERE(str);
        }

        String sqlCommand ;
        if (query.getOffset() >= 0) {
            sqlCommand = sql.toString() + " limit #{offset},#{pageSize}";
        }else {
            sqlCommand = sql.toString();
        }
        if (logger.isDebugEnabled()) {
            logger.debug(sqlCommand);
        }
        return sqlCommand;
    }
    
    /**
     * 删除对象
     * @param obj
     * @return
     */
    public String delete(T obj) {
        String idName = obtainIdName(obj.getClass());
        String idPro = null;
        SQL sql = new SQL();
        if(idName == null){
        	 for(Field field : obj.getClass().getDeclaredFields()) {
        		 PrimaryKey pkField = field.getAnnotation(PrimaryKey.class);
        		 if (pkField != null) {
        			 idName = getColumnName(field);
        			 idPro = field.getName();
        			 break;
        		 }
        	 }
         	sql.DELETE_FROM(obtainTableName(obj.getClass()));
         	sql.WHERE(idName + "=#{" + idPro + "}");
        }else{
        	sql.DELETE_FROM(obtainTableName(obj.getClass()));
        	sql.WHERE(idName + "=#{" + idName + "}");
        }
        
        return sql.toString();
    }

    /**
     * 获取单个对象
     * @param obj
     * @return
     */
    public String get(T obj) {
        String idName = obtainIdName(obj.getClass());
        String idPro = null;
        SQL sql = new SQL();
        if(idName == null){
        	 for(Field field : obj.getClass().getDeclaredFields()) {
        		 PrimaryKey pkField = field.getAnnotation(PrimaryKey.class);
        		 if (pkField != null) {
        			 idName = getColumnName(field);
        			 idPro = field.getName();
        			 break;
        		 }
        	 }
        	 sql.SELECT(getColumns(obj.getClass()));
             sql.FROM(obtainTableName(obj.getClass()));
             sql.WHERE(idName + "=#{" + idPro + "}");
        }else{
        	sql.SELECT(getColumns(obj.getClass()));
            sql.FROM(obtainTableName(obj.getClass()));
            sql.WHERE(idName + "=#{" + idName + "}");
        }
        
        return sql.toString();
    }


    @SuppressWarnings("rawtypes")
	private String getColumns(Class clz) {
        StringBuilder cols = new StringBuilder();
        for(Field field : clz.getDeclaredFields()) {
            String columnName = getColumnName(field);
            cols.append(columnName + ",");
        }

        return  cols.toString().substring(0,cols.length()-1);
    }

    /**
     * 保存对象
     * @param obj
     * @return
     * @throws Exception
     */
    public String saveOrUpdate(T obj) throws Exception{
        String sql ;
        if (!isIdExist(obj)) {
            sql = insert(obj);
        }else {
            sql = update(obj);
        }
        return sql;
    }

    /**
     * 更新对象
     * @param obj
     * @return
     * @throws Exception
     */
    public String update(T obj) throws Exception{
        SQL sql =  new SQL();
        sql.UPDATE(obtainTableName(obj.getClass()));

        String idName = "";
        String idFieldName = "";

        for(Field field : obj.getClass().getDeclaredFields()) {
            Id idField = field.getAnnotation(Id.class);
            if (idField != null) {
                idName = idField.value();
                idFieldName = field.getName();
                continue;
            }
            PrimaryKey pkField = field.getAnnotation(PrimaryKey.class);
            if (pkField != null) {
                idName = getColumnName(field);
                idFieldName = field.getName();
                continue;
            }
            if (skipField(obj , field)) {
                continue;
            }

            sql.SET(getColumnName(field) + "=#{" + field.getName() + "}");
        }

        sql.WHERE(idName + "=#{" + idFieldName + "}");

        if (logger.isDebugEnabled()) {
            logger.debug(sql.toString());
        }
        
        return sql.toString();
    }

    /**
     * 新增对象
     * @param obj
     * @return
     * @throws Exception
     */
    public String insert(T obj) throws Exception{
        SQL sql =  new SQL();
        sql.INSERT_INTO(obtainTableName(obj.getClass()));
        StringBuilder cols = new StringBuilder();
        StringBuilder values = new StringBuilder();
        for(Field field : obj.getClass().getDeclaredFields()) {
            if (skipField(obj , field)) continue;
            cols.append(getColumnName(field)+",");
            if(isPrimaryKeyColumnName(field)){
            	String value = BeanUtils.getProperty(obj , field.getName());
                if (value == null) {
                	values.append("'"+UUIDUtil.getUUID()+"',");
                } else {
                	values.append("'"+value+"',");
                }
            }else{
            	values.append("#{" + field.getName() + "},");
            }
        }
    	sql.VALUES(cols.toString().substring(0, cols.length() - 1),
    			values.toString().substring(0, values.length() - 1));
        if (logger.isDebugEnabled()) {
            logger.debug(sql.toString());
        }
        return sql.toString();
    }
    

    public  <M> String getColName(Class<M> clazz , String fieldName) {
        for(Field field : clazz.getDeclaredFields()) {
            String columnName = getColumnName(field);
            if (fieldName == field.getName()) {
                return columnName;
            }
        }
        throw new RuntimeException("fieldName :" +fieldName+" not find ");
    }

    
    
    protected String getPrimaryKeyColumnName(Field[]  fields) {
    	PrimaryKey pkColumn = null;
    	for(Field field : fields){
    		pkColumn = field.getAnnotation(PrimaryKey.class);
    		if (pkColumn != null && !StringUtils.isEmpty(pkColumn.value())) {
    			return pkColumn.value();
    		}
    	}
        return null;
    }
    
    protected boolean isPrimaryKeyColumnName(Field  field) {
    	PrimaryKey pkColumn = null;
		pkColumn = field.getAnnotation(PrimaryKey.class);
		if (pkColumn != null) {
			return true;
		}
        return false;
    }


    protected String getColumnName(Field  field) {
        Column column = field.getAnnotation(Column.class);
        SortColumn sortColumn = field.getAnnotation(SortColumn.class);
        Id idField = field.getAnnotation(Id.class);
        PrimaryKey pkField = field.getAnnotation(PrimaryKey.class);
        if (column != null && !StringUtils.isEmpty(column.value())) {
            return column.value();
        } if (sortColumn != null && !StringUtils.isEmpty(sortColumn.value())) {
            return sortColumn.value();
        } else if (idField != null  && !StringUtils.isEmpty(idField.value())) {
            return idField.value();
        } else if (pkField != null  && !StringUtils.isEmpty(pkField.value())) {
            return pkField.value();
        } else {
            // 约定：sysId > SYS_ID
            String propName = field.getName();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < propName.length(); i ++) {
                char c = propName.charAt(i);
                if (Character.isUpperCase(c)) {
                    builder.append('_').append(c);
                }
                else {
                    builder.append(Character.toUpperCase(c));
                }
            }
            return builder.toString();
        }
    }

    protected String getSortColumnName(Field  field) {
        SortColumn sortColumn = field.getAnnotation(SortColumn.class);
        if (sortColumn != null) {
            if (StringUtils.isEmpty(sortColumn.value())) {
                return field.getName();
            }else {
                return sortColumn.value();
            }
        }
        return null;
    }




    private boolean isIdExist(T obj) {
        for(Field field : obj.getClass().getDeclaredFields()) {
            Id idField = field.getAnnotation(Id.class);
            if (idField != null) {
                try {
                    String value = BeanUtils.getProperty(obj, field.getName());
                    if (value != null) {
                        return true;
                    }
                }catch (Exception e) {
                    logger.error("get id prop error!",e);
                }
            }
            PrimaryKey pkField = field.getAnnotation(PrimaryKey.class);
            if (pkField != null) {
                try {
                    String value = BeanUtils.getProperty(obj, field.getName());
                    if (value != null) {
                        return true;
                    }
                }catch (Exception e) {
                    logger.error("get id prop error!",e);
                }
            }
        }
        return false;
    }

    public String obtainTableName(Class<?> clazz) {
        Table table = clazz.getAnnotation(Table.class);
        if(table != null)
            return table.value();
        else
            throw new RuntimeException("undefine POJO @Table, need Tablename(@Table)");
    }

    /**
     * 获取POJO对应的主键名称
     * 需要POJO中的属性定义@Id
     * @return
     */
    public String obtainIdName(Class<?> clazz) {
        for(Field field : clazz.getFields()) {
            if(field.isAnnotationPresent(Id.class))
                return field.getName();
        }
        return null;
    }
    
   
    /**
     * 判断对象是否包含这个属性/字段
     * @param obj
     * @param field
     * @return
     */
    protected boolean skipField(T obj ,Field field) {
        try {
        	//通过反射得到对象 obj 的 field 字段的值
            UnColumn unColumn = field.getAnnotation(UnColumn.class);
            if (unColumn != null) {
                return true;
            }
           
            //判断属性是否存在
            if (!ClassUtil.isProperty(obj.getClass(), field.getName())) {
                return true;
            }
            String value = BeanUtils.getProperty(obj , field.getName());
            if (value == null) {
                return true;
            }
            PrimaryKey pkColumn = field.getAnnotation(PrimaryKey.class);
    		if (pkColumn != null) {
    			return false;
    		}
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
