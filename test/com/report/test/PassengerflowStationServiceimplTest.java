package com.report.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.model.PassengerFlowStationEntity;
import com.bmzy.report.service.IPassengerflowStationService;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class PassengerflowStationServiceimplTest {
	@Resource
	private IPassengerflowStationService passengerflowstationservice;
	 
		@Test
		public void test() {
			
			Example example = new Example(PassengerFlowStationEntity.class);
			PageHelper.startPage(1, 10);
			example.setOrderByClause("id desc");
			List<PassengerFlowStationEntity> Page =passengerflowstationservice.selectByExample(example);
			System.out.println(Page.get(0).getId());
			
		}
}
