package c_collection;
import java.util.*;

public class bHashSetLottoEx 
{
	public static void main(String[] args) 
	{
		HashSet<Integer> lottos = new HashSet<Integer>();

		while(lottos.size()<6) {
		int num = (int)((Math.random()*45)+1);
		lottos.add(num);
		}

//		System.out.println(lottos);
		ArrayList<Integer> list =new ArrayList<Integer>(lottos);
		Collections.sort(list);//이거머냐 ???????????
		System.out.println(list);
	}
}
