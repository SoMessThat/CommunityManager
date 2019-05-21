package mess.wkb.cm.code.service;



import static java.util.Locale.ENGLISH;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import mess.wkb.cm.code.dao.BaseDAO;
import mess.wkb.cm.tool.bean.Paged;
import mess.wkb.cm.tool.bean.Query;
import mess.wkb.cm.tool.util.ClassUtil;
import mess.wkb.cm.tool.util.ColumnUtils;
import mess.wkb.cm.tool.util.ObjectUtil;
import mess.wkb.cm.tool.web.MysqlDBException;

/**
 * User: wkb
 * Date: 13-11-19
 * Time: 上午9:13
 */
public class BaseService<T> implements ApplicationContextAware{

    private final static Logger logger = LoggerFactory.getLogger(BaseService.class);

    protected Class<T> t;
    private ApplicationContext applicationContext;

    public BaseService() {
        Class<T> type = ClassUtil.getActualType(this.getClass());
        if (type == null) throw new RuntimeException("继承类没有加泛型!");
        this.t = type;
    }

    /**
     * 获取条件总条数
     * @param query
     * @return
     */
    public int count(Query<T> query) {
        return getDAO().count(query);
    }
    
    /**
     * 插入对象
     * @param obj
     * @return
     */
    public T insert(T obj) throws MysqlDBException{
    	try {
//    		getDAO().insert(obj);
    		return obj;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("insert -- 数据库操作异常");
			throw new MysqlDBException("insert -- 数据库操作异常");
		}
    }

    /**
     * 获取单个 Integer 主键
     * @param id
     * @return
     */
    @SuppressWarnings("unchecked")
	public T get(Integer id){
        if (id == null) return null;
        try {
            Query<T> query = Query.build(t);
            query.addEq(ColumnUtils.getIdFieldName(t),id);
            List<T> objects = findByQuery(query);
            if (objects.size() > 0) {
                return objects.get(0);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    
    /**
     * 获取单个 String 主键
     * @param strId
     * @return
     */
    @SuppressWarnings("unchecked")
	public T get(String strId){
        if (strId == null) return null;
        try {
            Query<T> query = Query.build(t);
            query.addEq(ColumnUtils.getPrimaryKeyFieldName(t),strId);
            List<T> objects = findByQuery(query);
            if (objects.size() > 0) {
                return objects.get(0);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    

    public T get(Query<T> query){
        List<Map<String,Object>> list = getDAO().findByQuery(query);
        List<T> objects = ObjectUtil.toBeanList(t, list);
        if (objects.size() > 0) return objects.get(0);
        return null;
    }

	@SuppressWarnings("unchecked")
	public void delete(Integer id) throws MysqlDBException{
        try {
            Query<T> query = Query.build(t);
            query.addEq(ColumnUtils.getIdFieldName(t),id);
            getDAO().deleteByQuery(query);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("delete -- 数据库操作异常");
			throw new MysqlDBException("delete -- 数据库操作异常");
        }
    }

   	@SuppressWarnings("unchecked")
	public void delete(String strId) throws MysqlDBException{
       try {
           Query<T> query = Query.build(t);
           query.addEq(ColumnUtils.getPrimaryKeyFieldName(t),strId);
           getDAO().deleteByQuery(query);
       }catch (Exception e){
           e.printStackTrace();
           logger.error("delete -- 数据库操作异常");
           throw new MysqlDBException("delete -- 数据库操作异常");
       }
   }
    
    public void update(T obj) throws MysqlDBException{
        try {
            getDAO().update(obj);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("update -- 数据库操作异常");
			throw new MysqlDBException("update -- 数据库操作异常");
        }
    }

    public void delete(T obj) throws MysqlDBException{
        try {
            getDAO().delete(obj);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("delete -- 数据库操作异常");
            throw new MysqlDBException("delete -- 数据库操作异常");
        }
    }

    public void delete(Query<T> query) throws MysqlDBException{
        try {
            getDAO().deleteByQuery(query);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("delete -- 数据库操作异常");
            throw new MysqlDBException("delete -- 数据库操作异常");
        }
    }

    /**
     * 查询所有的
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<T> findAll(){
        try {
            Query<T> query = Query.build(t);
            List<T> objects = findByQuery(query);
            return objects;
        }catch (Exception e){
            e.printStackTrace();
        }
        return Collections.emptyList();
    }


    public List<T> findByQuery(Query<T> query){
        try {
            List<Map<String,Object>> list = getDAO().findByQuery(query);
            List<T> objects = ObjectUtil.toBeanList(t, list);
            return objects;
        }catch (Exception e){
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
    
    public List<String[]> findExpByQuery(Query<T> query,String[] columnProperty){
        try {
            List<Map<String,Object>> list = getDAO().findByQuery(query);
            List<String[]> objects = ObjectUtil.toBeanList(columnProperty, list);
            return objects;
        }catch (Exception e){
            e.printStackTrace();
        }
        return Collections.emptyList();
    }


    /**
     * 获取分页数据
     * @param query
     * @return
     */
    public Paged<T> findPagedByQuery(Query<T> query){
        List<T> objects = findByQuery(query);
        int count = getDAO().count(query);     
        return new Paged<T>(objects ,count ,query.getPageNo() ,query.getPageSize(),true);
    }

    @SuppressWarnings("unchecked")
	protected BaseDAO<T> getDAO(){
        String daoName = lowerTop(t.getSimpleName()) +"DAO";
        if (applicationContext.containsBean(daoName)) {
            Object dao =  applicationContext.getBean(daoName);
            if (dao != null ) {
                return (BaseDAO<T>)dao;
            }else {
                logger.error("bean not exist by name:"+ daoName);
            }

        }else {
            logger.error("bean not exist by name:"+ daoName);
        }
        return null;
    }



    /**
     * Returns a String which capitalizes the first letter of the string.
     */
    public static String lowerTop(String name) {
        if (name == null || name.length() == 0) {
            return name;
        }
        name = name.replace("PO", "");
        return name.substring(0, 1).toLowerCase(ENGLISH) + name.substring(1);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
