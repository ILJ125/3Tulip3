
public class Main2 {

	public static void main(String[] args) {
		Person info=method();
		//출력
		System.out.println(info.getName());
		System.out.println(info.getAge());
		System.out.println(info.getHeight());
	}

	static Person method(){

		Person info =new Person();
		
		info.setName("홍길자");
		info.setAge(24);
		info.setHeight(190.99);
		
		return info;
	}
}
class Person {

	private	String name;
	private int age ;
	private double height ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}

}