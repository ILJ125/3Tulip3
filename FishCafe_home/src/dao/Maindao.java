package dao;

import java.util.ArrayList;

public interface Maindao {
	
	// 시작, 종료 누르면 select 문으로 고객 정보 불러오기 
	// (시작시간 is not null 이고 종료시간이 null인것)불러오기
	public ArrayList ConfirmCustomer() throws Exception;
	//좌석 보기에 출력합니다. 
	//위와 동일합니다.단지 가져오는건 다릅니다.
	public ArrayList ConfirmSeat() throws Exception;
	//주문 버튼을 누르면 매출내역 Table 에  insert 합니다.
	public void addSales() throws Exception;
}
