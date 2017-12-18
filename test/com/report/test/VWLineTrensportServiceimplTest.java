package com.report.test;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.model.GisStation;
import com.bmzy.report.model.VWLineTrensport;
import com.bmzy.report.model.VWSectionFlow;
import com.bmzy.report.service.IGisStationService;
import com.bmzy.report.service.IVWLineTrensportService;
import com.bmzy.report.service.IVWSectionFlowService;
import com.bmzy.report.service.IVWTranSportService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class VWLineTrensportServiceimplTest {

	@Resource
	private IVWLineTrensportService vwlinetrensport;
	@Resource
	private IVWSectionFlowService iWSectionFlowService;
	@Resource
	private IGisStationService gisStationService;
	@Resource
	private IVWTranSportService vwranSportService;
	
	@Test
	public void test() {
//		Example example = new Example(VWSectionFlow.class);
//		Criteria c1 = example.createCriteria();
//		c1.andEqualTo("cDate", "2017-08-22").andEqualTo("times", "18:00");
////		List<VWSectionFlow> lista =  iWSectionFlowService.selectByExample(example);
//		List<VWSectionFlow> list = gisStation(lista);
//		Map<String, VWSectionFlow> appleMap = list.stream().collect(Collectors.toMap(VWSectionFlow::getSectionid, a -> a,(k1,k2)->k1));//转换map
//		Map<String, List<VWSectionFlow>> groupBy = list.stream().collect(Collectors.groupingBy(VWSectionFlow::getTimes));//分组
//		List<VWSectionFlow> bi = new ArrayList<VWSectionFlow>();    
//		for (VWSectionFlow VW : list) {
//            boolean state = false;    
//            for (VWSectionFlow bills : bi) {    
//                if(bills.getLineID().equals(VW.getLineID())&&bills.getTransd().equals(VW.getTransd())){    
//                    int num = bills.getNum();    
//                    num += VW.getNum();    
//                    bills.setNum(num);    
//                    state = true;    
//                }    
//            }    
//            if(!state){    
//                bi.add(VW);    
//            }    
//        }    
//		for(VWSectionFlow v:bi){
//			System.out.println(v.getLineID()+"    "+v.getSectionid()+"    "+v.getTimes()+"    "+v.getNum()+"运力：");//+
//		}
//		Example exampleLine = new Example(VWLineTrensport.class);
//		Criteria c = exampleLine.createCriteria();
//		c.andEqualTo("lineid", "1").andEqualTo("times", "08:00");
//		List<VWLineTrensport> listline = vwlinetrensport.selectByExample(exampleLine);
//		for(VWLineTrensport line:listline){
//			System.out.println("运力："+line.getTransd()+"  "+line.getTranscode()+"  :"+line.getNum()*line.getTransport()*6);
//		}
		System.out.println(vwranSportService.selectByExample(null).size());
		
	}

	public List<VWSectionFlow> gisStation(List<VWSectionFlow> list){
		List<VWSectionFlow> listreturn = new ArrayList<>();
		for(VWSectionFlow w:list){
			if(!w.getLineID().equals("7")){
				GisStation gis = gisStationService.selectByKey(w.getSectionid());
				w.setTransd(gis.getTransd());
				listreturn.add(w);
			}
		}
		return listreturn;
	}
	
	
	
}
