package mess.wkb.cm.tool.util;




import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 类说明: 日期工具类.
 * 
 * 类用途：提供日期操作的各种方法
 * 
 * <pre>
 * 修改日期      修改人    修改原因
 * 2013-04-13    qingwu   新建
 * </pre>
 */
public class DateUtil {

	private final static Logger logger = LoggerFactory
			.getLogger(DateUtil.class);

	/**
	 * 默认的日期格式,yyyy-MM-dd.
	 */
	public static final String ISO_DATE_FORMAT = "yyyy-MM-dd";

	/**
	 * 数字格式的日期格式,yyyyMMdd.
	 */
	public static final String NUMBER_DATE_FORMAT = "yyyyMMdd";

	/**
	 * 数字格式的时间字符串,HHmmss.
	 */
	public static final String NUMBER_TIME_FORMAT = "HHmmss";

	/**
	 * 数字格式的日期时间字符串, yyyyMMddHHmmss.
	 */
	public static final String NUMBER_DATE_TIME_FORMAT = "yyyyMMddHHmmss";

	/**
	 * 默认的日期时间格式,yyyy-MM-dd' 'HH:mm:ss.
	 */
	public static final String ISO_DATE_TIME_FORMAT = "yyyy-MM-dd' 'HH:mm:ss";

	/**
	 * 1年多少毫秒
	 */
	public static final Long YEAR_LONG_TIME = 365 * 24 * 60 * 60 * 1000l;
	
	
	/**
	 * 1月多少毫秒
	 */
	public static final Long MONTH_LONG_TIME = 30 * 24 * 60 * 60 * 1000l;
	
	/**
	 * 1天多少毫秒
	 */
	public static final Long DAY_LONG_TIME = 24 * 60 * 60 * 1000l;
	
	/**
	 * 十分钟
	 */
	public static final Long TEN_MIN = 10 * 60 * 1000l;
	
	public static String getRandom(int num){
		  String s="0123456789";
		  StringBuffer sb=new StringBuffer();
		  for(int i=0;i<num;i++){
			  int id=(int)(Math.random()*(s.length()-1));
			  String code=s.substring(id,id+1);
			  sb.append(code);
		  }
		  return sb.toString();
	  }
	
	/**
	 * 
	 * 转换日期格式.
	 * 
	 * @param date
	 *            字符型的日期
	 * @param oldFormat
	 *            原始的日期格式
	 * @param newFormat
	 *            新的日期格式
	 * @return 新的日期字符串
	 * 
	 *         <pre>
	 * 修改日期        修改人    修改原因
	 * 2010-12-20        新建
	 * </pre>
	 */
	public static String transformDateFormat(String date, String oldFormat,
			String newFormat) {
		if (date == null) {
			return null;
		}
		Date tempDate = parseDate(date, oldFormat);
		return formatDate(tempDate, newFormat);
	}

	/**
	 * 
	 * 解析日期,以默认日期格式yyyy-MM-dd进行解析.<br>
	 * 相关方法:{@link #parseDate(String, String)}
	 * 
	 * @param stringDate
	 *            日期字符串
	 * @return 日期对象
	 * 
	 *         <pre>
	 * 修改日期      修改人    修改原因
	 * 2010-11-15        新建
	 * 2010-12-07        修改注释和注释格式
	 * </pre>
	 * 
	 */
	public static Date parseDate(String stringDate) {
		return parseDate(stringDate, ISO_DATE_FORMAT);
	}

	/**
	 * 
	 * 解析日期,根据指定的格式进行解析.<br>
	 * 如果解析错误,则返回null
	 * 
	 * @param stringDate
	 *            日期字符串
	 * @param format
	 *            日期格式
	 * @return 日期类型
	 * 
	 *         <pre>
	 * 修改日期      修改人    修改原因
	 * 2010-11-15        整理
	 * 2010-12-07        修改注释和注释格式
	 * </pre>
	 * 
	 */
	public static Date parseDate(String stringDate, String format) {
		if (stringDate == null) {
			return null;
		}

		try {
			return DateUtils.parseDate(stringDate, new String[] { format });
		} catch (ParseException e) {
			logger.error("解析日期异常[" + stringDate + ":" + format + "]", e);
		}

		return null;
	}

