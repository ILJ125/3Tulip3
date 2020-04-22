package insert;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.sql.*;

public class fishinsert {

	SimpleDateFormat dayTime = new SimpleDateFormat("yyyymmddhhmmss");

	String url = "jdbc:oracle:thin:@192.168.0.66:1521:orcl";
	String user = "fishcafe";
	String pass = "kosmo66";

	Connection con;

	public fishinsert() throws Exception {
		// 1. 드라이버로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}

	public void insertclient() throws Exception {

		con = DriverManager.getConnection(url, user, pass);
		for(int i=0; i<200;i++) {
		String sql = "insert  into client(client_id,start_time,ring_id )   "
				+ " values (SEQUENCE_gitf_no.nextval,sysdate -? , ? ) ";

		PreparedStatement st = con.prepareStatement(sql);

//		long rand =(int)((Math.random() * 365)- (1/24*(Math.random() * 24)));

		st.setDouble(1, (double)((Math.random() * 365)- (1/24*(Math.random() * 24))));// ?의 의미
		st.setInt(2, (int) (Math.random() * 20) + 1);

		st.executeUpdate();
		st.close();
		}
		con.close();
		
	}

	public void UpdateclientEnd() throws Exception {
		con = DriverManager.getConnection(url, user, pass);
		String sql ="Update client set end_time =";
		
//		String sql = "Update client set price"
//				+ " = trunc(end_time-to_date(start_time)*166.666666668,-3)  ";

		PreparedStatement st = con.prepareStatement(sql);

//		long rand =(double)(1/24*(Math.random() * 24));
//			hh mi ss 60*(int)(Math.random()*60)+60*60*(int)(Math.randeom()*100)
		//시간 : (double)(1/24*(int)(Math.random()*10)+1/24/60(int)(Math.random()*60));
		st.setDouble(1,(double)((Math.random() * 365)- (1/24*(Math.random() * 24))));
		st.executeUpdate();
		st.close();
		con.close();
}

	public static void main(String[] args) {
		try {
			fishinsert fi = new fishinsert();

//			fi.insertclient();
			fi.UpdateclientEnd();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
