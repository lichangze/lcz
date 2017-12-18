package com.bmzy.report.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bmzy.report.baseDao.BaseDao;
import com.bmzy.report.model.GisEntity;

public interface GisDao extends BaseDao<GisEntity>{
	List<GisEntity> selectAllGis(@Param("type") int type,@Param("limit") int limit);
}
