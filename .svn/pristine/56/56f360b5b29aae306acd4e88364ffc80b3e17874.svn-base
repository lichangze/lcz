package com.bmzy.report.ws.view;

import java.util.List;

import com.alibaba.fastjson.JSON;

public class JsonUtil {
	
	public static String beantoJSONString(Object t){
		return JSON.toJSONString(t);
	}	
	
	public static <T> T  jsonToBean(String json,Class<T> cls){
		return JSON.parseObject(json, cls);
	}
	
	public static <T> List<T> jsonToArray(String json,Class<T> cls){
		return JSON.parseArray(json, cls);
	}
}
