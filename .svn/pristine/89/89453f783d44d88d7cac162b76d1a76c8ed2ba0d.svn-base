package com.bmzy.report.util;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * 数据源前置增强 
 * @author July_whj
 *
 */
public class DataSourceAspect implements MethodBeforeAdvice,AfterReturningAdvice{

	
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		DbcontextHolder.clearContext();
	}

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		 if (method.isAnnotationPresent(DataSource.class)) {  
	            DataSource datasource = method.getAnnotation(DataSource.class);  
	            DbcontextHolder.setDbType(datasource.value());  
	        } else {  
	        	DbcontextHolder  
	                    .setDbType(DbcontextHolder.DATA_SOURCE_LOG);  
	        }  
	}

}
