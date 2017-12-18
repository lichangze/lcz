package com.report.test;


import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.model.GisStation;
import com.bmzy.report.service.IGisStationService;
import com.bmzy.report.util.DataSource;
import com.bmzy.report.util.DbcontextHolder;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class IGisStationServiceTest {

	
	@Resource
	private IGisStationService gisStationsSrvice;
	@Test
	public void test() {
		Example ex = new Example(GisStation.class);
		Criteria c = ex.createCriteria();
		c.andEqualTo("lineId", 1);
		c.andEqualTo("transd", 1);
		List<GisStation> list = gisStationsSrvice.selectByExample(ex);
		for(GisStation e:list){
			e.setType("1");
			gisStationsSrvice.updateAll(e);
		}
	}

}