	/**
	 * 
	 * 解析日期,以所指定的日期格式集合进行解析.<br>
	 * <p>
	 * <li>如果满足其中一个日期格式,解析并且返回<br>
	 * <li>如果没解析成功或者解析错误,则返回null
	 * </p>
	 * 
	 * @param stringDate
	 *            日期字符串
	 * @param formates
	 *            日期格式的集合
	 * @return 日期类型
	 * 
	 *         <pre>
	 * 修改日期      修改人    修改原因
	 * 2010-11-15        整理
	 * </pre>
	 * 
	 */
	public static Date parseDate(String stringDate, Collection<String> formates) {
		if (formates == null || formates.size() == 0) {
			throw new IllegalStateException("Date format not set.");
		}

		try {
			return DateUtils.parseDate(stringDate,
					formates.toArray(new String[formates.size()]));
		} catch (Exception e) {
			logger.error("日期解析错误", e);
		}

		return null;
	}

	/**
	 * 
	 * 以默认的格式"yyyy-MM-dd"格式化日期.
	 * 
	 * @param srcDate
	 *            源日期
	 * @return 格式化后的日期字符串
	 * 
	 *         <pre>
	 * 修改日期      修改人    修改原因
	 * 2010-11-15        整理
	 * </pre>
	 * 
	 */
	public static String formatDate(Date srcDate) {
		return formatDate(srcDate, ISO_DATE_FORMAT);
	}

	/**
	 * 以指定的格式格式化日期.
	 * 
	 * @param srcDate
	 *            源日期
	 * @param pattern
	 *            格式
	 * @return 格式化的日期字符串
	 * 
	 *         <pre>
	 * 修改日期      修改人    修改原因
	 * 2010-11-15        新建
	 * </pre>
	 * 
	 */
	public static String formatDate(Date srcDate, String pattern) {
		if (srcDate == null) {
			return null;
		}
		return DateFormatUtils.format(srcDate, pattern);
	}

	/**
	 * 格式化time获得指定格式的字符串.
	 * 
	 * @param time
	 *            时间
	 * @param pattern
	 *            格式
	 * @return 格式化后的字符串
	 * @author zhufu
	 * @version 2013年10月18日 上午9:40:01
	 */
	public static String formatDate(long time, String pattern) {
		return DateFormatUtils.format(time, pattern);
	}

	/**
	 * 格式化date获得yyyyMMddHHmmss格式的字符串.
	 * 
	 * @param date
	 *            时间
	 * @return 格式化后的字符串
	 * @author zhufu
	 * @version 2013年10月18日 上午9:41:42
	 */
	public static String formatDateyyyyMMddHHmmss(Date date) {
		return formatDate(date, NUMBER_DATE_TIME_FORMAT);
	}

	/**
	 * 格式化time获得yyyyMMddHHmmss格式的字符串.
	 * 
	 * @param time
	 *            时间
	 * @return 格式化后的字符串
	 * @author zhufu
	 * @version 2013年10月18日 上午9:42:25
	 */
	public static String formatDateyyyyMMddHHmmss(long time) {
		return formatDate(time, NUMBER_DATE_TIME_FORMAT);
	}
	
	/**
	 * 格式化time获得yyyy-MM-dd格式的字符串.
	 * 
	 * @param time
	 *            时间
	 * @return 格式化后的字符串
	 * @author zhufu
	 * @version 2013年10月18日 上午9:42:25
	 */
	public static String formatDateyyyyMMdd(long time) {
		return formatDate(time, ISO_DATE_FORMAT);
	}

	/**
	 * 为指定日期添加N天.
	 * 
	 * @param date
	 *            指定日期
	 * @param amount
	 *            增加天数
	 * @return 计算后的日期
	 * 
	 *         <pre>
	 * 修改日期      修改人    修改原因
	 * 2010-11-15        新建
	 * </pre>
	 */
	public static Date addDays(Date date, int amount) {
		return DateUtils.addDays(date, amount);
	}
	
	
//	public static Long addDays(Long time, int amount) {
//		long temp =24*60*60*1000 * 3 ;
//		return time+temp;
//	}
	
	

	/**
	 * 为指定日期添加N月.
	 * 
	 * @param date
	 *            指定日期
	 * @param amount
	 *            增加月数
	 * @return 计算后的日期
	 * 
	 *         <pre>
	 * 修改日期      修改人    修改原因
	 * 2010-11-15        新建
	 * </pre>
	 */
	public static Date addMonths(Date date, int amount) {
		return DateUtils.addMonths(date, amount);
	}

