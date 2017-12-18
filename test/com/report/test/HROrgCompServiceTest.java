package com.report.test;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.model.HROrgCompEntity;
import com.bmzy.report.service.IHROrgCompService;
import com.bmzy.report.ws.sj.Util.HttpService;
import com.bmzy.report.ws.sj.Util.SignUtil;
import com.bmzy.report.ws.view.JsonUtil;
import com.bmzy.report.ws.viewModel.WsCompanyModel;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HROrgCompServiceTest {

	@Resource
	private IHROrgCompService hROrgCompService;

	@Test
	public void test() throws IOException {
		List<HROrgCompEntity> list = hROrgCompService.selectByExample(null);
		WsCompanyModel co = new WsCompanyModel();
		co.setMsg("公司表");
		co.setData(list);
		String json = JsonUtil.beantoJSONString(co);
		//getsj(json);
		
	}

	public void getsj(String json) throws IOException{
		// 系统id
				String system_id = "100";
				// 私钥
				String privateKey = "R5hDggMmBcfpbSY6KJfq18sKLunqCM3sMkEgMWTwVkhWf4tzn4xKiYnzBSihAYje";
				// 接口地址
				String url = "http://124.207.126.122/bjsjajj/interface/edr/corp/institution/delete";
				// 封装HTTP请求
				HttpService httpService = new HttpService(url);
				String time_stamp = SignUtil.getTimestamp();
				String nonce_str = SignUtil.getTimestamp();
				String sign = SignUtil.getSign(system_id, time_stamp, nonce_str, privateKey);
				httpService.addParameter("system_id", system_id);
				httpService.addParameter("time_stamp", time_stamp);
				httpService.addParameter("nonce_str", nonce_str);
				httpService.addParameter("sign", sign);
				httpService.addParameter("data", json);
				String responseJson = httpService.sendPostRequest();
				//System.out.println(responseJson);
				//System.out.println(json);
	}
	
}
