package com.report.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.model.PassengerflowStationTenTestEntity;
import com.bmzy.report.service.IPassengerflowStationTenTestService;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PassengerflowStationTenTestServiceImplTest {
@Resource
  private IPassengerflowStationTenTestService passengerflowstationtentestservice;
	@Test
	public void test() {
		Example example = new Example(PassengerflowStationTenTestEntity.class);
		PageHelper.startPage(1, 10);
		example.setOrderByClause("id desc");
		List<PassengerflowStationTenTestEntity> page = passengerflowstationtentestservice.selectByExample(example);
		System.out.println(page.get(0).getId());
	}

}
