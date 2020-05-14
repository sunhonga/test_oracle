package com.bond;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 2019-8-13
 * 创建人 SunHong
 */
public class BondAndYeWu extends AbstractBond {

	//key是自增的数，value存的是不同计息区间的天数，和该计息区间起始日到债券截止日的天数。
	public static LinkedList<String> linkedList= new LinkedList<>();

	public static YeWu yeWu = new YewuData().getYeWu();

	/*public  HashMap<Integer,String> satrt() {
		//BondBase bondBase = this.getBondBase();			//得到债品信息
		//YeWu yeWu = new YewuData().getYeWu();					//得到业务数据
		//System.out.println(yeWu);

		//获取计息方式
		if(bondBase.getJxfs() == 1){							//平均值计息时

			Period pe = new Period(yeWu.getMrsj(), bondBase.getJxjzr(), PeriodType.days());
			int sumdays = pe.getDays() +1; 										//总计息天数   计息截止日-买入日期+1
			System.out.println(sumdays);
		}
		return null;
		*//*getJiXiQuJian(bondBase);
		getJiXiQuJianSumDay(yeWu,bondBase);
		//确定业务日期所在计息区间
		return map;*//*
	}*/


/*	//获取所有计息区间
	public static void getJiXiQuJian(BondBase bondBase){
		int month = 12/bondBase.getFxpl();
		DateTime jxqsr = bondBase.getJxqsr();
		DateTime temp = null;
		int i =0;
		while (true){
			temp = jxqsr.plusMonths(month).minusDays(1);
			map2.put(++i,new DateTime[]{jxqsr,temp});
			if (temp.equals(bondBase.getJxjzr())){
				break;
			}else {
				jxqsr = temp.plusDays(1);
			}

		}

	}*/

	//获得计息区间所所含天数,和改计息区间起始日到债券计息截止日的天数。
	public static void getJiXiQuJianSumDay(HashMap<DateTime, DateTime> map){
		DateTime yeWuDate = yeWu.getMrsj();
		Period pe2 ;
		if(bondBase.getJxjc() == 0 ){			//       act/365计息
			pe2 = new Period(yeWuDate, bondBase.getJxjzr(), PeriodType.days());
			int days2 = pe2.getDays()+1;
			linkedList.add("365"+"\t\t"+days2);
			return ;
		}
		for(DateTime dateTime1 :map.keySet()){
			DateTime dateTime2 = map.get(dateTime1);
			if(new Period(yeWuDate,dateTime2,  PeriodType.days()).getDays() < 0 ){continue;}					//区间的截止日如果小于业务日期，就跳过
			Period pe1 = new Period(dateTime1,dateTime2,  PeriodType.days());
			int days1 = pe1.getDays() +1;				//获取计息区间的总天数
			if(new Period(dateTime1,yeWuDate,  PeriodType.days()).getDays() > 0 ){							//区间的计息起始日小于业务日期时.
				pe2 = new Period(yeWuDate, bondBase.getJxjzr(), PeriodType.days());
			}else {
				pe2 = new Period(dateTime1, bondBase.getJxjzr(), PeriodType.days());
			}
			int days2 = pe2.getDays()+1;
			linkedList.add(days1 + "\t\t" + days2);
		}
	}



	@Override
	protected LinkedList<String> getListOfYTM(HashMap<DateTime, DateTime> map) {
		getJiXiQuJianSumDay(map);
		return linkedList;
	}
}
