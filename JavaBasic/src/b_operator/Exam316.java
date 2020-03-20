package b_operator;

import java.util.Scanner;

public class Exam316 {

	public static void main(String[] args) {
		//100점 만점의 학생 점수를 입력받아 80~90 사이라면 '평균'이라고 출력
		
		int score=0;//점수는 정수형으로 선언
		
		System.out.println("점수를 입력해주세요");
		Scanner input = new Scanner(System.in);
		score=input.nextInt();//점수 입력받기
		
		if(score>80 &&score<90) {
			System.out.println("평균");
		}else {
			System.out.println("no 평균");
		}//만약 점수가 80~90사이면 평균이라고 출력 아니면 no 평균이라고 출력
		
	
	}

}
