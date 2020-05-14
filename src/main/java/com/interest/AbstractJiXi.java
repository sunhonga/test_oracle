package com.interest;

import com.bond.BondAndYeWu;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

/**
 * 2019-8-15
 * 创建人 SunHong
 */
public abstract class AbstractJiXi extends BondAndYeWu {

	public static LinkedHashMap<DateTime,Double> hanxi = new LinkedHashMap<>();

	public AbstractJiXi() {

	}


	//计算百元含息				银行间保留10位小数,交易所保留8位小数

	protected void jisuanhanxi(){
		DateTime jxqsr = bondBase.getJxqsr();
		DateTime jxjzr = bondBase.getJxjzr();
		Period pe = new Period(jxqsr,jxjzr,  PeriodType.days());
		int days = pe.getDays()+1;
		int j = 0;
		for (int i = 1; i <= days; i++) {

			if(bondBase.getJxjc() == 0  ){			//按实际天数/365计息
				if(j > 365)j=0;
				j++;
				hanxi.put(jxqsr.plusDays(i-1),m1(bondBase.getRate()*j/365));
			}
		}

	}



	//获取当日余额



	//生成付息数据




	//

	protected  double m1(double num){
		BigDecimal bg = new BigDecimal(num);
		double num1 = bg.setScale(10, BigDecimal.ROUND_HALF_UP).doubleValue();
		return num1;
	}

}
