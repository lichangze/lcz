package com.report.test;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.service.IEamPosLineService;
import com.bmzy.report.service.ISysUserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AdjustServiceImplTest {


	@Resource
	private ISysUserService sysUserService; 
	@Resource
	private IEamPosLineService eamPosLineCore;
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟
	
	@Test
	public void test() throws ParseException {
		System.out.println(eamPosLineCore.selectByExampleLog(null));
	}
	
	

}
