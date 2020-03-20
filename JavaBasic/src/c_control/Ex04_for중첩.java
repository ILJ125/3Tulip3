package c_control;

public class Ex04_for중첩 {

	public static void main(String[] args) {
// 		for 중첩
//		*****
//		 ****
//		  ***
//		  
//		    * **
		int j=0;
		for( j=0;j<5;j++) {
			
		for(int k=0;k<j;k++){
			System.out.print(" ");
		}
		for(int i=0;i<5-j;i++) {
			System.out.print("*");
		}
		
		System.out.println("");
		}
	
/*		
		//A~Z 한줄에 출력
		
		char i=0;
		for(int j=26;j>=0;j--)
		{
		for(i='A';i<='Z'-j;i++) {
			System.out.print(i);
		}
		System.out.println("");
		}
*/		
		
		
	}

	
}
