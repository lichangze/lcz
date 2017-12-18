package com.bmzy.report.gis.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
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
import com.bmzy.report.model.GisEntity;
import com.bmzy.report.service.IAdjustService;
import com.bmzy.report.service.IDailyPlanService;
import com.bmzy.report.service.IDeviceErrorService;
import com.bmzy.report.service.IGisService;
import com.bmzy.report.service.INoteService;
import com.bmzy.report.service.IPassEngerQuantityService;

/**
 * @author July_whj
 *
 */
@Controller
@RequestMapping("/gis")
public class GisDataController extends ActionBaseController<PageBaseParameter> {
	private final static String ENCODE = "utf-8";

	@Resource
	private IGisService gisService;

	@Resource
	private IPassEngerQuantityService passService;
	@Resource
	private IAdjustService adService;
	@Resource
	private IDailyPlanService dailyService;
	@Resource
	private INoteService noteService;
	@Resource  
	private IDeviceErrorService deviceService;

	// 客流展示ֵ
	@RequestMapping(value = "/passengerflow", method = { RequestMethod.POST, RequestMethod.GET })
	public void zd_mb_car(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Map<String, String> json = this.getDatepass();
		writeJSON(response, json);

	}
	
	// 客流展示ֵ
		@RequestMapping(value = "/zhflow", method = { RequestMethod.POST, RequestMethod.GET })
		public void zhflow(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
			Map<String, String> json = this.getDatezh();
			writeJSON(response, json);

		}

		// 桥展示ֵ
				@RequestMapping(value = "/bridgeflow", method = { RequestMethod.POST, RequestMethod.GET })
				public void bridgeflow(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
					Map<String, String> json = this.getDatebridge(5,0);
					writeJSON(response, json);

				}
				
			
		
		
	// 设备展示
	@RequestMapping(value = "/assetflow", method = { RequestMethod.POST, RequestMethod.GET })
	public void assetflow(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Map<String, String> json = this.getDateasset(3, 0);
		writeJSON(response, json);
	}
	// JOB
	@RequestMapping(value = "/jobflow", method = { RequestMethod.POST, RequestMethod.GET })
	public void jobflow(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Map<String, String> json = this.getDateJob(4, 0);
		writeJSON(response, json);
	}
	// HR
	@RequestMapping(value = "/empflow", method = { RequestMethod.POST, RequestMethod.GET })
	public void empflow(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Map<String, String> json = this.getDateasset(2, 0);
		writeJSON(response, json);
	}

	// ENER
	@RequestMapping(value = "/enerflow", method = { RequestMethod.POST, RequestMethod.GET })
	public void enerflow1(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Map<String, String> json = this.getDateener(6, 0);
		writeJSON(response, json);
	}
	// 牵引用电ENER
		@RequestMapping(value = "/qyenerflow", method = { RequestMethod.POST, RequestMethod.GET })
		public void qyenerflow(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
			Map<String, String> json = this.getDateener2(7, 0);
			writeJSON(response, json);
		}

	// ENER
	@RequestMapping(value = "/enerflow2", method = { RequestMethod.POST, RequestMethod.GET })
	public void enerflow2(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		Map<String, String> json = this.getDateener(7, 0);
		writeJSON(response, json);
	}
	 
	

	
	
