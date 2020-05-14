package com.bond;

import java.util.HashMap;
import java.util.Map;

/**
 * 2019-8-12
 * 创建人 SunHong
 */
public class Demo1 {

	 //final static String  FILE_PATH = "C:\\Users\\sunhong\\Desktop\\ww.txt";
	 static  Map<Integer,String> map = new HashMap<>();

	public static void main(String[] args) {
		//map = BondAndYeWu.satrt();
		//getMap();			//得到map集合
		String exp = getExpress();					//拼接公式字符串
		System.out.println(exp.substring(4));

	}

	private static String getExpress() {
		String exp =null;
		for(Integer integer:map.keySet()){
			String[] strs = map.get(integer).split("\t\t");
			if(integer == map.size()){
				String tail = map.get(integer).split("\t\t")[0];
				exp = exp + "$B$17*(B21-2/"+tail+"00)*((1+B21)^"+tail+"-1)/B21";
				return exp ;
			}
			exp = exp+ doPingJie(strs,integer);
		}

		return null;

	}

	private static String doPingJie(String[] strs,Integer integer) {
		//$B$17*(B21-2/18300)*((1+B21)^18217-(1+B21)^18080)/B21+
		String[] ss = map.get(integer+1).split("\t\t");
		return "$B$17*(B21-2/"+strs[0]+"00)*((1+B21)^"+strs[1]+"-(1+B21)^"+ss[1]+")/B21+";

	}

	/*public static void getMap(){
			FileInputStream fis = null;
			FileOutputStream fos = null;
			InputStreamReader isr = null;
			BufferedReader br = null;
			try{
				fis = new FileInputStream(FILE_PATH);
				isr=new InputStreamReader(fis, "GBK");
				br = new BufferedReader(isr);
				String line="";
				int i = 0;
				while ((line=br.readLine())!=null) {
					map.put(Integer.valueOf(++i),line);
					//System.out.println(line);
				}
			}catch (Exception e){
				e.printStackTrace();
			}finally {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}



	}*/


}
