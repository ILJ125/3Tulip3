package h_inherit2;

//has-a 관계 객체 생성해서 사용하는 관계 // MyFrame1 has a Frame

import java.awt.*;//화면 관련된거


class MyFrame1{
	Frame f; //awt안에 클래스 stack에 변수 선언
	MyFrame1(){
		f=new Frame("나의 첫 화면");//창 이름 & 객체생성함
		f.setSize(500,300);//픽셀  단위
		f.setVisible(true);//화면에 띄울래? 안띄울래?
	}
}

public class Test {

	public static void main(String[] args) {
		new MyFrame1();
		
	}


}