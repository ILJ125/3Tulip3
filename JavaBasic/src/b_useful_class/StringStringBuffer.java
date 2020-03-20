package b_useful_class;

public class StringStringBuffer {

	public static void main(String[] args) {
		// 0.기본형
		int a = 10;
		a +=5;
		System.out.println(a);
		
		//1.String : 참조형
		String s =new String("안녕");//무조건 new를 해줘야함
		//String s = "안녕";//문자열을 기본형인거 처럼 특권을 줌 기본형처럼 입력하면 안되긴함.
		s = s+"하세요.";//연산도 안돼지만 연산 할 수있게 해줬다.
						//s가 s+"안녕하세요"가  되면서 새로운 메모리 주소를 갖는다.
						//아무것도 안가르키고 있는 원래 "안녕" 메모리는 쓰레기가 된다.
						//참조형(new 를 만나는거)과 일반형은 메모리 구분이 다르다.
		//2.StringBuffer
		//StringBUffer는 데이터값에 변화를 줄때 원래 데이터값에 이어서 데이터값에 변화를 준다. 쓰레기를 안만든다.
		StringBuffer sb = new StringBuffer("행복한");
		//StringBuffer sb = "행복한"; //new를 안쓰는 특권은 String 한테만 있다.
		//sb=sb+"목요일"; //에러 있다. 문자열 연산 가능한건 String 만에 특권
		sb.append("목요일");//문자열을 더하는 기본적 방법
		System.out.println(sb);
		
		//String 
	}

}
