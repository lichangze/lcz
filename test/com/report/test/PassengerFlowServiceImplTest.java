package com.report.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.model.PassengerFlowEntity;
import com.bmzy.report.service.IPassengerFlowService;

import tk.mybatis.mapper.entity.Example;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PassengerFlowServiceImplTest {
    @Resource
    private IPassengerFlowService passengerflowService;
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟

    
	@Test
	public void test() {
		Example example = new Example(PassengerFlowEntity.class);
		example.setOrderByClause("id desc");
		List<PassengerFlowEntity> list = passengerflowService.selectByExample(example);
		System.out.println(sdf.format(list.get(0).getId()));
		
	}

}
