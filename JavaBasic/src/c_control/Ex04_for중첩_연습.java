package c_control;

public class Ex04_for중첩_연습 {

	public static void main(String[] args) {
/*		// 카페 중첩 연습
		//문제 1
		char i=0;
		for(int j=26;j>=0;j--)
		{
		for(i='A';i<='Z'-j;i++) {
			System.out.print(i);
		}
		System.out.println("");
		}
		//문제2
		char i=0;
		for(int j=0;j<26;j++)
		{
		for(i='A';i<='Z'-j;i++) {
			System.out.print(i);
		}
		System.out.println("");
		}

		//문제3
		char i=0;
		char temp='A';
		for(int j=0;j<26;j++)
		{
			
		for(i=temp;i<='Z';i++) {
			System.out.print(i);
		}
		temp+=1;
		System.out.println("");
		}

		//문제4
		
		char i=0;
		for(int j=25;j>=0;j--)
		{
		for(i='Z';i>='A'+j;i--) {
			System.out.print(i);
		}
		
		System.out.println("");
		}
	
*/
		//문제5
		char i=0;
		char temp='A';
		for(int j=0;j<26;j++)
		{
			for(int k=26;k>26-j;k--) {
				System.out.print(" ");
			}
			for(i=temp;i<='Z';i++) {
				System.out.print(i);
			}
			temp+=1;
			
			System.out.println("");
		}
	
	}

}
