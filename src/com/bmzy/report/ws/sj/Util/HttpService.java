package com.bmzy.report.ws.sj.Util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * <b>远程发送HTTP的POST请求</b> author lw
 * 
 */
public class HttpService {
	// 请求、应答的字符集
	private final String charset = "utf-8";

	// Servlet服务访问地址
	private String serviceUrl;

	// 请求参数封装
	private Map<String,String> pMap;

	// 有参构造
	public HttpService(String serviceUrl) {
		this.serviceUrl = serviceUrl;
		pMap = new HashMap<String,String>(10);
	}

	/**
	 * <b>向POST请求中加入参数</b> time: 2012-5-21 author：lw
	 * 
	 * @param pName
	 * @param pValue
	 */
	public void addParameter(String pName, String pValue) {
		pMap.put(pName, pValue);
	}

	/**
	 * <b>发送POST请求</b> time: 2012-5-21 author：lw
	 * 
	 * @param mMap
	 *            请求内容暂时只支持<key:String,value:String>
	 * @throws IOException
	 */
	public String sendPostRequest() throws IOException {
		URL mUrl = new URL(serviceUrl);
		HttpURLConnection conn = (HttpURLConnection) mUrl.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setUseCaches(false);
		// 设置POST
		conn.setRequestProperty("Content-type",
				"application/x-www-form-urlencoded");
		conn.connect();
		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
		StringBuffer sb = new StringBuffer();
		// 封装HTTP参数
		Iterator<Map.Entry<String, String>> iter = pMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, String> next = (Map.Entry<String, String>)iter.next();
			Map.Entry<String,String> entry = next;
			String key = entry.getKey();
			String value = entry.getValue();
			sb.append(key).append("=").append(value).append("&");
		}
		String content = sb.substring(0, sb.length() - 1);
		dos.write(content.getBytes(charset));
		dos.flush();
		dos.close();
		// 获取HTTP请求状态码
		int responseCode = conn.getResponseCode();
		// HTTP请求成功
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), charset));
			String line;
			// 清空字符缓存
			sb.delete(0, sb.length());
			// 循环获取应答信息
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			conn.disconnect();
			return sb.toString();
		} else// HTTP请求失败
		{
			System.out.println(responseCode);
			throw new IOException("Service is Bad!");
		}
	}

	public String sendGetRequest() throws IOException {
		URL mUrl = new URL(serviceUrl);
		HttpURLConnection conn = (HttpURLConnection) mUrl.openConnection();
		conn.setRequestMethod("GET");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setUseCaches(false);
		// 设置POST
		conn.setRequestProperty("Content-type",
				"application/x-www-form-urlencoded");
		conn.connect();
		DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
		StringBuffer sb = new StringBuffer();
		// 封装HTTP参数
		Iterator<Entry<String, String>> iter = pMap.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			sb.append(key).append("=").append(value).append("&");
		}
		String content = sb.substring(0, sb.length() - 1);
		dos.write(content.getBytes(charset));
		dos.flush();
		dos.close();
		// 获取HTTP请求状态码
		int responseCode = conn.getResponseCode();
		// HTTP请求成功
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), charset));
			String line;
			// 清空字符缓存
			sb.delete(0, sb.length());
			// 循环获取应答信息
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			reader.close();
			conn.disconnect();
			return sb.toString();
		} else// HTTP请求失败
		{
			throw new IOException("Service is Bad!");
		}
	}

	/**
	 * <b>test main</b> time: 2012-5-21 author：lw
	 * 
	 * @param args
	 */
//	public void test1() throws IOException{
//		String url = "http://192.168.1.30:8080/bjsjajj/mobile/statis/hd/data/json";
//		HttpService httpService = new HttpService(url);
//		httpService.addParameter("userId", "18361");
//		String responseJson = httpService.sendPostRequest();
//		System.out.println(responseJson);
//	}
	public static void main(String[] args) throws IOException {
//		String url = "http://localhost:8080/bjsjajj/longon";
//		HttpService httpService = new HttpService(url);
//		httpService.addParameter("agentcode", "410027640");
//		httpService.addParameter("psw", "4100276401320");
//		try {
//			System.out.println(httpService.sendPostRequest());
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
//		String url = "http://192.168.1.30:8080/bjsjajj/mobile/statis/hd/data/json";
//		HttpService httpService = new HttpService(url);
//		httpService.addParameter("userId", "18361");
//		String responseJson = httpService.sendPostRequest();
//		System.out.println(responseJson);
		
		String url = "http://192.168.1.30:8080/bjsjajj/mobile/oa/user/sign/queryStatus";
		HttpService httpService = new HttpService(url);
		httpService.addParameter("userId", "18361");
		httpService.addParameter("signAddress", "signAddress");
		httpService.addParameter("signCoord", "signCoord");
		String responseJson = httpService.sendPostRequest();
		//System.out.println(responseJson);
	 }
}	

