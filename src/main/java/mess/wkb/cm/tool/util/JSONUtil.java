package mess.wkb.cm.tool.util;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @Description: 处理json数据的工具类
 * @Copyright: 福州骏华信息有限公司 (c)2012
 * @Created Date : 2012-10-27
 * @author lys
 * @vesion 1.0
 */
public class JSONUtil{
	public static final String EMPTYJSON = "{\"rows\":[],\"total\":0}";
	public static final String EMPTY_COMBOBOX_JSON = "[]";
	
	public static final String NO_RIGHT_JSON = "{\"message\":\"对不起，您没有操作权限\",\"isSuccess\":false}";
	public static final String NOT_LOGIN_JSON= "{\"message\":\"请登录独立密码\",\"isSuccess\":false}";
	
	/**
	 * @Description: 将List型数据转化成Json数据
	 * @Create: 2012-10-27 上午10:26:14
	 * @author lys
	 * @update logs
	 * @param list
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static String toJson(List list){
		JSONArray jsonArray = JSONArray.fromObject(list);
		return jsonArray.toString();
	}
	
	
//	/**
//	 * 
//	 * @description: 
//	 * @createTime: 2018年8月13日 上午11:37:16
//	 * @author: huang.weikun
//	 * @param jsonStr
//	 * @return
//	 */
//	@SuppressWarnings("deprecation")
//	public static List<SysRolePO> JsonToObject(String jsonStr){
//		@SuppressWarnings("unchecked")
//		List<SysRolePO> list=(List<SysRolePO>)JSONArray.toList(JSONArray.fromObject(jsonStr), SysRolePO.class);
//		return list;
//	}
//	/**
//	 * 将List<SysPermissionPo>型数据转化成Json数据
//	 * @createTime: 2018年8月15日 下午4:23:30
//	 * @author: wu.kaibin
//	 * @param jsonStr
//	 * @return
//	 */
//	@SuppressWarnings("deprecation")
//	public static List<SysPermissionPO> JsonToSysPermission(String jsonStr){
//		@SuppressWarnings("unchecked")
//		List<SysPermissionPO> list=(List<SysPermissionPO>)JSONArray.toList(JSONArray.fromObject(jsonStr), SysPermissionPO.class);
//		return list;
//	}
//	
	
	
	
	/**
	 * @Description: 将List型数据转化成Json数据,并指定要选取的属性 
	 * @Create: 2012-10-27 上午10:48:13
	 * @author lys
	 * @update logs
	 * @param list
	 * @param filterList
	 * @return
	 * @throws Exception
	 */
//	@SuppressWarnings("rawtypes")
//	public static String toJsonWithoutRows(List list,List<String> propertyList){
//		JsonConfig jsonConfig = new JsonConfig();
//		jsonConfig.setJsonPropertyFilter(new JSONPropertyFilter(propertyList));
//		JSONArray jsonArray = JSONArray.fromObject(list, jsonConfig);
//		String result = jsonArray.toString();
//		return result;
//	}
	
