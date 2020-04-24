package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class fishinsert {
	String url = "jdbc:oracle:thin:@192.168.0.66:1521:orcl";
	String user = "fishcafe";
	String pass = "kosmo66";

	Connection con;

	public fishinsert() throws Exception {

		// 1. 드라이버로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}

	public void insertfish() throws Exception {

		con = DriverManager.getConnection(url, user, pass);
		for (int i = 0; i < 30; i++) {
			//메기, 30마리
//			String sql = "Insert Into fish VALUES "
//					+ " (SEQUENCE_fish_no.nextval, '메기', ? , 2000 )";
			//잉어,65마리
//			String sql = "Insert Into fish VALUES (SEQUENCE_fish_no.nextval, '잉어', ? , 1000) ";
			//철갑상어,3마리
//			String sql = "Insert Into fish VALUES (SEQUENCE_fish_no.nextval, '철갑상어', ? , 10000) ";
			//향어,65마리
//			String sql = "Insert Into fish VALUES (SEQUENCE_fish_no.nextval, '향어', ? , 1000) ";
//			비단 잉어,7마리
//			String sql = "Insert Into fish VALUES (SEQUENCE_fish_no.nextval, '비단잉어', ? , 5000) ";
			//참붕어,30마리
			String sql = "Insert Into fish VALUES (SEQUENCE_fish_no.nextval, '참붕어', ? , 3000) ";
					

			PreparedStatement st = con.prepareStatement(sql);
			//메기
//			st.setInt(1,(int) (Math.random() * 850) + 150);// 메기 최소:150 최대:1000
//			st.setInt(1,(int) (Math.random() * 900) + 100);// 잉어 최소:100 최대:1000
//			st.setInt(1,(int) (Math.random() * 4000) + 1000);// 철갑상어 최소:1000 최대:5000
//			st.setInt(1,(int) (Math.random() * 900) + 100);// 향어 최소:100 최대:1000
//			st.setInt(1,(int) (Math.random() * 650) + 150);// 비단잉어 최소:150 최대:800
			st.setInt(1,(int) (Math.random() * 630) + 70);// 참붕어 최소:70 최대:700

			st.executeUpdate();
			st.close();
		}
		con.close();

	}

	public static void main(String[] args) {
		fishinsert fish;
		try {
			fish = new fishinsert();
			fish.insertfish();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
