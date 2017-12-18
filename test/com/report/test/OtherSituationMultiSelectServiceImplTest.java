package com.report.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.model.OtherSituationMultiSelectEntity;
import com.bmzy.report.model.VehicleServiceUsageEntity;
import com.bmzy.report.service.IOtherSituationMultiSelectService;
import com.bmzy.report.service.IVehicleServiceUsageService;

import tk.mybatis.mapper.entity.Example;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class OtherSituationMultiSelectServiceImplTest {
	@Resource
	private IOtherSituationMultiSelectService otherSituationMultiSelectservice;
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟

	@Test
	public void test() {
		Example example = new Example(OtherSituationMultiSelectEntity.class);
		example.setOrderByClause("RecordDate desc");
			List<OtherSituationMultiSelectEntity> list = otherSituationMultiSelectservice.selectByExample(example);
			System.out.println(sdf.format(list.get(0)));
	}

}
