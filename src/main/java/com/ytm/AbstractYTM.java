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
 * 抽象的到期收益计算方式
 * 创建人 SunHong
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

	private void init() {					//初始化计算YTM的相关参数

		loadConfig();						//获得配置文件
		fuzhi();							//给基本参数赋值
		getJxXingxi();						//获得债券的计息区间
	}
	private void getJxXingxi() {
		linkedList = bondAndYeWu.getListOfYTM();				//等到是一个  key 从1自增,value 为每个计息区间的天数 + 改计息区间到计息截止日的天数
	}

	protected void fuzhi() {
		diedaicishu = Integer.valueOf(properties.getProperty("diedaicishu"));
		blws = Integer.valueOf(properties.getProperty("blws"));
		chushiMax = Integer.valueOf(properties.getProperty("chushimax"));
		chushiMin = Integer.valueOf(properties.getProperty("chushimin"));
	}


	/**
	 * 计算实际收益率公式：0=Z0(1+y)^n + M(y-i0)((1+y)^n-1)/y
	 * z0:初始溢折价
	 * y:实际收益率
	 * M：面值
	 * i0：日票面利率
	 */
	public abstract double ytm();


	//读取配置文件,未用reader方法.在这直接写(后期可以仿spring的写法)
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
