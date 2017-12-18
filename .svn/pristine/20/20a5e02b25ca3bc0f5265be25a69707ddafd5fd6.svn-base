package com.bmzy.report.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;  
import java.lang.annotation.ElementType;  
/**
 * 动态数据源(default:DATA_SOURCE) 
 * @author July_whj
 *
 */
@Target(ElementType.METHOD) 
@Retention(RetentionPolicy.RUNTIME)  
@Documented  
public @interface DataSource {
	String value() default DbcontextHolder.DATA_SOURCE;
}
