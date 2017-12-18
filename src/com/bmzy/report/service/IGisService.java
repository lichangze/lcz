package com.bmzy.report.service;

import java.util.List;

import com.bmzy.report.baseService.IService;
import com.bmzy.report.model.GisEntity;

public interface IGisService extends  IService<GisEntity>{
	List<GisEntity> selectAllGis(int type,int limit);
}
