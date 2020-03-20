package a_datatype;

import java.util.Scanner;

public class Exam {

	public static void main(String[] args) {
		
		//나이와 키를 입력받아서 출력

		int age=0;
		double tall=0;
		String name =null ;
		Scanner input = new Scanner(System.in);
		
		
		
		System.out.println("키를 입력해주세요.");
		tall = input.nextDouble();//tall이 double 형이어서 nextDouble() 입니다.
		
		System.out.println("나이를 입력해주세요.");
		age = input.nextInt();
		
		input.nextLine(); //// next라인은 앞에서 엔터를 치면 실행이 안되고 먹어버리기 때문에 먹으라고 하나 던져 준다.
		System.out.println("이름을 입력해 주세요.");
		name=input.nextLine();
		
		System.out.println("이름 = "+name + "\n키  = "+ tall +"\n나이 = "+ age);//입력받은걸 정리해서 출력으로 확인
		
		
		
		
	}

}
