package com.report.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.model.JmInformationWasEntity;
import com.bmzy.report.service.IJmInformationWasService;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JmInformationWasServiceImplTest {
    @Resource
    private IJmInformationWasService jminformationwasService;
	@Test
	public void test() {
		Example example = new Example(JmInformationWasEntity.class);
		PageHelper.startPage(1, 100);
		example.setOrderByClause("UpdateTime desc");
		List<JmInformationWasEntity> list = jminformationwasService.selectByExample(example);
		System.out.println(list.get(0).getLine());
		
		
	}

}
