package com.excel;


import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @ClassName TxtToTxt
 * @Description TODO
 * Author sunhong
 * Date 2019-9-11 13:29
 * 根据xml文件生成对应的pojo和实例对象
 **/
public class TxtToTxt {

    static final String TXT_FILE_PATH = "C:\\Users\\sunhong\\Desktop\\securities_20190703.xml";

    static final String EXCEL_FILE_PATH = "C:\\Users\\sunhong\\Desktop\\b.xls";


    public static void main(String[] args) throws Exception {

        // 解析xml文件
        // 创建SAXReader的对象
        SAXReader reader = new SAXReader();
        try {
            // 通过reader对象的read方法加载xml文件 ，获取docuement对象
            Document document = reader.read(new File(TXT_FILE_PATH));

            // 通过document对象获取根节点car
            Element car = document.getRootElement();
            // 通过element对象的elmentIterator方法获取迭代器

            Iterator it = car.elementIterator();

            // 遍历迭代器，获取根节点中的信息
            diedai(it,"");
            System.out.println("ss");

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void diedai(Iterator iterator,String string){
        while (iterator.hasNext()){
            Element value = (Element) iterator.next();
            Iterator iterator1 = value.elementIterator();
            System.out.println(string + value.getName());        //打印该节点信息
            if (iterator1.hasNext()) {    //该节点有子节点
                //System.out.println(value.getName());
                string = string+"\t";
                diedai(value.elementIterator(),string);
                string = string.substring(1);
            }
        }

    }
}
