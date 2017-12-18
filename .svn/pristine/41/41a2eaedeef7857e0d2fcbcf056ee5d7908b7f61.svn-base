package com.bmzy.report.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态切换数库
 * @author July_whj
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource{

	@Override
	protected Object determineCurrentLookupKey() {
		return DbcontextHolder.getDbType();
	}

}
