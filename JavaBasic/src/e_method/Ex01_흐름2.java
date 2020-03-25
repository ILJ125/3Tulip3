package e_method;

public class Ex01_흐름2 {
	//static 안쓰는 방법

	public static void main(String[] args) {
		
		System.out.println("main 시작");
		//내가 만든 클래스를 메모리로 올림
		//메모리에서  클래스를 호출 할 수있음
		Ex01_흐름2 ex = new Ex01_흐름2();
		method();
		
		System.out.println("main 끝");

	}
	
	static void method () {
		System.out.println("method 실행");
	}

}