	/**
	 * 为指定日期添加N周.
	 * 
	 * @param date
	 *            指定日期
	 * @param amount
	 *            增加周数
	 * @return 计算后的日期
	 * 
	 *         <pre>
	 * 修改日期      修改人    修改原因
	 * 2010-11-15        新建
	 * </pre>
	 */
	public static Date addWeeks(Date date, int amount) {
		return DateUtils.addWeeks(date, amount);
	}

	/**
	 * 为指定日期添加N年.
	 * 
	 * @param date
	 *            指定日期
	 * @param amount
	 *            增加年数
	 * @return 计算后的日期
	 * 
	 *         <pre>
	 * 修改日期      修改人    修改原因
	 * 2010-11-15        新建
	 * </pre>
	 */
	public static Date addYears(Date date, int amount) {
		return DateUtils.addYears(date, amount);
	}

	/**
	 * 为指定日期添加N小时.
	 * 
	 * @param date
	 *            指定日期
	 * @param amount
	 *            增加小时数
	 * @return 计算后的日期
	 * 
	 *         <pre>
	 * 修改日期      修改人    修改原因
	 * 2010-11-15                  整理
	 * </pre>
	 */
	public static Date addHours(Date date, int amount) {
		return DateUtils.addHours(date, amount);
	}

	/**
	 * 为指定日期添加N分钟.
	 * 
	 * @param date
	 *            指定日期
	 * @param amount
	 *            增加分钟数
	 * @return 计算后的日期
	 * 
	 *         <pre>
	 * 修改日期      修改人    修改原因
	 * 2010-11-15        整理
	 * </pre>
	 */
	public static Date addMinutes(Date date, int amount) {
		return DateUtils.addMinutes(date, amount);
	}

	/**
	 * 为指定日期添加N秒.
	 * 
	 * @param date
	 *            指定日期
	 * @param amount
	 *            增加秒数
	 * @return 计算后的日期
	 * 
	 *         <pre>
	 * 修改日期      修改人    修改原因
	 * 2010-11-15        新建
	 * </pre>
	 */
	public static Date addSeconds(Date date, int amount) {
		return DateUtils.addSeconds(date, amount);
	}

	/**
	 * 为指定日期添加N毫秒.
	 * 
	 * @param date
	 *            指定日期
	 * @param amount
	 *            增加毫秒数
	 * @return 计算后的日期
	 * 
	 *         <pre>
	 * 修改日期      修改人    修改原因
	 * 2010-11-15        新建
	 * </pre>
	 */
	public static Date addMilliseconds(Date date, int amount) {
		return DateUtils.addMilliseconds(date, amount);
	}

	/**
	 * 获取格式为“yyyyMMdd”的日期.
	 * 
	 * @return 日期字符串
	 * 
	 *         <pre>
	 * 修改日期      修改人    修改原因
	 * 2010-04-13        整理
	 * </pre>
	 */
	public static String getDate() {
		return getDate(new Date());
	}

	/**
	 * 获取格式为“yyyyMMdd”的日期.
	 * 
	 * @param date
	 * @return
	 * 
	 *         <pre>
	 * 修改日期        修改人    修改原因
	 * 2012-1-10    陈建榕    新建
	 * </pre>
	 */
	public final static String getDate(Date date) {
		return formatDate(date, NUMBER_DATE_FORMAT);
	}

	/**
	 * 获取格式为“yyyyMMdd”的日期.
	 * 
	 * @param date
	 * @return 日期字符串
	 * 
	 *         <pre>
	 * 修改日期        修改人    修改原因
	 * 2011-12-14    陈建榕    新建
	 * </pre>
	 */
	public static String getDateStr(Date date) {
		return formatDate(date, NUMBER_DATE_FORMAT);
	}

	/**
	 * 获取格式为"yyyyMMdd"的数值型日期.
	 * 
	 * @return
	 * 
	 *         <pre>
	 * 修改日期        修改人    修改原因
	 * 2011-12-14    陈建榕    新建
	 * </pre>
	 */
	public static final Integer getNumDate() {
		return Integer.valueOf(getDate());
	}

