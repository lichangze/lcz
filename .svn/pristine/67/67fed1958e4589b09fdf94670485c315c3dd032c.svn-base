package com.report.test;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.ftp.FtpTaskUtil;
import com.bmzy.report.service.IAdjustService;
import com.bmzy.report.service.IZDLineService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ZdlineServiceImplTest extends FtpTaskUtil{
	@Resource
	private IZDLineService zdservice;
	@Resource
	private IAdjustService adjustService;
	
	@Test
	public void test() {
		System.out.println(zdservice.selectByExample(null).iterator().next().getLine_name());
	}
	
	
	

}
