package h_inherit3;

public class Book extends Item{
	private String  writer;
	private String  publisher;
	
	public Book(){
		System.out.println("기본 생성자");
	}
	public Book(int number,String title,String writer,String publisher){
//		super.number=number; //엄밀히 말하면 부모의 number 
//		super.title=title;
		super(number,title);//부모 생성자 함수 호출 할  때
		this.writer=writer;
		this.publisher=publisher;
		System.out.println("Book 인자 생성자");
	}
	public void output() {
		System.out.println(number);
		System.out.println(title);
		System.out.println(writer);
		System.out.println(publisher);
	}
}
