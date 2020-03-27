package h_inherit4;

public class Test {

	public static void main(String[] args) {
		
		Item[] item =method();
		for(int i=0;i<item.length;i++) {
			item[i].output();
		}
	}
	
	static Item[] method() {
		Book b =new Book("001","자바","홍길동","코스모");
		Cd c = new Cd("002","아는노래","지코");
		Dvd d= new Dvd("003","킹덤","배두나","김은희");
		
		Item [] i=new Item[3];
		i[0]=b;
		i[1]=c;
		i[2]=d;
		
		return i;
	}

}
