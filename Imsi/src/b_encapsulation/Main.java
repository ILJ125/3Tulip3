package b_encapsulation;

public class Main {

	public static void main(String[] args) {

		Student s = new Student();
//		s.kor =70;
//		s.eng =80;
//		s.math =88;
		s.setKor(70);
		s.setEng(88);
		s.setMath(99); //private 메소드에 접근하기 위해서는 public으로 메소드를 만들어 줘야한다.
						// public 메소드의 위치는 private 변수가 있는 클래스 위치에 있기 때문에  private에 접근가능
		System.out.println(s.getKor() +"/" +s.getEng()+"/"+s.getMath()+"/");
		System.out.println("총점: "+s.calTotal());
		System.out.println("평균: "+s.calAverage());
		
		//이름에 홍길동 저장하고 출력
		s.setName("홍길동");
		System.out.println(s.getName());
	}
	/*
	 * [ 결론내기 ] 캡슐화란??? 
	 */
}
