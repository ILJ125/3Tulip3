package b_encapsulation;

import java.util.*;

public class CalculatorTest {

	public static void main(String[] args) {
		//연습jpg 보고 만드는거
		CalculatorExpr ce = new CalculatorExpr();
		//반복
		boolean repeat=false;
		do {
			//입력 받음
			Scanner input = new Scanner(System.in);
			System.out.println("숫자 2개 입력해주세요");

			//멤버 변수에 숫자 입력
			ce.setNum1(input.nextInt());//input 바로 넣을 수 있음
			ce.setNum2(input.nextInt());

			//추출된 숫자 출력
			System.out.println(ce.getNum1());
			System.out.println(ce.getNum2());

			//덧셈 등등 출력
			System.out.println("덧셈 : "+ce.getAddition());
			System.out.println("뺄셈 : "+ce.getSubtraction());
			System.out.println("곱셈 : "+ce.getMultiplication());
			System.out.println("나눗셈 : "+ce.getDivision());
			do {
				System.out.println("계속 진행하시겠습니까?\n예 : y\n아니오 : n");
				char answer=input.next().charAt(0);
				if(answer=='y') repeat=true;
				else if(answer=='n'){
					System.out.println("프로그램이 끝났습니다.");
					repeat=false;
				}else {repeat=true;System.out.println("잘못 입력 되었습니다."); continue;}
			}while(repeat);
		}while(repeat);
	}

}
