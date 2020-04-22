package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.Maindao;

public class MainModel implements Maindao {
	String url = "jdbc:oracle:thin:@192.168.0.66:1521:orcl";
	String user = "fishcafe";
	String pass = "kosmo66";

	Connection con;

	String[] itemname = new String[21];

	public MainModel() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");

	}

	// 시작, 종료 누르면 select 문으로 고객 정보 불러오기
	// (시작시간 is not null 이고 종료시간이 null인것)불러오기
	public ArrayList ConfirmCustomer() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// 좌석 보기에 출력합니다.
	// 위와 동일합니다.단지 가져오는건 다릅니다.
	public ArrayList ConfirmSeat() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	// 주문 버튼을 누르면 매출내역 Table 에 insert 합니다.
	public void addSales() throws Exception {
		// TODO Auto-generated method stub

	}

	public String[] itemname() throws Exception {
		// 2. Connection 연결객체 얻어오기
				con = DriverManager.getConnection(url, user, pass);
				// 3. sql 문장 만들기
				String sql = " SELECT * FROM item ";
				// 4. sql 전송객체 (PreparedStatement)
				Statement st = con.createStatement();
				// 5.전송
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					int i = 0;
					ArrayList temp = new ArrayList();
					temp.add(rs.getString("type"));
					itemname[i+1] = String.valueOf(temp.get(i));

					System.out.println(temp.get(i));
					i++;
				}
				// 6.닫기
				rs.close();
				st.close();
				con.close();

				return itemname;
		}

	}

