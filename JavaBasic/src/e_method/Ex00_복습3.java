package e_method;

import java.util.*;


public class Ex00_복습3 {
	static int total =0;
	static double avg=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score[]=input();
		calscore(score);
		output();
	}
	//입력받은 궁영수 점수로 총점, 평균을 구하기
	static void calscore(int score[]) {
		
		for (int i=0;i<score.length;i++) {
			total +=score[i];
		}
		avg=(double)total/score.length;
	
	}
	//국영수 점수를 입력받기
	static int[] input() {
		Scanner input = new Scanner(System.in);
		System.out.println("국어");
		int kor=input.nextInt();
		System.out.println("영어");
		int eng=input.nextInt();
		System.out.println("수학");
		int math =input.nextInt();
		
		int [] score= {kor,eng,math};
		return score;
		
	}
	static void output() {
		System.out.println("총점 : "+total);
		System.out.println("평균 : "+avg);
	}

}
