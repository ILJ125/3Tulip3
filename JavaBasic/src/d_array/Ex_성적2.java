package d_array;

import java.util.Scanner;


public class Ex_성적2 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		Scanner input= new Scanner(System.in);
		System.out.println("학생 수 입력해봐라");
		int su=input.nextInt();//학생 수 입력 받음

		// 점수(score)를 입력 받은 학생 수만큼 선언, 그런데  한 학생당 과목 3개 점수 입력 받음
		int [][] score=new int[su][3];

		/*				//입력
		int sum_1[] =new int[score.length-1];	
		double avg_1[] = new double[score.length-1];//학생 평균	
		for(int i =0; i<score.length;i++) {
			System.out.println((i+1)+"째 학생의 성적을 입력 -> ");
			for(int j=0; j<score[i].length;j++) {
				score[i][j]=input.nextInt();
				sum_1[i] +=score[i][j];
			}
			avg_1[i]=sum_1[i]/score.length;
		}


		출력

		for(int i =0; i<score.length;i++) {
			System.out.printf("%d번째 학생의 총점은 %d",(i+1),sum_1[i]);

		 * 	  
		 */
		//입력2

		for(int i =0; i<score.length;i++) {
			System.out.println((i+1)+"째 학생의 성적을 입력 -> ");
			for(int j=0; j<score[i].length;j++) {
				score[i][j]=input.nextInt();
			}

		}

		int sum_2[] =new int[score[su-1].length];//과목의 갯수는 한학생의 열의 갯수 이다.
		double avg_2[] = new double[score[su-1].length];//과목 평균
		
		for(int j=0;j<score[su-1].length;j++) {
			for(int i=0;i<score.length;i++) {
				sum_2[j] += score[i][j];//[0][0] +[1][0]+[2][0] = 한 과목의 합
			} 
			avg_2[j]=sum_2[j]/score[su-1].length;
		}
		//출력 
		System.out.println();

		System.out.printf("국어 과목 총점 %d이고 평균은 %f입니다.",sum_2[0],avg_2[0]);
		System.out.printf("\n수학 과목 총점 %d이고 평균은 %f입니다.",sum_2[1],avg_2[1]);
		System.out.printf("\n영어 과목 총점 %d이고 평균은 %f입니다.",sum_2[2],avg_2[2]);
	}

	
}	

