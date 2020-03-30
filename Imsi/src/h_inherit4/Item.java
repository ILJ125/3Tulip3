package h_inherit4;

public abstract class Item {
	protected String  number;
	protected String  title;

	public Item(){
		System.out.println("기본 생성자");
	}
	public Item(String number,String title){
		this.number=number;
		this.title=title;
		System.out.println("Item 인자 생성자");

	}
	
	public abstract void output();
}
