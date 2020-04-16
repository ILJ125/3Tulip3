package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.CustomerDao;
import model.vo.Customer;

public class CustomerModel implements CustomerDao {

	String url = "jdbc:oracle:thin:@192.168.0.66:1521:orcl";
	String user = "nanana";
	String pass = "kosmo66";
	Connection con;

	public CustomerModel() throws Exception {
		// 1. 드라이버로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}

	public void insertCustomer(Customer vo) throws Exception {
		// 2. Connection 연결객체 얻어오기
		con = DriverManager.getConnection(url, user, pass);
		// 3. sql 문장 만들기
		String sql = "INSERT INTO customer VALUES (?,?,?,?,?)";
		// 4. sql 전송객체 (PreparedStatement)
		PreparedStatement insert = con.prepareStatement(sql);
		insert.setString(1, vo.getCustTel1());
		insert.setString(2, vo.getCustName());
		insert.setString(3, vo.getCustTel2());
		insert.setString(4, vo.getCustAddr());
		insert.setString(5, vo.getCustEmail());
		// 5. sql 전송
		insert.executeUpdate();
		// 6. 닫기
		insert.close();
		con.close();
	}

	public Customer selectByTel(String tel) throws Exception {
		Customer dao = new Customer();
		// 2. Connection 연결객체 얻어오기
		con = DriverManager.getConnection(url, user, pass);
		// 3. sql 문장 만들기
		String sql = "SELECT * from customer where tel=?";
		// 4. sql 전송객체 (PreparedStatement)
		PreparedStatement searchtel = con.prepareStatement(sql);
		searchtel.setString(1, tel);
		// 5. sql 전송
		ResultSet rs=searchtel.executeQuery();
		rs.next();
		dao.setCustTel1(rs.getString("TEL"));
		dao.setCustAddr(rs.getString("ADR"));
		dao.setCustTel2(rs.getString("TEL2"));
		dao.setCustName(rs.getString("NAME"));
		dao.setCustEmail(rs.getString("EMAIL"));
		//닫기
		rs.close();
		searchtel.close();
		con.close();
		
		return dao;

	}
	public ArrayList<String> searchSameName(String searchname) throws Exception{
		//동명이인 찾아서 전화번호 넘기기
		// 2. Connection 연결객체 얻어오기
		con = DriverManager.getConnection(url, user, pass);
		// 3. sql 문장 만들기
		String sql="Select tel from customer where name=?";
		// 4. sql 전송객체 (PreparedStatement)(ssn=Search Same name)
			PreparedStatement ssn = con.prepareStatement(sql);
			ssn.setString(1,searchname);
		//5.전송
		ResultSet rs=ssn.executeQuery();
		ArrayList<String> list =new ArrayList<String>();
		while(rs.next()) {
			list.add(rs.getString("TEL"));
		}
		
		System.out.println(list.get(0));
		//닫기
		rs.close();
		ssn.close();
		con.close();
			
		return list;
	}

	public void updateCustomer(Customer vo) throws Exception {
		con = DriverManager.getConnection(url, user, pass);
		// 3. sql 문장 만들기
		String sql = "UPDATE customer set name=?,tel2=?,adr=?,email=? where tel=?";
		// 4. sql 전송객체 (PreparedStatement)
		PreparedStatement update = con.prepareStatement(sql);
		update.setString(5, vo.getCustTel1());
		update.setString(1, vo.getCustName());
		update.setString(2, vo.getCustTel2());
		update.setString(3, vo.getCustAddr());
		update.setString(4, vo.getCustEmail());
		// 5. sql 전송
		update.executeUpdate();
		// 6. 닫기
		update.close();
		con.close();
		

		
	}
}
