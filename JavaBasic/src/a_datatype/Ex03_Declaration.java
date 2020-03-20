package a_datatype;

public class Ex03_Declaration {

	public static void main(String[] args) {
		
		// 국어 점수를 저장할 변수 선언 - 값 대입
//		int kor;
//		kor = 90;
//		
//		
//		// 초기화 : 변수 선언시 값 대입
//		int eng =100;
//		

				
		//  kor와 eng 두개 이상의 변수를 한 번에 선언
		
		int kor=90,eng=100;
		System.out.println("국어:"+kor+"\n" +"영어:"+eng);

		
		//---------------------------------------------------
		// 점수바꾸기 - swap
		int temp;
		temp=kor;
		kor=eng;
		eng=temp;
		
		System.out.println("Swapping 후 \n국어:"+kor+"\n영어:"+eng);
		
		if(kor==eng) {
			System.out.println("동일한 점수");
		}else
		{
			System.out.println("다른 점수");
		}
		
	}

}
