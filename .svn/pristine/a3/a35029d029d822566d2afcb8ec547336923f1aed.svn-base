package com.bmzy.report.ws.sj.Util;
/**
 * 签名工具类
 * @author 徐永君
 * @Date 2016-8-29 下午04:52:43
 */
public class SignUtil {
	
	/**
	 * 获取32位随机字符串
	 * @return
	 */
	public static String getNonceStr_32(){
		//随机字符串
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int maxPos = chars.length();
        String nonceStr = "";
        for(int i = 0; i < 32; i++){
        	nonceStr += chars.charAt((int) Math.floor(Math.random() * maxPos));
        }
		return nonceStr;
	}
	/**
	 * 获取当前时间的时间戳
	 * @return
	 */
	public static String getTimestamp(){
		String timestamp = String.valueOf(System.currentTimeMillis());
		return timestamp;
	}
	/**
	 * 签名处理
	 * @author 徐永君
	 * @Date 2016-8-29 下午04:52:30
	 * @param systemId
	 * @param privateKey
	 * @return
	 */
	public static String getSign(String systemId, String timeStamp, String nonceStr, String privateKey){
		String sign = MD5.Md5_32(systemId + timeStamp + nonceStr + privateKey);
		return sign;
	}
}
