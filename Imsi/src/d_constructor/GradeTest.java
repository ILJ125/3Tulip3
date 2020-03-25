package d_constructor;

import java.util.Scanner;

public class GradeTest {

	public static void main(String[] args) {
		//입력하려는 데이터 갯수 입력
		Scanner in =new Scanner(System.in);
		System.out.println("데이터 수를 입력 하세요 ");
		int data_su=in.nextInt();

		//점수 배열 생성
		int [] jumsu=new int [data_su];

		//데이터 입력 받기
		System.out.println(data_su+"개의 점수를 입력하세요.");
		for(int i=0;i<jumsu.length;i++) {
			jumsu[i]=in.nextInt();
		}

		//입력 받은 점수들을  GradeExpr안에 jumsu[]값으로 주기 with 생성자 함수
		GradeExpr ge=new GradeExpr(jumsu);//인자를 전해줄때는 변수 명만 배열이어도

		//저장된 원소들의 값들을 하나의 행에 ,기호로 분리하여 출력한다.
		System.out.print("점수들 :");
		for(int i=0;i<ge.jumsu.length;i++) {
			if(i==ge.jumsu.length-1) {
				System.out.print(ge.jumsu[i]+"\n");
			}else {
				System.out.print(ge.jumsu[i]+",");
			}
		}
		//총점, 평균(소수점 둘째 자리 까지 출력)
		System.out.printf("총점 :%d\n평균 :%.2f\n최고 점수 :%d\n최저 점수 :%d",ge.getTotal(),ge.getAverage(),ge.getGoodScore(),ge.getBadScore());


	}

}
