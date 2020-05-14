package com.excel;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ExcelToTxt
 * @Description TODO
 * Author sunhong
 * Date 2019-9-5 11:02
 **/
public class ExcelToTxt {


    static final String TXT_FILE_PATH = "C:\\Users\\sunhong\\Desktop\\66618627trddata20190515.txt";

    static final String EXCEL_FILE_PATH = "C:\\Users\\sunhong\\Desktop\\a.xls";

    static  ArrayList<String> list = new ArrayList<String>();



    public static void main(String[] args) throws Exception{
        loadExcel();
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(TXT_FILE_PATH),"GBK"));
        for (int i = 0; i < list.size(); i++) {
            br.write(list.get(i));
            br.write("\r\n");
        }
        if (br != null) {
            br.close();
        }
        System.out.println("生成TXT文件成功。。。。");
    }

    public static  void loadExcel(){

        InputStream is = null;
        try {
            is = new FileInputStream(EXCEL_FILE_PATH);
            String fileType = EXCEL_FILE_PATH.substring(EXCEL_FILE_PATH.lastIndexOf(".") + 1);
            //获取工作薄
            Workbook wb = null;
            if (fileType.equals("xls")) {
                wb = new HSSFWorkbook(is);
            } else if (fileType.equals("xlsx")) {
                wb = new XSSFWorkbook(is);
            }

            //读取第一个工作页sheet
            Sheet sheet = wb.getSheetAt(0);
            //第一行为标题
            for (Row row : sheet) {
                StringBuffer sb = new StringBuffer();
                for (Cell cell : row) {
                    //根据不同类型转化成字符串
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    String s = cell.getStringCellValue();
                    if(s.trim().length() == 0 && s.trim() == ""){break;}
                    sb.append(cell.getStringCellValue()).append("@");
                }
                String ss = sb.toString();
                if(TXT_FILE_PATH.contains("h")){         //每日持仓数据
                    list.add(ss);
                }else if (TXT_FILE_PATH.contains("r")) {   //每日交易数据
                    list.add(ss.substring(0, ss.lastIndexOf("@")));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
