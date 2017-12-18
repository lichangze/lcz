package com.report.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.model.PowerSupplyEntity;
import com.bmzy.report.service.IPassEngerQuantityService;
import com.bmzy.report.service.IPowerSupplyService;

import tk.mybatis.mapper.entity.Example;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class PowerSupplyServiceImplTest {
	
	@Resource
	private IPowerSupplyService powersupplyService;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟
    

	@Test
	public void test() {
		Example example = new Example(PowerSupplyEntity.class);
	    example.setOrderByClause("cDate desc");
	    List<PowerSupplyEntity> list = powersupplyService.selectByExample(example);
	    System.out.println(sdf.format(list.get(0).getcDate()));
		  
	}

}
