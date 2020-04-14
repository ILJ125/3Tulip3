package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestSelect3 {

	public static void main(String[] args) {
		//hr계정에서 사원 번호 ,사원 전체 이름,부서명 출력 하기 조건 급여가 3000이상인 사원
		try {
			// 1.드라이버 메모리에 로딩
			// new oracle.jdbc.driver.OracleDriver();
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.Connection 얻어오기
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.66:1521:orcl", "hr", "hr");

			// 3. sql 문장
			
			//String sql ="SELECT id,name,deptname from v_emp_select3";
			String sql=" select e.employee_id id,e.first_name || e.last_name name, d.department_name deptname "+
			" from employees e, departments d " +
			" where e.department_id=d.department_id and e.salary>=3000 ";
			// 4. 전송객체 얻어오기
			Statement st = con.createStatement();

			// 5. 전송
			ResultSet rs =st.executeQuery(sql);
			// 6. 결과 확인하기
			// ResultSet.next 다음 레코드가 있으면 true 없으면 false
			// ResultSet 이 맨 처음 가리키는건 데이터 값이 아니라 속성을 가리키기에 데이터 출력을 위해선 맨 처음 다음것을 가리키도록 해줘야한다.
			int i=0;
			while (rs.next()) {
				System.out.print(rs.getInt("ID") + "\t");//EMPNO값을 얻어오는데 int형으로 자료형 맞추기
				System.out.print(rs.getString("NAME")+ "\t");
				System.out.println(rs.getString("DEPTNAME")+ "\t");
				i++;
			}
			System.out.println("총 갯수 :"+i);
			
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
