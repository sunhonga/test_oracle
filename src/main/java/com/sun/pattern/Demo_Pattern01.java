package com.sun.pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName Demo_Pattern01
 * @Description TODO
 * Author sunhong
 * Date 2019-11-19 9:22
 **/
public class Demo_Pattern01 {


    public static void main(String[] args) {


        String content =  "adaf34.4adf5345sdge0.001afrewf5";

        Pattern pattern = Pattern.compile("\\d+(\\.\\d+)?");

        Matcher matcher = pattern.matcher(content);

        List<String> lists = new ArrayList<>();

        while (matcher.find()) {
            lists.add(matcher.group());
        }


        System.out.println("s");

    }


}
