package i_abstract;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		// 화면가정 - 여기서 그림을 그린다 가정
		Sharp s = method();
		//		s.draw();
		s.extent();
	
	}

	static Sharp method(){
		Scanner in = new Scanner(System.in);
		System.out.println("님이 원하는 도형은? 1.사각 2.원 3.삼각");
		int sel = in.nextInt();
		Sharp s = null;
		if(sel==1){
			System.out.println("높이와 한 변의 길이를 순서대로 입력해 주세요.");
			int height=in.nextInt();
			int line=in.nextInt();
			s = new Rect(height,line);
		}else if(sel==2) {
			System.out.println("반지름의 길이를 입력해 주세요");
			int r=in.nextInt();
			s = new Circle(r);
		}else if(sel==3) {
			System.out.println("높이와 밑변의 길이를 입력해 주세요");
			int height=in.nextInt();
			int base_line=in.nextInt();
			s = new Tri(height,base_line);
		}
		return s;
	}
	//		[ 추가 ] 밑변이나 높이 등의 값을 각각 입력 받아 넓이 구하기
}

abstract class Sharp{
	int height;
	public Sharp() {
		
	}
	public Sharp(int height) {
		this.height=height;
	}
	public abstract void draw();
	public abstract void extent();
}
class Rect extends Sharp{
	int line;

	public Rect(int height,int line) {
		super(height);
		this.line=line;
	}
	public void draw(){
		System.out.println("사각형을 그림");
	}
	public void rectangel(){
		System.out.println("사각형은 점 4개의 도형입니다.");
	}
	public void extent() {
		System.out.println("사각형의 넓이는 "+super.height*line+"입니다.");
	}

}
class Circle  extends Sharp{
	int r;
	public Circle(int r) {
		this.r=r;
	}
	public void draw(){
		System.out.println("원을 그림");
	}
	public void extent() {
		System.out.println("원의 넓이는 "+(double)r*r*3.14+"입니다.");
	}
}
class Tri  extends Sharp{
	int base_line;
	public Tri(int heigth,int base_line) {
		super(heigth);
		this.base_line=base_line;
	}
	public void draw(){
		System.out.println("삼각형을 그림");
	}
	public void extent() {
		System.out.println("삼각형의 넓이는"+(double)super.height*base_line/2+"입니다.");
	}
} 
