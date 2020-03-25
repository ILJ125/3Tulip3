package d_constructor;

import java.util.Scanner;

public class MainArray {
	
	/**
	 * 	3명의 학생 정보를 입력받아 각 학생별 총점 평균을 구한다면
	 */
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		Student su[]=new Student[3];//배열3명
		
		for(int i =0;i<su.length;i++) {
//			String name=in.next();
//			int k=in.nextInt();
//			int e=in.nextInt();
//			int m=in.nextInt();
			System.out.println((i+1)+"번째 학생 이름 국어점수 수학점수 영어점수 를 입력하세요");
			su[i]=new Student(in.next(),in.nextInt(),in.nextInt(),in.nextInt());
		}
		for(int i=0;i<su.length;i++)
		{
			System.out.println((i+1)+"번째 학생 이름: "+su[i].getName()+"/총점 : "+su[i].calTotal()+"/평균 :"+su[i].calAverage());
			
		}
		int sum_kor=0;
		int sum_eng=0;
		int sum_math=0;
		
		for(int i=0;i<su.length;i++) {
			 sum_kor+=su[i].getKor();
			 sum_eng+=su[i].getEng();
			 sum_math+=su[i].getMath();
					 }
		System.out.println("총 국어 점수 "+sum_kor+"총 영어 점수"+sum_eng+"총 수학 점수"+sum_math);
			// 추가적으로 각 과목별 총점을 구한다면?
			
		
	}

}
