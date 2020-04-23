package insert;

import java.sql.Connection;
import java.sql.*;
/*
 * 선행 사항 
 *  	1. 데이터 베이스 접속후  
 *  		alter session set nls_date_format='yyyymmddhh24miss';
 *  	를 입력해줘야한다. //시간 데이터가 저 형태로 출력됨
 *  
 *   오픈 시간 : 오후 3시 ~새볔 6시까지 
 *   시간은 1시~3시간 정도 손님 약 800명
 *   그이상 약 100명
 */

public class clientinsert {

//	String url = "jdbc:oracle:thin:@192.168.35.43:1521:orcl"; //나현쓰 집 아이피
	String url = "jdbc:oracle:thin:@192.168.0.66:1521:orcl";
	String user = "fishcafe";
	String pass = "kosmo66";

	Connection con;

	public clientinsert() throws Exception {
		// 1. 드라이버로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}

	public void clientinsert() throws Exception {

		con = DriverManager.getConnection(url, user, pass);
		for (int i = 0; i < 100; i++) {
			String sql = "insert  into client ( client_id,start_time,end_time,client_point,ring_id )   "
					+ " values (SEQUENCE_gitf_no.nextval,(sysdate -?-?-?),(sysdate-?-?-?+?+?),?, ?) ";

			PreparedStatement st = con.prepareStatement(sql);

			double a= ((double) (int) (Math.random() * 60) / (24 * 60));//분
			double b= ((double) (int) ((Math.random() * 14)+9) / 24);//시
			double c= ((double) (int) (Math.random() * 90));//일
			st.setDouble(1,a);// 분의 의미
			st.setDouble(2,b );// 시
			st.setDouble(3,c );// 3개월 개월당 300개건
			st.setDouble(4,a);// 분의 의미
			st.setDouble(5,b);// 시
			st.setDouble(6,c );
			st.setDouble(7,((double) (int) ((Math.random() * 30)+30) / (24 * 60)));// 분 (strat_time 과 차이남)
//			st.setDouble(8,((double) (int) ((Math.random() * 2)+1)/ 24));// 1~2시간 (start _time 과 차이남) 
			st.setDouble(8,((double) (int) ((Math.random() * 5)+3) / 24));// 3~8시간 (start _time 과 차이남) 200개?
			st.setInt(9, (int) ((Math.random() * 30) * 100));//결국 사용하고 남은 포인트 이다.
			st.setInt(10, (int) (Math.random() * 20) + 1);

			st.executeUpdate();
			st.close();
		}
		con.close();

	}


	public static void main(String[] args) {
		try {
			clientinsert fi = new clientinsert();

			fi.clientinsert();
//			fi.UpdateclientEnd();
//			fi.no();// no 만들기

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
