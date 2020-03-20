package c_control;

import java.util.Scanner;

public class Ex03_선택연습 {

	public static void main(String[] args) 
	{
//		
//		int A=0,B=0,C=0;
//		int second_big_num=0;
//		Scanner sc = new Scanner(System.in);
//		A=sc.nextInt();
//		B=sc.nextInt();
//		C=sc.nextInt();
//
//		if(A>B)
//		second_big_num = (B > C) ? B : ((A > C) ? C : A);
//		else
//		second_big_num = (A > C) ? A : ((B > C) ? C : B);
//
//		System.out.println(second_big_num);

		Scanner input=new Scanner(System.in);
		System.out.println("세정수를 입력해주세요 ");
		int num1=input.nextInt();
		int num2=input.nextInt();
		int num3=input.nextInt();
		int max=0;
		int mid=0;
		max=num1>num2?num1:num2;
		max=max>num3?max:num3;

		if(max==num1) {//최댓값이 num1일때,num1=num3(num2작음),num2=num3(num1큼),num1!=num2!=num3 일 때 이다.
		mid=num2>num3?num2:num3;

		}else if(max==num2) {//최댓값이 num2일 때는 num1=num2(num3작음),num1=num3(num2큼),세 수가 다를 때
		mid=num1>num3?num1:num3;

		}else {//최댓값이 num3일 때는 num1=num2=num3일 때,num2=num3(num1작음),num1=num2(num3큼)
		if(num2==num3)
		{
		mid=num1>num2?num2:num1;//사실 mid=num2|mid=num3이라고 적어줘도 된다. 왜냐하면 num2=num3일때 num3이 max가 될려면 num1이(num2=num3)보다 작을 수 밖에없다.
		}else
		{
		mid=num1>num2?num1:num2;
		}
		}

		System.out.println("두번째로 큰 수 는 : " +mid);


	}
}		
	
	
