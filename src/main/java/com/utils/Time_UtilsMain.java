package com.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * 2019-8-16
 * ¥¥Ω®»À SunHong
 */
public class Time_UtilsMain {

	public static void main(String[] args) throws Exception {

		DateTime dt1 = DateTime.parse("2019-05-12", DateTimeFormat.forPattern("yyyy-MM-dd"));
		DateTime dt2 = DateTime.parse("2018-05-12", DateTimeFormat.forPattern("yyyy-MM-dd"));

		boolean bb = Time_Utils.isLeapYear(dt1,dt2);
		System.out.println(bb);
	}
}
