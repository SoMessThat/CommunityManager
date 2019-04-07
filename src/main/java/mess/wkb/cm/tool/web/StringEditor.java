package mess.wkb.cm.tool.web;



import java.beans.PropertyEditorSupport;

import mess.wkb.cm.tool.util.ObjectUtil;





/**
 * 字符串注入过滤器<br>
 * 
 * @author yangz
 * @date 2013-3-30 下午3:14:08
 */
public class StringEditor extends PropertyEditorSupport {

	public void setAsText(String text) throws IllegalArgumentException {
//		if(sqlValidate(text)){
//			text = "非法字符";
//		}
		if (!ObjectUtil.isEmpty(text)) {
			setValue(text.toString().trim());
		} else {
			setValue(text);
		}
	}

	public String getAsText() {
		Object value = getValue();
		if(sqlValidate((String)value)){
			try {
				throw new Exception("请不要输入非法字符");
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return ObjectUtil.isEmpty(value) ? "" : value.toString().trim();
	}

	public boolean sqlValidate(String str) {
		str = str.toLowerCase();// 统一转为小写
		String badStr = "and|exec|execute|insert|select|delete|update|count|drop|*|chr|mid|master|truncate|"
				+ "char|declare|sitename|net user|xp_cmdshell|;|+|,|like'|and|exec|execute|insert|create|drop|"
				+ "table|from|grant|use|group_concat|column_name|"
				+ "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|"
				+ "chr|mid|master|truncate|char|declare|;|+|,|like|#";// 过滤掉的sql关键字，可以手动添加
		String[] badStrs = badStr.split("\\|");
		for (int i = 0; i < badStrs.length; i++) {
			if (str.indexOf(badStrs[i]) >= 0) {
				return true;
			}
		}
		return false;
	}
}