package h_inherit2;

import java.awt.Frame;

//상속 관계는 is-a ; // MyFrame2 is a Frame
//부모의 멤버를 막 가져와서 쓰고 싶을 때
class MyFrame2 extends Frame {

	MyFrame2(){
		super("나의 두번째 화면");//자식의 생성자 함수는 자동으로 부모 생성자 함수를 부르는 코딩을 해준다.
		setSize(500, 300);
		setVisible(true);
	}
}



public class Test2 {

	public static void main(String[] args) {
		MyFrame2 mf2=new MyFrame2();

	}

}
