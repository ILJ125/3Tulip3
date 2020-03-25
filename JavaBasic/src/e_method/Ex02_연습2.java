package e_method;

import java.util.*;

public class Ex02_연습2 {
	
	//문제1
	public static void main(String[] args) {
		//문자 입력
		Scanner input = new Scanner(System.in);
		System.out.println("영문자를 입력해 주세요.");
		char ch=input.next().charAt(0);
		
		char result=checkLower(ch);
	
		//소문자인지 대문자인지 출력
		System.out.println(result);

	}
	static char checkLower(char ch) {
		
		//소문자이면 대문자로 변환	
			if(ch>='a'&ch<='z') {
				char Upper =(char) (ch-32);
				return Upper ;
			}
			else {
				return ch;
			}
			
		}
		
		
		
	}


