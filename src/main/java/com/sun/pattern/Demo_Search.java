package com.sun.pattern;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2019-8-1
 * ʵ��idea����������
 * ������ SunHong
 */
public class Demo_Search  {

	final static String[] FILE_PATH = {"E:\\ideadevelop\\JJCWGZ3.0\\src","E:\\ideadevelop\\JJCWGZ3.0\\fundacc"};
	final  static  List<String> FILES  = new ArrayList<>();

	final static String SCAN_STRING = "���м�ծȯ�������ۼ�";			//��Ҫ�������ַ���
	final static Pattern PATTERN = Pattern.compile("insert\\s*into\\s*shhq",Pattern.CASE_INSENSITIVE) ;  //������ʽƥ�������

	public static void main(String[] args) throws Exception {


		searchFile(FILE_PATH);
		System.out.println("ss");
		scan(true);

	}

	private static void scan(boolean b) throws Exception {


		if(b){			//����ƥ��
			scan(FILES,PATTERN);
		}else {		   //������ƥ��
			scan(FILES);
		}
	}

	private static void scan(List<String> files, Pattern pattern) throws Exception{
		for(String s : files){
			FileInputStream fis=new FileInputStream(s);
			InputStreamReader isr=new InputStreamReader(fis, "GBK");
			BufferedReader br = new BufferedReader(isr);
			String line="";
			int x = 0;
			while ((line=br.readLine())!=null) {
				x++;
				Matcher matcher = pattern.matcher(line);
				if(matcher.find()){
					System.out.println("�ļ�"+s+"��"+x+"��"+line);
				}
			}
			br.close();
			isr.close();
			fis.close();
		}

	}

	private static void scan(List<String> files) throws Exception {
		for(String s : files){
			FileInputStream fis=new FileInputStream(s);
			InputStreamReader isr=new InputStreamReader(fis, "GBK");
			BufferedReader br = new BufferedReader(isr);
			String line="";
			int x = 0;
			while ((line=br.readLine())!=null) {
				x++;
				if(line.contains(SCAN_STRING)){
					System.out.println("�ļ�"+s+"��"+x+"��"+line);
				}
			}
			br.close();
			isr.close();
			fis.close();
		}
	}

	private static void searchFile(String[] filePath) {
		for(String s : filePath){
			searchFile(s);
		}
	}

	public  static void   searchFile(String s){

		File file = new File(s);
		if (file.isDirectory()){
			File[] files = file.listFiles();
			for(File f : files){
				if(f.isDirectory()){
					searchFile(f.getPath());
				}else {
					if(f.getName().endsWith(".java") || f.getName().endsWith(".jsp") || f.getName().endsWith(".htm") || f.getName().endsWith(".xml")){
						FILES.add(f.getPath());
					}
				}
			}
		}

	}
}
