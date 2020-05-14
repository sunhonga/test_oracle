package com.sun.pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2019-7-31
 * 创建人 SunHong
 */
public class Demo_Pattern {


	public static void main(String[] args) {

		String text = "There are eetom1 in life 2tom3 you miss someone so much that you just wa";

		//一次比较
		//boolean bool = Pattern.matches("\\s.*tom.*\\s",text);
		//多次比较
		Pattern pattern = Pattern.compile("(\\s\\w*tom\\w*\\s)");

		Matcher matcher = pattern.matcher(text);

		List<String>  lists = new ArrayList<>();
		while (matcher.find()){
			//System.out.println(matcher.group());
			lists.add(matcher.group());
		}


		System.out.println("");

		String s = "private\\Q*static\\.*public.com .*sum .*";

		String s1 = s.replaceAll("\\\\.\\*","sds");
		System.out.println(s1);
		s.replaceAll("\\\\\\.\\*","123");
		System.out.println(s);

	}
}
