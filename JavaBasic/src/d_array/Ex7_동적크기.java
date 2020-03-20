package d_array;

public class Ex7_동적크기 {

	public static void main(String[] args) {
		// 
		//char[][] star=new char[5][5];
		char[][] star =new char[5][];
		//입력
		//<문제1>
		/*
		 <출력>
		 *  
		 * *  
		 * * * 
		 * * * * 
		 * * * * * 
	
		 */
		for(int i=0;i<star.length;i++) 
		{
			star[i]=new char[i+1];//star[0]에 배열[0+1]를 대입하고 싶어, star[1]에 배열[1+1]즉 배열 2개짜리를 대입하고 싶어
			for(int j=0;j<=i;j++) {

				star[i][j]='*';//증가 부분을 for문에 같이 넣을 수 있다.	
			}
		}
		//출력
		for(int i=0;i<star.length;i++) 
		{
			for(int j=0;j<star[i].length;j++) {
				System.out.print(star[i][j]+" ");
			}
			System.out.println();
		}
	}

}
