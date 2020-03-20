package b_operator;

/**
 * 	not : 결과를 반대로 하는 연산자
 * 			- 일반논리 not :  !
 * 			- 이진논리 not : ~
 */
public class Ex02_Not {

	public static void main(String[] args) {
		
		boolean result = 3>4;
		System.out.println(!result);
	
		int a = 15;
		System.out.println(~a);
		//a15  00000000 00000000 00000000 00001111
		//~a   11111111 11111111 11111111 11110000
		//결론 음수로가 나온다. 맨 앞에 부호가 1 이므로 음수 이다.
	}

}
