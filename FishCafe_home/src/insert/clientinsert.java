package insert;

import java.sql.Connection;
import java.sql.*;

public class clientinsert {

	String url = "jdbc:oracle:thin:@192.168.35.43:1521:orcl";
	String user = "fishcafe";
	String pass = "kosmo66";

	Connection con;

	public clientinsert() throws Exception {
		// 1. 드라이버로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}

	public void insertclient() throws Exception {

		con = DriverManager.getConnection(url, user, pass);
		for (int i = 0; i < 300; i++) {
			String sql = "insert  into client ( client_id,start_time,end_time,client_point,ring_id )   "
					+ " values (SEQUENCE_gitf_no.nextval,(sysdate -?-?-?),(sysdate-?-?-?+?+?),?, ?) ";

			PreparedStatement st = con.prepareStatement(sql);

			double a= ((double) (int) (Math.random() * 60) / (24 * 60));
			double b= ((double) (int) (Math.random() * 60) / 24);
			double c= ((double) (int) (Math.random() * 90));
			st.setDouble(1,a);// 분의 의미
			st.setDouble(2,b );// 시
			st.setDouble(3,c );// 3개월 개월당 300개건
			st.setDouble(4,a);// 분의 의미
			st.setDouble(5,b);// 시
			st.setDouble(6,c );
			st.setDouble(7,((double) (int) (Math.random() * 60) / (24 * 60)));// 분 (strat_time 과 차이남)
			st.setDouble(8,((double) (int) ((Math.random()+1) * 2) / 24));// 1~2시간 (start _time 과 차이남) 
//			st.setDouble(8,((double) (int) ((Math.random() * 10)) / 24));// 0~10시간 (start _time 과 차이남) 200개?
			st.setInt(9, (int) ((Math.random() * 200) * 100));
			st.setInt(10, (int) (Math.random() * 20) + 1);

			st.executeUpdate();
			st.close();
		}
		con.close();

	}


	public void no() throws Exception {
		// no라는 col을 만들어서 for로 1부터 900까지 반복된느 숫자를 집어 넣어자
		// 그리고 위에서 endtime에 랜덤숫자로 업데이트 시킬때 반복할 때 사용하자
		con = DriverManager.getConnection(url, user, pass);
		for (int i = 1; i <= 900; i++) {
			String sql = "Update client set no = ? where no i";
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, i);
			st.executeUpdate();
			st.close();
		}
		con.close();
	}

	public static void main(String[] args) {
		try {
			clientinsert fi = new clientinsert();

			fi.insertclient();
//			fi.UpdateclientEnd();
//			fi.no();// no 만들기

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
