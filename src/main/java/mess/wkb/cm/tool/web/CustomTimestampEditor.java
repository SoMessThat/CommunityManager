package mess.wkb.cm.tool.web;





import java.beans.PropertyEditorSupport;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import org.springframework.util.StringUtils;
import java.text.ParseException;

/**
 * Timestamp日期类型转换(Timestamp类型上传参数).
 * 
 * @author qingwu
 * @date 2014-2-21 下午2:49:35
 */
public class CustomTimestampEditor extends PropertyEditorSupport {

	private static final int TYPE_DATE_FORMAT = 1;
	private static final int TYPE_DATE_LONG = 2;
	private int type;
	private SimpleDateFormat dateFormat;
	private boolean allowEmpty;
	private int exactDateLength;

	/**
	 * 时间戳格式.
	 * 
	 * @param allowEmpty
	 *            是否允许为空
	 * @author qingwu
	 * @date 2014-2-21 下午2:49:35
	 */
	public CustomTimestampEditor(boolean allowEmpty) {
		type = TYPE_DATE_LONG;
		this.allowEmpty = allowEmpty;
		this.exactDateLength = -1;
	}

	/**
	 * 指定日期格式转换.
	 * 
	 * @param dateFormat 日期格式
	 * @param allowEmpty 是否为空
	 * @author qingwu
	 * @date 2014-2-21 下午2:49:35
	 */
	public CustomTimestampEditor(String dateFormat, boolean allowEmpty) {
		type = TYPE_DATE_FORMAT;
		setDateFormat(dateFormat);
		this.allowEmpty = allowEmpty;
		this.exactDateLength = -1;
	}

	/**
	 * 设置日期格式.
	 * 
	 * @author qingwu
	 * @date 2014-2-21 下午2:49:35
	 */
	private void setDateFormat(String format) {
		dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
	}

	/**
	 * 参数上传类型转化.
	 * 
	 * @author qingwu
	 * @date 2014-2-21 下午2:49:35
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if ((this.allowEmpty) && (!(StringUtils.hasText(text)))) {
			setValue(null);
		} else {
			if ((text != null) && (this.exactDateLength >= 0)
					&& (text.length() != this.exactDateLength)) {
				throw new IllegalArgumentException(
						"Could not parse date: it is not exactly"
								+ this.exactDateLength + "characters long");
			}
			try {
				switch (this.type) {
				case TYPE_DATE_LONG:
					setValue(new Timestamp(Long.valueOf(text)));
					break;
				case TYPE_DATE_FORMAT:
					if (text.length() == 10) {// 如果上传的时间格式是yyyy-MM-dd，自动加上时分秒
						text += " 00:00:00";
					}
					setValue(new Timestamp(this.dateFormat.parse(text)
							.getTime()));
					break;
				}

			} catch (ParseException ex) {
				throw new IllegalArgumentException("Could not parse date: "
						+ ex.getMessage(), ex);
			}
		}
	}

	/**
	 * 获得时间显示类型.
	 * 
	 * @author qingwu
	 * @date 2014-2-21 下午2:49:35
	 */
	@Override
	public String getAsText() {
		Timestamp value = (Timestamp) getValue();
		String returnStr = null;
		switch (this.type) {
		case TYPE_DATE_LONG:
			returnStr = ((value != null) ? String.valueOf(value.getTime()) : "");
			break;
		case TYPE_DATE_FORMAT:
			returnStr = ((value != null) ? this.dateFormat.format(value) : "");
			break;
		}
		return returnStr;
	}
}
