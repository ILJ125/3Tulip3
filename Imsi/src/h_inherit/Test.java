package h_inherit;

/*
   overloading : 동일한 함수명으로 인자의 자료형과 갯수 다른 함수들
   
   overriding : 상속 관계에서 인자와 반환값까지 전부 동일한 함수들
 */
public class Test {

	public static void main(String[] args) {


		Umma u =new Umma();
//		u.gene();
//		u.job();
//		
//		Ddal d =new Ddal();
//		d.gene();
//		d.study();
		
		//자식변수로 엄마 객체 생성
//		d.job(); //딸 객체를 통해서 엄마꺼 부름,자기 함수 처럼
		
		//2. 부모변수에 자식 객체 생성
		u=new Ddal();//
//		u.study(); //
		//*
		u.gene(); //
		//딸 객체를 생성
		
		
		//3. 객체임을 확인
		//객체 관계인지 묻고 싶을 때 instanceof
//		if(d instanceof Ddal) {
//			System.out.println("응 딸 객체야");
//		}
//		if(d instanceof Umma) {
//			System.out.println( "부모 객체");
//		}
		
		//4. 형변환
		// (casting ):기본형에 만 /상속관계의 클래스
		
//		Umma a =new Umma();
//		Ddal b =(Ddal)a;// 컴파일 오류는 아니지만 에러이다. 존재하지도 않는 메모리를 건들기에
		
		Ddal c = new Ddal();
		Umma d = (Umma)c; //딸이 부모로 형변환 up-casting
		Ddal e = (Ddal)d; //부모가 딸로 형변환 down-casting 이미 딸 객체 생성으로 메모리가있어서 가능 
	}

}
