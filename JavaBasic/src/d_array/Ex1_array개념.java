package d_array;

public class Ex1_array개념 {

	public static void main(String[] args) {
		// 성적
		//		int [] kor;//변수 선언
		//		kor = new int[5];//객체 생성 ;참조형
		int [] kor=new int [5]; //변수 선언과 객체 생성 동시에
		//int [] kor = new int[] {90, 88, 89, 70, 77};// 기본 문구 변수선언, 객체생성,초기화 동시
		//int [] kor = {90,88,89,70,77};//new int를 생략함
		
//		kor[0]=90;
//		kor[1]=88;
//		kor[2]=89;
		kor[3]=70;
		kor[4]=77;
		//		kor[5]=99;

		int total =0;
		for (int i=0;i<kor.length;i++)//kor.lenght kor배열에 길이 즉 kor 배열 갯수만큼 입력해줄게
		{
			System.out.println(kor[i]);
			total +=kor[i];
		}
		System.out.println("총점 : "+total);
	}

	
}
