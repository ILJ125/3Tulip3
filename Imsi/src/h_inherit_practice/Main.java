package h_inherit_practice;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean result= true;
		do {
			Language l=null;

			Scanner input=new Scanner(System.in);
			System.out.println("언어를 선택하세요 (1.한국어 2.영어 3.일본어)");
			int choice1=input.nextInt();

			switch(choice1) {
			case 1 : l= new Korean(); break ;
			case 2 : l= new English(); break ;
			case 3 : l= new Japanese(); break ;
			}
			System.out.println("메시지를 선택하세요 (1.인사말 2.자기소개 3.하고싶은 말)");
			int choice2=input.nextInt();
			switch(choice2) {
			case 1 : l.Greeting();break;
			case 2 : l.Self();break;
			case 3 : l.Want();break;
			}
			System.out.println("다시하시겠습니까? (Y/N)");
			char temp=input.next().charAt(0);
			if(temp=='Y')continue;
			else result= false ;break;
			
		}while(result);
	}
}
