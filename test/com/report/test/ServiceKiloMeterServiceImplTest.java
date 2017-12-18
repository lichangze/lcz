package com.report.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.model.ServiceKiloMeterEntity;
import com.bmzy.report.service.IServiceKiloMeterService;

import tk.mybatis.mapper.entity.Example;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ServiceKiloMeterServiceImplTest {
   @Resource
   private IServiceKiloMeterService servicekilometerSerivice;
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟

	@Test
	public void test() {
		Example example = new Example(ServiceKiloMeterEntity.class);
		example.setOrderByClause("cDate desc");
		List<ServiceKiloMeterEntity> list = servicekilometerSerivice.selectByExample(example);
		System.out.println(sdf.format(list.get(0).getcDate()));
		
	}

}
