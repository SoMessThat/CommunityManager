package mess.wkb.cm.tool.cache;





/**
 * 短信缓存机
 * @author Administrator
 *
 */
public class MsgCacheManager {

	public static final int VALI_TIME = 1800;

	public static final int VALI_LIFE = 60;
	
	public static final int IMG_VALI_LIFE = 180;
	
	
	
	/**
	 * 注册短信IP组 验证码 倒计时 3分钟
	 * @param ip
	 * @param msgcode
	 */
	public static void setIpMsgCode(String ip , String msgcode){
		ISimpleCacheProxy cache = CacheHandle.getCacheProxy();
		cache.set(ip+"ipMsgLife", msgcode, IMG_VALI_LIFE);
	}
	/**
	 * 注册短信IP组 验证码 倒计时 3分钟
	 * @param ip
	 * @param msgcode
	 */
	public static String getIpMsgCode(String ip) {
		ISimpleCacheProxy cache = CacheHandle.getCacheProxy();
		Object obj = cache.get(ip+"ipMsgLife");
		if (obj != null) {
			return (String)obj;
		}
		return null;
	}
	
	
	/**
	 * 注册短信号码组 验证码 倒计时 3分钟
	 * @param ip
	 * @param msgcode
	 */
	public static void setPhoneMsgCode(String phone , String msgcode){
		ISimpleCacheProxy cache = CacheHandle.getCacheProxy();
		cache.set(phone+"phoneMsgLife", msgcode, IMG_VALI_LIFE);
	}
	/**
	 * 注册短信号码组 验证码 倒计时 3分钟
	 * @param ip
	 * @param msgcode
	 */
	public static String getPhoneMsgCode(String phone) {
		ISimpleCacheProxy cache = CacheHandle.getCacheProxy();
		Object obj = cache.get(phone+"phoneMsgLife");
		if (obj != null) {
			return (String)obj;
		}
		return null;
	}
	

}
