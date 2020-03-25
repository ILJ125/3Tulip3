package e_method;

public class Ex01_흐름 {

	public static void main(String[] args) {
		//jvm 즉 virtual 머신이 main이라는 이름을 갖고 찾아줘요.
		//내가 만든 함수는 virtual머신이 모른다.
		//그래서 내가 불러줘야한다.
		System.out.println("main 시작");
		
		method();
		
		System.out.println("main 끝");

	}
	
	static void method () {
		System.out.println("method 실행");
	}

}
/*명명규칙
 * 1. 문자 + 숫자 + _ + $ 조합
 * 2. 길이 제한 없음
 * 3. 첫글자에 숫자만 아니면 됨
 * 4. 대소문자 구별
 * 5. 예약어(keyword)는 안됨
 * 
 * 권장사항
 *  -클래스명의 첫글자는ㄴ 대문자시작
 *  -변수와 메소드명은 소문자로 시작
 *  -라벨명은 전부 대문자
 *  -패키지명은 전부 소문자
 */
//void : 아무 것도 없다.
//java main 함수가 static이기 때문에 static 아니면 못 쓴다.
//흐름이 어떻게 흐르는지 봐줘야 한다.