package c_control;

import java.util.Scanner;

public class Ex04_for복습 {

	public static void main(String[] args) {
		// 주사위의 합 정올-1599
		Scanner input=new Scanner(System.in);
		System.out.println("구하고 싶은 주사위의 합은?");
		int num=input.nextInt();
		
		if(num<=6&num>1) {
			for(int i= 1;i<num;i++) {
				System.out.printf("%d %d\n",i,num-i);
			}
			
		}else if(num<=12&num>6) {
			for(int i=num-6;i<=6;i++) {
				System.out.println(i+" "+(num-i));
			}
		}else {
			System.out.println("주사위의 합은 2~12까지입니다.\n2~12까지의 숫자만 입력해주세요.");
		}
		//주사위 1개를 1~6까지 반복하는 반복문으로 본다.

	}

}
