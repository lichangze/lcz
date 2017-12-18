package com.report.test;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.dao.ISysMenuDao;
import com.bmzy.report.service.IGisService;
import com.bmzy.report.service.IHROrgDeptService;
import com.bmzy.report.service.ISysMenuService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ISysMenuDaoTest {

	@Resource
	private ISysMenuDao sysdao;
	@Resource
	private ISysMenuService sysser;
	@Resource
	private IGisService gis;
	@Resource
	private IHROrgDeptService hrorgdept;
	
	@Test
	public void test() {
		
		
	}

}
