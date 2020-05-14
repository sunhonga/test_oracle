package com.utils;

import org.joda.time.DateTime;

/**
 * 2019-8-16
 * ������ SunHong
 */
public class Time_Utils {

	/**
	 * ����һ��ʱ���жϣ������Ƿ�������
	 * @param dt
	 * @return
	 */
	protected static boolean isLeapYear(DateTime dt){
		return dt.year().isLeap();
	}


	/**
	 * �ж�һ��ʱ�����������Ƿ���2��29�ա�
	 * @param dt1
	 * @param dt2
	 * @return
	 */
	protected static boolean isLeapYear(DateTime dt1,DateTime dt2) throws Exception {

		if(dt2.getMillisOfSecond() < dt1.getMillisOfSecond()){
			throw new Exception("�������ʼ����С������Ľ�ֹ����");
		}else if ((dt2.getYear() - dt1.getYear()) > 1){
			throw new Exception("�������ʼ���ںͽ�ֹ���ڴ���һ����Ϣ���");
		}
		while (true){
			if((dt1.getYear() == dt2.getYear()) && (dt1.getMonthOfYear() > dt2.getMonthOfYear())){break;}
			if (dt1.dayOfMonth().getMaximumValue() == 29){return true;}
			dt1 = dt1.plusMonths(1);
		}
		return false;
	}
}
