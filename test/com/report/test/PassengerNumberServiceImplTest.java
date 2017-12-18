package com.report.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.model.PassengerNumberEntity;
import com.bmzy.report.service.IPassengerNumberService;

import tk.mybatis.mapper.entity.Example;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class PassengerNumberServiceImplTest {
   @Resource
   private IPassengerNumberService passEngerNumberService;
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟

	@Test
	public void test() {
		Example example = new Example(PassengerNumberEntity.class);
		example.setOrderByClause("RecordDate desc");
			List<PassengerNumberEntity> list = passEngerNumberService.selectByExample(example);
			System.out.println(sdf.format(list.get(0).getRecordDate()));
	}

}
