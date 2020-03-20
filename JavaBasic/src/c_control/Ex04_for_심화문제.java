package c_control;

import java.util.Scanner;

public class Ex04_for_심화문제{
	public static void main(String[] args) {
/*
		//문제1[과제]
		Scanner input=new Scanner(System.in);
		System.out.println("숫자를 입력해주세요.");
		int end=input.nextInt();
		for(int j=1;j<=end;j++)
		{
			for(int k=0;k<end-j;k++) {
				System.out.print("  ");//(한 숫자당 뛰어쓰기 2번 n*2*"_"(\n)(n-1)*2*"_"(\n)...1*2*"_" 요런 느낌으로 출력
			}
			for(int i=1;i<=j;i++) 
			{
				System.out.print(i+" ");
			}
			System.out.println("");
		}
	

		//문제2
		
		Scanner input=new Scanner(System.in);
		System.out.println("숫자를 입력해주세요.");
		int end=input.nextInt();
		int temp=1;
		for(int j=0;j<end;j++)
		{
			for(int k=0;k<j;k++) {
				System.out.print("  ");//(한 숫자당 뛰어쓰기 2번 n*2*"_"(\n)(n-1)*2*"_"(\n)...1*2*"_" 요런 느낌으로 출력
			}
			for(int i=temp;i<temp+end-j;i++) 
			{
				System.out.print(i+" ");
			}
			temp +=(end-j);
			System.out.println("");
		}
*/
		//문제 : 숫자 사각형1
		
		Scanner input=new Scanner(System.in);
		System.out.println("높이(행)를 입력해주세요");
		int line=input.nextInt();//행
		System.out.println("너비(열)을 입력해주세요");
		int row=input.nextInt();//열
		int s_point=1;
		
		for(int i=0;i<line;i++) {
			
			for(int j=s_point;j<s_point+row;j++) {
				System.out.print(j+" ");
			}
			s_point+=row;
			System.out.println();
		}
		
		
		
	
	}
	
}


