package com.excel;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TxtToExcel2
 * @Description TODO
 * Author sunhong
 * Date 2019-9-11 9:59
 **/
public class TxtToExcel2 {

    static final String TXT_FILE_PATH = "C:\\Users\\sunhong\\Desktop\\fjy20190603.txt";

    static final String EXCEL_FILE_PATH = "C:\\Users\\sunhong\\Desktop\\b.xls";


    public static void main(String[] args) throws Exception{

        List<String> list = new ArrayList<>();
        list = loadTxt();

        //第一步创建workbook
        HSSFWorkbook wb = new HSSFWorkbook();

        //第二步创建sheet
        HSSFSheet sheet = wb.createSheet("sheet1");

        //第三步创建行row:添加表头0行
        HSSFRow row = sheet.createRow(0);
        HSSFCellStyle style = wb.createCellStyle();
        //style.setAlignment(HSSFCellStyle.ALIGN_CENTER);  //居中


       /* //第四步创建单元格
        HSSFCell cell = row.createCell(0); //第一个单元格
        cell.setCellValue("姓名");
        cell.setCellStyle(style);


        cell = row.createCell(1);         //第二个单元格
        cell.setCellValue("年龄");
        cell.setCellStyle(style);*/


        //第五步插入数据
        int size = list.size();
        for (int i = 0; i < size; i++) {
            //创建行
            row = sheet.createRow(i + 1);
            //创建单元格并且添加数据
            String[] arr = list.get(i).split("\\|");
            int arr_size = arr.length;
            for (int j = 0; j < arr_size; j++) {
                row.createCell(j).setCellValue(arr[j]);
            }


        }

        //第六步将生成excel文件保存到指定路径下
        try {
            FileOutputStream fout = new FileOutputStream(EXCEL_FILE_PATH);
            wb.write(fout);
            fout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Excel文件生成成功...");
    }

    private static List<String> loadTxt() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(TXT_FILE_PATH),"GBK"));
        List<String> list = new  ArrayList<>();
        String line;
        while((line = br.readLine()) != null) {
            list.add(line);
        }


        return list;



        /*FileInputStream fis = new FileInputStream(TXT_FILE_PATH);
        File file = new File(TXT_FILE_PATH);
        byte[] bytes = new byte[(int) file.length()];
        int ret  = fis.read(bytes);
        String content = new String(bytes, 0, ret);



        return null;*/
    }
}
