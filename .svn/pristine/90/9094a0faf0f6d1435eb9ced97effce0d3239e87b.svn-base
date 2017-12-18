package com.bmzy.report.gis.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bmzy.generic.core.controller.ActionBaseController;
import com.bmzy.generic.core.support.PageBaseParameter;
import com.bmzy.report.model.GisStation;
import com.bmzy.report.model.VWLineEntity;
import com.bmzy.report.model.VWLineTrensport;
import com.bmzy.report.model.VWTranSportCapacityEntityy;
import com.bmzy.report.service.IGisStationService;
import com.bmzy.report.service.IVWLineTrensportService;
import com.bmzy.report.service.IVWTLineService;
import com.bmzy.report.service.IVWTranSportService;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Function;
import com.google.common.collect.Maps;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;
@Controller
@RequestMapping("/gisyl")
public class GisYlController extends ActionBaseController<PageBaseParameter>{

	
	@Resource
	private IGisStationService gisStationService;
	@Resource
	private IVWLineTrensportService lineTrensportService;
	@Resource
	private IVWTranSportService tranSportService;
	@Resource
	private IVWTLineService lineService;
	
	
	Map<String,GisStation> mapGis = null;
	Map<String,VWLineTrensport> mapLine = null;
	
	@Override
	public void getColHidden(HttpServletRequest arg0, HttpServletResponse arg1) throws IOException {
	}

	@RequestMapping(value = "/gisflow", method = { RequestMethod.POST, RequestMethod.GET })
	public void zd_mb_car(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String showTime = request.getParameter("showTime");
		String lineId = request.getParameter("lineID");
		String transcode = request.getParameter("transcode");
		String date = request.getParameter("date");
		String times = request.getParameter("times");
		String num = request.getParameter("num");
		if(mapGis == null){
			System.out.println("Gis初始化..");
			mapGis = getMap();
			System.out.println(mapGis.get("1").getSectionName());
		}
		writeJSON(response, getDateStation(showTime,lineId,transcode,date,times,num));
	}
	
	@RequestMapping(value = "/getMsgValue", method = { RequestMethod.POST, RequestMethod.GET })
	public void getMsgValue(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Map<String, String> map = new HashMap<>();
		Example example = new Example(VWTranSportCapacityEntityy.class);
		Criteria c = example.createCriteria();
		int tranNum=0;
		int transportnum = 0;
		String showTime = request.getParameter("showTime");
		String lineId = request.getParameter("lineID");
		String transcode = request.getParameter("transcode");
		String date = request.getParameter("date");
		String times = request.getParameter("times");
		String num = request.getParameter("num");
		if(showTime == null){
			showTime = "05:00";
		}
		c.andEqualTo("Times", showTime);
		if(lineId != null && !lineId.equals("ALL")){
			c.andEqualTo("lineid", lineId);
		}else{
			c.andNotEqualTo("lineid", "7");
		}
		if(transcode != null && !transcode.equals("undefined")){
			c.andEqualTo("transcode", transcode);
		}else{
			transcode = "默认运行图";
		}
		if(date != null&&!date.equals("")){
			c.andEqualTo("cdate", date);
		}else{
			date =getMaxDate();
			c.andEqualTo("cdate", date);
		}
		if(times != null && num != null && times.equals(showTime)){
			transportnum = Integer.parseInt(num);
		}
		List<VWTranSportCapacityEntityy> list = tranSportService.selectByExample(example);
		Map<Integer, Integer> mapNum = gettransportnum(list);
		for(VWTranSportCapacityEntityy v:list){
			tranNum =tranNum + v.getSectionnum();
		}
		map.put("dateValue", date);
		map.put("timeValue", showTime);
		map.put("lineValue", getLineName(lineId));
		map.put("transcodeValue", transcode);
		map.put("numValue", mapNum.get(1)+"");
		map.put("ylnumValue", mapNum.get(2)+"");
		map.put("yllnumValue", tranNum+"");
		writeJSON(response, map);
	}
	
	private Map<Integer, Integer> gettransportnum(List<VWTranSportCapacityEntityy> list){
		Map<Integer, Integer> map = new HashMap<>();
		int tranmun = 0;
		int tranylmun = 0;
		HashSet<String> set = new HashSet<>();
		for(VWTranSportCapacityEntityy v:list){
			if(v.getTranscode().substring(0, 2).equals("PR") || v.getTranscode().substring(0, 2).equals("TY")){
				String str = v.getLineid()+","+v.getTransportnum()+","+v.getTransport()+","+v.getTransd();
				set.add(str);
			}
		}
		List<String> lists = new ArrayList<>(set);
		for(String st:lists){
			String[] strs = st.split(",");
			tranmun = tranmun+(Integer.parseInt(strs[1]));
			tranylmun = tranylmun+(Integer.parseInt(strs[1])*Integer.parseInt(strs[2])*6);
		}
	        map.put(1, tranmun);
	        map.put(2, tranylmun);
		return map;
	}
	
	private String getMaxDate(){
		Example example = new Example(VWTranSportCapacityEntityy.class);
		PageHelper.startPage(1, 2);
		example.setOrderByClause("cdate");
		List<VWTranSportCapacityEntityy> list = tranSportService.selectByExample(example);
		return list.get(0).getCdate();
	}
	
	
	
	@RequestMapping(value = "/test", method = { RequestMethod.POST, RequestMethod.GET })
	public void test(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String line = request.getParameter("lineID");
		orderby(line);
	}
	
