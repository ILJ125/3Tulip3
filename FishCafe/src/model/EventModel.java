package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class EventModel {
	String url = "jdbc:oracle:thin:@192.168.0.66:1521:orcl";
	String user = "fishcafe";
	String pass = "kosmo66";

	Connection con;

	public EventModel() throws Exception {
		// 1. 드라이버로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

	}

	public ArrayList loaddata() throws Exception {
		ArrayList arrtype_point = new ArrayList();
		con = DriverManager.getConnection(url, user, pass);
		// 3. sql 문장 만들기
		// tel 와 video id
		// 만약 rentdate 가 null 이면 검색 안함
		String sql = "Select type,avg(point) point from fish group by type ";
		Statement stfishdata = con.createStatement();
		ResultSet rsfishdata = stfishdata.executeQuery(sql);
		while (rsfishdata.next()) {
			ArrayList temp = new ArrayList();
			temp.add(rsfishdata.getString("type"));
			temp.add(rsfishdata.getInt("point"));
			arrtype_point.add(temp);
		}
//		for(int i=0;i<arrtype_point.size();i++)
//		{
//			System.out.println(arrtype_point.get(i));
//		}
		rsfishdata.close();
		stfishdata.close();
		con.close();
		return arrtype_point;

	}

	public void updatePoint(int no, int point, int client) throws Exception {

		con = DriverManager.getConnection(url, user, pass);
		String sql = "";
		if (no == 1) {
			sql = "update client set point=point + ? where client_id = ? ";
		} else {
			sql = "update client set point=point - ? where client_id = ? ";
		}
		PreparedStatement st = con.prepareStatement(sql);

		st.setInt(1, point);
		st.setInt(2, client);

		st.executeUpdate();
		
		st.close();
		con.close();
	}

}
