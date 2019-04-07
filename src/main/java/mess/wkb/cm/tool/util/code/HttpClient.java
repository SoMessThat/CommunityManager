package mess.wkb.cm.tool.util.code;





import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

/**
 * 使用Http协议与Web服务器通讯.
 * 
 * @author qingwu
 * @date 2014-2-7 下午2:24:33
 */
public class HttpClient {

	// Http服务器域名/IP + PORT
	private String httpServerUrl;
	// 是否POST访问
	private boolean isPost;
	// 读取cookie用于保持session
	private String cookie;

	public HttpClient(String httpServerUrl, boolean isPost) {
		this.httpServerUrl = httpServerUrl;
		this.isPost = isPost;
	}

	/**
	 * 获取字符串
	 * 
	 * @param uri
	 * @param paramMap
	 * @return
	 * @throws IOException
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 */
	public String getString(String uri, Map<String, Object> paramMap)
			throws IOException {
		HttpURLConnection urlConnection = getHttpURLConnection(uri, paramMap);
		BufferedReader reader = null;
		try {
			StringBuilder builder = new StringBuilder();
			reader = new BufferedReader(new InputStreamReader(
					urlConnection.getInputStream(), "utf-8"));
			String lines;
			while ((lines = reader.readLine()) != null) {
				builder.append(lines);
			}
			cookie = urlConnection.getHeaderField("set-cookie");
			return builder.toString();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException ex) {
				} // 忽略
				reader = null;
			}
		}
	}

	/**
	 * 直接根据url进行请求(GET方式).
	 * 
	 * @param paramUrl
	 * @return
	 * @author qingwu
	 * @date 2014-2-7 下午2:36:44
	 */
	public static String getResult(String paramUrl) {
		try {
			URL url = new URL(paramUrl);
			HttpURLConnection urlConnection = (HttpURLConnection) url
					.openConnection();
			// 处理数据发送
			urlConnection.setDoOutput(true);
			// 禁止使用缓存
			urlConnection.setUseCaches(false);
			// 发送请求
			BufferedReader reader = null;
			try {
				StringBuilder builder = new StringBuilder();
				reader = new BufferedReader(new InputStreamReader(
						urlConnection.getInputStream(), "utf-8"));
				String lines;
				while ((lines = reader.readLine()) != null) {
					builder.append(lines);
				}
				return builder.toString();
			} finally {
				if (reader != null) {
					try {
						reader.close();
					} catch (IOException ex) {
					} // 忽略
					reader = null;
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 获取Http连接
	 * 
	 * @param uri
	 * @param paramMap
	 * @return
	 * @throws IOException
	 */
	private HttpURLConnection getHttpURLConnection(String uri,
			Map<String, Object> paramMap) throws IOException {
		// 编码请求参数
		StringBuilder paramBuilder = new StringBuilder(256);
		if (paramMap != null) {
			for (Map.Entry<String, Object> entry : paramMap.entrySet()) {
				paramBuilder.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
				paramBuilder.append("=");
				Object value = entry.getValue();
				paramBuilder.append(URLEncoder.encode(value == null ? ""
						: value.toString(), "UTF-8"));
				paramBuilder.append("&");
			}
			paramBuilder.deleteCharAt(paramBuilder.length() - 1);
		}
		String paramString = paramBuilder.toString();

		URL url = isPost ? new URL(httpServerUrl + uri) : new URL(httpServerUrl
				+ uri + "?" + paramString);
		HttpURLConnection urlConnection = (HttpURLConnection) url
				.openConnection();
		// 处理数据发送
		urlConnection.setDoOutput(true);
		// 禁止使用缓存
		urlConnection.setUseCaches(false);
		// 若cookie存在，则增加请求属性"cookie"
		if (cookie != null) {
			urlConnection.setRequestProperty("cookie", cookie);
		}
		// 发送POST请求参数
		if (isPost) {
			DataOutputStream out = null;
			try {
				out = new DataOutputStream(new BufferedOutputStream(
						urlConnection.getOutputStream(), 256));
				out.writeBytes(paramString);
			} finally {
				if (out != null) {
					try {
						out.close();
					} catch (IOException ex) {
					} // 忽略
					out = null;
				}
			}
		}
		return urlConnection;
	}
}
