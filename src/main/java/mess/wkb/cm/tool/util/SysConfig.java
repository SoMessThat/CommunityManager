package mess.wkb.cm.tool.util;



import org.springframework.stereotype.Component;

import mess.wkb.cm.tool.util.file.IHotDeployInit;
import mess.wkb.cm.tool.util.file.PropertiesUtil;





/**
 * 系统配置.
 * 
 * @author qingwu
 * @date 2014-1-17 下午4:58:06
 */
@Component
public class SysConfig implements IHotDeployInit {
	
//	/**
//	 * 微信网页授权 access_token 
//	 */
//	public static JsapiTicket J_TICKET = new JsapiTicket();
//	
//	/**
//	 * 微信访问普通  access_token
//	 */
//	public static AccessToken PT_ACCESS = new AccessToken();
	

	static {
		new SysConfig().init();
	}
	
	/**
	 * 微信  appId
	 */
	public static String APPID;
	/**
	 * 微信  APPSECRET
	 */
	public static String APPSECRET;
	/**
	 * 微信 url
	 */
	public static String URL;
	
	/**
	 * (还款，满标 能否进行)
	 */
	public static Boolean IS_DO_ING = true;
	
	/**
	 * 初始化.
	 * 
	 * @author qingwu
	 * @date 2014-1-17 下午5:05:02
	 */
	public void init() {
		PropertiesUtil p = new PropertiesUtil(Constants.CONFIG_PROPERTIES_PATH);
		APPID = p.getProperties("weixin.appid");
		APPSECRET = p.getProperties("weixin.appsecret");
		URL = p.getProperties("weixin.url");
	}
}
