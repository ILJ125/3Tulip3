package c_control;

public class Ex04_for_개념 {

	public static void main(String[] args) {
		// for문 개념 잡기
		/* for (초기치;조건식;증가치;){
		 * 반복 구문
		 * }
		 */
	/*//0.인사말 5번 출력하기
		for (int i= 0;i<5;i++) {
			System.out.println("좋은 아침이에요");
		}
	
		//1. 1~10까지의 합을 구하기
		int i= 0;
		int j=0;
		for(i=0; i<=100;i++) {
			 j += i;
			 
		}
		System.out.println("1~"+i-1+"까지의 합 : "+ j);
	
	//2. 1~100까지의 홀수의 합과 짝수의 합 구하기
		int even=0,odd=0;//even=짝수의 합 , odd=홀수의 합
		for (int i=0;i<=100;i++) {
			if(i % 2 ==1) {
				odd+=i;
			}else {
				even+=i;	
			}
		}
		System.out.println("1~100까지의 짝수의 합 : "+even+"\n1~100까지의 홀수의 합 : " + odd);
	*/
		//3. A~Z 출력 (아스키코드)
		for(char ch='a';ch<='z' ; ch++) {
			System.out.print(ch);
		}
		System.out.println();
		//4. A~Z 출력 (2개씩 건너띄기)
		for(char ch='a';ch<='z' ; ch += 2) {
			System.out.print(ch);
		}
		System.out.println();
		//5. Z~A 출력 
		for(char ch='Z';ch>='A' ; ch--) {
			System.out.print(ch);
		}
	}
}
