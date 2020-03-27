package h_inherit4;

public class Dvd extends Item{
	String  actor;
	String  director;
	
	public Dvd(){
		System.out.println("기본 생성자");
	}
	public Dvd(String number,String title,String actor, String director){
		super.number=number;
		super.title=title;
		this.actor=actor;
		this.director=director;
		System.out.println("Dvd 인자 생성자");
	}
	public void output() {
		System.out.println(number);
		System.out.println(title);
		System.out.println(actor);
		System.out.println(director);
	}
}
