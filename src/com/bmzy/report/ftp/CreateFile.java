package com.bmzy.report.ftp;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bmzy.report.model.DailyPlanEntity;
import com.bmzy.report.model.DeviceErrorEntity;
import com.bmzy.report.model.EamPosLineEntity;
import com.bmzy.report.model.EamPositonEntity;
import com.bmzy.report.model.FileRecordEntity;
import com.bmzy.report.model.KiloMeterEntity;
import com.bmzy.report.model.PassEngerQuantityEntity;
import com.bmzy.report.model.PassengerFlowEntity;
import com.bmzy.report.model.PowerSupplyEntity;
import com.bmzy.report.model.ServiceKiloMeterEntity;
import com.bmzy.report.model.TrainErrorEntity;
import com.bmzy.report.model.TrainStatEntity;
import com.bmzy.report.model.WeatherEntity;
import com.bmzy.report.service.IDailyPlanService;
import com.bmzy.report.service.IDeviceErrorService;
import com.bmzy.report.service.IEamPosLineService;
import com.bmzy.report.service.IEamPositionService;
import com.bmzy.report.service.IFileRecordService;
import com.bmzy.report.service.IKilometerService;
import com.bmzy.report.service.IPassEngerQuantityService;
import com.bmzy.report.service.IPassengerFlowService;
import com.bmzy.report.service.IPowerSupplyService;
import com.bmzy.report.service.IServiceKiloMeterService;
import com.bmzy.report.service.ITrainErrorService;
import com.bmzy.report.service.ITrainStatService;
import com.bmzy.report.service.IVWSTATIONTRANSFLOWService;
import com.bmzy.report.service.IWeatherService;
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;
@Service
@Component
public class CreateFile extends FtpTaskUtil {
	@Resource
	private IFileRecordService fileRecordService;
	@Resource
	private IKilometerService kilometerService;
	@Resource
	private IDailyPlanService dailyPlanService;
	@Resource
	private IDeviceErrorService deviceerrorService;
	@Resource
	private ITrainErrorService trainerrorService;
	@Resource
	private IWeatherService weatherService;
	@Resource
	private IPowerSupplyService powersupplyService;
	@Resource
	private ITrainStatService trainstatService;
	@Resource
	private IServiceKiloMeterService servicekilometerService;
	@Resource
	private IPassEngerQuantityService passengerquantityService;
	@Resource
	private IPassengerFlowService passengerflowService;
	@Resource
	private IEamPositionService eampositionService;
	@Resource
	private IEamPosLineService eamposlineService;
	@Resource
	private IVWSTATIONTRANSFLOWService vwstationtransflowService;
	char FIELD_SPR = 0x01; // 十六进制分隔符
	String LINE_SPR = "\n"; // 换行符
	public static final SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat datefile2 = new SimpleDateFormat("yyyyMMddHHmmss");
	public static final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat datefile = new SimpleDateFormat("yyyyMMdd");
	@Scheduled(cron ="0 15 9 * * ?")
	public void taskCycle() {
		   /* zd_kilometer("zd_kilometer");
			zd_dailyplan("zd_dailyplan");
			zd_powersupply("zd_powersupply");
			zd_trainstat("zd_trainstat");
			zd_servicekilometer("zd_servicekilometer");
		    zd_passengerquantity("zd_passengerquantity");
		    zd_deviceerror("zd_deviceerror");
			zd_trainerror("zd_trainerror");
			weather("weather");
		    eam_pos_position("eam_pos_position");
		    eam_pos_line("eam_pos_line");
		    passengerflow("passengerflow");*/
		    //System.out.println("111111");
}
	@Scheduled(cron ="0 30 17 * * ?")
	public void taskCycle2() {
		//passengerflow("passengerflow");
		//System.out.println("222222");
	}
	//1 ZD_KILOMETER
	public void zd_kilometer(String table) {
		String taskId = ener+"_"+table;
		Example example = new Example(KiloMeterEntity.class);
		example.setOrderByClause("cDate desc");
		example.createCriteria().andGreaterThan("cDate", getLastTime(taskId));
		List<KiloMeterEntity> list = kilometerService.selectByExample(example);
		if(list.size() != 0){
			//Date dateTimeMax = list.get(0).getcDate();
			//String filePath = getfilePathzd(table,dateTimeMax);
			//Iterator<KiloMeterEntity> it = list.iterator();
			Map<String,FileUtilEntity> map = new HashMap<String,FileUtilEntity>();
			Iterator<KiloMeterEntity> it = list.iterator();
			while (it.hasNext()) {
				KiloMeterEntity gis = it.next();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String key = sdf.format(gis.getcDate().getTime());
				//判断集合是否保存
				if(map.get(key) == null){
					FileUtilEntity fue = new FileUtilEntity();
					fue.setLength(1);
					fue.setPath(getfilePathzd(table,gis.getcDate()));
					fue.setTime(gis.getcDate());
					map.put(key, fue);
				}else{
					map.get(key).addLength();
				}
				FileUtil.method2((String)map.get(key).getPath(), gis.getId() + FIELD_SPR + gis.getLineId() + FIELD_SPR
						+ dateFormater.format(gis.getcDate()) + FIELD_SPR + gis.getKilValue() + LINE_SPR);
			}
			for(Entry<String, FileUtilEntity> e : map.entrySet()){
			FileRecordEntity entity = FileUtil.fileCheckChk(e.getValue().getPath(),table,e.getValue().getLength());
			entity.setToSystem(ener);
			entity.setTaskId(taskId);
			entity.setDataLastUpdateTime(e.getValue().getTime());
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getFilePath()).upfileload();
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getCheckFilePath()).upfileload();
			addlogs(entity);
			delFile(entity);
		}
	}
	}
   // 2 ZD_DAILYPLAN
	public void zd_dailyplan(String table) {
		String taskId = ener+"_"+table;
		Example example = new Example(DailyPlanEntity.class);
		example.setOrderByClause("cDate desc");
		example.createCriteria().andGreaterThan("cDate", getLastTime(taskId));
		List<DailyPlanEntity> list = dailyPlanService.selectByExample(example);
		if(list.size() != 0){
			//Date dateTimeMax = list.get(0).getcDate();
			//String filePath = getfilePathzd(table,dateTimeMax);
			//Iterator<DailyPlanEntity> it = list.iterator();
			Map<String,FileUtilEntity> map = new HashMap<String,FileUtilEntity>();
			Iterator<DailyPlanEntity> it = list.iterator();
			while (it.hasNext()) {
				DailyPlanEntity gis = it.next();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String key = sdf.format(gis.getcDate().getTime());
				//判断集合是否保存
				if(map.get(key) == null){
					FileUtilEntity fue = new FileUtilEntity();
					fue.setLength(1);
					fue.setPath(getfilePathzd(table,gis.getcDate()));
					fue.setTime(gis.getcDate());
					map.put(key, fue);
				}else{
					map.get(key).addLength();
				}
				FileUtil.method2((String)map.get(key).getPath(), qnull(gis.getId())+FIELD_SPR+
						qnull(gis.getLineId())+FIELD_SPR+
						qnull(dateFormater.format(gis.getcDate()))+FIELD_SPR+
						qnull(gis.getPlan())+FIELD_SPR+
						qnull(gis.getFact())+FIELD_SPR+
						qnull(gis.getTemp())+FIELD_SPR+
						qnull(gis.getEmpty())+FIELD_SPR+
						qnull(gis.getRescue())+FIELD_SPR+
						qnull(gis.getDayDebug())+FIELD_SPR+
						qnull(gis.getNightDebug())+FIELD_SPR+
						qnull(gis.getDeBug())+FIELD_SPR+
						qnull(gis.getTrain())+FIELD_SPR+
						qnull(gis.getCoTrain())+LINE_SPR);
			}
			for(Entry<String, FileUtilEntity> e : map.entrySet()){
				FileRecordEntity entity = FileUtil.fileCheckChk(e.getValue().getPath(),table,e.getValue().getLength());
			entity.setToSystem(ener);
			entity.setTaskId(taskId);
			entity.setDataLastUpdateTime(e.getValue().getTime());
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getFilePath()).upfileload();
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getCheckFilePath()).upfileload();
			addlogs(entity);
			delFile(entity);
		}
	}
	}
    // 3 ZD_DEVICEERROR
	public void zd_deviceerror(String table) {
		String taskId = ener+"_"+table;
		Example example = new Example(DeviceErrorEntity.class);
		example.setOrderByClause("cDate desc");
		example.createCriteria().andGreaterThan("cDate", getLastTime(taskId));
		List<DeviceErrorEntity> list = deviceerrorService.selectByExample(example);
		if(list.size() != 0){
			//Date dateTimeMax = list.get(0).getcDate();
			//String filePath = getfilePathzd(table,dateTimeMax);
			//Iterator<DeviceErrorEntity> it = list.iterator();
			Map<String,FileUtilEntity> map = new HashMap<String,FileUtilEntity>();
			Iterator<DeviceErrorEntity> it = list.iterator();
			while (it.hasNext()) {
				DeviceErrorEntity gis = it.next();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String key = sdf.format(gis.getcDate().getTime());
				//判断集合是否保存
				if(map.get(key) == null){
					FileUtilEntity fue = new FileUtilEntity();
					fue.setLength(1);
					fue.setPath(getfilePathzd(table,gis.getcDate()));
					fue.setTime(gis.getcDate());
					map.put(key, fue);
				}else{
					map.get(key).addLength();
				}
				FileUtil.method2(map.get(key).getPath(), qnull(gis.getId())+FIELD_SPR+
						qnull(gis.getLineId())+FIELD_SPR+
						dateFormater.format(gis.getcDate())+FIELD_SPR+
						qnull(gis.getCategoryId())+FIELD_SPR+
						dateFormater.format(gis.getBeginTime())+FIELD_SPR+
				        dateFormater.format(gis.getEndTime())+FIELD_SPR+
				        qnull(gis.getContent())+FIELD_SPR+
				        qnull(gis.getClear())+FIELD_SPR+
				        qnull(gis.getdChange())+FIELD_SPR+
				        qnull(gis.getDown())+FIELD_SPR+
				        qnull(gis.getMiss())+FIELD_SPR+
				        qnull(gis.getAttached())+FIELD_SPR+
				        qnull(gis.getHalt())+FIELD_SPR+
				        qnull(gis.getPass())+FIELD_SPR+
				        qnull(gis.getStart1())+FIELD_SPR+
				        qnull(gis.getStop1())+FIELD_SPR+
				        qnull(gis.getStartEffect1())+FIELD_SPR+
				        qnull(gis.getStopEffect1())+FIELD_SPR+
				        qnull(gis.getStart2())+FIELD_SPR+
				        qnull(gis.getStop2())+FIELD_SPR+
				        qnull(gis.getStartEffect2())+FIELD_SPR+
				        qnull(gis.getStopEffect2())+FIELD_SPR+
				        qnull(gis.getStart5())+FIELD_SPR+
				        qnull(gis.getStop5())+FIELD_SPR+
				        qnull(gis.getStartEffect5())+FIELD_SPR+
				        qnull(gis.getStopEffect5())+FIELD_SPR+
				        qnull(gis.getCometCount())+FIELD_SPR+
				        qnull(gis.getCometMinute())+FIELD_SPR+
				        qnull(gis.getLateType5())+FIELD_SPR+
				        qnull(gis.getLateType15())+FIELD_SPR+
				        qnull(gis.getLateType30())+FIELD_SPR+
				        qnull(gis.getIfNext())+FIELD_SPR+
				        qnull(gis.getIfBnext())+FIELD_SPR+
				        qnull(gis.getSeTrainno())+LINE_SPR);
			}
			for(Entry<String, FileUtilEntity> e : map.entrySet()){
			FileRecordEntity entity = FileUtil.fileCheckChk(e.getValue().getPath(),table,e.getValue().getLength());
			entity.setToSystem(ener);
			entity.setTaskId(taskId);
			entity.setDataLastUpdateTime(e.getValue().getTime());
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getFilePath()).upfileload();
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getCheckFilePath()).upfileload();
			addlogs(entity);
			delFile(entity);
		}
	}}
	// 4 ZD_TRAINERROR
	public void zd_trainerror(String table) {
		String taskId = ener+"_"+table;
		Example example = new Example(TrainErrorEntity.class);
		example.setOrderByClause("cDate desc");
		example.createCriteria().andGreaterThan("cDate", getLastTime(taskId));
		List<TrainErrorEntity> list = trainerrorService.selectByExample(example);
		if(list.size() != 0){
			//Date dateTimeMax = list.get(0).getcDate();
			//String filePath = getfilePathzd(table,dateTimeMax);
			//自定义Map
			Map<String,FileUtilEntity> map = new HashMap<String,FileUtilEntity>();
			Iterator<TrainErrorEntity> it = list.iterator();
			while (it.hasNext()) {
				TrainErrorEntity gis = it.next();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String key = sdf.format(gis.getcDate());
				//判断集合是否保存
				if(map.get(key) == null){
					FileUtilEntity fue = new FileUtilEntity();
					fue.setLength(1);
					fue.setPath(getfilePathzd(table,gis.getcDate()));
					fue.setTime(gis.getcDate());
					map.put(key, fue);
				}else{
					map.get(key).addLength();
				}
				FileUtil.method2((String)map.get(key).getPath(), qnull(gis.getId())+FIELD_SPR+
						qnull(gis.getLineId())+FIELD_SPR+
						dateFormater.format(gis.getcDate())+FIELD_SPR+
						qnull(gis.getCategoryId())+FIELD_SPR+
						qnull(gis.getTrainId())+FIELD_SPR+
						qnull(gis.getTrainNo())+FIELD_SPR+
						qnull(gis.getContent())+FIELD_SPR+
						qnull(gis.getClear())+FIELD_SPR+
						qnull(gis.getdChange())+FIELD_SPR+
						qnull(gis.getDown())+FIELD_SPR+
						qnull(gis.getMiss())+FIELD_SPR+
						qnull(gis.getAttached())+FIELD_SPR+
						qnull(gis.getHalt())+FIELD_SPR+
						qnull(gis.getPass())+FIELD_SPR+
						qnull(gis.getStart1())+FIELD_SPR+
						qnull(gis.getStop1())+FIELD_SPR+
						qnull(gis.getStartEffect1())+FIELD_SPR+
						qnull(gis.getStopEffect1())+FIELD_SPR+
						qnull(gis.getStart2())+FIELD_SPR+
						qnull(gis.getStop2())+FIELD_SPR+
						qnull(gis.getStartEffect2())+FIELD_SPR+
						qnull(gis.getStopEffect2())+FIELD_SPR+
						qnull(gis.getStart5())+FIELD_SPR+
						qnull(gis.getStop5())+FIELD_SPR+
						qnull(gis.getStartEffect5())+FIELD_SPR+
						qnull(gis.getStopEffect5())+FIELD_SPR+
						qnull(gis.getCometCount())+FIELD_SPR+
						qnull(gis.getCometMinute())+FIELD_SPR+
						qnull(gis.getLateType5())+FIELD_SPR+
						qnull(gis.getLateType15())+FIELD_SPR+
						qnull(gis.getLateType30())+FIELD_SPR+
						qnull(gis.getSeTrainNo())+LINE_SPR);
			}
			//遍历Map集合
			for(Entry<String, FileUtilEntity> e : map.entrySet()){
				FileRecordEntity entity = FileUtil.fileCheckChk(e.getValue().getPath(),table,e.getValue().getLength());
				entity.setToSystem(ener);
				entity.setTaskId(taskId);
				entity.setDataLastUpdateTime(e.getValue().getTime());
				new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getFilePath()).upfileload();
				new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getCheckFilePath()).upfileload();
				addlogs(entity);
				delFile(entity);
			}
			
			
		}
	}
	// 5 WEATHER
	public void weather(String table) {
		String taskId = ener+"_"+table;
		Example example = new Example(WeatherEntity.class);
		example.setOrderByClause("wdate desc");
		example.createCriteria().andGreaterThan("date", getLastTime(taskId));
		List<WeatherEntity> list = weatherService.selectByExample(example);
		if(list.size() != 0){
			//Date dateTimeMax = list.get(0).getDate();
			//String filePath = getfilePathzd(table,dateTimeMax);
			//Iterator<WeatherEntity> it = list.iterator();
			Map<String,FileUtilEntity> map = new HashMap<String,FileUtilEntity>();
			Iterator<WeatherEntity> it = list.iterator();
			while (it.hasNext()) {
				WeatherEntity gis = it.next();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String key = sdf.format(gis.getDate().getTime());
				//判断集合是否保存
				if(map.get(key) == null){
					FileUtilEntity fue = new FileUtilEntity();
					fue.setLength(1);
					fue.setPath(getfilePathzd(table,gis.getDate()));
					fue.setTime(gis.getDate());
					map.put(key, fue);
				}else{
					map.get(key).addLength();
				}
				FileUtil.method2((String)map.get(key).getPath(), gis.getId().toString()+FIELD_SPR+
						qnull(gis.getRadar())+FIELD_SPR+
						qnull(gis.getSd())+FIELD_SPR+
						qnull(gis.getWd())+FIELD_SPR+
						qnull(gis.getWs())+FIELD_SPR+
						qnull(gis.getWse())+FIELD_SPR+
						qnull(gis.getCity())+FIELD_SPR+
						qnull(gis.getTemp())+FIELD_SPR+
						qnull(gis.getTime())+FIELD_SPR+
						dateFormater.format(gis.getDate())+LINE_SPR);
			}
			for(Entry<String, FileUtilEntity> e : map.entrySet()){
				FileRecordEntity entity = FileUtil.fileCheckChk(e.getValue().getPath(),table,e.getValue().getLength());
			entity.setToSystem(ener);
			entity.setTaskId(taskId);
			entity.setDataLastUpdateTime(e.getValue().getTime());
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getFilePath()).upfileload();
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getCheckFilePath()).upfileload();
			addlogs(entity);
			delFile(entity);
		}
	}
	}
	// 6 ZD_POWERSUPPLY
	public void zd_powersupply(String table) {
		String taskId = ener+"_"+table;
		Example example = new Example(PowerSupplyEntity.class);
		example.setOrderByClause("cDate desc");
		example.createCriteria().andGreaterThan("cDate", getLastTime(taskId));
	
		List<PowerSupplyEntity> list = powersupplyService.selectByExample(example);
		if(list.size() != 0){
			//Date dateTimeMax = list.get(0).getcDate();
			//String filePath = getfilePathzd(table,dateTimeMax);
			Map<String,FileUtilEntity> map = new HashMap<String,FileUtilEntity>();
			Iterator<PowerSupplyEntity> it = list.iterator();
			while (it.hasNext()) {
				PowerSupplyEntity gis = it.next();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String key = sdf.format(gis.getcDate().getTime());
				//判断集合是否保存
				if(map.get(key) == null){
					FileUtilEntity fue = new FileUtilEntity();
					fue.setLength(1);
					fue.setPath(getfilePathzd(table,gis.getcDate()));
					fue.setTime(gis.getcDate());
					map.put(key, fue);
				}else{
					map.get(key).addLength();
				}
				FileUtil.method2((String)map.get(key).getPath(),qnull(gis.getId())+FIELD_SPR+
						qnull(gis.getLineId())+FIELD_SPR+
						dateFormater.format(gis.getcDate())+FIELD_SPR+
						dateFormater.format(gis.getRequestOff())+FIELD_SPR+
						dateFormater.format(gis.getActualOn())+FIELD_SPR+
						dateFormater.format(gis.getRequestOff())+FIELD_SPR+
						dateFormater.format(gis.getActualOff())+FIELD_SPR+
						qnull(gis.getNotOff())+FIELD_SPR+
						qnull(gis.getNotOn())+LINE_SPR);
			}
			//遍历Map集合
			for(Entry<String, FileUtilEntity> e : map.entrySet()){
				FileRecordEntity entity = FileUtil.fileCheckChk(e.getValue().getPath(),table,e.getValue().getLength());
			entity.setToSystem(ener);
			entity.setTaskId(taskId);
			entity.setDataLastUpdateTime(e.getValue().getTime());
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getFilePath()).upfileload();
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getCheckFilePath()).upfileload();
			addlogs(entity);
			delFile(entity);
		}
	}
	}
	// 7 ZD_TRAINSTAT
	public void zd_trainstat(String table) {
		String taskId = ener+"_"+table;
		Example example = new Example(TrainStatEntity.class);
		example.setOrderByClause("cDate desc");
		example.createCriteria().andGreaterThan("cDate", getLastTime(taskId));
		List<TrainStatEntity> list = trainstatService.selectByExample(example);
		if(list.size() != 0){
			//Date dateTimeMax = list.get(0).getcDate();
			//String filePath = getfilePathzd(table,dateTimeMax);
			Map<String,FileUtilEntity> map = new HashMap<String,FileUtilEntity>();
			Iterator<TrainStatEntity> it = list.iterator();
			while (it.hasNext()) {
				TrainStatEntity gis = it.next();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String key = sdf.format(gis.getcDate().getTime());
				//判断集合是否保存
				if(map.get(key) == null){
					FileUtilEntity fue = new FileUtilEntity();
					fue.setLength(1);
					fue.setPath(getfilePathzd(table,gis.getcDate()));
					fue.setTime(gis.getcDate());
					map.put(key, fue);
				}else{
					map.get(key).addLength();
				}
				FileUtil.method2((String)map.get(key).getPath(),qnull(gis.getId())+FIELD_SPR+
						qnull(gis.getLineId())+FIELD_SPR+
						dateFormater.format(gis.getcDate())+FIELD_SPR+
						qnull(gis.getTuSing())+FIELD_SPR+
						qnull(gis.gettPrepare())+FIELD_SPR+
						qnull(gis.getTemprepare())+FIELD_SPR+
						qnull(gis.getMonthRepare())+FIELD_SPR+
						qnull(gis.getScheduleRepare())+FIELD_SPR+
						qnull(gis.getAxisRepare())+FIELD_SPR+
						qnull(gis.getFactorRepare())+FIELD_SPR+
						qnull(gis.getSegmentRepare())+FIELD_SPR+
						qnull(gis.getOther())+LINE_SPR);
			}
			//遍历Map集合
			for(Entry<String, FileUtilEntity> e : map.entrySet()){
				FileRecordEntity entity = FileUtil.fileCheckChk(e.getValue().getPath(),table,e.getValue().getLength());
			entity.setToSystem(ener);
			entity.setTaskId(taskId);
			entity.setDataLastUpdateTime(e.getValue().getTime());
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getFilePath()).upfileload();
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getCheckFilePath()).upfileload();
			addlogs(entity);
			delFile(entity);
		}
	}
	}
	// 8 ZD_SERVICEKILOMETER
	public void zd_servicekilometer(String table) {
		String taskId = ener+"_"+table;
		Example example = new Example(ServiceKiloMeterEntity.class);
		example.setOrderByClause("cDate desc");
		example.createCriteria().andGreaterThan("cDate", getLastTime(taskId));
		List<ServiceKiloMeterEntity> list = servicekilometerService.selectByExample(example);
		if(list.size() != 0){
			//Date dateTimeMax = list.get(0).getcDate();
			//String filePath = getfilePathzd(table,dateTimeMax);
			Map<String,FileUtilEntity> map = new HashMap<String,FileUtilEntity>();
			Iterator<ServiceKiloMeterEntity> it = list.iterator();
			while (it.hasNext()) {
				ServiceKiloMeterEntity gis = it.next();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String key = sdf.format(gis.getcDate().getTime());
				//判断集合是否保存
				if(map.get(key) == null){
					FileUtilEntity fue = new FileUtilEntity();
					fue.setLength(1);
					fue.setPath(getfilePathzd(table,gis.getcDate()));
					fue.setTime(gis.getcDate());
					map.put(key, fue);
				}else{
					map.get(key).addLength();
				}
				FileUtil.method2((String)map.get(key).getPath(),qnull(gis.getId())+FIELD_SPR+
						qnull(gis.getLineId())+FIELD_SPR+
						dateFormater.format(gis.getcDate())+FIELD_SPR+
						qnull(gis.getSkilValue())+LINE_SPR);
			}
			//遍历Map集合
			for(Entry<String, FileUtilEntity> e : map.entrySet()){
				FileRecordEntity entity = FileUtil.fileCheckChk(e.getValue().getPath(),table,e.getValue().getLength());
			entity.setToSystem(ener);
			entity.setTaskId(taskId);
			entity.setDataLastUpdateTime(e.getValue().getTime());
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getFilePath()).upfileload();
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getCheckFilePath()).upfileload();
			addlogs(entity);
			delFile(entity);
		}
	}
	}
	// 9 ZD_PASSENGERQUANTITY
	public void zd_passengerquantity(String table) {
		String taskId = ener+"_"+table;
		Example example = new Example(PassEngerQuantityEntity.class);
	    example.setOrderByClause("cDate desc");
		example.createCriteria().andGreaterThan("cDate", getLastTime(taskId));
		List<PassEngerQuantityEntity> list = passengerquantityService.selectByExample(example);
		if(list.size() != 0){
			//Date dateTimeMax = list.get(0).getcDate();
			//String filePath = getfilePathzd(table,dateTimeMax);
			Map<String,FileUtilEntity> map = new HashMap<String,FileUtilEntity>();
			Iterator<PassEngerQuantityEntity> it = list.iterator();
			while (it.hasNext()) {
				PassEngerQuantityEntity gis = it.next();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String key = sdf.format(gis.getcDate().getTime());
				//判断集合是否保存
				if(map.get(key) == null){
					FileUtilEntity fue = new FileUtilEntity();
					fue.setLength(1);
					fue.setPath(getfilePathzd(table,gis.getcDate()));
					fue.setTime(gis.getcDate());
					map.put(key, fue);
				}else{
					map.get(key).addLength();
				}
				FileUtil.method2((String)map.get(key).getPath(),qnull(gis.getId())+FIELD_SPR+
						qnull(gis.getLineId())+FIELD_SPR+
						dateFormater.format(gis.getcDate())+FIELD_SPR+
						gis.getPasValue()+LINE_SPR);
			}
			//遍历Map集合
			for(Entry<String, FileUtilEntity> e : map.entrySet()){
				FileRecordEntity entity = FileUtil.fileCheckChk(e.getValue().getPath(),table,e.getValue().getLength());
			entity.setToSystem(ener);
			entity.setTaskId(taskId);
			entity.setDataLastUpdateTime(e.getValue().getTime());
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getFilePath()).upfileload();
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getCheckFilePath()).upfileload();
			addlogs(entity);
			delFile(entity);
		}
	}
	}
	// 10 EAM_POS_LINE
	public void eam_pos_line(String table) {
		String taskId = ener+"_"+table;
		String filePath = getfilePath2(table);
		Example example = new Example(EamPosLineEntity.class);
		List<EamPosLineEntity> list = eamposlineService.selectByExample(example);
		if(list.size() != 0){
			Iterator<EamPosLineEntity> it = list.iterator();
			while (it.hasNext()) {
				EamPosLineEntity gis = it.next();
				FileUtil.method2(filePath,qnull(gis.getLine_code())+
						FIELD_SPR+qnull(gis.getLine_name())+
						FIELD_SPR+gis.getLine_m()+
						FIELD_SPR+qnull(gis.getDict_no())+
						FIELD_SPR+qnull(gis.getLine_type())+
						FIELD_SPR+dateNull(gis.getLine_strart_date())+
				        FIELD_SPR+qnull(gis.getMemo())+
				        FIELD_SPR+qnull(dateFormater.format(gis.getCreatedTime()))+
				        FIELD_SPR+dateFormater.format(gis.getLastModifidTime())+
				        LINE_SPR);
			}
			FileRecordEntity entity = FileUtil.fileCheckChk2(filePath,table,list.size());
			entity.setToSystem(ener);
			entity.setTaskId(taskId);
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getFilePath()).upfileload();
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getCheckFilePath()).upfileload();
			addlogs(entity);
			delFile(entity);
		}
	}
	// 12 EAM_POS_POSITION
		public void eam_pos_position(String table) {
			String taskId = ener+"_"+table;
			String filePath = getfilePath2(table);
			Example example = new Example(EamPositonEntity.class);
			List<EamPositonEntity> list = eampositionService.selectByExample(example);
			if(list.size() != 0){
				Iterator<EamPositonEntity> it = list.iterator();
				while (it.hasNext()) {
					EamPositonEntity gis = it.next();
					FileUtil.method2(filePath,qnull(gis.getPosition_no())+FIELD_SPR+
							qnull(gis.getPosition_code())+FIELD_SPR+
							qnull(gis.getF_position_no())+FIELD_SPR+
							qnull(gis.getPosition_name())+FIELD_SPR+
							qnull(gis.getLine_code())+FIELD_SPR+
							floNull(gis.getLongitude())+FIELD_SPR+
							floNull(gis.getLatitude())+FIELD_SPR+
							qnull(gis.getDept_no())+FIELD_SPR+
							qnull(gis.getBelong_dept())+FIELD_SPR+
							qnull(dateFormater.format(gis.getCreatedTime()))+FIELD_SPR+
							qnull(dateFormater.format(gis.getLastModifidTime()))+FIELD_SPR+
							qnull(gis.getMemo())+LINE_SPR);
				}
				FileRecordEntity entity = FileUtil.fileCheckChk2(filePath,table,list.size());
				entity.setToSystem(ener);
				entity.setTaskId(taskId);
				new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getFilePath()).upfileload();
				new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getCheckFilePath()).upfileload();
				addlogs(entity);
				delFile(entity);
			}
		}
	//mlc
	public void passengerflow(String table){
		for(int i=1;i<3000;i++){
			System.out.println("----"+i);
			String taskId = ener+"_"+table;
			Example example = new Example(PassengerFlowEntity.class);
		    example.createCriteria().andGreaterThan("date_Time_For_Flow", getLastTime(taskId));
			PageHelper.startPage(i, 10000);
			List<PassengerFlowEntity> list = passengerflowService.selectByExample(example);
			if(list.size() != 0){
				//Date dateTimeMax = list.get(0).getDate_Time_For_Flow();
				//String filePath = getfilePathzd(table,dateTimeMax);
				Map<String,FileUtilEntity> map = new HashMap<String,FileUtilEntity>();
				Iterator<PassengerFlowEntity> it = list.iterator();
				
				while (it.hasNext()) {
					PassengerFlowEntity gis = it.next();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String key = sdf.format(gis.getDate_Time_For_Flow().getTime());
					//判断集合是否保存
					if(map.get(key) == null){
						FileUtilEntity fue = new FileUtilEntity();
						fue.setLength(1);
						fue.setPath(getfilePathzd(table,gis.getDate_Time_For_Flow()));
						fue.setTime(gis.getDate_Time_For_Flow());
						map.put(key, fue);
					}else{
						map.get(key).addLength();
					}
					FileUtil.method2((String)map.get(key).getPath(), IntNull(gis.getId())+FIELD_SPR+
							dateFormater.format(gis.getSettltment_Date())+FIELD_SPR+
							dateFormater.format(gis.getTxn_Date_Time())+FIELD_SPR+
							qnull(gis.getLine_Id())+FIELD_SPR+
							qnull(gis.getStation_Id())+FIELD_SPR+
							qnull(gis.getDevice_Id())+FIELD_SPR+
							qnull(gis.getDevice_Id_For_Flow())+FIELD_SPR+
							qnull(gis.getDevice_Type_For_Flow())+FIELD_SPR+
							gis.getCorner_Id_For_Flow()+FIELD_SPR+
					        gis.getGroup_Id_For_Flow()+FIELD_SPR+
					        dateFormater.format(gis.getDate_Time_For_Flow())+FIELD_SPR+
					        gis.getType_Of_Passenger_Flow()+FIELD_SPR+
					        gis.getNum_Of_Passenger_Flow()+LINE_SPR);
				}
				//遍历Map集合
				for(Entry<String, FileUtilEntity> e : map.entrySet()){
					FileRecordEntity entity = FileUtil.fileCheckChk(e.getValue().getPath(),table,e.getValue().getLength());
				entity.setToSystem(ener);
				entity.setTaskId(taskId);
				entity.setDataLastUpdateTime(e.getValue().getTime());
				new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getFilePath()).upfileload();
				new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getCheckFilePath()).upfileload();
				addlogs(entity);
			}
		}
	}}
	
	/*
	public void vwstationtransflowService(String table) {
		for(int i=1;i<3000;i++){
		System.out.println("----"+i);
		String taskId = ener+"_"+table;
		String filePath = getfilePath(table);
		Example example = new Example(VWSTATIONTRANSFLOWEntity.class);
	    example.createCriteria().andGreaterThan("cDate", getLastTime(taskId));
		PageHelper.startPage(i, 10000);
		List<VWSTATIONTRANSFLOWEntity> list = vwstationtransflowService.selectByExample(example);
		if(list.size() != 0){
			Date dateTimeMax = list.get(0).getcDate();
			Iterator<VWSTATIONTRANSFLOWEntity> it = list.iterator();
			while (it.hasNext()) {
				VWSTATIONTRANSFLOWEntity gis = it.next();
				FileUtil.method2(filePath,IntNull(gis.getStationId())+FIELD_SPR+
						gis.getcDate()+FIELD_SPR+
						IntNull(gis.getLineId1())+FIELD_SPR+
						IntNull(gis.getTransd1())+FIELD_SPR+
						IntNull(gis.getLineId2())+FIELD_SPR+
						IntNull(gis.getTransd2())+FIELD_SPR+
						IntNull(gis.getDataType())+FIELD_SPR+
						qnull(gis.getTimes())+FIELD_SPR+
						IntNull(gis.getNum())+FIELD_SPR+
						IntNull(gis.getTotal())+LINE_SPR);
			}
			FileRecordEntity entity = FileUtil.fileCheckChk(filePath,table,list.size());
			entity.setToSystem(ener);
			entity.setTaskId(taskId);
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getFilePath()).upfileload();
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getCheckFilePath()).upfileload();
			addlogs(entity);
			delFile(entity);
		}}
	}
	*/
	public Date getLastTime(String taskId){
		Example example = new Example(FileRecordEntity.class);
		example.setOrderByClause("data_lastupdatetime desc");
		example.createCriteria().andEqualTo("taskId", taskId);
		List<FileRecordEntity> list = fileRecordService.selectByExample(example);
		if(list.size() == 0){
			return null;
		}
		Date date = list.get(0).getDataLastUpdateTime();
		return date;
	}
	public void delFile(FileRecordEntity entity){
		new File(entity.getFilePath()).delete();
		new File(entity.getCheckFilePath()).delete();
	}
	//mlc客流、天气增量时间点需求
	public String getfilePath(String table,Date maxtime) {
		String system = "tadw_";
		String  time = datefile2.format(maxtime);
		return _filePath + system + table + "_i_" + time + ".dat";
	}
	//无时分秒
	public String getfilePathzd(String table,Date maxtime) {
		String system = "tadw_";
		String  time = datefile.format(maxtime);
		return _filePath + system + table + "_i_" + time + ".dat";
	}
	//维度表无时间
	public String getfilePath2(String table) {
		String system = "tadw_";
		String  time = datefile.format(new Date());
		return _filePath + system + table + "_f_" + time + ".dat";
	}
	
	public String qnull(String str) {
		if (StringUtils.isNotEmpty(str)) {
			return str;
		} else {
			return "";
		}
	}
	public String dateNull(Date time) {
		if (null == time) {
			return "";
		} else {
			return dateFormater.format(time);
		}
	}
	public String DouNull(Double d) {
		if (null == d) {
			return "";
		} else {
			return d.toString();
		}
	}
	
	public String floNull(Float f) {
		if (null == f) {
			return "";
		} else {
			return f.toString();
		}
	}
	public String IntNull(Integer i) {
		if (null == i) {
			return "";
		} else {
			return i.toString();
		}
	}
	public void addlogs(FileRecordEntity entity) {
		fileRecordService.save(entity);
	}
	
	
	
	/**
	 * 内部类
	 * @author sjsj
	 *
	 */
	public class FileUtilEntity{
		
		private String path;
		
		private int length;
		
		private Date time;

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public int getLength() {
			return length;
		}

		public void setLength(int length) {
			this.length = length;
		}

		public Date getTime() {
			return time;
		}

		public void setTime(Date time) {
			this.time = time;
		}
		
		public void addLength(){
			this.length ++ ;
		}
	}
}