	/**
	 * 获取格式为"yyyyMMdd"的数值型日期.
	 * 
	 * @param date
	 * @return
	 * 
	 *         <pre>
	 * 修改日期        修改人    修改原因
	 * 2011-12-14    陈建榕    新建
	 * </pre>
	 */
	public static final Integer getNumDate(Date date) {
		return Integer.valueOf(getDate(date));
	}

	/**
	 * 获取格式“HHmmss”的时间.
	 * 
	 * @return 时间字符串
	 * 
	 *         <pre>
	 * 修改日期      修改人    修改原因
	 * 2010-04-13        整理
	 * </pre>
	 */
	public static String getTime() {
		return formatDate(new Date(), NUMBER_TIME_FORMAT);
	}

	/**
	 * 获取格式为“yyyy-MM-dd HH:mm:ss”的日期和时间.
	 * 
	 * @return 时间日期字符串
	 * 
	 *         <pre>
	 * 修改日期      修改人    修改原因
	 * 2010-04-13        整理
	 * </pre>
	 */
	public static String getDateTime() {
		return formatDate(new Date(), ISO_DATE_TIME_FORMAT);
	}

	/**
	 * 获取格式为“yyyy-MM-dd HH:mm:ss”的日期和时间.
	 * 
	 * @return 时间日期字符串
	 * 
	 *         <pre>
	 * 修改日期      修改人    修改原因
	 * 2010-04-13        整理
	 * </pre>
	 */
	public static String getDateTime(Date date) {
		return formatDate(date, ISO_DATE_TIME_FORMAT);
	}

	/**
	 * 获取格式为“yyyy-MM-dd HH:mm:ss”的日期和时间.
	 * 
	 * @return 时间日期字符串
	 * 
	 *         <pre>
	 * 修改日期      修改人    修改原因
	 * 2010-04-13        整理
	 * </pre>
	 */
	public static String getDateTime(long time) {
		return formatDate(new Date(time), ISO_DATE_TIME_FORMAT);
	}

