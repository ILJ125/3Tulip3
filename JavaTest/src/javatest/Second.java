package javatest;

public class Second {

	public static void main(String[] args) {
		/*
		int sum=0;
		for(int i=1;i<=100;i++) {
			if(i%3==0 || i%5==0) {
				if(i%15 !=0) {
					sum +=i;
				}
			}
		}
		*/
		int sum =0;
		int i =1;
		while (i<=100) {
			if((i%3==0 | i%5==0 )& i%15 !=0) {
				sum +=i;
			}
			i++;
			}
		System.out.println("ver.while \n3의 배수와 5의 배수 총합 (단 공배수 제외): "+ sum);
		
	}
}

