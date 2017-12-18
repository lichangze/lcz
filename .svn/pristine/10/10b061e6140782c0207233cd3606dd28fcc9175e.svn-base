package com.report.test;



import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.dao.PassEngerQuantityDao;
import com.bmzy.report.model.DailyPlanEntity;
import com.bmzy.report.model.PassEngerQuantityEntity;
import com.bmzy.report.service.IDailyPlanService;
import com.bmzy.report.service.IPassEngerQuantityService;

import tk.mybatis.mapper.entity.Example;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PassEngerQuantityDaoTest {

	@Resource
	private IPassEngerQuantityService passEngerQuantityService;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟
	
	@Test
	public void test() {
		Example example = new Example(PassEngerQuantityEntity.class);
	example.setOrderByClause("cDate desc");
		List<PassEngerQuantityEntity> list = passEngerQuantityService.selectByExample(example);
		System.out.println(sdf.format(list.get(0).getcDate()));
	}
	

}
