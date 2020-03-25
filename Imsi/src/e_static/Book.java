package e_static;

public class Book {
	
	private static int count;

	public Book(){
		count++;
		System.out.println("책 한개 생성");
	}
	
	public static int getCount() {
		return count;
	}
	
}
