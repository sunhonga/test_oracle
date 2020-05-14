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
 * ������ SunHong
 */
public class BondAndYeWu extends AbstractBond {

	//key������������value����ǲ�ͬ��Ϣ������������͸ü�Ϣ������ʼ�յ�ծȯ��ֹ�յ�������
	public static LinkedList<String> linkedList= new LinkedList<>();

	public static YeWu yeWu = new YewuData().getYeWu();

	/*public  HashMap<Integer,String> satrt() {
		//BondBase bondBase = this.getBondBase();			//�õ�ծƷ��Ϣ
		//YeWu yeWu = new YewuData().getYeWu();					//�õ�ҵ������
		//System.out.println(yeWu);

		//��ȡ��Ϣ��ʽ
		if(bondBase.getJxfs() == 1){							//ƽ��ֵ��Ϣʱ

			Period pe = new Period(yeWu.getMrsj(), bondBase.getJxjzr(), PeriodType.days());
			int sumdays = pe.getDays() +1; 										//�ܼ�Ϣ����   ��Ϣ��ֹ��-��������+1
			System.out.println(sumdays);
		}
		return null;
		*//*getJiXiQuJian(bondBase);
		getJiXiQuJianSumDay(yeWu,bondBase);
		//ȷ��ҵ���������ڼ�Ϣ����
		return map;*//*
	}*/


/*	//��ȡ���м�Ϣ����
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

	//��ü�Ϣ��������������,�͸ļ�Ϣ������ʼ�յ�ծȯ��Ϣ��ֹ�յ�������
	public static void getJiXiQuJianSumDay(HashMap<DateTime, DateTime> map){
		DateTime yeWuDate = yeWu.getMrsj();
		Period pe2 ;
		if(bondBase.getJxjc() == 0 ){			//       act/365��Ϣ
			pe2 = new Period(yeWuDate, bondBase.getJxjzr(), PeriodType.days());
			int days2 = pe2.getDays()+1;
			linkedList.add("365"+"\t\t"+days2);
			return ;
		}
		for(DateTime dateTime1 :map.keySet()){
			DateTime dateTime2 = map.get(dateTime1);
			if(new Period(yeWuDate,dateTime2,  PeriodType.days()).getDays() < 0 ){continue;}					//����Ľ�ֹ�����С��ҵ�����ڣ�������
			Period pe1 = new Period(dateTime1,dateTime2,  PeriodType.days());
			int days1 = pe1.getDays() +1;				//��ȡ��Ϣ�����������
			if(new Period(dateTime1,yeWuDate,  PeriodType.days()).getDays() > 0 ){							//����ļ�Ϣ��ʼ��С��ҵ������ʱ.
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
