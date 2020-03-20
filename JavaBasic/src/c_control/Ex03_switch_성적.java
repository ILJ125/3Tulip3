package c_control;

import java.util.Scanner;

public class Ex03_switch_성적 {

	public static void main(String[] args) {
		// 국,영,수 점수 입력받아서 총점, 평균 출력
		//1.평균에 따라 학점(A~F)출력
		//***switch문 이용
		Scanner input=new Scanner(System.in);
		
		System.out.println("국어");
		int kor=input.nextInt();
		System.out.println("수학");
		int math=input.nextInt();
		System.out.println("영어");
		int eng=input.nextInt();
		
		int sum=kor+math+eng;
		double avg=(double)sum/3;
		int avg2=(int)avg/10;
		char result= 0;
		
		switch(avg2) {
		case 10 :;
		case 9:result='A';break;
		case 8:result='B';break;
		case 7:result='C';break;
		case 6:result='D';break;
		case 5:result='E';break;
		default:result='F';
		}
		
		
//		String s_avg = Double.toString(avg);
//		char c_avg=s_avg.charAt(0);
//		
//		switch(c_avg) {
//		case '9':result='A';break;
//		case '8':result='B';break;
//		case '7':result='C';break;
//		case '6':result='D';break;
//		case '5':result='E';break;
//		default:result='F';
//		}
		System.out.println("총점 : "+sum+"\n평균 : "+avg+"\n학점 : "+result);
	
		
	}
}
