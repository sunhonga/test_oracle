import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * 跨表抓取数据
 * 2019-7-30
 * 创建人 SunHong
 */
public class JdbcTest_HzjkQs
{
	static  List<String> fsetcode =  new ArrayList<>();
	static HashSet<String> stringHashSet = new HashSet<>();

	public static void main(String[] args) {
		//获取lestlist表里面所有的套账号，存入festcode集合
		testOracle("select table_name from user_tables  where table_name like 'A%FCWVCH' and tablespace_name = 'FUND_CD' ");
		for (String s : fsetcode) {
			//String hzjkqs_sql = "SELECT FDATE,FZQDM,FSZSH,FYWBZ FROM " + s + " WHERE substr(FVCHZY,16,6) like '0%' AND FPZLY like '%SG%'";
/*			String hzjkqs_sql = "select * from (\n" +
					"select aa.zqdm ,aa.fdate from \n" +
					"(select * from csholiday where fdate>date'2018-01-01' and fdate<date'2018-12-31' and fbz=0)  ss\n" +
					"   left join \n" +
					"(SELECT substr(fkmh, 9) zqdm, fdate\n" +
					"  FROM " + s + " WHERE fjd = 'D'\n" +
					"   and (fvchzy like '%派息%' or fvchzy like '%兑付%')\n" +
					"   and length(fkmh) = '14') aa \n" +
					" on aa.fdate = ss.fdate ) where zqdm <>'2'";*/
/*			String hzjkqs_sql = "select * from " + s +" where (fvchzy like '%派息%' or fvchzy like '%兑付%')\n" +
                    "   and fdate in (select fdate from csholiday where fbz = '0' and fdate>date'2018-01-01' and fdate<date'2019-01-01')\n" +
                    "   and fdate + 1 in (select fdate from csholiday where fbz = '0' and fdate>date'2018-01-01' and fdate<date'2019-01-01')";*/
   //			substr(fvchzy,16,6) in (select fzqdm from cszqxx  where  fjysc = '上交所') and
			String hzjkqs_sql = "select * from " + s+  " where  fvchzy like '%兑付%' and  fdate in (select fdate from csholiday where fbz ='0' and fdate>date'2018-01-01' and fdate<date'2018-12-31')";
			List<HzjkQs> hzjkqs =  huoqushuju(hzjkqs_sql,s);
			if( hzjkqs != null) {
				for (HzjkQs hzjkqs1 : hzjkqs) {
					//System.out.println(hzjkqs1);
				}
			}

        }
        System.out.println(stringHashSet.size());
        for(String str : stringHashSet){
            System.out.println(str);
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
			//System.out.println("开始尝试连接数据库！");
			String url = "jdbc:oracle:" + "thin:@192.168.32.203:1521:orcl";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
			String user = "sbfund";// 用户名,系统默认的账户名
			String password = "sbfund";// 你安装时选设置的密码
			con = DriverManager.getConnection(url, user, password);// 获取连接
			//System.out.println("连接成功！");
			//String sql = "select distinct (fsetcode ) from lsetlist ";// 预编译语句，“？”代表参数
			pre = con.prepareStatement(sql);// 实例化预编译语句
			//pre.setString(1, "小茗同学");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
			while (result.next()){
				// 当结果集不为空时
				fsetcode.add(result.getString("table_name"));}
			//System.out.println("sss");
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
				//System.out.println("数据库连接已关闭！");
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
			//System.out.println("开始尝试连接数据库！");
			String url = "jdbc:oracle:" + "thin:@192.168.32.203:1521:orcl";// 127.0.0.1是本机地址，XE是精简版Oracle的默认数据库名
			String user = "sbfund";// 用户名,系统默认的账户名
			String password = "sbfund";// 你安装时选设置的密码
			con = DriverManager.getConnection(url, user, password);// 获取连接
			//System.out.println("连接成功！");
			//String sql = "select distinct (fsetcode ) from lsetlist ";// 预编译语句，“？”代表参数
			pre = con.prepareStatement(sql);// 实例化预编译语句
			//pre.setString(1, "小茗同学");// 设置参数，前面的1表示参数的索引，而不是表中列名的索引
			result = pre.executeQuery();// 执行查询，注意括号中不需要再加参数
            int columns = result.getMetaData().getColumnCount();
			while (result.next()){
/*				HzjkQs hzjkqs = new HzjkQs();
				hzjkqs.setFdate(result.getDate("FDATE"));
				hzjkqs.setFzdm(result.getString("FZQDM"));
				hzjkqs.setFszsh(result.getString("FSZSH"));
				hzjkqs.setFywbz(result.getString("FYWBZ"));
				hzjkqs.setFsetcode(s);
				lists.add(hzjkqs);*/
				//System.out.println(result.getDate("FDATE") + "套账号"+s);

                stringHashSet.add(s+"时间"+result.getString("FDATE"));
				//System.out.println(s);
			}
			//System.out.println("sss");
		}
		catch (Exception e)
		{
			//System.out.println(s);
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
				//System.out.println("数据库连接已关闭！");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return lists;

		}
	}

}