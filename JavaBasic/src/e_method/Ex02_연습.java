package e_method;

import java.util.*;

public class Ex02_연습 {
	
	//문제1
	public static void main(String[] args) {
		//문자 입력
		Scanner input = new Scanner(System.in);
		System.out.println("영문자를 입력해 주세요.");
		char ch=input.next().charAt(0);
		
		boolean result=checkLower(ch);
	
		//소문자인지 대문자인지 출력
		if(result)
		{
			System.out.println("소문자");
		}else {
		System.out.println("소문자 아님");
		}
		
	}
	static boolean checkLower(char ch) {
		//소문자이면 true 아니면 false		
			if(ch>='a'&ch<='z') {
				return true;
			}
			else {
				return false;
			}
		}
		
		
		
	}


