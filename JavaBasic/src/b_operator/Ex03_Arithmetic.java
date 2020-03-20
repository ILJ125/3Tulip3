package b_operator;

import java.util.Scanner;

/**
 *  두 정수를 입력받아 사칙연산과 나머지 연산을 수행한 결과를 출력한다
 */


// 나머지 연산자 활용 - 홀/짝수 구하기

public class Ex03_Arithmetic {

	public static void main(String[] args) { 
	/*	
		int num1=0,num2=0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("첫번째 숫자 입력해주세요 :");	
		num1=input.nextInt();//변수에 숫자 입력 받음

		System.out.println("두번째 숫자 입력해 주세요 :");
		num2=input.nextInt();
		
		System.out.println(num1+" + "+num2+" = "+(num1+num2));
		System.out.println(num1+" - "+num2+" = "+(num1-num2));
		System.out.println(num1+" * "+num2+" = "+(num1*num2));
		System.out.println(num1+" / "+num2+" = "+(double)(num1/num2));
		System.out.println(num1+" % "+num2+" = "+(num1%num2));
*/
		//나머지 연산자 활용 - 홀/짝수 구하기
		
		//(1) 정수형 변수 su 선언
		int su=0;
		//(2) scanner 선언
		Scanner input = new Scanner(System.in);
		//(3) 화면에 "정수를 입력하세요" 출력
		System.out.println("정수를 입력하세요");
		//(4) 입력받은 정수를 su 변수에 저장
		su=input.nextInt();
		//(5) 입력받은 su가 홀,수 인지 아는 방법
		if(su%2==0) {
		System.out.println("짝수입니다.");		}else {
		System.out.println("홀수입니다.");
		}
		//(6) 입력받은 su가 3의 배수인지 아는 방법
		if(su%3==0) {
			System.out.println("3의 배수입니다.");		}else {
			System.out.println("3의 배수가 아닙니다.");
			}
		
		
		
	}

}
