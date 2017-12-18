package com.report.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.model.JmDailyMaintenanceDateEntity;
import com.bmzy.report.service.IJmDailyMaintenanceDataService;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JmDailyMaintenanceDataServiceImplTest {
    @Resource
    private IJmDailyMaintenanceDataService jmdailymaintenancedataService;
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟

	@Test
	public void test() {
		Example example = new Example(JmDailyMaintenanceDateEntity.class);
		PageHelper.startPage(1, 100);
		example.setOrderByClause("date desc");
		List<JmDailyMaintenanceDateEntity> list = jmdailymaintenancedataService.selectByExample(example);
		System.out.println(list.get(0).getDate());
	}

}
