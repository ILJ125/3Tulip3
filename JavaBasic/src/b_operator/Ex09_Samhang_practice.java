package b_operator;

import java.util.Scanner;

public class Ex09_Samhang_practice {

	public static void main(String[] args) {
		//카페 삼항 문제 세정수를 입력받아 그중에 가장 큰 수를 구한다.
		
		int num1=0,num2=0,num3=0;
		
		Scanner input =new Scanner(System.in);
		
		System.out.println("첫번째 숫자를 입력해주세요");
		num1=input.nextInt();
		
		System.out.println("두번째 숫자를 입력해주세요");
		num2=input.nextInt();
		
		System.out.println("세번째 숫자를 입력해주세요");
		num3=input.nextInt();

		int max=num1>num2?num1:num2;
		max=max>num3?max:num3;
	}

}

