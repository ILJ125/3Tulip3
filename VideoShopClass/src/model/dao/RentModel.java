package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.RentDao;

public class RentModel implements RentDao {
	String url = "jdbc:oracle:thin:@192.168.0.66:1521:orcl";
	String user = "nanana";
	String pass = "kosmo66";

	Connection con;

	public RentModel() throws Exception {
		// 1. 드라이버로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

	}

	public String selectByTel(String tel) throws Exception {
		// 2. Connection 연결객체 얻어오기
		con = DriverManager.getConnection(url, user, pass);
		// 3. sql 문장 만들기
		String sql = "Select  name from customer where tel=? ";
		// 4. sql 전송객체 (PreparedStatement)
		PreparedStatement insert = con.prepareStatement(sql);
		insert.setString(1, tel);
		// 5. sql 전송
		ResultSet rs = insert.executeQuery();
		rs.next();
		String name = rs.getString("name");

		// 닫기
		rs.close();
		insert.close();
		con.close();

		return name;
	}

	/**
	 * 도움말 만드는 주석 함수명 : rentVideo 인자 : 전화번호 (String), 비디오번호(String) 리턴값 : void 역할 :
	 * 대여테이블에 정보를 입력합니다.
	 */
	public void rentVideo(String tel, String vnum) throws Exception {
		if (confirm(vnum) == 1) {
			JOptionPane.showMessageDialog(null, "대여중인 비디오 번호 입니다.");
			return;

		}
		// 2. Connection 연결객체 얻어오기
		con = DriverManager.getConnection(url, user, pass);
		// 3. sql 문장 만들기
		// tel 와 video id
		// 만약 rentdate 가 null 이면 검색 안함
		String sql = "Insert Into borrow(no,tel,videoid,bordate) " + " Values (SEQUENCE_borrow_no.nextval,?,?,sysdate)";
		// 4. sql 전송객체 (PreparedStatement)
		PreparedStatement rent = con.prepareStatement(sql);
		rent.setString(1, tel);
		rent.setString(2, vnum);
		// 5. sql 전송
		rent.executeUpdate();
		// 6. 닫기

		rent.close();
		con.close();

	}

	public int confirm(String vnum) throws Exception {
		// 2. Connection 연결객체 얻어오기
		int res = 0;
		con = DriverManager.getConnection(url, user, pass);
		// 3. sql 문장 만들기
		// tel 와 video id
		// 만약 rentdate 가 null 이면 검색 안함
		String confirm_sql = "Select videoid from borrow where redate is null ";
		Statement confirm = con.createStatement();
		ResultSet videoid = confirm.executeQuery(confirm_sql);
		ArrayList list = new ArrayList();
		while (videoid.next()) {
			list.add(videoid.getString("videoid"));
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
			if (vnum .equals(list.get(i))) {
				System.out.println(res);
				res = 1;
				videoid.close();
				confirm.close();
				return res;
			}
		}
		videoid.close();
		confirm.close();
		return res;

	}

	public void returnVideo(String vnum) throws Exception {
		con = DriverManager.getConnection(url, user, pass);
		// 3. sql 문장 만들기
		String sql = "Update borrow set redate = sysdate where videoid = ?";
		// 4. sql 전송객체 (PreparedStatement)
		PreparedStatement returnv = con.prepareStatement(sql);
		returnv.setString(1, vnum);
		// 5. sql 전송
		returnv.executeUpdate();

		// 닫기
		returnv.close();
		con.close();

	}

	public ArrayList selectList() throws Exception {
		ArrayList list = new ArrayList();
		// 2. Connection 연결객체 얻어오기
		con = DriverManager.getConnection(url, user, pass);
		// 3. sql 문장 만들기
		String sql = "Select v.videoid videoid ,m.title title ,c.name name,b.tel tel ,"
				+ " to_char(b.bordate+3,'YYYY-MM-DD') duedate ,'미납' state \r\n"
				+ "from borrow b, customer c, video v , movie m \r\n"
				+ "where v.videoid=b.videoid  and c.tel = b.tel and m.movieid=v.movieid and redate is null";
		// 4. sql 전송객체 (PreparedStatement)
		Statement select = con.createStatement();
		// 5.전송
		ResultSet result = select.executeQuery(sql);
		while (result.next()) {
			ArrayList temp = new ArrayList();
			temp.add(result.getString("videoid"));
			temp.add(result.getString("title"));
			temp.add(result.getString("name"));
			temp.add(result.getString("tel"));
			temp.add(result.getString("duedate"));
			temp.add(result.getString("state"));
			list.add(temp);
		}
		result.close();
		select.close();
		con.close();
		return list;
	}

}