	/**
	 * @Description: 将List型数据转化成Json数据,并指定要选取的属性 ( easyui datagrid中使用)
	 * @Create: 2012-10-28 上午9:25:48
	 * @author lys
	 * @update logs
	 * @param list
	 * @param total
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static String toJson(List list,Long total){
		JSONArray jsonArray = JSONArray.fromObject(list);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", total);
		map.put("rows", jsonArray);
		String result = JSONObject.fromObject(map).toString();
		return result;
	}
	/**
	 * @Description: 取得list的json字符串(带rows)
	 * @Create: 2012-12-29 下午6:23:29
	 * @author lys
	 * @update logs
	 * @param list
	 * @param properties
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String toJson(List list,String[] properties){
		JSONObject object = new JSONObject();
		object.put("rows", toJsonWithoutRows(list,properties));
		return object.toString();
	}
	
	/**
	 * @description: 取得list的json(带rows)
	 * @createTime: 2018年8月15日 下午3:53:43
	 * @author: huang.weikun
	 * @param list
	 * @param properties
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static JSONObject toJsonObject(List list,String[] properties){
		JSONObject object = new JSONObject();
		object.put("code", 0);
		object.put("msg", "");
		object.put("count", list.size());
		object.put("data", toJsonWithoutRows(list,properties));
		return object;
	}
	/**
	 * @description: 取得list的json(带rows)
	 * @createTime: 2018年8月15日 下午4:25:06
	 * @author: wu.kaibin
	 * @param list
	 * @param properties
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static JSONObject SysPermissiontoJsonObject(List list,String[] properties){
		JSONObject object = new JSONObject();
		object.put("code", 0);
		object.put("msg", "");
		object.put("count", list.size());
		object.put("data", toJsonWithoutRows(list,properties));
		return object;
	}
	
	
	
	/**
	 * @Description: 取得list的json字符串(不带rows)
	 * @Create: 2012-12-29 下午6:24:53
	 * @author lys
	 * @update logs
	 * @param list
	 * @param properties
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	public static String toJsonWithoutRows(List list,String[] properties){
		JSONArray array = new JSONArray();
		for (Object t : list) {
			array.add(toJSONObject(t, properties));
		}
		return array.toString();
	}
	/**
	 * @Description: 取得list的json字符串(带rows+total)
	 * @Create: 2012-12-29 下午6:26:43
	 * @author lys
	 * @update logs
	 * @param list
	 * @param properties
	 * @param total
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String toJson(List list, String[] properties,
			Long total) {
		JSONObject object = new JSONObject();
		String rows = JSONUtil.toJsonWithoutRows(list, properties);
		object.put("rows", rows);
		object.put("total", total);
		return object.toString();
	}
	/**
	 * @Description: 取得对象的json字符串
	 * @Create: 2013-1-8 下午10:35:55
	 * @author lys
	 * @update logs
	 * @param object
	 * @return
	 * @throws Exception 
	 */
	public static String toJson(Object object,String[] properties){
		return toJSONObject(object,properties).toString();
	}
	
