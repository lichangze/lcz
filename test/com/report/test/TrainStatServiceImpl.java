package com.report.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.model.TrainStatEntity;
import com.bmzy.report.service.ITrainStatService;

import tk.mybatis.mapper.entity.Example;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TrainStatServiceImpl {

@Resource
private ITrainStatService trainstatService;

public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟

	@Test
	public void test(){
		Example example = new Example(TrainStatEntity.class);
		example.setOrderByClause("cDate desc");
		List<TrainStatEntity> list = trainstatService.selectByExample(example);
		System.out.println(list.get(0).getcDate());
		
	}

}
