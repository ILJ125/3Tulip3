package d_array;

import java.util.*;
public class Ex_주간과제 {

	public static void main(String[] args) {
		// OX문제 

		// 입력
		//만약 문자열을 잘못 입력하면 다시 입력하라고 하고 싶다.내가 입력받길 원하는건 소문자 'o','x'이다.
		boolean want=true;
		HERE://반복문을 많이 써줘서 오류를 만나면 라벨 다음 반복문의 끝으로 가서 다시 반복(반복되는 이유는 want변수가 계속 true여서 )시키고 싶다.
		while(want) {
			//1.테스트 케이스 갯수 

			Scanner input=new Scanner(System.in);
			System.out.println("테스트 갯수 입력해라!어? 알겠냐? .");
			int test_case=input.nextInt();
			int [] answer_su =new int[test_case];//테스트 갯수 만큼 정답 갯수 저장할 배열
			int temp_su=0;//'o'가ㅏ 연속으로 주어질때 연속으로 주어진 'o'갯수만큼 누적으로 계산 'ooo' 점수 = 3+2+1
			input.nextLine();//개행
			//2.문제 문자열 입력 받기
			String result[]=new String[test_case];
			for(int i=0;i<result.length;i++) {
				System.out.println((i+1)+"번째 문제 결과 입력하세요.(소문자 o와 x로만 구성되야합니다.)");
				result[i]=input.nextLine();
			}
			//3.문자열 안에 o갯수를 answer_su[]에 저장

			for(int i=0;i<result.length;i++) {
				for(int j=0;j<result[i].length();j++) {

					char temp=result[i].charAt(j);//임시저장 TEMP 입력받은 문자열에서 한글자씩 때오는데 한번 때오고 사용하고 필요가없어서 임시로저장

					if(temp=='o'& j!=result[i].length()-1 ) //마지막에 'o'일 때는 다르게 처리해줘야한다.
					{
						temp_su++;

					}
					else if(temp !='o'&temp !='x'|result[i].length()>80)//소문자'o',소문자'x'가 아니면 점수를 매기지 1 못하니 다시 입력받음 
					{
						System.out.println("잘못 입력했습니다. 다시 입력하세요.");
						System.out.println("----------------------------------------");
						continue HERE;
					}
					else  {
						if (temp=='o') {temp_su++;}//마지막 'o'는  temp_su를 먼저 증가 시키고 누적합 구해야함

						for(int k=1;k<temp_su+1;k++) {
							answer_su[i]+=k;

						}
						temp_su=0;//anwer_su[i]에 점수를 입력받고 x를 만나면 다시 1점부터 점수를 매기니 초기화 시켜줘야 한다.
					}
				}

			}
			for(int i=0; i<result.length;i++) {
				System.out.println((i+1)+"번째 문제의 정답 갯수 : "+answer_su[i]);}
			want=false;//끝까지 출력이 잘 됬으니 반복문을 나가 주겠습니다.
		};
		//출력


	}


}


