package c_control;

import java.util.Scanner;

public class Ex06_do_while개념 {

	public static void main(String[] args) {
		// Do while 개념
		//조건 비교를 나중에 할 수 없을 까?->Do while
		String result="";
		do
		{
		Scanner input=new Scanner(System.in);
		System.out.println("입력");
		int num=input.nextInt();
		for(int i=1;i<10;i++) {
			System.out.printf(" %d * %d= %d\n",num,i,num*i);
		}
		System.out.println("다시 입력하시겠습니까?");
		result =input.next();
		if(result.equals("N")|result.equals("n")) break;
		
	
		}while(/*조건문*/result.equals("Y"));


	}
}
