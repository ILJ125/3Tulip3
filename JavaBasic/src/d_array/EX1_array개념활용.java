package d_array;

import java.util.*;

public class EX1_array개념활용 {

	public static void main(String[] args) {
		// 성적
		/* 학생 점수를 입력받아 평균과 총점을 출력 
		 * 입력형식 : 80/88/77
		 * 출력형식 :
		 * 			총점 : xxx
		 * 			평균 : xxx
		 */
		
		Scanner input =new Scanner(System.in);
		System.out.println("숫자를 숫자/숫자/숫자 형태로 입력해주세요");
		String scan_score=input.nextLine();
		
		StringTokenizer token = new StringTokenizer(scan_score,"/");
		
		int l_score=token.countTokens();
		int [] score = new int[l_score];
		int i=0;//0~ token 갯수만큼 반복 해주고 싶어요
		int hap=0; //점수의 합
		double avg=0;//평균

		while(token.hasMoreTokens()) {
			String temp=token.nextToken();//nextToken token 갯수를 줄입니다.
			score[i]=Integer.parseInt(temp);
			
			hap +=score[i];//hap에 score배열의 누적 점수를 더해 줄게요 ,총점
			
			i++;
		}
		avg=hap/l_score;
		
		System.out.println("총점 : "+ hap);
		System.out.println("평균 : "+ avg);
	}

}