	public String getURLDecoderString(String str) {
		String result = "";
		if (null == str) {
			return "";
		}
		try {
			result = java.net.URLDecoder.decode(str, ENCODE);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * mlc
	 * @param table
	 * @return
	 * @throws SQLException
	 */
	private Map<String, String> getDatepass() throws SQLException {
		Map<String, String> map = new HashMap<>();
		StringBuffer strs = new StringBuffer();
		StringBuffer strpo = new StringBuffer();
		strs.append("[");
		strpo.append("{");
		String station_name = null;
		int value = 40;
		String longitude = null;
		String latitude = null;
		int in_passenger = 0;
		int valuePs = 0;
		List<GisEntity> list = gisService.selectAllGis(1,20);	
		for (GisEntity entity : list ) {
			valuePs++;
			station_name = entity.getStation_name();
			value = entity.getValue();
			in_passenger = entity.getIn_passenger();
			latitude = entity.getLatitude() + "";
			longitude = entity.getLongitude() + "";
			strpo.append("'" + station_name + "':[" + longitude + "," + latitude + "],");
			strs.append("{ name: '");
			strs.append(station_name);
			strs.append("', value:");
			strs.append(value(value) - valuePs * 15);
			strs.append(", valueshow:");
			strs.append(value);
			strs.append(", valuein:");
			strs.append(in_passenger);
			strs.append(", valueout:");
			strs.append(value - in_passenger);
			strs.append(",visualMap: false},");
			}
		strpo.append("}");
		strs.append("]");
		map.put("value", strs.toString());
		map.put("station", strpo.toString());
		return map;
	}

	private Map<String, String> getDatezh() throws SQLException {
		Map<String, String> map = new HashMap<>();
		StringBuffer strs = new StringBuffer();
		StringBuffer strpo = new StringBuffer();
		strs.append("[");
		strpo.append("{");
		String station_name = null;
		int value = 40;
		String longitude = null;
		String latitude = null;
		int in_passenger = 0;
		int valuePs = 0;
		List<GisEntity> list = gisService.selectAllGis(1,0);	
		for (GisEntity entity : list ) {
			valuePs++;
			station_name = entity.getStation_name();
			value = entity.getValue();
			in_passenger = entity.getIn_passenger();
			latitude = entity.getLatitude() + "";
			longitude = entity.getLongitude() + "";
			strpo.append("'" + station_name + "':[" + longitude + "," + latitude + "],");
			strs.append("{ name: '");
			strs.append(station_name);
			strs.append("', value:");
			strs.append(value(value) - valuePs * 15);
			strs.append(", valueshow:");
			strs.append(value);
			strs.append(", valuein:");
			strs.append(in_passenger);
			strs.append(", valueout:");
			strs.append(value - in_passenger);
			strs.append(",visualMap: false},");
			}
		strpo.append("}");
		strs.append("]");
		map.put("value", strs.toString());
		map.put("station", strpo.toString());
		return map;
	}
	
	/**
	 * mlc�豸����Դ
	 * 
	 * @param table
	 * @return
	 * @throws SQLException
	 */
	private Map<String, String> getDatebridge(int type, int limit) throws SQLException {
		Map<String, String> map = new HashMap<>();
		StringBuffer strs = new StringBuffer();
		StringBuffer strpo = new StringBuffer();
		strs.append("[");
		strpo.append("{");
		String station_name = null;
		int value = 40;
		String longitude = null;
		String latitude = null;
		int in_passenger = 0;
		int out_passenger = 0;
		int valuePs = 0;
		List<GisEntity> list = gisService.selectAllGis(type,limit);
		for (GisEntity entity : list ) {
			valuePs++;
			station_name = entity.getStation_name();
			value = entity.getValue();
			in_passenger = entity.getIn_passenger();
			out_passenger = entity.getOut_passenger();
			latitude = entity.getLatitude() + "";
			longitude = entity.getLongitude() + "";
			strpo.append("'" + station_name + "':[" + longitude + "," + latitude + "],");
			strs.append("{ name: '");
			strs.append(station_name);
			strs.append("', value:");
			strs.append(value(value) - valuePs * 15);
			strs.append(", valueshow:");	
			strs.append(value);
			strs.append(", type:");	
			strs.append(type);
			strs.append(", valuein:");
			strs.append(in_passenger);
			strs.append(", valueout:");
			strs.append(out_passenger);
			strs.append(",visualMap: false},");
			}
		strpo.append("}");
		strs.append("]");
		map.put("value", strs.toString());
		map.put("station", strpo.toString());
		return map;
	}

	
	/**
	 * ener 能耗
	 * 
	 * @param table
	 * @return
	 * @throws SQLException
	 */
	private Map<String, String> getDateener(int type, int limit) throws SQLException {
		Map<String, String> map = new HashMap<>();
		StringBuffer strs = new StringBuffer();
		StringBuffer strpo = new StringBuffer();
		strs.append("[");
		strpo.append("{");
		String station_name = null;
		int value = 40;
		String longitude = null;
		String latitude = null;
		int in_passenger = 0;
		int out_passenger = 0;
		int valuePs = 0;
		List<GisEntity> list = gisService.selectAllGis(type,limit);
		for (GisEntity entity : list ) {
			valuePs++;
			station_name = entity.getStation_name();
			value = entity.getValue();
			in_passenger = entity.getIn_passenger();
			out_passenger = entity.getOut_passenger();
			latitude = entity.getLatitude() + "";
			longitude = entity.getLongitude() + "";
			strpo.append("'" + station_name + "':[" + longitude + "," + latitude + "],");
			strs.append("{ name: '");
			strs.append(station_name);
			strs.append("', value:");
			strs.append(value(value) - valuePs * 15);
			strs.append(", valueshow:");
			strs.append(value);
			strs.append(", type:");
			strs.append(type);
			strs.append(", valuein:");
			strs.append(in_passenger);
			strs.append(", valueout:");
			strs.append(out_passenger);
			strs.append(",visualMap: false},");
			}
		strpo.append("}");
		strs.append("]");
		map.put("value", strs.toString());
		map.put("station", strpo.toString());
		return map;
	}

	
	
	
	/**
	 * JOB
	 * 
	 * @param table
	 * @return
	 * @throws SQLException
	 */
	private Map<String, String> getDateJob(int type, int limit) throws SQLException {
		Map<String, String> map = new HashMap<>();
		StringBuffer strs = new StringBuffer();
		StringBuffer strpo = new StringBuffer();
		strs.append("[");
		strpo.append("{");
		String station_name = null;
		int value = 40;
		String longitude = null;
		String latitude = null;
		List<GisEntity> list = gisService.selectAllGis(type, limit);
		for (GisEntity entity : list) {
			station_name = entity.getStation_name();
			value = entity.getValue();
			latitude = entity.getLatitude() + "";
			longitude = entity.getLongitude() + "";
			strpo.append("'" + station_name + "':[" + longitude + "," + latitude + "],");
			strs.append("{ name: '");
			strs.append(station_name);
			strs.append("', value:");
			strs.append(value*100);
			strs.append(", valueshow:");
			strs.append(value);
			strs.append(",visualMap: false},");
		}
		strpo.append("}");
		strs.append("]");
		map.put("value", strs.toString());
		map.put("station", strpo.toString());
		return map;
	}
	
	private Map<String, String> getDateener2(int type, int limit) throws SQLException {
		Map<String, String> map = new HashMap<>();
		StringBuffer strs = new StringBuffer();
		StringBuffer strpo = new StringBuffer();
		strs.append("[");
		strpo.append("{");
		String station_name = null;
		int value = 40;
		String longitude = null;
		String latitude = null;
		List<GisEntity> list = gisService.selectAllGis(type, limit);
		for (GisEntity entity : list) {
			station_name = entity.getStation_name();
			value = entity.getValue();
			latitude = entity.getLatitude() + "";
			longitude = entity.getLongitude() + "";
			strpo.append("'" + station_name + "':[" + longitude + "," + latitude + "],");
			strs.append("{ name: '");
			strs.append(station_name);
			strs.append("', value:");
			strs.append(value*100);
			strs.append(", valueshow:");
			strs.append(value);
			strs.append(",visualMap: false},");
		}
		strpo.append("}");
		strs.append("]");
		map.put("value", strs.toString());
		map.put("station", strpo.toString());
		return map;
	}
	
	
	/**
	 * mlc�豸����Դ
	 * 
	 * @param table
	 * @return
	 * @throws SQLException
	 */
	private Map<String, String> getDateasset(int type, int limit) throws SQLException {
		Map<String, String> map = new HashMap<>();
		StringBuffer strs = new StringBuffer();
		StringBuffer strpo = new StringBuffer();
		strs.append("[");
		strpo.append("{");
		String station_name = null;
		int value = 40;
		String longitude = null;
		String latitude = null;
		List<GisEntity> list = gisService.selectAllGis(type, limit);
		for (GisEntity entity : list) {
			station_name = entity.getStation_name();
			value = entity.getValue();
			latitude = entity.getLatitude() + "";
			longitude = entity.getLongitude() + "";
			strpo.append("'" + station_name + "':[" + longitude + "," + latitude + "],");
			strs.append("{ name: '");
			strs.append(station_name);
			strs.append("', value:");
			strs.append(value);
			strs.append(", valueshow:");
			strs.append(value);
			strs.append(",visualMap: false},");
		}
		strpo.append("}");
		strs.append("]");
		map.put("value", strs.toString());
		map.put("station", strpo.toString());
		return map;
	}

	/**
	 * ת��value value > 4 y=100*log2Value
	 * 
	 * @return
	 */
	private double value(int value) {
		double mun = 0;
		if (value <= 4) {
			mun = 200;
		} else if (value > 50000) {
			mun = 1500;
		} else {
			mun = 80 * (Math.log(value) / Math.log(2));
		}
		return mun;
	}
	private double value2(int value) {
		double mun = 0;
		if (value <= 500) {
			mun = 50;
		} else if (value <= 2000 && value > 500) {
			mun = 200;
		} else if (value <= 4000 && value > 2000) {
			mun = 300;
		} else {
			mun = 300;
		}
		return mun;
	}

	public static void main(String[] args) throws SQLException {
	}
    
	@Override
	public void getColHidden(HttpServletRequest arg0, HttpServletResponse arg1) throws IOException {
		// TODO Auto-generated method stub
    
	}

}
