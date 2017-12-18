package com.report.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.model.KiloMeterEntity;
import com.bmzy.report.service.IKilometerService;
import com.bmzy.report.ws.view.JsonUtil;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class KiloMeterServiceImplTest {
    @Resource
    private IKilometerService kilometerService;
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 小写的mm表示的是分钟

	@Test
	public void test() {
		KiloList ki = new KiloList();
		Example example = new Example(KiloMeterEntity.class);
		example.setOrderByClause("cDate desc");
		PageHelper.startPage(1, 10);
		List<KiloMeterEntity> list = kilometerService.selectByExample(example);
		ki.setData("走行公里");
		ki.setList(list);
		String json = JsonUtil.beantoJSONString(ki);
		System.out.println(json);
	}

}
