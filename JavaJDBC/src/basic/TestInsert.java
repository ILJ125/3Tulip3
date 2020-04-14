package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.드라이버 메모리에 로딩
		//new oracle.jdbc.driver.OracleDriver();
		Connection con =null ;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.Connection 얻어오기
			
			con =DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.66:1521:orcl","scott","tiger");
			
			//3. sql 문장
			String sql = "INSERT INTO emp(empno,ename,sal) VALUES(9001,'맹순이',4000)";
			
			//4. 전송객체 얻어오기
			Statement st = con.createStatement();
			
			//5. 전송
			st.executeUpdate(sql);
			//6. 결과 받기
			st.close();
			
		
			System.out.println("성공");
		} catch (Exception e) {
			System.out.println("실패");
		} // 문자열이 들어왔을 때 그 문자열이 있는 경로를 불러와서 적용해줌
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
