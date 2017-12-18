package com.bmzy.report.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bmzy.report.baseService.BaseService;
import com.bmzy.report.dao.GisDao;
import com.bmzy.report.model.GisEntity;
import com.bmzy.report.service.IGisService;
@Service
public class GisService extends BaseService<GisEntity> implements IGisService {
	
	@Resource
	private GisDao dao ;

	@Override
	public List<GisEntity> selectAllGis(int type,int limit) {
		return dao.selectAllGis(type,limit);
	}
	
	
}
