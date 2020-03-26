package e_static_sample;

public class ViewA {

	DBConect db;//조합형은 자동 초기화 null

	public ViewA() {
		db = DBConect.getInstance();
		//new 붙여서 DBConect의 객체를 생성할 수 없게 막아놨다.
		//그래서 클래스명으로 함수를 불러야한다.
		//클래스명으로 함수를 부르기 위해서는 static이 함수에 붙어있어야한다.
	}

	public void use() {
		System.out.println("디비 작업 중");
	}
}
