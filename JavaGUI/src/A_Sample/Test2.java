package A_Sample;

import java.awt.*;
public class Test2 extends Frame{
	//멤버변수 선언
	Button b;

	public Test2() {
		//객체 생성
		super("나의 창2");
		
		//객체 생성
		 b=new Button("OK2");
		
		//붙이기
		add(b);
		
		//화면 출력
		setSize(500,400);
		setVisible(true);
	}
	public static void main(String[] args) {
		
		Test2 t= new Test2();

	}

}
