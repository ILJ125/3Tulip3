package k_interface;

import java.util.*;


public class Main {


	public static void main(String[] args) {

		//변수 선언
		Scanner input=new Scanner(System.in);

		//데이터 입력 받고 토큰으로 자르기
		System.out.println("Cheese,Pineapple,Meatball,Bulgogi,Potato중 먹고 싶은 메뉴를 선택하세요. (ex chees,bulgogi)");
		String order=input.nextLine();
		StringTokenizer st = new StringTokenizer(order,",");
		String []orderList=new String[st.countTokens()];
		//토큰자른거 order 배열에 입력
		for(int i=0;st.hasMoreTokens();i++) {
			orderList[i]=st.nextToken();
		}
		int total=solution(orderList);
		System.out.println("총가격 : "+total);
	}

	static public int solution(String []orderList){
		PizzaStore ps =new PizzaStore();

		ps.setOrderList(orderList);

		int total=0;
		total =ps.getTotalPrice();
		return total;
	}


}
