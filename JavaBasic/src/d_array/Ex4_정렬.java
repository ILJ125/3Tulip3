package d_array;

import java.util.Scanner;

public class Ex4_정렬 {

	public static void main(String[] args) {
		// BUBBLE 정렬
		
		int num[] = {4,0,5,2,6,1,9,8,3,7};

	Scanner input= new Scanner(System.in);
	System.out.println("몇개의 숫자를 입력 하실 것입니까?");
	
	int length_num=input.nextInt();
		for(int i=0;i<num.length-1;i++) 
		{
			for(int j=0;j<num.length-i-1;j++){

				if(num[j]>num[j+1]) 
				{
					int temp=num[j];
					num[j]=num[j+1];
					num[j+1]=temp;

				}

			}
			for(int k=0;k<num.length;k++){
				
				System.out.print(num[k]);
			}
			
			System.out.println();

		}

	}

}
