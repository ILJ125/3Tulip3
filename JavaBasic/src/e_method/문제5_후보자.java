package e_method;

public class 문제5_후보자 {

	public static void main(String[] args) {
		// 도전하세요. 후보자이야기

		int []result=solution();
		//출력
		for(int i=0;i<result.length;i++)
		{
			System.out.print(result[i]+"");
		}
	}
	static int[] solution(){
		//데이터 입력 받음
		int candidate = 5;
		int [] vote= {1,5,4,3,2,5,2,5,5,4};
		//후보 번호 입력 받고, 갯수 세기
		int candidate_su[]=new int [candidate];//후보 투표 갯수 배열로 저장
		int candidate_index[]= {1,2,3,4,5};//후보자들 위치 ->투표수 기준 내림차순 정리

		for(int i=0;i<candidate;i++) {
			for(int j=0;j<vote.length;j++) {
				if(vote[j]==i+1) candidate_su[i]++;		
			} 			
		}

		//		최대 투표 수 구하기 버블 정렬 사용 후 맨 앞에 최대 투표수가 오도록 한다.
		for(int i=1;i<=candidate;i++) {
			for(int j=0;j<candidate-i;j++) {
				if(candidate_su[j]<candidate_su[j+1]) {
					//최대 투표수 버블 정렬 (오른쪽이 크게)
					int temp=candidate_su[j];
					candidate_su[j]=candidate_su[j+1];
					candidate_su[j+1]=temp;
					//최대 투표의 후보자 번호 정렬 (오른쪽이 최대 투표수가 크게)
					int temp_index=candidate_index[j];
					candidate_index[j]=candidate_index[j+1];
					candidate_index[j+1]=temp_index;
				}
			}

		}

		//정렬은 다 됬는데 어디까지가 최대 투표수인가?
		int max_index=0;//마지막 최대 투표수 위치 예를들어  투표수는 5 5 0 이고 이것에 index는 1 4 5 이면 max_index =1 
		for(int i=0;i<candidate;i++)
		{
			if(candidate_su[0]==candidate_su[i]) {
				max_index=i;
			}
		}

		//최종적으로 최대 투표를 받은 후보자만 기록한 배열 반환
		int result[]=new int[max_index+1];//max_index는 0부터 시작 하기 때문에 +1을 해줘야한다.
		for(int i=0;i<result.length;i++) {
			result[i]=candidate_index[i];
		}
		return result;

	}

}
