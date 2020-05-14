package com.ytm;

import com.bond.BondBase;
import com.bond.YeWu;

/**
 * 2019-8-13
 * ������ SunHong
 * ��ʵ��������Ϣ
 */
public class Act_365YTM extends AbstractYTM{




	/**
	 * ����ʵ�������ʹ�ʽ��0=Z0(1+y)^n + M(y-i0)((1+y)^n-1)/y
	 * z0:��ʼ���ۼ�
	 * y:ʵ��������
	 * M����ֵ
	 * i0����Ʊ������
	 */
	@Override
	public double ytm() {

		double y =0;
		int i = 1;
		double rate = bondAndYeWu.bondBase.getRate();
		double mianzhi = bondAndYeWu.bondBase.getPmje();
		double bdje = bondAndYeWu.yeWu.getBdje();
		double sl = bondAndYeWu.yeWu.getSl();
		int n = Integer.valueOf(linkedList.get(0).split("\t\t")[1]);   //ҵ�����ڵ���Ϣ��ֹ�յ�����
		while (i++ <= diedaicishu){
			y = (chushiMax+chushiMin)/2/36500;              //��ʼ����������
			//���
			double zuobian = 0;
			double youbian = 0;
			zuobian =bdje/sl*Math.pow(1+y,n);
			String[] strs = linkedList.get(0).split("\t\t");
			Integer[] ints = new Integer[]{Integer.valueOf(strs[0])*100,Integer.valueOf(strs[1])};
			youbian = youbian + mianzhi*(y - rate/ints[0])*(Math.pow(1+y,ints[1])-1)/y;
			if (Math.abs(zuobian+youbian) < Math.pow(0.1,blws)){break;}
			if (zuobian+youbian<0){
				chushiMin = (chushiMin+chushiMax)/2;
			}else if(zuobian+youbian>0){
				chushiMax = (chushiMin+chushiMax)/2;
			}else {
				return y;
			}

		}
		return y;



	}
}
