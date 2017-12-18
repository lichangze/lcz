package com.report.test;
import java.util.List;
import org.junit.Test;
import com.bmzy.report.model.VWSTATIONTRANSFLOWEntity;
import com.bmzy.report.service.IVWSTATIONTRANSFLOWService;
import tk.mybatis.mapper.entity.Example;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class VWSTATIONTRANSFLOWServiceImplTest {
	private IVWSTATIONTRANSFLOWService vwstationtransflowService;
	@Test
	public void test(){
		Example example = new Example(VWSTATIONTRANSFLOWEntity.class);
		example.setOrderByClause("STATIONID desc");
		List<VWSTATIONTRANSFLOWEntity> list = vwstationtransflowService.selectByExample(example);
		System.out.println(list.get(0).getNum());
	}
}
