package com.report.test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bmzy.report.ftp.FTPUtil;
import com.bmzy.report.ftp.FileUtil;
import com.bmzy.report.ftp.FtpTaskUtil;
import com.bmzy.report.model.DailyPlanEntity;
import com.bmzy.report.model.FileRecordEntity;
import com.bmzy.report.model.KiloMeterEntity;
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
import com.bmzy.report.service.IWeatherService;

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
	private IEamPositionService eampositionService;
	@Resource
	private IEamPosLineService eamposlineService;
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


	char FIELD_SPR = 0x01; // 十六进制分隔符
	String LINE_SPR = "\n"; // 换行符

	public static final SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat datefile = new SimpleDateFormat("yyyyMMdd");

	@Scheduled(cron = "0/30 * * * * ? ") // 间隔5秒执行
	/*public void taskCycle() {
		zd_kilometer("zd_kilometer");
	}
    */
    @Test
	public void zd_kilometer(String table) {
		String taskId = ener+"_"+table;
		String filePath = getfilePath(table);
		Example example = new Example(KiloMeterEntity.class);
		example.setOrderByClause("cDate desc");
		example.createCriteria().andGreaterThan("cDate", getLastTime(taskId));
		List<KiloMeterEntity> list = kilometerService.selectByExample(example);
		if(list.size() != 0){
			Date dateTimeMax = list.get(0).getcDate();
			Iterator<KiloMeterEntity> it = list.iterator();
			while (it.hasNext()) {
				KiloMeterEntity gis = it.next();
				FileUtil.method2(filePath, gis.getId() + FIELD_SPR + gis.getLineId() + FIELD_SPR
						+ dateFormater.format(gis.getcDate()) + FIELD_SPR + gis.getKilValue() + LINE_SPR);
			}
			FileRecordEntity entity = FileUtil.fileCheckChk(filePath,table,list.size());
			entity.setToSystem(ener);
			entity.setTaskId(taskId);
			entity.setDataLastUpdateTime(dateTimeMax);
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getFilePath()).upfileload();
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getCheckFilePath()).upfileload();
			addlogs(entity);
			delFile(entity);
		}
	}
    @Test
	public void zd_dailyplan(String table) {
		String taskId = ener+"_"+table;
		String filePath = getfilePath(table);
		Example example = new Example(DailyPlanEntity.class);
		example.setOrderByClause("cDate desc");
		example.createCriteria().andGreaterThan("cDate", getLastTime(taskId));
		List<DailyPlanEntity> list = dailyPlanService.selectByExample(example);
		if(list.size() != 0){
			Date dateTimeMax = list.get(0).getcDate();
			Iterator<DailyPlanEntity> it = list.iterator();
			while (it.hasNext()) {
				DailyPlanEntity gis = it.next();
				FileUtil.method2(filePath, qnull(gis.getId())+FIELD_SPR+
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
			FileRecordEntity entity = FileUtil.fileCheckChk(filePath,table,list.size());
			entity.setToSystem(ener);
			entity.setTaskId(taskId);
			entity.setDataLastUpdateTime(dateTimeMax);
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getFilePath()).upfileload();
			new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getCheckFilePath()).upfileload();
			addlogs(entity);
			delFile(entity);
		}
	}
	

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
	
	public String getfilePath(String table) {
		String system = "tadw_";
		String time = datefile.format(new Date());
		return _filePath + system + table + "_i_" + time + ".dat";
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
}
