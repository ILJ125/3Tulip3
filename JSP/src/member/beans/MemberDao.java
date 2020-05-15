package member.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {

	
	// DB 연결시  관한 변수 

	private static final String 	dbDriver	=	"oracle.jdbc.driver.OracleDriver";
	private static final String		dbUrl		=	"jdbc:oracle:thin:@192.168.0.62:1521:orcl";
	private static final String		dbUser		=	"scott";
	private static final String		dbPass		=	"tiger";

		
	private static MemberDao memberDao;
	
	public static MemberDao getInstance() throws MemberException
	{
		if( memberDao == null )
		{
			memberDao =  new MemberDao();
		}
		return memberDao;
	}
	

	private MemberDao() throws MemberException
	{
			
		try{
			
			/********************************************
				1. 드라이버를 로딩
			*/				
			Class.forName("oracle.jdbc.driver.OracleDriver");

		
		}catch( Exception ex ){
			throw new MemberException("DB 연결시 오류  : " + ex.toString() );	
		}
	}
	
	/*******************************************
	 * * 회원관리테이블 MEMBERTEST 에  회원정보를 입력하는 함수
	 * @param rec
	 * @throws MemberException
	 */
	Connection con;
	public void insertMember( Member rec ) throws MemberException
	{
		try {
			con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			//3.sql문장(insert 문)
			String sql = "insert into temp values(?,?,?,?,?) ";
			//4.전송객체 얻어오기(PreparedStatement) + ? 지정
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, rec.getId());
			st.setString(2, rec.getPassword());
			st.setString(3, rec.getName());
			st.setString(4, rec.getTel());
			st.setString(5, rec.getAddr());
			//5.전송 (excuteUpdate() 이용)
			st.executeUpdate();
			//6.닫기 
			st.close();
			con.close();
			
			 
		} catch ( Exception ex ){
			throw new MemberException("멤버 입력시 오류  : " + ex.toString() );			
		}		
		finally {
			
		}
	}
	
	/**********************************************************
	 * * 회원관리테이블 MEMBERTEST에서 기존의 id값과 중복되는지 확인하는 함수
	 */
	public boolean isDuplicatedId( String id ) throws MemberException
	{
		boolean flag = false;
		
		try{
			con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
			//3.sql문장(select 문)
			String sql = "select id,pass from temp where id=? ";
			//4.전송객체 얻어오기(PreparedStatement) + ? 지정
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, id);
			//5.전송 (excuteUpdate() 이용)
			ResultSet rs=st.executeQuery();
			if(rs.next()) {
				flag=true;
			}
			//6.닫기 
			rs.close();
			st.close();
			con.close();

			
		}catch( Exception ex ){
			throw new MemberException("중복아이디 검사시 오류  : " + ex.toString() );			
		}
			
		return flag;
	}
}
