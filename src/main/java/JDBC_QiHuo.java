import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName JDBC_QiHuo
 * @Description TODO
 * Author sunhong
 * Date 2019-9-17 15:41
 **/
public class JDBC_QiHuo {



    static List<String> fsetcode =  new ArrayList<>();

    public static void main(String[] args) {
        //��ȡlestlist���������е����˺ţ�����festcode����
        testOracle("select table_name from user_tables  where table_name like 'A%CSGDDM%' and tablespace_name = 'FUND' ");
        for (String s : fsetcode) {
            String hzjkqs_sql = "SELECT * FROM ZJSTRADE WHERE FDATE = TO_DATE("+"'2018-4-27'"+","+"'YYYY-MM-DD') " +"AND CLIENTID IN ( SELECT FGDDM FROM " + s  + ")";
            List<HzjkQs> hzjkqs =  huoqushuju(hzjkqs_sql,s);
            if( hzjkqs != null) {
                for (HzjkQs hzjkqs1 : hzjkqs) {
                    System.out.println(hzjkqs1);
                }
            }
        }

    }
    /**
     * һ���ǳ���׼������Oracle���ݿ��ʾ������
     */
    public static void testOracle(String sql)
    {
        Connection con = null;// ����һ�����ݿ�����
        PreparedStatement pre = null;// ����Ԥ����������һ�㶼�������������Statement
        ResultSet result = null;// ����һ�����������
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");// ����Oracle��������
            System.out.println("��ʼ�����������ݿ⣡");
            String url = "jdbc:oracle:" + "thin:@192.168.32.206:1521:orcl";// 127.0.0.1�Ǳ�����ַ��XE�Ǿ����Oracle��Ĭ�����ݿ���
            String user = "fund_bj";// �û���,ϵͳĬ�ϵ��˻���
            String password = "fund_bj";// �㰲װʱѡ���õ�����
            con = DriverManager.getConnection(url, user, password);// ��ȡ����
            System.out.println("���ӳɹ���");
            //String sql = "select distinct (fsetcode ) from lsetlist ";// Ԥ������䣬�������������
            pre = con.prepareStatement(sql);// ʵ����Ԥ�������
            //pre.setString(1, "С��ͬѧ");// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
            result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
            while (result.next()){
                // ���������Ϊ��ʱ
                fsetcode.add(result.getString("table_name"));}
            System.out.println("sss");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                // ��һ������ļ�������رգ���Ϊ���رյĻ���Ӱ�����ܡ�����ռ����Դ
                // ע��رյ�˳�����ʹ�õ����ȹر�
                if (result != null)
                    result.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
                System.out.println("���ݿ������ѹرգ�");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }



    public static   List<HzjkQs> huoqushuju(String sql,String s)
    {
        List<HzjkQs> lists = new ArrayList<>();
        Connection con = null;// ����һ�����ݿ�����
        PreparedStatement pre = null;// ����Ԥ����������һ�㶼�������������Statement
        ResultSet result = null;// ����һ�����������
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");// ����Oracle��������
            System.out.println("��ʼ�����������ݿ⣡");
            String url = "jdbc:oracle:" + "thin:@192.168.32.206:1521:orcl";// 127.0.0.1�Ǳ�����ַ��XE�Ǿ����Oracle��Ĭ�����ݿ���
            String user = "fund_bj";// �û���,ϵͳĬ�ϵ��˻���
            String password = "fund_bj";// �㰲װʱѡ���õ�����
            con = DriverManager.getConnection(url, user, password);// ��ȡ����
            System.out.println("���ӳɹ���");
            //String sql = "select distinct (fsetcode ) from lsetlist ";// Ԥ������䣬�������������
            pre = con.prepareStatement(sql);// ʵ����Ԥ�������
            //pre.setString(1, "С��ͬѧ");// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
            result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
            while (result.next()){
                System.out.println(s);
            }
            //System.out.println("sss");
        }
        catch (Exception e)
        {
            System.out.println(s);
            return null;
        }
        finally
        {
            try
            {
                // ��һ������ļ�������رգ���Ϊ���رյĻ���Ӱ�����ܡ�����ռ����Դ
                // ע��رյ�˳�����ʹ�õ����ȹر�
                if (result != null)
                    result.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
                System.out.println("���ݿ������ѹرգ�");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return lists;

        }
    }
}
