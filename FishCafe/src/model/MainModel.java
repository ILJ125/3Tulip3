package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class MainModel {
	String url = "jdbc:oracle:thin:@192.168.0.66:1521:orcl";
	String user = "fishcafe";
	String pass = "kosmo66";

	ArrayList itemdata = new  ArrayList();
	Connection con;

	public MainModel() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");

	}
	public void insertstart(int ringnum) throws Exception {
		con = DriverManager.getConnection(url, user, pass);
		// 3. sql 문장 만들기
		String sql = " insert into client(client_id, start_time, ring_id) values ( SEQUENCE_CLIENT_NO.nextval,sysdate,? )";
		// 4. sql 전송객체 (PreparedStatement)
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1,ringnum);
		st.executeUpdate();
		// 6.닫기
		st.close();
		con.close();
	}

	
	
	public void updatecost(int cost, int ring_id) throws Exception {
		// 2. Connection 연결객체 얻어오기
				con = DriverManager.getConnection(url, user, pass);
				// 3. sql 문장 만들기
				String sql = " update client set price = ? , end_time =sysdate  where ring_id =?  and end_time is null";
				// 4. sql 전송객체 (PreparedStatement)
				PreparedStatement st = con.prepareStatement(sql);
				st.setInt(1,cost);
				st.setInt(2,ring_id);
				st.executeUpdate();
				// 6.닫기
				st.close();
				con.close();

		}

	}

