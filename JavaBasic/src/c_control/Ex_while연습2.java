package c_control;

import java.util.Scanner;

public class Ex_while연습2 {

	public static void main(String[] args) {
		/* 1부터 10,000까지 8이라는 숫자가 총 몇번 나오는가?
		 8이 포함되어 있는 숫자의 갯수를 카운팅 하는 것이 아니라 8이라는 숫자를 모두 카운팅 해야 한다.
		 (※ 예를들어 8808은 3, 8888은 4로 카운팅 해야 합니다)
		 결과 : 4000

	int count=0;//8들어간 갯수 세는 변수
	for(int i=1;i<10000;i++) {
		int num=i;
		
		
		while(num!=0) {
			int na=num%10;
			if(na==8) {
				count++;
			}
			num /=10;			
		}		
	}
	System.out.println(count);
*/		
		//구글 입사 아직 미해결 (타인)
		Scanner input =new Scanner(System.in);
		int num=input.nextInt();
		
		
		int cnt =0;
		String s_num=Integer.toString(num);
		int l_num=s_num.length();
	
		for(int i =1; i<=num; i++)
			
		{
			
			for(int j=0;j<l_num;j++)
			{
				int temp=(int)Math.pow(10,j);
				if(((int)i/temp)%10==8) cnt++;

			}
		}
		System.out.println(cnt);
	}

}
