package a_basic;

public class Main {

	public static void main(String[] args) {
		//변수선언
		//Student s;
		//객체생성(메모리에 확보)
		//s = new Student();
		Student s = new Student();//s에 머가 들었는지는 모지만 클래스에 포함된게 s라는 이름으로 메모리 확보
		s.kor=70;
		s.eng=88;
		s.math=99;
		System.out.println("총점: "+s.calTotal());
		System.out.println("평균:  "+s.calAve());
	}

}