	@RequestMapping(value = "/chengeType", method = { RequestMethod.POST, RequestMethod.GET })
	public void chengeType(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String line = request.getParameter("lineID");
		chengeType(line);
	}
	
	@RequestMapping(value = "/getTranscode", method = { RequestMethod.POST, RequestMethod.GET })
	public void getTranscode(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		String line = request.getParameter("lineId");
		Example example = new Example(VWLineTrensport.class);
		example.createCriteria().andEqualTo("lineid", line);
		List<VWLineTrensport> list = lineTrensportService.selectByExample(example);
		HashSet<String> set = new HashSet<>();
		for(VWLineTrensport v:list){
			set.add(v.getTranscode());
		}
		List<String> listr = new ArrayList<>(set);
		StringBuffer strs = new StringBuffer();
		for(String str:listr){
			strs.append("<option value="+str+">"+str+"</option>");
		}
		writeJSON(response, strs.toString());
	}
	

	private  String getDateStation(String showtimes,String lineid,String transcode,String date,String times,String num)  {
		Example ex = new Example(VWTranSportCapacityEntityy.class);
		Criteria c = ex.createCriteria();
		if(showtimes == null){
			showtimes = "05:00";
		}
		c.andEqualTo("Times", showtimes);
		if(lineid != null && !lineid.equals("ALL")){
			c.andEqualTo("lineid", lineid);
		}else{
			c.andNotEqualTo("lineid", "7");
		}
		if(transcode != null && !transcode.equals("undefined")){
			c.andEqualTo("transcode", transcode);
		}
		
		if(date != null&&!date.equals("")){
			c.andEqualTo("cdate", date);
		}
		
		if(times != null && num != null){
			
		}
		List<VWTranSportCapacityEntityy> listTran = tranSportService.selectByExample(ex);
		StringBuffer strs = new StringBuffer();
		strs.append("[");
		String str = "";
		List<GisStation> list = getGisList(listTran);
		for(GisStation e:list){
			if(e.getTransd().equals("1") && e.getType() != null){
				str = e.getType();
			}else{
				str = e.getChangeVale();
			}
			strs.append("[");
		    strs.append(e.getValue()+","+str);
			strs.append("],");
		}
		return strs.toString().substring(0,strs.toString().length() - 1)+"]";
	}
	
	private List<GisStation> getGisList(List<VWTranSportCapacityEntityy> listTran){
		List<GisStation> list = new ArrayList<>();
		if(mapGis == null){
			mapGis = getMap();
		}else{
			for(VWTranSportCapacityEntityy tran:listTran){
				GisStation gis = mapGis.get(tran.getSectionid()+"");
				int b = (tran.getTransport()*tran.getTransportnum());
				if(b == 0){
					b=1;
				}
				if(tran.getSectionnum()/b  >= 2){
					gis.setValue(4);
				}else if(tran.getSectionnum()/b>=1 && tran.getSectionnum()/b < 2){
					gis.setValue(1.5);
				}else{
					gis.setValue(0.5);
				}
				list.add(gis);
			}
		}
		return list;
	}
	
	
	private String getLineName(String lineid){
		String name = "全路网";
		if(null ==lineid || lineid.equals("ALL")){
			
		}else{
			VWLineEntity line = lineService.selectByKey(Integer.parseInt(lineid));
			name = line.getLineName();
		}
		return name;
	}
	
	/**
	 * 初始化map
	 * @return
	 */
	private Map<String,GisStation> getMap(){
		Example example = new Example(GisStation.class);
		List<GisStation>  gis = gisStationService.selectByExample(example);
		Map<String,GisStation> mappedMovies = Maps.uniqueIndex(gis, new Function <GisStation,String> () {  
	          public String apply(GisStation from) {  
	            return from.getSectionId();   
	    }});  
		return mappedMovies;
	}
	
	
	
	/**
	 * 运算新的坐标点
	 */
	private void chengeType(String lineId){
		Example ex = new Example(GisStation.class);
		Criteria c = ex.createCriteria();
		c.andEqualTo("lineId", Integer.parseInt(lineId));
		c.andEqualTo("transd", 1);
		List<GisStation> list = gisStationService.selectByExample(ex);
		for(GisStation e:list){
			float a = 0,b= 0;
			String[] strs = e.getChangeVale().split(",");
			for(int i=0;i<strs.length;i++){
				if(i%2==0){
					a +=  Float.parseFloat(strs[i]);
				}else{
					b += Float.parseFloat(strs[i]);
				}
			}
			e.setType((a+30)+","+(b+30));
			gisStationService.updateAll(e);
		}
	}
	
	private void orderby(String lineid){
		Example ex = new Example(GisStation.class);
		ex.setOrderByClause("orderId");
		Criteria c = ex.createCriteria();
		c.andEqualTo("lineId", Integer.parseInt(lineid));
		c.andEqualTo("transd", 1);
		List<GisStation> list = gisStationService.selectByExample(ex);
		float a = 0,b = 0;
		float d = 0,f = 0;
		for(GisStation e:list){
			String[] strs = e.getType().split(",");
			if(a != 0 || b !=0){
				d = a - Float.parseFloat(strs[0]);
				f = b - Float.parseFloat(strs[1]);
				e.setType(e.getType()+","+d+","+f);
				gisStationService.updateAll(e);
			}
			a = Float.parseFloat(strs[0]);
			b = Float.parseFloat(strs[1]);
			
		}
	}
}
