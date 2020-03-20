package d_array;

public class Ex7_동적크기연습2 {

	public static void main(String[] args) {
		// 문제1 카페 동적크기연습
		
		int a[][]=new int[][]{{3,-5, 12, 3, -21}, {-2, 11, 2, -7, -11}, {21, -21, -35, -93, -11}, {9, 14, 39, -98, -1}};
		 
		 int sum[]=new int[a.length];
		 
		 //각 행의 합을 구하는거
		 for(int i=0;i<a.length;i++) {
			 for(int j=0;j<a[i].length;j++) {
				 sum[i] += a[i][j];
			 }
			 
		 }
		 //각행의 크기 비교 
		 int max_sum=sum[0];//합중에 가장 큰거 
		 int max_hang=0;//합이 큰 행
		 for(int i=1;i<a.length;i++) {
			 if(max_sum<sum[i]) {
				 max_sum=sum[i];
				 max_hang=i;
			 }
		 }
		 
		 //각열의 크기 비교
		 int yeol=a[max_hang][0];//yeol 합이 가장 큰 행의 가장 큰 열의 값;
		 int max_yeol=0;//가장 큰 yeol의 위치;
		 for(int i=1;i<a[max_hang].length;i++) {
			 if(yeol<a[max_hang][i]) {
				 yeol=a[max_hang][i];
				 max_yeol=i;
			 }
		 }
		 //출력
		 for (int i=0;i<a.length;i++) {
			 System.out.println(i+"행의 합 = "+sum[i]);
			 
		 }
		 System.out.println("가장 큰 행  합= "+max_sum);
		 System.out.println("가장 큰 행 = "+max_hang);
		 System.out.println("가장 큰 행의 가장 큰 열 값 = "+yeol);
		 System.out.println("가장 큰 행의 가장 큰 열의 위치 = "+max_yeol);

	}

}
