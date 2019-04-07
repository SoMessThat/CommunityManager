package mess.wkb.cm.tool.util;




import java.math.BigDecimal;

/**
 * 数据类型.
 * 
 * @author yangz
 * @date 2012-7-28 下午02:42:26
 */
public class ValueUtil {
	
	public static int LOL_PK_MONEY = 1;
	public static int LOL_PK_POINT = 10;
	
	
	/**
	 * 撸币换算
	 */
	public static int LolConversion(int money){
		return money*LOL_PK_MONEY;
	}
	
	/**
	 * 撸币积分换算
	 */
	public static int LolPointConversion(int money){
		return money*LOL_PK_POINT;
	}
	
	
	/**
	 * 值对象 --> String.
	 * 
	 * @param value
	 * @return
	 * @author yangz
	 * @date 2012-7-28 下午03:15:11
	 */
	public static String getString(Object value) {
		String result = "";
		if (value != null) {
			String sValue = value.toString().trim();
			if (value instanceof Number) {
				if (value instanceof Double || value instanceof BigDecimal) {
					if (!"Infinity".equals(sValue) && !"NaN".equals(sValue)) {
						result = StringUtil.toNuSicen(value);
					} else {
						result = "0";
					}
				} else {
					result = sValue;
				}
			} else {
				result = sValue;
			}
		}
		return result.trim();
	}

	/**
	 * 值对象 --> long.
	 * 
	 * @param value
	 * @return
	 * @author yangz
	 * @date 2012-7-28 下午03:27:21
	 */
	public static long getLong(Object value) {
		try {
			return Long.parseLong(getString(value));
		} catch (Exception e) {
			return 0L;
		}
	}

	/**
	 * 值对象 --> double.
	 * 
	 * @param value
	 * @return
	 * @author yangz
	 * @date 2012-7-28 下午03:29:25
	 */
	public static double getDouble(Object value) {
		try {
			return Double.parseDouble(getString(value));
		} catch (Exception e) {
			return 0.0;
		}
	}

	/**
	 * 值对象 --> int.
	 * 
	 * @param value
	 * @return
	 * @author yangz
	 * @date 2012-7-28 下午03:29:35
	 */
	public static int getInt(Object value) {
		try {
			return Integer.parseInt(getString(value));
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * 值对象 --> boolean.
	 * 
	 * @param value
	 * @return
	 * @author yangz
	 * @date 2012-10-12 上午09:00:16
	 */
	public static boolean getBoolean(Object value) {
		try {
			String v = getString(value);
			if ("1".equals(v)) {
				return true;
			} else if ("0".equals(v)) {
				return false;
			} else if ("Y".equals(v)) {
				return true;
			} else if ("N".equals(v)) {
				return false;
			} else {
				return Boolean.parseBoolean(v);
			}
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 获得四舍五入的数字结果(精确到2位小数点).
	 * 
	 * @param num
	 *            数字
	 * @return 四舍五入的数字结果
	 * @author qingwu
	 * @date 2013-10-24 下午5:16:32
	 */
	public static double getRoundNum(double num) {
		BigDecimal b = new BigDecimal(num);
		double f1 = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		return f1;
	}

	/**
	 * 金额  个位和 分位 分开
	 * @param money
	 * @param note
	 * @return
	 */
	public static String[] getStrSplit(String val) {
		
		String[] b = new String[]{"00",".00"};
		String[] c = val.split("\\.");
		
		if(c.length == 1){
			b[0] = c[0];
		}else{
			b[0] = c[0];
			if(c[1].equals("0")){
				b[1] = "."+c[1]+"0";				
			}else{
				b[1] = "."+c[1];
			}
		}
		
		return b;
	}
	
	/**
	 * 指定的 4位数字随机数
	 * @return
	 */
	public static String getRoundNumLimit4(Integer num){
		int i = (int)(Math.random()*num);
		if(i<10) return "000"+i;
		if(9<i && i<100) return "00"+i;
		if(99<i && i<1000) return "0"+i;
		return i+"";
	}
}
