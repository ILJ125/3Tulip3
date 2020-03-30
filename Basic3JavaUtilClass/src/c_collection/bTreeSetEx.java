package c_collection;
import java.util.TreeSet;

public class bTreeSetEx 
{
	public static void main(String[] args) 
	{
		TreeSet  set = new TreeSet();//Tree 구조라서 정렬 할 수 있음
		//Tree 구조는 작으면 오른쪽 크면 왼쪽
		
		set.add("elephant");
		set.add("tiger");
		set.add("lion");
		set.add("cat");
		set.add("dog");
		set.add("ant");
		set.add("snack");
		set.add("zebra");
		set.add("bee");

		System.out.println( set );
		

	}
}
