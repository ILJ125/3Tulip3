package c_control;

import java.util.*;

public class Ex04_for_연습 {

	public static void main(String[] args) {
		// 문제 1)1~ N까지의 숫자를 다음처럼 출력하라
		//1 2 3 4 5
		//6 7 8 9 10
		//11 12 13 14 15
/*
		for(int i=1;i<16;i++)
		{
			if(i%5==0) {
				System.out.println(i);
			}else {
				System.out.print(i+" ");
			}
			
		}
		
		int end=0;//입력받을 숫자 변수
		Scanner input =new Scanner(System.in);
		System.out.println("숫자 몇까지 입력 받고 싶으세요?");
		end=input.nextInt();//scanner 입력
		for(int i=1;i<=end;i++)
		{
			if(i%5==0) {
				System.out.println(i);
			}else {
				System.out.print(i+" ");
			}
			
		}

		
		//문제 2 
		char alph=0;
		Scanner input =new Scanner(System.in);
		System.out.println("알파벳을 입력해 주세요?");
		alph=input.next().charAt(0);
		
		if(alph>='A'&alph<='Z') {
			for(char i = alph;i <='Z';i++) {
				System.out.print(i);
			}
		}else if(alph>='a'&alph<='z'){
			for(char i = 'a';i<=alph;i++) {
				System.out.print(i);
			}
		}else {
			System.out.println("Error");
		}
	
	
		//문제 3 
		
		Scanner input =new Scanner(System.in);
		System.out.println("문자열을 입력해 주세요");
		String line="";//입력받은 문자열 저장 변수
		line=input.nextLine();//입력 받음
		int l_line= line.length();//문자열의 길이 입력 변수
		
		for(int i=l_line;i>0;i--) {
			System.out.print(line.charAt(i-1));
		}
		//문자열에 맨 뒤 주소 즉 lenght-1 부터 0 위치 까지 (반복)한 글자씩 뽑아서 출력한다.
		//맨 끝자리 주소 부터 맨 앞 주소까지 한글자씩 뽑아서 입력
		 //주의 legnth는  글자 갯수이고 charAt는 맨앞에 글자주소를 0부터 읽는다.
		 //예시로 "안녕"은 길이는 2, '안'을 추출 할려면 charAt(0),'녕'을 추출할려면 charAt(1)
		
*/
		//문제4
		Scanner input = new Scanner(System.in);
		System.out.println("자연수를 입력해주세요.");
		int end =input.nextInt();
		
		for(int i=1;i<=end*end;i++) {
			if(i%end==0) {
				System.out.println((2*i-1)%10);
				
			}else {
				System.out.print((2*i-1)%10+" ");
			}
		}
		
		
		
		
		
	}

}
