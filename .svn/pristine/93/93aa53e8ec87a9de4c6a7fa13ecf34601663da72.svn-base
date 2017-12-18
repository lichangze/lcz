package com.report.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bmzy.report.ftp.FTPUtil;
import com.bmzy.report.ftp.FileUtil;
import com.bmzy.report.ftp.FtpTaskUtil;
import com.bmzy.report.model.FileRecordEntity;
import com.bmzy.report.model.PassengerFlowEntity;
import com.bmzy.report.service.IAdjustService;
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
import com.github.pagehelper.PageHelper;

import tk.mybatis.mapper.entity.Example;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class WitFilr extends FtpTaskUtil{
	@Resource
	private IAdjustService adjustService;
	@Resource
	private IDailyPlanService dailyplanService;
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
	@Resource
	private IKilometerService kilometerService;
	@Resource
	private IFileRecordService fileRecordService;

	char FIELD_SPR = 0x01; // 十六进制分隔符
	String LINE_SPR = "\n"; // 换行符

	public static final SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat datefile = new SimpleDateFormat("yyyyMMdd");

	public void addlogs(FileRecordEntity entity) {
		fileRecordService.save(entity);
	}

	@Test
	public void test1() {
		for(int i=1;i<3000;i++){
			System.out.println("----"+i);
			String table = "passengerflow";
			String taskId = ener+"_"+table;
			String filePath = getfilePath(table);
			Example example = new Example(PassengerFlowEntity.class);
//		example.createCriteria().andGreaterThan("date_Time_For_Flow", getLastTime(taskId));
			PageHelper.startPage(i, 10000);
			List<PassengerFlowEntity> list = passengerflowService.selectByExample(example);
			if(list.size() != 0){
				Date dateTimeMax = list.get(0).getDate_Time_For_Flow();
				Iterator<PassengerFlowEntity> it = list.iterator();
				while (it.hasNext()) {
					PassengerFlowEntity gis = it.next();
					FileUtil.method2(filePath, gis.getId() + FIELD_SPR + gis.getStation_Id() + FIELD_SPR
							+ dateFormater.format(gis.getDate_Time_For_Flow()) + FIELD_SPR + gis.getNum_Of_Passenger_Flow() + LINE_SPR);
				}
				FileRecordEntity entity = FileUtil.fileCheckChk(filePath,table,list.size());
				entity.setToSystem(ener);
				entity.setTaskId(taskId);
				entity.setDataLastUpdateTime(dateTimeMax);
				new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getFilePath()).upfileload();
				new FTPUtil(_ftpUrl, _ftpPost, _ftpUser, _ftpPwd, _enerftpPath, entity.getCheckFilePath()).upfileload();
				addlogs(entity);
			}
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
	public String getfilePath(String table) {
		String system = "tadw_";
		String time = datefile.format(new Date());
		return _filePath + system + table + "_i_" + time + ".dat";
	}
}