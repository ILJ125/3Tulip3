package b_operator;

import java.util.Scanner;

public class Ex09_Samhang2 {

	public static void main(String[] args) {
		// 3항 연습
		//학생 점수를 입력받아 80점 이상이면 "합격"출력 그렇지 않으면 "불합격"을 출력하세요.
		
		int score=0;
		String result=null;
		
		Scanner input=new Scanner(System.in);
		System.out.println("점수를 입력해주세요.");
		score=input.nextInt();
		
		result=score>=80?"합격":"불합격";
		System.out.println(result);
	
		

	}

}
