package c_array;

import java.util.Scanner;

public class Main {

	/**
	 * 			배열을 이용해서 3명의 국영수 점수를 입력받아 총점과 평균을 구한다
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		//이건 Student 형태의 s[]배열을 객체 생성해준거다.
		Student [] s = new Student[3];		// 학생 수 3은 배열의 갯수를 의미한다.

		//		
		//		String name=in.next();
		//		s[0].setName(name);

		//Student 클래스 객체를 s[i]배열 안에  생성
		for(int i=0;i<s.length; i++) {
			s[i]=new Student();
		}
		//각 학생의 이름과 국영수 점수를 입력받아 이름과 총점, 평균 출력
		for(int i=0; i<s.length;i++)
		{	
			System.out.println("이름");
			s[i].setName(in.next());
			System.out.println("국어점수");
			s[i].setKor(in.nextInt());
			System.out.println("영어 점수");
			s[i].setEng(in.nextInt());
			System.out.println("수학점수");
			s[i].setMath(in.nextInt());
		}
		//출력
		for(int i=0;i<s.length;i++) {
			System.out.println((i+1)+"번째 학생 이름: "+s[i].getName()+"/총점 : "+s[i].calTotal()+"/평균 :"+s[i].calAverage());
		}
	}

}
