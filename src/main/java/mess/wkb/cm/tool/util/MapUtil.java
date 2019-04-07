package mess.wkb.cm.tool.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import net.sf.json.JSONObject;

public class MapUtil {
	public static String GetLocationMsg(double latitude,double longitude){

		String message = "";
//		String ak="T2nwphiIpi2QRUbdmLTQf8z1e3SP2Wgc";
//		String url = String.format(
//						"http://api.map.baidu.com/geocoder/v2/?callback=renderReverse&location=%s,%s&output=json&pois=1&latest_admin=1&ak=%s",
//						latitude,longitude,ak);
		String key="ee5ca956120c2a332e9ed8ca25d01ab5";
		String url = String.format(
				"https://restapi.amap.com/v3/geocode/regeo?output=json&location=%s,%s&key=%s",
				latitude,longitude,key);
		URL myURL = null;
		URLConnection httpsConn = null;
		try {
			myURL = new URL(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			httpsConn = (URLConnection) myURL.openConnection();
			if (httpsConn != null) {
				InputStreamReader insr = new InputStreamReader(
						httpsConn.getInputStream(), "UTF-8");
				BufferedReader br = new BufferedReader(insr);
				String data = null;
				while ((data = br.readLine()) != null) {
					message = message+data;
				}
				insr.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return message;

	}
	public static String getAddress(double latitude,double longitude) {
		String obj=GetLocationMsg(latitude,longitude);
		JSONObject json = JSONObject.fromObject(obj);
//		System.out.println(json.getString("status"));
		JSONObject result=json.getJSONObject("regeocode");
//		System.out.println(result.toString());
		String address = result.getString("formatted_address");
		
		return address;
	}
	public final static void main(String[] args) {

//	        	String obj=GetLocationMsg(119.371528,26.085293);
	        	
	        	//baidu
	        	//转换成json格式字符串
//	        	int index1 = obj.indexOf('(');
//    			String a = obj.substring(index1 + 1);
//    			String jsonStr = a.substring(0, a.length()-1);
//    			System.out.println(jsonStr);
//	        	JSONObject json = JSONObject.fromObject(jsonStr);
    			//转换为json对象
    			//第一层
//    			System.out.println(json.getString("status"));
    			//第二层
//    			JSONObject result=json.getJSONObject("result");
//    			System.out.println(result.getString("formatted_address"));
    			
	        	//高德
//    			JSONObject json = JSONObject.fromObject(obj);
//    			System.out.println(json.getString("status"));
//    			JSONObject result=json.getJSONObject("regeocode");
//    			System.out.println(result.toString());
//    			System.out.println(result.getString("formatted_address"));
	        	
	        	
	        	System.err.println(getAddress(119.371994, 26.0838689));
	}
}