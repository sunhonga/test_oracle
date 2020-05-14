import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


/**
 * ���ץȡ����
 * 2019-7-30
 * ������ SunHong
 */
public class JdbcTest_HzjkQs
{
	static  List<String> fsetcode =  new ArrayList<>();
	static HashSet<String> stringHashSet = new HashSet<>();

	public static void main(String[] args) {
		//��ȡlestlist���������е����˺ţ�����festcode����
		testOracle("select table_name from user_tables  where table_name like 'A%FCWVCH' and tablespace_name = 'FUND_CD' ");
		for (String s : fsetcode) {
			//String hzjkqs_sql = "SELECT FDATE,FZQDM,FSZSH,FYWBZ FROM " + s + " WHERE substr(FVCHZY,16,6) like '0%' AND FPZLY like '%SG%'";
/*			String hzjkqs_sql = "select * from (\n" +
					"select aa.zqdm ,aa.fdate from \n" +
					"(select * from csholiday where fdate>date'2018-01-01' and fdate<date'2018-12-31' and fbz=0)  ss\n" +
					"   left join \n" +
					"(SELECT substr(fkmh, 9) zqdm, fdate\n" +
					"  FROM " + s + " WHERE fjd = 'D'\n" +
					"   and (fvchzy like '%��Ϣ%' or fvchzy like '%�Ҹ�%')\n" +
					"   and length(fkmh) = '14') aa \n" +
					" on aa.fdate = ss.fdate ) where zqdm <>'2'";*/
/*			String hzjkqs_sql = "select * from " + s +" where (fvchzy like '%��Ϣ%' or fvchzy like '%�Ҹ�%')\n" +
                    "   and fdate in (select fdate from csholiday where fbz = '0' and fdate>date'2018-01-01' and fdate<date'2019-01-01')\n" +
                    "   and fdate + 1 in (select fdate from csholiday where fbz = '0' and fdate>date'2018-01-01' and fdate<date'2019-01-01')";*/
   //			substr(fvchzy,16,6) in (select fzqdm from cszqxx  where  fjysc = '�Ͻ���') and
			String hzjkqs_sql = "select * from " + s+  " where  fvchzy like '%�Ҹ�%' and  fdate in (select fdate from csholiday where fbz ='0' and fdate>date'2018-01-01' and fdate<date'2018-12-31')";
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
			//System.out.println("��ʼ�����������ݿ⣡");
			String url = "jdbc:oracle:" + "thin:@192.168.32.203:1521:orcl";// 127.0.0.1�Ǳ�����ַ��XE�Ǿ����Oracle��Ĭ�����ݿ���
			String user = "sbfund";// �û���,ϵͳĬ�ϵ��˻���
			String password = "sbfund";// �㰲װʱѡ���õ�����
			con = DriverManager.getConnection(url, user, password);// ��ȡ����
			//System.out.println("���ӳɹ���");
			//String sql = "select distinct (fsetcode ) from lsetlist ";// Ԥ������䣬�������������
			pre = con.prepareStatement(sql);// ʵ����Ԥ�������
			//pre.setString(1, "С��ͬѧ");// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
			result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
			while (result.next()){
				// ���������Ϊ��ʱ
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
				// ��һ������ļ�������رգ���Ϊ���رյĻ���Ӱ�����ܡ�����ռ����Դ
				// ע��رյ�˳�����ʹ�õ����ȹر�
				if (result != null)
					result.close();
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
				//System.out.println("���ݿ������ѹرգ�");
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
			//System.out.println("��ʼ�����������ݿ⣡");
			String url = "jdbc:oracle:" + "thin:@192.168.32.203:1521:orcl";// 127.0.0.1�Ǳ�����ַ��XE�Ǿ����Oracle��Ĭ�����ݿ���
			String user = "sbfund";// �û���,ϵͳĬ�ϵ��˻���
			String password = "sbfund";// �㰲װʱѡ���õ�����
			con = DriverManager.getConnection(url, user, password);// ��ȡ����
			//System.out.println("���ӳɹ���");
			//String sql = "select distinct (fsetcode ) from lsetlist ";// Ԥ������䣬�������������
			pre = con.prepareStatement(sql);// ʵ����Ԥ�������
			//pre.setString(1, "С��ͬѧ");// ���ò�����ǰ���1��ʾ�����������������Ǳ�������������
			result = pre.executeQuery();// ִ�в�ѯ��ע�������в���Ҫ�ټӲ���
            int columns = result.getMetaData().getColumnCount();
			while (result.next()){
/*				HzjkQs hzjkqs = new HzjkQs();
				hzjkqs.setFdate(result.getDate("FDATE"));
				hzjkqs.setFzdm(result.getString("FZQDM"));
				hzjkqs.setFszsh(result.getString("FSZSH"));
				hzjkqs.setFywbz(result.getString("FYWBZ"));
				hzjkqs.setFsetcode(s);
				lists.add(hzjkqs);*/
				//System.out.println(result.getDate("FDATE") + "���˺�"+s);

                stringHashSet.add(s+"ʱ��"+result.getString("FDATE"));
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
				// ��һ������ļ�������رգ���Ϊ���رյĻ���Ӱ�����ܡ�����ռ����Դ
				// ע��رյ�˳�����ʹ�õ����ȹر�
				if (result != null)
					result.close();
				if (pre != null)
					pre.close();
				if (con != null)
					con.close();
				//System.out.println("���ݿ������ѹرգ�");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return lists;

		}
	}

}