	/**
	 * 获取清理了时分秒的日期,只保留年月日的信息.
	 * 
	 * @param date
	 * @return
	 * 
	 *         <pre>
	 * 修改日期        修改人    修改原因
	 * 2011-12-13    陈建榕    新建
	 * </pre>
	 */
	public final static Date getClearDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.clear(Calendar.HOUR_OF_DAY);
		calendar.clear(Calendar.AM_PM);
		calendar.clear(Calendar.HOUR);
		calendar.clear(Calendar.MINUTE);
		calendar.clear(Calendar.SECOND);
		calendar.clear(Calendar.MILLISECOND);
		return calendar.getTime();
	}

	/**
	 * 获取清理了时分秒的日期,只保留年月的信息，日为1号.
	 * 
	 * @param date
	 * @return
	 * 
	 *         <pre>
	 * 修改日期        修改人    修改原因
	 * 2011-12-13    陈建榕    新建
	 * </pre>
	 */
	public final static Date getClearMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.clear(Calendar.HOUR_OF_DAY);
		calendar.clear(Calendar.AM_PM);
		calendar.clear(Calendar.HOUR);
		calendar.clear(Calendar.MINUTE);
		calendar.clear(Calendar.SECOND);
		calendar.clear(Calendar.MILLISECOND);
		return calendar.getTime();
	}

	/**
	 * 以指定的格式格式化日期.
	 * 
	 * @param srcDate
	 *            源日期
	 * @param pattern
	 *            格式
	 * @return 格式化的日期字符串
	 * 
	 *         <pre>
	 * 修改日期         修改人    修改原因
	 * 2013-07-09  qingwu    新建
	 * </pre>
	 * 
	 */
	public static String formatDate(Timestamp srcDate, String pattern) {
		if (srcDate == null) {
			return null;
		}
		DateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(srcDate);
	}
	
	/**
	 * calcLastWeek(new GregorianCalendar());
	 * 获取上周六
	 * @param calendar
	 */
	public static long calcLastWeek() {
		GregorianCalendar calendar = new GregorianCalendar();
		int minus = calendar.get(GregorianCalendar.DAY_OF_WEEK) ;
		calendar.add(GregorianCalendar.DATE, -minus);
		return calendar.getTime().getTime();
	}
	
	/**
	 * calcLastWeek(new GregorianCalendar());
	 * 获取上上周六
	 * @param calendar
	 */
	public static long calcLastLastWeek() {
		GregorianCalendar calendar = new GregorianCalendar();
		int minus = calendar.get(GregorianCalendar.DAY_OF_WEEK) ;
		calendar.add(GregorianCalendar.DATE, -minus);
		calendar.add(GregorianCalendar.DATE, - 4 );
		return calendar.getTime().getTime();
	}
	
	/**
	 * string to long
	 * @param datetime
	 * @return
	 */
	public static Long strToLongDate(String datetime){
		if(datetime == null)return null;
		return DateUtil.parseDate(datetime,DateUtil.ISO_DATE_TIME_FORMAT).getTime();
	}
	
	
	/**
	 * 返回指定日期的整点
	 * string to long
	 * @param datetime
	 * @return
	 */
	public static Long strToLongDateBegin(String datetime){
		if(datetime == null)return null;
		datetime = datetime.substring(0, 10)+" 00:00:00";
		return DateUtil.parseDate(datetime,DateUtil.ISO_DATE_TIME_FORMAT).getTime();
	}
	
	/**
	 * 返回当前日期整点
	 * string to long
	 * @param datetime
	 * @return
	 */
	public static Long strToLongDateBegin(){
		String datetime = "";
		datetime = getDateTime();
		datetime = datetime.substring(0, 10)+" 00:00:00";
		return DateUtil.parseDate(datetime,DateUtil.ISO_DATE_TIME_FORMAT).getTime();
	}
	
	
	
	
	/**
	 * 计算两个时间相差几天 (按照时分秒计算)
	 */
	public static Integer jsxiangjian(Long end , Long start){
		return Integer.valueOf(((end-start)/(24*60*60*1000))+"");   
	}
	
	/**
	 * 计算两个Long类型时间相差几天  （忽略 小时 ）
	 * @param end
	 * @param start
	 * @return
	 */
	public static Integer dayPoor(Long end , Long start){
		Date endDate = getClearDate(new Date(end));
		Date startDate = getClearDate(new Date(start));
		
		return jsxiangjian(endDate.getTime(),startDate.getTime());
	}
	
	public static Long addMinutes(Long date, int amount) {
		return date +( amount * 60*1000);   
	}
	
	/**
	 * 返回天数
	 * @param time
	 * @return
	 */
	public static long getDateDay(long time) {
		return time/1000/60/60/24;
	}
	
	/**
	 * 富有参数拼接
	 * @param aFormat
	 * @return
	 */
	public static String getCurrentDate(String aFormat) {
        String tDate = new SimpleDateFormat(aFormat).format(new java.util.Date(System.currentTimeMillis()));
        return tDate;
    }
	
	/**
	 * 富有参数拼接
	 * @param codeLen
	 * @return
	 */
	public static String getNewRandomCode(int codeLen) {
		//首先定义随机数据源
		//根据需要得到的数据码的长度返回随机字符串
		java.util.Random randomCode = new java.util.Random();
		String strCode = "";
		while (codeLen > 0) {
			int charCode=randomCode.nextInt(9);
			strCode += charCode;
			codeLen--;
		}
		return strCode;
	}
	
/**
 * 获取当前网络时间
 * @author yeqingrong
 * @return String类型的时间（格式：YYYY-MM-dd HH:mm:ss）
 */
	public static String getNetTime(){
		String webUrl="http://www.baidu.com";//百度时间
		try {
			 URL url = new URL(webUrl);
			URLConnection conn=url.openConnection();
	         conn.connect();
	         long dateL=conn.getDate();
	         Date date=new Date(dateL);
	         SimpleDateFormat dateFormat=new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
	         return dateFormat.format(date);
		} catch (Exception e) {
			logger.error("异常", e);
		}
		return "";
   
	}
	
	/**
	 * 将时间转换为时间戳   
	 * @param s
	 * @return
	 * @throws ParseException
	 */
    public static String dateToStamp(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date;
		try {
			date = simpleDateFormat.parse(s);
			long ts = date.getTime();
	        res = String.valueOf(ts);
	        return res;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
    /**
     * 将时间戳转换为时间
     * @param s
     * @return
     */
    public static String stampToDate(String s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }
	
}
