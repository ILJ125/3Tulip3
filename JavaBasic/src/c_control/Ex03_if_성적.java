package c_control;

import java.util.Scanner;

public class Ex03_if_성적 {

	public static void main(String[] args) {
		// 국,영,수 점수 입력받아서 총점, 평균 출력
		//1.평균에 따라 학점(A~F)출력
		//***if문 이용
		Scanner input=new Scanner(System.in);
		
		System.out.println("국어");
		int kor=input.nextInt();
		System.out.println("수학");
		int math=input.nextInt();
		System.out.println("영어");
		int eng=input.nextInt();
		
		int sum=kor+math+eng;
		double avg=(double)(sum/3);
		char result= 0;
	
		if(avg>=90) {
			result='A';
		}else if(avg>=80) {
			result='B';
		}else if(avg>=70) {
			result='C';
		}else if(avg>=60) {
			result='D';
		}else if(avg>=50) {
			result='E';
		}
		else {
			result='F';
		}
		System.out.println("총점 : "+sum+"\n평균 : "+avg+"\n학점 : "+result);
	}

}
