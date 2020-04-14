package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSelect2 {

	public static void main(String[] args) {
		
		try {
			// 1.드라이버 메모리에 로딩
			// new oracle.jdbc.driver.OracleDriver();
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.Connection 얻어오기
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.66:1521:orcl", "scott", "tiger");

			// 3. sql 문장
			//사원 테이블의 총 사원 수
			String sql ="SELECT count(*) count from emp";
			// 4. 전송객체 얻어오기
			Statement st = con.createStatement();

			// 5. 전송
			ResultSet rs =st.executeQuery(sql);
			// 6. 결과 확인하기
			// ResultSet.next 다음 레코드가 있으면 true 없으면 false
			// ResultSet 이 맨 처음 가리키는건 데이터 값이 아니라 속성을 가리키기에 데이터 출력을 위해선 맨 처음 다음것을 가리키도록 해줘야한다.
			rs.next();
			int result = rs.getInt("COUNT");
			System.out.println("사원 수 :"+result);
			/*
			while (rs.next()) {
				System.out.print(rs.getInt("EMPNO") + "\t");//EMPNO값을 얻어오는데 int형으로 자료형 맞추기
				System.out.print(rs.getString("ENAME")+ "\t");
				System.out.print(rs.getInt("SAL")+ "\t");
				System.out.println(rs.getString("JOB"));
			}
			*/
			
			// 7. 닫기
			rs.close();
			st.close();
			con.close();

			System.out.println("성공");
		} catch (Exception e) {
			System.out.println("실패");
		} // 문자열이 들어왔을 때 그 문자열이 있는 경로를 불러와서 적용해줌

	}

}
