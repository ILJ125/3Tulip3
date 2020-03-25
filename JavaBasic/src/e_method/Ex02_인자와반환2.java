package e_method;

public class Ex02_인자와반환2 {

	public static void main(String[] args) {
		//데이터 입력
		int sum =add();
		//출력
		System.out.println("출력" + sum);
	}

	//int형 결과 갑을 출력하는 하수 를만들겠습니다.
	static int add() {

		//데이타 입력 (main에서 데이터를 받아오는게 아니라 함수내에 데이터가 존재해서 인자를 안씀)
		int a =10; int b=20;
		//계산

		int sum=a+b;
		return sum; //return 되는 순간 메모리 다 날아감


	}



}
