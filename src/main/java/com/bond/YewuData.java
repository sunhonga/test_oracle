package com.bond;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 2019-8-13
 * ¥¥Ω®»À SunHong
 */
public  class YewuData {

	public static Properties properties = new Properties();


	protected void loadConfig(){

		InputStream in =null;
		InputStreamReader isr = null;

		try{
			in = this.getClass().getResourceAsStream("/yewu.properties");
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




	public YeWu getYeWu(){
		loadConfig();
		YeWu yeWu = new YeWu();
		yeWu.setMrsj(DateTime.parse(properties.getProperty("mrsj"), DateTimeFormat.forPattern("yyyy-MM-dd")));
		yeWu.setBdje(Double.valueOf(properties.getProperty("bdje")));
		yeWu.setSl(Double.valueOf(properties.getProperty("sl")));
		return yeWu;

	}
}
