package com.bmzy.report.baseDao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用myMapper
 * @author July_whj
 *
 * @param <T>
 */
public interface BaseDao<T> extends Mapper<T>, MySqlMapper<T>{

}
