package com.report.test;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.model.AdjustEntity;
import com.bmzy.report.model.ZdLine;
import com.bmzy.report.service.IAdjustService;
import com.bmzy.report.service.IDailyPlanService;
import com.bmzy.report.service.IZDLineService;

import tk.mybatis.mapper.entity.Example;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class DailyPlanServiceImplTest {

	@Resource
	private IDailyPlanService dailyPlanService;
	@Resource
	private IZDLineService zdservice;
	@Resource
	private IAdjustService adjustService;
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟
	
	@Test
	public void test() {
		for(int i=1;i<5;i++){
			addAdjust(i);
		}
	}

	private void addAdjust(int i){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟
		Date date = new Date();// 获取当前时间
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, -i);
		calendar.getTime();// 获取一年前的时间，或者一个月前的时间
		List<String> lineList = selectline(sdf.format(calendar.getTime()));
		List<ZdLine> lineAllList = zdservice.selectByExample(null);
		for(ZdLine line:lineAllList){
			if(!lineList.contains(line.getZd_lineno())){
				AdjustEntity entity = new AdjustEntity();
				entity.setId(date.getTime()+line.getZd_lineno());
				entity.setcDate(calendar.getTime());
				entity.setLineId(line.getZd_lineno());
				entity.setaChange("0");
				entity.setcLear("0");
				entity.setMiss("0");
				entity.setDown("0");
				adjustService.save(entity);
			}
		}
	
	}
	
	private List<String> selectline(String date){
		List<String> reList = new ArrayList<>();
		Example example = new Example(AdjustEntity.class);
		example.createCriteria().andEqualTo("cDate", date);
		List<AdjustEntity> list =  adjustService.selectByExample(example);
		for(AdjustEntity ad:list){
			reList.add(ad.getLineId());
		}
		return reList;
	}

	
}
