package jdbc.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//DB연결 여기서 
public class InfoModelImpl implements InfoModel {

	String url = "jdbc:oracle:thin:@192.168.0.66:1521:orcl";
	String user = "scott";
	String pass = "tiger";

	Connection con = null;

	public InfoModelImpl() throws Exception {
		// 1.드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}

	// 난 예외 발견하면 넘길거야
	// try & finally만 사용해서 catch없이 connection이 무조건 닫히도록 finally에 입력해줍니다.
	public void insert(InfoVO vo) throws SQLException {
		try {
			// 2.연결객체 얻어오기
			con = DriverManager.getConnection(url, user, pass);
			// 3. sql 문장
			String sql = "INSERT INTO INFO_TAB (name,jumin,tel,gender,age,home)" + "VALUES (?,?," + "?," + "? ,?,?)";
			// 4.전송객체 얻어오익
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, vo.getName());
			st.setString(2, vo.getJumin());
			st.setString(3, vo.getTel());
			st.setString(4, vo.getGender());
			st.setInt(5, vo.getAge());
			st.setString(6, vo.getHome());
			// 5.전송
			st.executeUpdate();
			// 6.닫기
			st.close();
		} finally {
			con.close();
		}
	}

	public ArrayList<InfoVO> selectAll() throws SQLException {
		// 1.드라이버 로딩
		try {
			// 2.connection 얻어오기
			con = DriverManager.getConnection(url, user, pass);
			// 3. sql 문장
			String sql = "Select * from info_tab ";

			// 4.전송객체 얻어오익
			PreparedStatement st = con.prepareStatement(sql);

			// 5.전송
			ResultSet rs = st.executeQuery();
			// while문을 벗어나면 vo에 저장한 데이터가 다 날라가 가기 때문에
			// while문이 몇번 돌지 모르게 때문에 ArrayList를 만들어준다.
			ArrayList<InfoVO> list = new ArrayList<InfoVO>();
			while (rs.next()) {
				InfoVO vo = new InfoVO();
				vo.setName(rs.getString("NAME"));
				vo.setTel(rs.getString("TEL"));
				vo.setJumin(rs.getString("JUMIN"));
				vo.setGender(rs.getString("GENDER"));
				vo.setAge(rs.getInt("AGE"));
				vo.setHome(rs.getString("HOME"));
				list.add(vo);
			}
			// 6. 닫기
			rs.close();
			st.close();
			return list;

			// 7.반환
		} finally {
			con.close();
		}

	}

	public void delete(String tel) throws SQLException {
		try {
			// 2.connection 얻어오기
			con = DriverManager.getConnection(url, user, pass);
			// 3. sql 문장
			String sql = "Delete from info_tab where tel=?";

			// 4.전송객체 얻어오익
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, tel);
			// 5.전송
			st.executeUpdate();
			// 6.닫기
			st.close();
		} finally {
			con.close();
		}

	}

	public InfoVO selectByTel(String tel) throws SQLException {
		try {
			InfoVO vo = new InfoVO();
			// 2.connection 얻어오기
			con = DriverManager.getConnection(url, user, pass);
			// 3. sql 문장
			String sql = "Select * from info_tab where tel=? ";
			// 4.전송객체 얻어오익
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, tel);
			// 5.전송
			ResultSet rs = st.executeQuery();

			if (rs.next()) {

				vo.setName(rs.getString("NAME"));
				vo.setJumin(rs.getString("JUMIN"));
				vo.setGender(rs.getString("GENDER"));
				vo.setAge(rs.getInt("AGE"));
				vo.setHome(rs.getString("HOME"));
			}
			// 6. 닫기
			rs.close();
			st.close();

			return vo;

		} finally {
			con.close();
		}
	}

	public void modify(InfoVO vo) throws SQLException {
		try {
			// 2.연결객체 얻어오기
			con = DriverManager.getConnection(url, user, pass);
			// 3. sql 문장
			String sql = "UPDATE INFO_TAB SET  name = ?,jumin=?,gender=?,age=?,home=? where tel=?";
			// 4.전송객체 얻어오익
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, vo.getName());
			st.setString(2, vo.getJumin());
			st.setString(6, vo.getTel());
			st.setString(3, vo.getGender());
			st.setInt(4, vo.getAge());
			st.setString(5, vo.getHome());
			// 5.전송
			st.executeUpdate();
			// 6.닫기
			st.close();
		} finally {
			con.close();
		}
	}

}
