package e_method;

public class Ex03_변수의범위 {

	static int a,b;//선언을 main밖에서하면 다 쓸 수있다.
				   //main밖에서 변수 선언할 때 static을 앞에 붙여줘야한다.
				   //멤버 변수
				   //메모리 영역중 heap에 잡는다.
	static int sum;
	public static void main(String[] args) {
		//데이터는 main에 합산은 함수에서 출력은 main
		
		int a =10; 
		// heap메모리의 a가 아닌 stack에 a메모리가 저장된다.
		// 지역변수가 멤버변수 보다 우선순위가 높아서 a값 출력 경우 지역변수의 a 값이 출력된다.
		 b=20;
		int result = add();
		//출력
		System.out.println("합:" + result );
		
	}

	static int add() {
		 sum = a+b;//여기서 쓰는 a는 멤버변수로 선언한거라서 초기화된 0이된다.
		 return sum;
		
	}
}
	