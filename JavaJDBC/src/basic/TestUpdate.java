package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.드라이버 메모리에 로딩
		//new oracle.jdbc.driver.OracleDriver();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.Connection 얻어오기
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.68:1521:orcl","scott","tiger");
			
			//3. sql 문장
			//9001번 사원의 이름은 홍길 숙으로 바꿔주시고, 급여는 4500으로 변경해주세요
			//String sql = "Update emp set ename='홍길숙',sal=4500 where empno=9001";
			//String sql="DELETE FROM emp_copy";
			//20번 부서의 사원들 급여를 500 인상
			String sql = "Update emp set sal=sal+500 where deptno=20";
			
			
			//4. 전송객체 얻어오기
			Statement st = con.createStatement();
			
			//5. 전송
			int result =st.executeUpdate(sql);
			System.out.println(result + "행을 실행합니다.");
			//-int executeUpdate() : INSERT/UPDATE/DELETE
			//-ResultSet executeQuery() : select //테이블을 resultset에 받아요
			//6. 결과 확인
			
			//7. 닫기
			st.close();
			con.close();
		
			System.out.println("성공");
		} catch (Exception e) {
			System.out.println("실패");
		} // 문자열이 들어왔을 때 그 문자열이 있는 경로를 불러와서 적용해줌
		
	}

}
