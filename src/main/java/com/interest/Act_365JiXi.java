package com.interest;

import com.bond.BondAndYeWu;
import com.ytm.AbstractYTM;
import org.joda.time.DateTime;

/**
 * 2019-8-15
 * ¥¥Ω®»À SunHong
 */
public class Act_365JiXi extends AbstractJiXi {

	public static void main(String[] args) {

		new Act_365JiXi().jisuanhanxi();

		for(DateTime dateTime : hanxi.keySet()){
			System.out.print(dateTime);
			System.out.println(hanxi.get(dateTime));
		}
	}
}
