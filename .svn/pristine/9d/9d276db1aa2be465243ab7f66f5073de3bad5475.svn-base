package com.bmzy.report.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DbcontextHolder extends AbstractRoutingDataSource{

public static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    
	public static final String DATA_SOURCE = "dataSource";  
	public static final String DATA_SOURCE_LOG = "dataSourceLog"; 

    /**
     * 设置当前数据源
     * @param dbType
     */
    public static void setDbType(String dbType){
        contextHolder.set(dbType);
    }
    /**
     * 获得当前数据源
     * @return
     */
    public static String getDbType(){
        String dbType = (String)contextHolder.get();
        return dbType;
    }
    /**
     *清除上下文
     *
     */
    public static void clearContext(){
        contextHolder.remove();
    }
    @Override
    protected Object determineCurrentLookupKey() {
        return DbcontextHolder.getDbType();
    }

}
