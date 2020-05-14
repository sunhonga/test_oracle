package com.interest;

import com.bond.BondAndYeWu;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.math.BigDecimal;
import java.util.LinkedHashMap;

/**
 * 2019-8-15
 * ������ SunHong
 */
public abstract class AbstractJiXi extends BondAndYeWu {

	public static LinkedHashMap<DateTime,Double> hanxi = new LinkedHashMap<>();

	public AbstractJiXi() {

	}


	//�����Ԫ��Ϣ				���м䱣��10λС��,����������8λС��

	protected void jisuanhanxi(){
		DateTime jxqsr = bondBase.getJxqsr();
		DateTime jxjzr = bondBase.getJxjzr();
		Period pe = new Period(jxqsr,jxjzr,  PeriodType.days());
		int days = pe.getDays()+1;
		int j = 0;
		for (int i = 1; i <= days; i++) {

			if(bondBase.getJxjc() == 0  ){			//��ʵ������/365��Ϣ
				if(j > 365)j=0;
				j++;
				hanxi.put(jxqsr.plusDays(i-1),m1(bondBase.getRate()*j/365));
			}
		}

	}



	//��ȡ�������



	//���ɸ�Ϣ����




	//

	protected  double m1(double num){
		BigDecimal bg = new BigDecimal(num);
		double num1 = bg.setScale(10, BigDecimal.ROUND_HALF_UP).doubleValue();
		return num1;
	}

}
