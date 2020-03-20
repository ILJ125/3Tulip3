package temp;

import java.util.Scanner;

public class leep_year {

	public static void main(String[] args) {
		// 윤년 구하기
		// (4의 배수 이며 100배수가 아니고) 또는 400의 배수인
		
		int year=0;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("윤년인지 확인하고 싶은 연도를 입력하세요.");
		year=input.nextInt();
		
		if(year%4==0 && year%100!=0 || year%400==0) {
			System.out.println("윤년입니다.");
		}else{
			
		System.out.println("윤년이 아닙니다.");
		}
	
	
	}

}
