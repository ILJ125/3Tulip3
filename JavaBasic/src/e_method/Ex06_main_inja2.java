package e_method;

public class Ex06_main_inja2 {

	public static void main(String[] args) {
		//서버접속
		for(int i=0; i<args.length;i++) {
			System.out.println(args[i]);
		}
		System.out.println("서버접속");

	}
	

}
/*
 * 직접 운영체제에서 자바 실행할 때
 * (1) 자바 컴파일 : 자바 파일(사람이 보는파일)->class(컴퓨터가 보는 파일)
 * 		javac Hello.java (Hello.java-> Hello.class)
 * (2) 자바 실행 (Hello.class)
 * 		java Hello(확장자를 뺀 클래스파일명을 기술한다.)
 * 
 * -문자열을 입력하며 실행(코딩에 서버 정보를 입력하지 않고 접속하기 위해서)
 * 	java Ex06_main인자 서버ip 서버 계정 서버 비밀번호 를 실행하는 순간에 가져와서 접속하기 위해서.
 * -String[] args에 [서버ip][서버 계정][서버 비밀번호]를 저장 해놓고 class 실행할 때 가져오기
 * :Run->Run configulations ->Arguments ->program Arguments에 "127.0.01 kosmo 1234"입력
 * :args[0] = 127.0.01 ,args[1] =kosmo,args[2]=1234 저장 
 * -cmd로 자바 파일 실행 할 때 [서버ip][서버 계정][서버 비밀번호]를 입력하여 실행하는 방법 
 * :컴퓨터가 읽는 자바 파일이 있는 위치로 cmd 위치를 바꿔 준다.
 *  ex)cd C:\Users\Canon\git\ilj125.github.com\JavaBasic\bin
 * :java 패키지명.java파일 명 (확장자 빼고)  [서버ip][서버 계정][서버 비밀번호]
 * :java e_method.Ex06_main_inja2 127.0.0.2 admin 1234  
 */
