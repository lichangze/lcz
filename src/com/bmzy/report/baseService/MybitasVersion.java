package com.bmzy.report.baseService;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MybitasVersion {
	public static final String ID = "id";
	public static final String CREATED_TIME = "createdTime";
	public static final String LAST_MODIFIED_TIME = "lastModifidTime";
	public static final String INVALID = "invalid";
	public static final String VERSION = "version";


	@Before("execution(* com.bmzy.report.baseService.*.updateAll(..))")
	public void permissionCheck(JoinPoint point) {
		Object[] args = point.getArgs();
		if (args != null && args.length > 0) {
			Object argument = args[0];
			BeanWrapper beanWrapper = new BeanWrapperImpl(argument);
			// 设置创建时间和修改时间
			if (beanWrapper.isWritableProperty(VERSION)) {
				beanWrapper.setPropertyValue(VERSION, (Integer) beanWrapper.getPropertyValue(VERSION) + 1);
			}
			if (beanWrapper.isWritableProperty(INVALID)) {
				beanWrapper.setPropertyValue(INVALID, false);
			}
			if (beanWrapper.isWritableProperty(LAST_MODIFIED_TIME)) {
				beanWrapper.setPropertyValue(LAST_MODIFIED_TIME, new Date());
			}
		}
	}

	@Before("execution(* com.bmzy.report.baseService.*.save(..))")
	public void permissionSave(JoinPoint point) {
		Object[] args = point.getArgs();
		if (args != null && args.length > 0) {
			Object argument = args[0];
			BeanWrapper beanWrapper = new BeanWrapperImpl(argument);
			// 设置创建时间和修改时间
			if (beanWrapper.isWritableProperty(INVALID)) {
				beanWrapper.setPropertyValue(INVALID, false);
			}
			if (beanWrapper.isWritableProperty(CREATED_TIME)) {
				beanWrapper.setPropertyValue(CREATED_TIME, new Date());
			}
			if (beanWrapper.isWritableProperty(LAST_MODIFIED_TIME)) {
				beanWrapper.setPropertyValue(LAST_MODIFIED_TIME, new Date());
			}
			if (beanWrapper.isWritableProperty(VERSION)) {
				beanWrapper.setPropertyValue(VERSION, 0);
			}
		}
	}

}
