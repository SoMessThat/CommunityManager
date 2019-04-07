package mess.wkb.cm.tool.util;



import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * WEB工具类.
 * 
 * @author qingwu
 * @date 2014-1-20 下午12:28:16
 */
public class WebUtil {

	/**
	 * 设置http应答为excel导出.
	 * 
	 * @param fileName
	 *            文件名称
	 * @param response
	 *            http应答
	 * @param outputStream
	 *            输出流
	 */
	@SuppressWarnings("deprecation")
	public static void setExcelExportResponse(String fileName,
			HttpServletResponse response) {
		response.setContentType("application/x-xls");
		response.setCharacterEncoding("gbk");// excel必须是这样.
		response.setHeader("Content-disposition", "attachment;filename="
				+ URLEncoder.encode(fileName) + ".xls");
	}

	/**
	 * 获得编码后的url地址
	 * 
	 * @param url
	 *            url地址
	 * @return
	 * @author qingwu
	 * @date 2013-9-3 上午09:00:00
	 */
	public static String encodedUri(String url) {
		UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url)
				.build();
		String encodedUri = uriComponents.encode().toUriString();
		return encodedUri;
	}

	/**
	 * 获取远程访问的IP地址.
	 * 
	 * @param request
	 * @return
	 * @author yangz
	 * @date 2012-9-18 上午09:02:09
	 */
	public static String getIpAddress(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
			if (ip.equals("127.0.0.1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					throw new UnCaughtException(e);
				}
				ip = inet.getHostAddress();
			}
		}

		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ip != null && ip.length() > 15) { // "***.***.***.***".length() = 15
			if (ip.indexOf(",") > 0) {
				ip = ip.substring(0, ip.indexOf(","));
			}
		}

		return ip;
	}

	/**
	 * 获得request所有请求参数.
	 * 
	 * @param request
	 * @return
	 * @author qingwu
	 * @date 2014-3-14 下午2:48:05
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, String> getRequestParams(
			HttpServletRequest request) {
		Map<String, String> reqMap = new HashMap<String, String>();
		Enumeration enum_term = request.getParameterNames();
		while (enum_term.hasMoreElements()) {
			String paramName = (String) enum_term.nextElement();
			String paramValue = request.getParameter(paramName);
			reqMap.put(paramName, paramValue);

		}
		return reqMap;
	}
}
