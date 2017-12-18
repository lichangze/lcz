package com.bmzy.report.timer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
public class BigDateCheckUtil {

	public static final SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyy-MM-dd");
	
	 public static void main(String[] args) throws Exception
	 {
	  String start = "2015-01-01";
	  Date dBegin = sdfYMD.parse(start);
	  long startTime=System.currentTimeMillis();   //获取开始时间
	  List<Date> lDate = findDates(dBegin, new Date());
	 for(Date date:lDate){
		 System.out.println(sdfYMD.format(date));
	 }
	 
	  //list1.removeAll(list2);
	  long endTime=System.currentTimeMillis(); //获取结束时间
	  System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
	 }
	 

	public static List<Date> findDates(Date dBegin, Date dEnd) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dEnd);
		cal.add(Calendar.DATE, -2);
		List<Date> lDate = new ArrayList<>();
		lDate.add(dBegin);
		Calendar calBegin = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calBegin.setTime(dBegin);
		Calendar calEnd = Calendar.getInstance();
		// 使用给定的 Date 设置此 Calendar 的时间
		calEnd.setTime(cal.getTime());
		// 测试此日期是否在指定日期之后
		while (cal.getTime().after(calBegin.getTime())) {
			// 根据日历的规则，为给定的日历字段添加或减去指定的时间量
			calBegin.add(Calendar.DAY_OF_MONTH, 1);
			lDate.add(calBegin.getTime());
		}
		return lDate;
	}
}
