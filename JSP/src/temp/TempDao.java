package temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//jdbc 연결 
public class TempDao  {
	String url = "jdbc:oracle:thin:@192.168.0.62:1521:orcl";
	String user = "scott";
	String pass = "tiger";
	//싱글톤 패턴
	static TempDao dao;
	public static TempDao getInstance() throws Exception{
		if( dao == null) {
		dao = new TempDao();
		}
		return dao;
	}
	
	private TempDao() throws Exception {
		// 1.드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
	}
	/*
	 * 메소드명 : login
	 * 매개변수 : tempVO
	 * 리턴형 : boolean
	 * 역활 : 아이디와 패스워드를 받아서 해당 테이블에 존재하는지 확인 후 boolean형으로 리턴 합니다.
	 */
	public boolean login(tempVO vo) throws Exception {
		boolean success=false;
		//2.연결객체 얻어오기
				Connection con = DriverManager.getConnection(url, user, pass);
				//3.sql문장(select 문)
				String sql = "select id,pass from temp where id=? and pass=?";
				//4.전송객체 얻어오기(PreparedStatement) + ? 지정
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, vo.getId());
				st.setString(2, vo.getPass());
				//5.전송 (excuteUpdate() 이용)
				ResultSet rs=st.executeQuery();
				if(rs.next()) {
					success=true;
				}
				//6.닫기 
				rs.close();
				st.close();
				con.close();
				return success;
	}
	public void insert(tempVO vo) throws Exception {
		//2.연결객체 얻어오기
		Connection con = DriverManager.getConnection(url, user, pass);
		//3.sql문장(insert 문)
		String sql = "insert into temp values(?,?,?,?,?) ";
		//4.전송객체 얻어오기(PreparedStatement) + ? 지정
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, vo.getId());
		st.setString(2, vo.getPass());
		st.setString(3, vo.getName());
		st.setString(4, vo.getTel());
		st.setString(5, vo.getAddr());
		//5.전송 (excuteUpdate() 이용)
		st.executeUpdate();
		//6.닫기 
		st.close();
		con.close();
	}


}
