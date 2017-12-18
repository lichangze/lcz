package com.report.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.model.SecurityCheckEntity;
import com.bmzy.report.service.ISecurityCheckService;

import tk.mybatis.mapper.entity.Example;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SecurityCheckServiceImplTest {
   @Resource
   private ISecurityCheckService securitycheckservice;
	@Test
	public void test() {
		Example example = new Example(SecurityCheckEntity.class);
		example.setOrderByClause("cdate desc");
		List<SecurityCheckEntity> list = securitycheckservice.selectByExample(example);
		System.out.println(list.get(0).getcDate());
		
	}

}
