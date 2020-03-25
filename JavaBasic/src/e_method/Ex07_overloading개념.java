package e_method;
/*
  오버로딩( overloading )
  		- 인자의 자료형과 갯수가 다른 동일한 함수들(함수명 동일)
  		ex) println() ,println(boolean x),println(int x) ... 등
       ;오버로딩 개념 없으면 데이터 형 마다 다른 print이름을 줘야했음
       -return형만 다른 함수는 오버로딩이 아닙니다.
 */
public class Ex07_overloading개념 {

	public static void main(String[] args) {
		//각각의 자료형 변수의 값에 "화이팅!!" 더하여 출력
		String str = new String("홍길동");
		StringBuffer sb = new StringBuffer("홍길자");
		char [] ch =new char[] {'홍','길','이'};
		
		fighting(str);
		fighting(sb);
		fighting(ch);
	}

	static void fighting(String s) {
		System.out.println(s+"화이팅!!!");
	}
	static void fighting(StringBuffer s) {
		System.out.println(s.append("화이팅!!!"));
	}
	static void fighting(char[] s) {
		for(int i=0;i<s.length;i++) {
			System.out.print(s[i]);
			
		}
		System.out.println("화이팅!!!!");
	}
}
