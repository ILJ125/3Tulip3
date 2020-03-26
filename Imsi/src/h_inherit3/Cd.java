package h_inherit3;

public class Cd extends Item
{
	String  singer;
	
	public Cd(){
		System.out.println("기본 생성자");
	}
	public Cd(int number,String title,String singer){
		this.number=number;
		this.title=title;
		this.singer=singer;
		System.out.println("Book 인자 생성자");
	}
	public void output() {
		System.out.println(number);
		System.out.println(title);
		System.out.println(singer);	
	}
}
