package mess.wkb.cm.tool.util.msg;




import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class MsgCall {

	/**
	 * fwq 亿美短信平台短信发送发送
	 * 
	 * @param user_id
	 * @param password
	 * @param mobile_phone 电话号码
	 * @param msg
	 * @return 返回结果:Xml格式 0 表示成功
	 */
	public static String ymSendMsg(String phone, String msg) {
		String ret_str = "";
		String user_id = "9SDK-EMY-0999-JDWTL";
		String password = "705350";
		
		try {
			String data = "cdkey=" + user_id + "&password=" + password
					+ "&phone=" + phone + "&message="
					+ URLEncoder.encode(msg, "UTF-8") + "&addserial=";
			
			URL url = new URL("http://sdk999ws.eucp.b2m.cn:8080/sdkproxy/sendsms.action?");
			URLConnection conn = url.openConnection();
			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(data);
			wr.flush();
			
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			while ((line = rd.readLine()) != null) {
				ret_str = ret_str + line;
			}
			wr.close();
			rd.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret_str;
	}

	
	public static String getRomcode(){
		return String.valueOf((Math.random()*9+1)*100000).substring(0, 6);  
	}
}
