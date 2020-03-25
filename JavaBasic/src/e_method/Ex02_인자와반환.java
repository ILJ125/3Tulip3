package e_method;

public class Ex02_인자와반환 {

	public static void main(String[] args) {
		
		int a =10, b=20;
		add(a, b);
		
		
	}
	//void 쓸때는 return이 없다.
	static void add(int a, int b) {
		int sum = a+b;
		//출력
		System.out.println("합:" + sum);
	}
}
//인자와 반환1 & 인자와 반환2의 차이점

//return : 프로그램 흐름 반환
//		단 하나의 변수를 반환할 수 있음