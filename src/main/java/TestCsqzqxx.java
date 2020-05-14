import org.apache.xmlbeans.impl.regex.Match;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName TestCsqzqxx
 * @Description TODO
 * Author sunhong
 * Date 2020-5-2 10:14
 **/
public class TestCsqzqxx {

    private static String PATH = "C:\\Users\\sunhong\\Desktop\\jjhzhq.sql";

    private static String regex = "to_date\\(\\'\\d{2}-\\d{2}-\\d{4}\\',\\s\\'dd-mm-yyyy\\'\\)";

    public static void main(String[] args) throws Exception {



        FileReader inputStream = new FileReader(PATH);
        BufferedReader bufferedReader = new BufferedReader(inputStream);

        String temp = null;
        int i =0;
        while ((temp = bufferedReader.readLine()) != null) {
            if (temp.trim().length() != 0){
                if (temp.startsWith("values")) {
                    Pattern pattern = Pattern.compile(regex);
                    Matcher m = pattern.matcher(temp);
                    while (m.find()) {
                        String f = m.group();
                        String[] ss = f.split("'")[1].split("-");
                        temp = temp.replaceAll("to_date\\(\\'"+ss[0]+"-"+ss[1]+"-"+ss[2]+"\\',\\s\\'dd-mm-yyyy\\'\\)", "'"+ss[2]+"-"+ss[1]+"-"+ss[0]+"'");
//                        System.out.println(temp.replaceAll(stringToRegex(m.group()), ss[2]+"-"+ss[1]+"-"+ss[0]));
                    }
                }
            }
            System.out.println(temp);
            i++;
        }

        if (inputStream != null) {
            inputStream.close();
        }
        if (bufferedReader != null) {
            bufferedReader.close();
        }
    }


    public static String stringToRegex(String s){
        String reStirng = s.replaceAll("\\(","\\\\\\\\(");
        reStirng = reStirng.replaceAll("\\'","\\\\\\\\'");
        reStirng = reStirng.replaceAll("\\)","\\\\\\\\)");
        reStirng = reStirng.replaceAll("\\s","\\\\\\\\s");
        return reStirng;
    }



    public static String month5test(){
        System.out.println("练习Git分支");
        return null;
    }

    public static String month5test2(){
        System.out.println("练习Git分支2");
        return null;
    }
}
