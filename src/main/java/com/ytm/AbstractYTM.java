package com.ytm;

import com.bond.BondAndYeWu;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Properties;

/**
 * 2019-8-13
 * ����ĵ���������㷽ʽ
 * ������ SunHong
 */
public abstract class AbstractYTM {

	public static Properties properties = new Properties();
	public static int diedaicishu;
	public static int blws;
	public static double chushiMax;
	public static double chushiMin;

	public static LinkedList<String> linkedList;
	public static BondAndYeWu bondAndYeWu = new BondAndYeWu();


	public AbstractYTM() {
		init();
	}

	private void init() {					//��ʼ������YTM����ز���

		loadConfig();						//��������ļ�
		fuzhi();							//������������ֵ
		getJxXingxi();						//���ծȯ�ļ�Ϣ����
	}
	private void getJxXingxi() {
		linkedList = bondAndYeWu.getListOfYTM();				//�ȵ���һ��  key ��1����,value Ϊÿ����Ϣ��������� + �ļ�Ϣ���䵽��Ϣ��ֹ�յ�����
	}

	protected void fuzhi() {
		diedaicishu = Integer.valueOf(properties.getProperty("diedaicishu"));
		blws = Integer.valueOf(properties.getProperty("blws"));
		chushiMax = Integer.valueOf(properties.getProperty("chushimax"));
		chushiMin = Integer.valueOf(properties.getProperty("chushimin"));
	}


	/**
	 * ����ʵ�������ʹ�ʽ��0=Z0(1+y)^n + M(y-i0)((1+y)^n-1)/y
	 * z0:��ʼ���ۼ�
	 * y:ʵ��������
	 * M����ֵ
	 * i0����Ʊ������
	 */
	public abstract double ytm();


	//��ȡ�����ļ�,δ��reader����.����ֱ��д(���ڿ��Է�spring��д��)
	protected void loadConfig(){
		InputStream in =null;
		InputStreamReader isr = null;

		try{
			in = this.getClass().getResourceAsStream("/ytm.properties");
			isr = new InputStreamReader(in,"UTF-8");
			properties.load(isr);
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			if(in !=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