	/**
	 * @Description: 转化成JSONObject
	 * @Create: 2013-1-8 下午11:07:46
	 * @author lys
	 * @update logs
	 * @param object
	 * @param properties
	 * @return
	 * @throws Exception
	 */
	public static JSONObject toJSONObject(Object object,String[] properties){
		JSONObject item = new JSONObject();
		try {
			for(String property : properties){
				/*
				 * 处理property 
				 * property的规则是:
				 * 如果包含有：这说明指定了key的别名
				 * 
				 * 如果没有则key的名称，要最后一个.后的名称为key
				 */
				String key = null;
				if(property.contains(":")){
					 key = StringUtils.substringAfter(property, ":");
					 property =  StringUtils.substringBefore(property, ":");
				}else{
					if(property.contains(".")){
						 key =  StringUtils.substringAfterLast(property, ".");
					}else{
						key = property;
					}
				}
				if(property.contains(".")){
					String propertyPrefix = "";
					String propertySuffix = property;
					
					boolean canGetProperty = true;
					/*
					 * 判读.前的属性是否为null，如果为null，则不能读取该属性
					 * 如果不为null，则需截取.后的属性，继续相同判断，直到最后截取的属性中不含有.
					 */
					String haveTestStr = "";
					while(propertySuffix.contains(".")){
						propertyPrefix = StringUtils.substringBefore(propertySuffix, ".");
						if(BeanUtils.getProperty(object, haveTestStr+propertyPrefix)==null){
							canGetProperty = false;
							break;
						}
						haveTestStr+=propertyPrefix+".";;
						propertySuffix = StringUtils.substringAfter(propertySuffix, ".");
					}
					if(canGetProperty){
						item.put(key, BeanUtils.getProperty(object, property));
					}
				}else{
					item.put(key, BeanUtils.getProperty(object, property));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}
	/**
	 * @Description: 从Map中取得json数据
	 * @Create: 2014-7-30 上午9:04:20
	 * @author lys
	 * @update logs
	 * @param map
	 * @return
	 */
	public static String toJsonFromMap(Map<String, Object> map){
		if(map==null){
			return EMPTYJSON;
		}
		JSONObject item = null;
		Set<String> keySet = map.keySet();
		try {
			item = new JSONObject();
			Object value = null;
			for(String key : keySet){
				value = map.get(key);
				item.put(key, value);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item.toString();
	}
	/**
	 * @Description: 将List<Map>数据转化成json数据
	 * @Create: 2013-1-11 下午11:04:41
	 * @author lys
	 * @update logs
	 * @param listMap
	 * @return
	 */
	public static String toJsonFromListMap(List<Map<String, Object>> listMap) {
		if(listMap==null||listMap.size()==0){
			return EMPTYJSON;
		}
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject item = null;
		Set<String> keySet = listMap.get(0).keySet();
		try {
			for (Map<String,Object> map : listMap) {
				item = new JSONObject();
				Object value = null;
				for(String key : keySet){
					value = map.get(key);
					item.put(key, value);
				}
				array.add(item);
			}
			object.put("rows", array);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object.toString();
	}
	/**
	 * @Description: 将List<Map>数据转化成json数据(不带rows)
	 * @Create: 2013-1-11 下午11:04:41
	 * @author lys
	 * @update logs
	 * @param listMap
	 * @return
	 */
	public static String toJsonFromListMapWithOutRows(List<Map<String, Object>> listMap) {
		if(listMap==null||listMap.size()==0){
			return EMPTYJSON;
		}
		JSONArray array = new JSONArray();
		JSONObject item = null;
		Set<String> keySet = listMap.get(0).keySet();
		try {
			for (Map<String,Object> map : listMap) {
				item = new JSONObject();
				Object value = null;
				for(String key : keySet){
					value = map.get(key);
					item.put(key, value);
				}
				array.add(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return array.toString();
	}
	
	/**
	 * @Description: 将List<Map> total数据转化成json数据
	 * @Create: 2013-1-11 下午11:04:41
	 * @author lys
	 * @update logs
	 * @param listMap
	 * @return
	 */
	public static String toJsonFromListMap(List<Map<String, Object>> listMap,Long total) {
		if(listMap==null||listMap.size()==0){
			return EMPTYJSON;
		}
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject item = null;
		Set<String> keySet = listMap.get(0).keySet();
		try {
			for (Map<String,Object> map : listMap) {
				item = new JSONObject();
				Object value = null;
				for(String key : keySet){
					value = map.get(key);
					if(value instanceof Date){
						item.put(key, value.toString());
					}else{
						item.put(key, value);
					}
				}
				array.add(item);
			}
			object.put("rows", array);
			object.put("total", total);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object.toString();
	}

	public static String toJson(Map<String, Object> map) {
		return JSONObject.fromObject(map).toString();
	}
	/**
	 * 
	 * @Description: 将List<Map> total数据转化成json数据（rows,footer）
	 * @Create: 2015-1-5 上午11:17:48
	 * @author yk
	 * @update logs
	 * @param listMap
	 * @param footerListMap
	 * @return
	 */
	public static String toJsonFromListMapFooter(List<Map<String, Object>> listMap,Map<String, Object> footerMap) {
		if(listMap==null||listMap.size()==0){
			return EMPTYJSON;
		}
		JSONObject object = new JSONObject();
		JSONArray array = new JSONArray();
		JSONArray footerArray = new JSONArray();
		JSONObject item = null;
		Set<String> keySet = listMap.get(0).keySet();
		Set<String> footerKeySet = footerMap.keySet();
		try {
			for (Map<String,Object> map : listMap) {
				item = new JSONObject();
				Object value = null;
				for(String key : keySet){
					value = map.get(key);
					item.put(key, value);
				}
				array.add(item);
			}
			item = new JSONObject();
			Object value = null;
			for(String key : footerKeySet){
				value = footerMap.get(key);
				item.put(key, value);
			}
			footerArray.add(item);
			object.put("rows", array);
			object.put("footer", footerArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object.toString();
	}
	
}
