package e_method;

import java.util.Scanner;

public class Ex00_복습2 {

	static int jumsu=0;
	
	public static void main(String[] args) {
		String result=func();
		// 여기서 합격 여부를 출력하려면?
		System.out.println(result);
		//성적 출력
		char grade=method();
		System.out.println("성적 ->"+grade);
	}

	/** 
	 * method1
	 *  	- 점수를 입력받아 합격여부 확인하는 메소드
	 */
	static  String func() {
		Scanner in = new Scanner(System.in);		
		jumsu = in.nextInt();
		if( jumsu >= 80) return "합격";
		else return "불합격";
		//블럭이 끝나기 전에 먼저 값을 반환하기 위해서 return을 씀
	}
	
	/**
	 * 점수를 넘겨받아 성적을 구하는 메소드
	 */
	static char method() {
		char grade=0;
		if(jumsu>=90) grade='A';
		else if(jumsu>=80) grade='B';
		else grade='C';
		
		return grade;
		
	
	}

}
