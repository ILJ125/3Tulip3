package c_control;

public class Ex_while연습 {

	public static void main(String[] args) {
		//문제 4) 369게임
//
//		 1부터 50까지 숫자 중에서 3.6.9 게임처럼
//		 3, 6, 9 숫자를 포함하면  그 갯수만큼 "짝" 글자를 출력하고
//		 그렇지 않으면 그 숫자를 출력한다.
	
		for(int i=1; i<= 50; i++){
		int su = i;
		boolean su369 =false;
		
		while(su !=0 ){
		int na =su %10;//나머지를 입력
		if(na==3 | na==6 |na==9){
		System.out.print("짝");
		su369 =true;
		}
		su=su/10;
		}
		if(su369) System.out.println();
		else System.out.println(i);
		}
		/*
			
		//나는 숫자를 입력받아서 몇자리숫자든 다아 입력 받아서 짝짝 출력하고 싶어.
		Scanner input =new Scanner(system.in);
		System.out.println("숫자를 입력해봐");
		int num=input.nextInt();
		int count=0;
		
 */
		
	}

}
