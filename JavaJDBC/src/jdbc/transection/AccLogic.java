package jdbc.transection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class AccLogic 
{
	// 연결 객체 생성시 필요한 변수 선언
	String url;
	String user;
	String pass;

	//===============================================
	// 드라이버를 드라이버매니저에 등록
	public AccLogic() throws Exception{
		/////////////////////////////////////////////////////////
		// 1. 드라이버를 드라이버 매니저에 등록
		Class.forName("oracle.jdbc.driver.OracleDriver");
		url = "jdbc:oracle:thin:@192.168.0.66:1521:orcl";
		user = "nanana";
		pass = "kosmo66";
	}


	//====================================================
	// 보내는 계좌번호와 받는 계좌번호와 계좌금액을 넘겨받아 
	//	보내는계좌에서 계좌금액을 빼고 받는계좌에서 계좌금액을 더한다
	public int moveAccount(String sendAcc, String recvAcc, int money)
	{
		Connection con = null;

		///////////////////////////////////////////////////////////
		//	 1. Connection 객체 생성
		//@@ 2. Auto-commit을 해제
		//	 3. 출금계좌에서 이체금액을 뺀다
		//	 4. 입금계좌에 이체금액을 더한다
		//@@ 5. commit을 전송한다
		//	 6. 객체 닫기
		//	 - 만일 정상적인 경우는 0을 리턴하고 도중에 잘못되었으면 트랜잭션을 롤백시키고 -1을 리턴
		
		//1)드라이브 연결
		try {
			con=DriverManager.getConnection(url, user, pass);
			con.setAutoCommit(false);//자동 커밋 막기
			//2)sql문 만들기
			//보내는 계좌에서 금액 빼기
			String sendSql="UPDATE account SET amount=(amount-?)   WHERE account_num=?";
			//3)전송 객체
			PreparedStatement sendPs =con.prepareStatement(sendSql);
			sendPs.setInt(1,money);
			sendPs.setString(2,sendAcc);
				//? 지정하기
			//4)전송 
			//밑에 받는 사람계좌에 이체가 성공해야지 데이터에 commit 하도록  자동 커밋 꺼주고 
			int rs1=sendPs.executeUpdate();
			//0개의 행 수행 시  롤백
			if(rs1 == 0) {
				con.rollback();
				return -1;
			}
			sendPs.close();
			
			//두번 째 sql
			//받는 계좌에서 금액 더하기
			String resvSql = "UPDATE account SET amount=(amount+?) WHERE account_num=?";
			PreparedStatement resvPs =con.prepareStatement(resvSql);
			resvPs.setInt(1,money);
			resvPs.setString(2,recvAcc);
			
			int rs2=resvPs.executeUpdate();
			if(rs2==0) {
				//0행 실행되면  sql실행 실패 한거니 최근의 comit한 상태로 돌아 갈 수 있도록 rolback 해준다.
				con.rollback();
				//rollback해주고 자바에게도 실패했다고 알려줘야한다.
				return -1;
			}
			resvPs.close();

			//마지막에  커밋이 되도록 (중간에 성공하지 못해도 커밋 안된도록)
			con.commit();
		} catch (SQLException e) {
			try {
				//예외가 발견되면 다시 최근의 커밋한 상태로 돌려놓기 위해서 롤백
				con.rollback();
			} catch (SQLException e1) {}
			return -1;
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				
			}
		}
		
		
		
		return 0;
	}

	//=======================================================
	//	보내는계좌번호와 받는계좌번호를 넘겨받아
	//		보내는계좌고객명과 보내는계좌의남은 금액을 얻어오고
	//		받는계좌고객명을 얻어와서
	//		얻은 정보를 ConfirmData객체에 넣고 리턴
	public ConfirmData confirmAccount(String sendAcc, String recvAcc) 
		throws Exception{

		
		String sendCust="", recvCust="";
		int gainMoney=0;
		ConfirmData  resultData=null;
		
		//	1. Connection 객체 생성
		//	2. 테이블에서, 넘겨받은 sendAcc와 같은 account_num필드에서 customer, amount를 얻어온다
		//	3. 테이블에서, 넘겨받은 recvAcc와 같은 account_num필드에서 customer를 얻어온다
		//  4. 2와 3에서 얻은 값을 ConfirmData 객체에 저장
		//	5. 4번의 객체를 리턴



		return resultData;
	}

}


//#################################################################
//	테이블명 : account//nanana계정
//	account_num		계좌번호		varchar2(20)
//	customer		고객명			varchar2(20)
//	amount			계좌금액		int
