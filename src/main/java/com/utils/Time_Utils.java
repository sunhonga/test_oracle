package com.utils;

import org.joda.time.DateTime;

/**
 * 2019-8-16
 * 创建人 SunHong
 */
public class Time_Utils {

	/**
	 * 给定一个时间判断，当年是否是闰年
	 * @param dt
	 * @return
	 */
	protected static boolean isLeapYear(DateTime dt){
		return dt.year().isLeap();
	}


	/**
	 * 判断一个时间区间里面是否有2月29日。
	 * @param dt1
	 * @param dt2
	 * @return
	 */
	protected static boolean isLeapYear(DateTime dt1,DateTime dt2) throws Exception {

		if(dt2.getMillisOfSecond() < dt1.getMillisOfSecond()){
			throw new Exception("输入的起始日期小于输入的截止日期");
		}else if ((dt2.getYear() - dt1.getYear()) > 1){
			throw new Exception("输入的起始日期和截止日期大于一个计息年度");
		}
		while (true){
			if((dt1.getYear() == dt2.getYear()) && (dt1.getMonthOfYear() > dt2.getMonthOfYear())){break;}
			if (dt1.dayOfMonth().getMaximumValue() == 29){return true;}
			dt1 = dt1.plusMonths(1);
		}
		return false;
	}
}
