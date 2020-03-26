package h_inherit3;

public class Dvd extends Item{
	String  actor;
	String  director;
	
	public Dvd(){
		System.out.println("기본 생성자");
	}
	public Dvd(int number,String title,String actor, String director){
		this.number=number;
		this.title=title;
		this.actor=actor;
		this.director=director;
		System.out.println("Book 인자 생성자");
	}
	public void output() {
		System.out.println(number);
		System.out.println(title);
		System.out.println(actor);
		System.out.println(director);
	}
}
