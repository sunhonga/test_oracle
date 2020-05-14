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
 * 创建人 SunHong
 * Bond的抽象类,包含债券基本的信息
 */
public abstract class AbstractBond {


	public static Properties properties = new Properties();
	public static BondBase bondBase;

	//基本的债券信息在抽象里面初始化，不同类别的债券由其子类自己实现
	public AbstractBond() {
		super();
		loadConfig();
		initBondBase();
	}


	//获取债券的所有计息区间集合(不考虑业务日期,具体子类根据业务数据变换该集合)。
	public LinkedList<String> getListOfYTM() {
		HashMap<DateTime, DateTime> map= new LinkedHashMap<>();

		if(bondBase.getJxjc() != 1){		//0按实际天数/365计息；2按ACT/360计息；3按30/360计息
			map.put(bondBase.getJxqsr(),bondBase.getJxjzr());
			return getListOfYTM(map);
		}else {		//1按实际天数计息；
			int month = 12 / bondBase.getFxpl();
			DateTime jxqsr = bondBase.getJxqsr();
			DateTime temp;
			while (true) {
				temp = jxqsr.plusMonths(month).minusDays(1);                            //目前未考虑遇到闰平的时候
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

	//具体功能子类根据业务实现
	protected abstract LinkedList<String> getListOfYTM(HashMap<DateTime,DateTime> map);


	/**
	 * 加载资源路径下的债券的基本信息
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
	 * 初始化债券的基本信息
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
