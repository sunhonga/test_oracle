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
        //获取lestlist表里面所有的套账号，存入festcode集合
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
     * 一个非常标准的连接Oracle数据库的示例代码
     */
    public static void testOracle(String sql)
    {
        Connection con = null;// 创建一个数据库连接
        PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
        ResultSet result = null;// 创建一个结果集对象
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
            System.out.println("开始尝试连接数据库！");
            String url = "jdbc:oracle:" + "thin:@192.168.32.206:1521:orcl";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
            String user = "fund_bj";// 用户名,系统默认的账户名
            String password = "fund_bj";// 你安装时选设置的密码
            con = DriverManager.getConnection(url, user, password);// 获取连接
            System.out.println("连接成功！");
            //String sql = "select distinct (fsetcode ) from lsetlist ";// 预编译语句，“？”代表参数
            pre = con.prepareStatement(sql);// 实例化预编译语句
            //pre.setString(1, "小茗同学");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
            result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
            while (result.next()){
                // 当结果集不为空时
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
                // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
                // 注意关闭的顺序，最后使用的最先关闭
                if (result != null)
                    result.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
                System.out.println("数据库连接已关闭！");
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
        Connection con = null;// 创建一个数据库连接
        PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement
        ResultSet result = null;// 创建一个结果集对象
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");// 加载Oracle驱动程序
            System.out.println("开始尝试连接数据库！");
            String url = "jdbc:oracle:" + "thin:@192.168.32.206:1521:orcl";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
            String user = "fund_bj";// 用户名,系统默认的账户名
            String password = "fund_bj";// 你安装时选设置的密码
            con = DriverManager.getConnection(url, user, password);// 获取连接
            System.out.println("连接成功！");
            //String sql = "select distinct (fsetcode ) from lsetlist ";// 预编译语句，“？”代表参数
            pre = con.prepareStatement(sql);// 实例化预编译语句
            //pre.setString(1, "小茗同学");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
            result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
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
                // 逐一将上面的几个对象关闭，因为不关闭的话会影响性能、并且占用资源
                // 注意关闭的顺序，最后使用的最先关闭
                if (result != null)
                    result.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
                System.out.println("数据库连接已关闭！");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return lists;

        }
    }
}
