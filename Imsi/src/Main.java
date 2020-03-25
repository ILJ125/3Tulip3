
public class Main {

	public static void main(String[] args) {
		// 소문자 main = 메소드명
		// 대문다 Main = 클래스명
		
		String name="홍길자";
		int age =24;
		double height =190.99;
		method(name,age,height);
		
	}
	static void method(String name,int age, double height) {
		//출력
		System.out.println("이름: "+name+"\n나이: "+age+"\n키: "+height);
	}

}
