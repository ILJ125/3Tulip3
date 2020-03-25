package e_static;

/*
 * 무언가(변수값 같은거)를 단 하나로 공유 하고 싶어요 : static
 * static을 붙이는 순간 static영역에 따로 저장이 됩니다. 이름을 공유 합니다. 
 * 객체 명이 아닌 클래스명이 접근이 가능 
 * 
 */

public class Main {

	public static void main(String[] args) {
		
//		Book b1 = new Book();
//		Book b2 = new Book();
//		Book b3 = new Book();
		
		System.out.println("총갯수: " + Book.getCount());

	}

}
