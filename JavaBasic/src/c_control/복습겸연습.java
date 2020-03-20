package c_control;

public class 복습겸연습 {

	public static void main(String[] args) {
		//1부터 3까지 출력
		/*for(int i=1;i<4;i++) {
		System.out.println(i);
		*/	
		//3행 2렬 
		for(int i=0;i<3;i++) {
			for(int j=0;j<2;j++) {
				System.out.printf("<%d,%d>",i,j);//0~조건식 만큼 즉 2번 반보 **이렇게 반복문끝날때 출력
			}
			System.out.println();
		}

	}

}
