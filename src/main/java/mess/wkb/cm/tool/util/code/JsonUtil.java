package mess.wkb.cm.tool.util.code;





import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 类工具.
 * 
 * @author qingwu
 * @date 2014-2-7 下午5:04:50
 */
public class JsonUtil {

	/**
	 * json转对象.
	 * 
	 * @param json
	 * @param obj
	 * @author qingwu
	 * @date 2014-2-7 下午5:07:31
	 */
	public static <T> void jsonToObject(JSONObject json, T obj) {
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				Object value = null;
				String fieldName = field.getName();
				if (fieldName.equals("class")
						|| fieldName.equals("serialVersionUID")) {
					continue;
				}
				if (json.isNull(fieldName) == true) {
					continue;
				}
				String fieldType = field.getType().getName();
				if ("java.lang.String".equals(fieldType)) {// 字符串类型
					value = json.getString(fieldName);
				} else if ("java.sql.Timestamp".equals(fieldType)) {// 时间类型
					value = json.getString(fieldName);
					SimpleDateFormat sdf = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					Date date = sdf.parse(value.toString());
					value = new java.sql.Timestamp(date.getTime());
				} else if ("java.lang.Long".equals(fieldType)) {// 数字类型
					value = json.getLong(fieldName);
				}
				if (value != null) {
					setFieldValue(obj, fieldName, value);
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 执行某个对象的方法.
	 * 
	 * @param owner 对象
	 * @param methodName  方法名称
	 * @param args  方法参数
	 * @return
	 * @throws Exception
	 * @author qingwu
	 * @date 2014-2-7 下午5:07:31
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object invokeMethod(Object owner, String methodName,
			Object[] args) throws Exception {
		Class ownerClass = owner.getClass();
		Class[] argsClass = new Class[args.length];
		for (int i = 0, j = args.length; i < j; i++) {
			argsClass[i] = args[i].getClass();
		}
		Method method = ownerClass.getMethod(methodName, argsClass);
		return method.invoke(owner, args);
	}

	/**
	 * 注入字段值.
	 * 
	 * @param obj
	 * @param fieldName
	 * @param value
	 * @throws Exception
	 * @author qingwu
	 * @date 2014-2-7 下午5:07:31
	 */
	public static void setFieldValue(Object obj, String fieldName, Object value)
			throws Exception {
		String methodName = "set"
				+ String.valueOf(fieldName.charAt(0)).toUpperCase()
				+ fieldName.substring(1);
		invokeMethod(obj, methodName, new Object[] { value });
	}

}
