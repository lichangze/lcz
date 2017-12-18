package com.report.test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.ftp.FileUtil;
import com.bmzy.report.model.PassEngerQuantityEntity;
import com.bmzy.report.service.IPassEngerQuantityService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class CerFilecheak {
	@Resource
	private IPassEngerQuantityService passengerquantityService;
	
	 char FIELD_SPR = 0x01;  //十六进制分隔符
	 String FIELD = " ";
     String LINE_SPR = "\n"; //换行符
     public static final SimpleDateFormat dateFormater = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
	@Test
	public void test11() throws IOException{
		FileUtil file = new FileUtil();
		int sum = 0; 
		List<PassEngerQuantityEntity> list =passengerquantityService.selectByExample(null);
		for(PassEngerQuantityEntity gis:list ){
			sum++;

			file.method2("C:/Users/sjsj/Desktop/tadw_zd_passengerquantity_i_20171009.dat", gis.getId()+FIELD_SPR+gis.getLineId()+FIELD_SPR+dateFormater.format(gis.getcDate())+FIELD_SPR+gis.getPasValue()+LINE_SPR);

	//		file.method2("C:/Users/July_whj/Desktop/zd_zd_passengerquantity_i_20171009.dat", gis.getId()+FIELD_SPR+gis.getLineId()+FIELD_SPR+dateFormater.format(gis.getcDate())+FIELD_SPR+gis.getPasValue()+LINE_SPR);

			if(sum==50){
				break;
			}
		}

//		file.fileCheckChk("C:/Users/sjsj/Desktop/tadw_zd_passengerquantity_i_20171009.dat","zd_passengerquantity", sum);

	//	file.fileCheckChk("C:/Users/July_whj/Desktop/zd_zd_passengerquantity_i_20171009.dat","zd_passengerquantity", sum);

		}
	
	
}
