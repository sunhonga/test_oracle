package com.bond;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Properties;

/**
 * 2019-8-13
 * ������ SunHong
 * Bond�ĳ�����,����ծȯ��������Ϣ
 */
public abstract class AbstractBond {


	public static Properties properties = new Properties();
	public static BondBase bondBase;

	//������ծȯ��Ϣ�ڳ��������ʼ������ͬ����ծȯ���������Լ�ʵ��
	public AbstractBond() {
		super();
		loadConfig();
		initBondBase();
	}


	//��ȡծȯ�����м�Ϣ���伯��(������ҵ������,�����������ҵ�����ݱ任�ü���)��
	public LinkedList<String> getListOfYTM() {
		HashMap<DateTime, DateTime> map= new LinkedHashMap<>();

		if(bondBase.getJxjc() != 1){		//0��ʵ������/365��Ϣ��2��ACT/360��Ϣ��3��30/360��Ϣ
			map.put(bondBase.getJxqsr(),bondBase.getJxjzr());
			return getListOfYTM(map);
		}else {		//1��ʵ��������Ϣ��
			int month = 12 / bondBase.getFxpl();
			DateTime jxqsr = bondBase.getJxqsr();
			DateTime temp;
			while (true) {
				temp = jxqsr.plusMonths(month).minusDays(1);                            //Ŀǰδ����������ƽ��ʱ��
				map.put(jxqsr, temp);
				if (temp.equals(bondBase.getJxjzr())) {
					break;
				} else {
					jxqsr = temp.plusDays(1);
				}
			}
			return getListOfYTM(map);
		}
	}

	//���幦���������ҵ��ʵ��
	protected abstract LinkedList<String> getListOfYTM(HashMap<DateTime,DateTime> map);


	/**
	 * ������Դ·���µ�ծȯ�Ļ�����Ϣ
	 */
	protected void loadConfig(){

		InputStream in =null;
		InputStreamReader isr = null;

		try{
			in = this.getClass().getResourceAsStream("/bond_base.properties");
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

	};

	/**
	 * ��ʼ��ծȯ�Ļ�����Ϣ
	 */
	public void initBondBase(){
		bondBase = new BondBase();
		bondBase.setJxqsr(DateTime.parse(properties.getProperty("jxqsr"), DateTimeFormat.forPattern("yyyy-MM-dd")));
		bondBase.setJxjzr(DateTime.parse(properties.getProperty("jxjzr"), DateTimeFormat.forPattern("yyyy-MM-dd")));
		bondBase.setRate(Double.valueOf(properties.getProperty("rate")));
		bondBase.setPmje(Double.valueOf(properties.getProperty("pmje")));
		bondBase.setJxfs(Integer.valueOf(properties.getProperty("jxfs")));
		bondBase.setJxjc(Integer.valueOf(properties.getProperty("jxjc")));
		bondBase.setFxpl(Integer.valueOf(properties.getProperty("fxpl")));
	}




}
