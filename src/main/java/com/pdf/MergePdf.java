package com.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.util.LinkedList;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;


/**
 * @ClassName MergePdf
 * @Description TODO
 * Author sunhong
 * Date 2019-12-24 11:20
 **/
public class MergePdf {


    static LinkedList<String>  filePath = new LinkedList<>();
    static String FILE_PATH = "E:\\ѧϰ����\\����\\������\\�ֲ�ʽ��΢����\\05.�ֲ�ʽ��������";
    //������pdf�ļ��ϲ���һ��


    public static void main(String[] args) throws ParseException {
        //������pdf�ϲ���һ��
/*        String[] files = {"C:\\Users\\sunhong\\Desktop\\pdf\\JVMʵսƪ�ʼ�.pdf", "C:\\Users\\sunhong\\Desktop\\pdf\\JVM�ս�ƪ�ʼ�.pdf"};
        String savepath = "C:\\Users\\sunhong\\Desktop\\pdf\\temp.pdf";
        mergePdfFiles(files, savepath);*/
        getFilePath(FILE_PATH);
        System.out.println("ss");
        LinkedList<String>  linkedList = new LinkedList<>();
        for (int i = 0; i <filePath.size() ; i++) {
            if (i >3 && i <8 ){
                linkedList.add(filePath.get(i));
            }
        }
        mergePdfFiles(linkedList,"E:\\ѧϰ����\\����\\������\\�ֲ�ʽ��΢����\\05.�ֲ�ʽ��������\\Zookeeper.pdf");

    }


    //������pdf�ļ��ϲ���һ��
    public static boolean mergePdfFiles(LinkedList<String> files, String newfile) {
        boolean retValue = false;
        Document document = null;
        try {
            document = new Document(new PdfReader(files.get(0)).getPageSize(1));
            PdfCopy copy = new PdfCopy(document, new FileOutputStream(newfile));
            document.open();
            for (int i = 0; i < files.size(); i++) {
                PdfReader reader = new PdfReader(files.get(i));
                int n = reader.getNumberOfPages();
                for (int j = 1; j <= n; j++) {
                    document.newPage();
                    PdfImportedPage page = copy.getImportedPage(reader, j);
                    copy.addPage(page);
                }
            }
            retValue = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
        return retValue;
    }


    public static void getFilePath(String path) {

        File file = new File(path);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isDirectory()) {
                    getFilePath(f.getPath());
                }else {
                    if (f.getName().endsWith(".pdf") && f.getName().contains("�ʼ�")){
                        filePath.add(f.getPath());
                    }
                }
            }
        }

    }
}

/*

{

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

        }*/
