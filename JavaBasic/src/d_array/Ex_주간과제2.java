package d_array;

import java.util.*;
public class Ex_주간과제2 {

	public static void main(String[] args) {
		// 평균 구하기

		// 입력
		Scanner input =new Scanner(System.in);
		System.out.println("테스트 케이스 수 입력:");
		int test_case =input.nextInt();
		
		//케이스 수 =각 케이스의 여러명의 학생의 점수를 입력해야하니 이중 배열로 선언해 줍니다.
		int [][]score=new int [test_case][];//각 케이스의 몇명의 학생의 점수가  들었는지는 나중에 객체생성해주겠습니다.
		for(int i=0;i<test_case;i++) {
			int j=0;//각케이스의  학생 수 만큼 점수를 입력해 주고 나면 j값은 그 학생 수+1 이기에 다음케이스로 넘어갔을 때 초기화 시켜줘야한다.
			do {
				if(j==0)//score[i][0]은 i케이스의 몇 명의 학생점수를 입력받는다.입력받고 그 값 만큼 객체생성 해줘야한다.
				{
					int temp=input.nextInt();//일단 입력한 수만큼 객체 생성하기 위해 임시로 저장해놓겠습니다.
					score[i]=new int [temp+1];//객체 생성하고
					score[i][0]=temp;//temp에 임시로 저장한걸 제대로 저장해줍니다.
				}else {
					score[i][j]=input.nextInt();
				}
			j++;//while문이기에 증가치는 블록 앞쪽에 적어주겠습니다.			
			}while(j<score[i].length);	
		}		
		//계산 		
		//1.평균을 구해주자
		int [] sum=new int [test_case]; //각 케이스의 학생의 점수의 합
		double [] avg  =new double [test_case];//각 케이스의 학생의 점수들의 평균
		
		for(int i=0;i<score.length;i++) {
			for(int j=1;j<score[i].length;j++) //score[i][0]=>각 케이스의 학생 수 이기에 제외함
				{
				sum[i] +=score[i][j];
			}
			avg[i]=(double)sum[i]/(score[i].length-1);
		}
		//2.비율 계산을 시작 해보지
		//비율 : 평균을 넘는 학생들의 수/각 케이스의 학생 수 *100
		int good_student[] =new int [test_case]; //각 케이스의 평균을 넘는 학생 수
		double percentage[] =new double[test_case];//각 케이스의 평균을 넘는 학생 비율
		double nunu=0;
		for(int i=0;i<score.length;i++)
		{
			for(int j=1;j<score[i].length;j++) {
				if(score[i][j]>avg[i])//평균 이상인 친구들 몇명인지  
					{
					good_student[i]++;
				}
			}	
			percentage[i]=(double)good_student[i]/(score[i].length-1)*100;
			//비율 계산  주의!!! 자바는 기본적으로 int형으로 인식하기에 double은 double로 형변환!
		}		
		//출력
		for(int i=0;i<score.length;i++) {
			System.out.println("각 케이스의 평균이상의 점수를 가진 학생의 비율 => "+(Math.round(percentage[i]*1000)/1000.0)+"%");
			//단 소수점 이하 4번째 자리에서 반올림 =소수점 3번째 자리까지 출력			
		}				
	}
}


