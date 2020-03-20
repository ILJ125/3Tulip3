package d_array;

public class Ex7_동적크기연습 {

	public static void main(String[] args) {
		// 문제1 카페 동적크기연습
		
		 int a[][]=new int[][]{{3,-5, 12 }, {-2, 11, 2, -7}, {21, -21, -35, -93, -11}, {9, 14, 39, -98}};
		 
		 int sum[]=new int[a.length];
		 
		 //각 행의 합을 구하는거
		 for(int i=0;i<a.length;i++) {
			 for(int j=0;j<a[i].length;j++) {
				 sum[i] += a[i][j];
			 }
			 
		 }
		 //각행의 크기 비교 
		 int max=sum[0];
		 int max_hang=0;
		 for(int i=1;i<a.length;i++) {
			 if(max<sum[i]) {
				 max=sum[i];
				 max_hang=i;
			 }
		 }
		 
		 //출력
		 for (int i=0;i<a.length;i++) {
			 System.out.println(i+"행의 합 = "+sum[i]);
			 
		 }
		 System.out.println("가장 큰 행  합= "+max);
		 System.out.println("가장 큰 행 = "+max_hang);

	}

}
