package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestInsert2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.드라이버 메모리에 로딩
		//new oracle.jdbc.driver.OracleDriver();
		Connection con =null ;
		
		//화면에서 입력값을 받아서 저장한 변수 상상하기 
		int empno= 9005;
		String ename="김준이";
		int sal =5000;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.Connection 얻어오기
			
			con =DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.66:1521:orcl","scott","tiger");
			
			//3. sql 문장
			//String sql = " INSERT INTO emp(empno,ename,sal) "
			//		+ " VALUES("+empno+",'"+ename +"',"+sal+")";
			String sql = " INSERT INTO emp(empno,ename,sal) "
							+ " VALUES(?,?,?)";//?가 하나라도 있으면 바로 PreparedStatement를 사용해야한다.
			//4. 전송객체 얻어오기
			//Statement st = con.createStatement();
			PreparedStatement st = con.prepareStatement(sql); // prepare 와 그냥 Statement의 차이점은  sql을 먼저 집어 넣는가, 안넣어는가의 차이점
			st.setInt(1,empno);
			st.setString(2,ename);
			st.setInt(3,sal);
			
			//PreparedStatement 사용시 더 간편하게 sql문장을 입력할 수있다. 
			//물음표로 먼저 sql문장 만들고
			//전송객체 만들고 거기에 sql 넣고
			//물읍표에 집어넣을 값 입력
			//5단계 전송 시에 st.executeUpdate()안에 sql을 넣어주면 안된다. 왜냐하면 전송객체 얻어오기에서 sql을 입력했기 때문
			//5. 전송
			st.executeUpdate();
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
			}
		}
	}

}
