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
 * ����xml�ļ����ɶ�Ӧ��pojo��ʵ������
 **/
public class TxtToTxt {

    static final String TXT_FILE_PATH = "C:\\Users\\sunhong\\Desktop\\securities_20190703.xml";

    static final String EXCEL_FILE_PATH = "C:\\Users\\sunhong\\Desktop\\b.xls";


    public static void main(String[] args) throws Exception {

        // ����xml�ļ�
        // ����SAXReader�Ķ���
        SAXReader reader = new SAXReader();
        try {
            // ͨ��reader�����read��������xml�ļ� ����ȡdocuement����
            Document document = reader.read(new File(TXT_FILE_PATH));

            // ͨ��document�����ȡ���ڵ�car
            Element car = document.getRootElement();
            // ͨ��element�����elmentIterator������ȡ������

            Iterator it = car.elementIterator();

            // ��������������ȡ���ڵ��е���Ϣ
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
            System.out.println(string + value.getName());        //��ӡ�ýڵ���Ϣ
            if (iterator1.hasNext()) {    //�ýڵ����ӽڵ�
                //System.out.println(value.getName());
                string = string+"\t";
                diedai(value.elementIterator(),string);
                string = string.substring(1);
            }
        }

    }
}
