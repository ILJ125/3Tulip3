package model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.VideoDao;
import model.vo.Video;

public class VideoModel implements VideoDao {
	String url = "jdbc:oracle:thin:@192.168.0.66:1521:orcl";
	String user = "nanana";
	String pass = "kosmo66";
	Connection con = null;

	public VideoModel() throws Exception {
		// 1. 드라이버로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}

	public void insertVideo(Video vo, int count) throws Exception {
		try {
			// 2. Connection 연결객체 얻어오기
			con = DriverManager.getConnection(url, user, pass);
			con.setAutoCommit(false);// 자동 커밋 막기
			// 3. sql 문장 만들기
			String sql1 = "Insert into movie VALUES (SEQUENCE_movie_movieid.nextval," + "?,?,?,?,?)";
			// 4. sql 전송객체 (PreparedStatement)
			PreparedStatement insert1 = con.prepareStatement(sql1);
			insert1.setString(1, vo.getGenre());
			insert1.setString(2, vo.getVideoName());
			insert1.setString(3, vo.getDirector());
			insert1.setString(4, vo.getActor());
			insert1.setString(5, vo.getExp());
			// 5. sql 전송
			insert1.executeUpdate();
			// 6. 닫기
			insert1.close();

			// 두번째 sql

			for (int i = 0; i < count; i++) {
				String sql2 = "INSERT INTO video VALUES( "
						+ "sequence_video_videoid.nextval, SEQUENCE_movie_movieid.currval )";
				PreparedStatement insert2 = con.prepareStatement(sql2);
				insert2.executeUpdate();
				insert2.close();
			}
			con.commit();
		} catch (SQLException e) {
			System.out.println("이겨야?");
			con.rollback();
		} finally {
			con.close();
		}
	}

	public ArrayList selectVideo(int index, String word) throws Exception {

		ArrayList list = new ArrayList();
		String[] colname = { "title", "actor" };
		// 2. Connection 연결객체 얻어오기

		con = DriverManager.getConnection(url, user, pass);

		// 3.sql
		String sql = "Select MOVIEID,TITLE,GENRE,ACTOR " + " from movie " + " where " + colname[index] + " like '%" + word
				+ "%' ";
		// 4.전송객체
		Statement st = con.createStatement();
		// 5.전송
		ResultSet result = st.executeQuery(sql);
		while (result.next()) {
			//자 봐봐 행과 열로 이루어져있지. 그럼 이중배열이니깐 ArrayList를 두 개 써야해
			ArrayList temp = new ArrayList();
			temp.add(result.getString("MOVIEID"));
			temp.add(result.getString("TITLE"));
			temp.add(result.getString("GENRE"));
			temp.add(result.getString("ACTOR"));
			list.add(temp);
		}
		return list;

	}
	public Video selectByPK(String vnum) throws Exception {
		Video vo =new Video();
		// 2. Connection 연결객체 얻어오기
		con = DriverManager.getConnection(url, user, pass);
		// 3.sql
		String sql = "SELECT * FROM movie where movieid=?";		
		//해당 비디오번호의 비디오정보를 검색하여 video 클래스에 각각 멤버변수로 지정
		//4.전송객체
		PreparedStatement select_pk = con.prepareStatement(sql);
		select_pk.setInt(1, Integer.parseInt(vnum));
		//5.전송
		ResultSet result_pk = select_pk.executeQuery();
		
		result_pk.next();
		vo.setVideoNo(result_pk.getInt("MOVIEID"));
		vo.setGenre(result_pk.getString("GENRE"));
		vo.setVideoName(result_pk.getString("TITLE"));
		vo.setDirector(result_pk.getString("DIRECTOR"));
		vo.setActor(result_pk.getString("ACTOR"));
		vo.setExp(result_pk.getString("VDETAIL"));

		return vo;
	}
}
