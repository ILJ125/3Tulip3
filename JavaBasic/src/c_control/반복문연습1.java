package c_control;

import java.util.Scanner;

public class 반복문연습1 {

	public static void main(String[] args) {
		// 숫자사각형3 (정올-1304)
		/*
		Scanner input= new Scanner(System.in);
		System.out.println("100이하의 자연수만 입력해주세요.");
		int num = input.nextInt();

		for(int i =1;i<=num;i++) {

			for(int j=i;j<=i+num*(num-1);j+=num) {
				System.out.print(j+" ");			
			}
			System.out.println();
		}
*/
		//숫자 사각형 2(정올-1856)
		
		Scanner input= new Scanner(System.in);
		System.out.println("100이하의 자연수만 입력해주세요.");
		int n = input.nextInt();
		int m =input.nextInt();

		int odd_start= 1;
		int even_start=2*m;
		
		for(int i=1;i<=n;i++)
		{
			if(i%2 == 1) {
				for(int j=odd_start;j<odd_start+m;j++) {
					System.out.print(j+" ");
					
				}
				odd_start +=2*m;
				
			}else {
				for(int k=even_start;k>even_start-m;k--) {
					System.out.print(k+" ");
				
				}
					even_start +=2*m;
			}
			
			/*
			if(i%2 == 1) {
				for(int j=(i-1)*m+1;j<=i*m;j++) {
					System.out.print(j+" ");
				}
			}else {
				for(int k=i*m;k>=(i-1)*m+1;k--) {
					System.out.print(k+" ");
				}
				
			}
			*/

			System.out.println();
			
		}
	
	
	}

}
