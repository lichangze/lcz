package com.bmzy.report.ws.view;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		SysUserModel user = new SysUserModel();
		user.setUserName("张三");
		String json = JsonUtil.beantoJSONString(user);
		//System.out.println(json);
		
		
		
		String str = WsHttpUtil.sendGet("http://10.19.1.177:8080/aems-pda-service/sys/sysuser/getSysUser", "rows=10&page=1&workAreaid=274e4499-30e5-4edc-ba9a-7745d249abb3");
		System.out.println(str);
//		SysUserModel user2 = JsonUtil.jsonToBean(str, SysUserModel.class);
		//List<SysUserModel> list = JsonUtil.jsonToArray(str, SysUserModel.class);
		//System.out.println(list.get(0).getUserName());
	}
	
	
	public String getUserjson(){
		WsUtil ws = new WsUtil();
		ws.setIp("localhost");
		ws.setPort("8080");
		ws.setMethodUrl("");
		return null;
	}
	
}
