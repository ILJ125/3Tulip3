
package c_collection;
import java.util.ArrayList;

class aArrayListEx0
{
	public static void main(String[] args) 
	{
		Object [] ob =dataSet();
		
		// dataSet() 안의 변수 값들을 여기서 출력한다면??
		for(int i =0; i<ob.length;i++) {
			System.out.println(ob[i]);
		}
	}

	static Object[] dataSet()
	{
		String	name = "김태희";
		int		age = 31;
		double	height = 162.3;
		
		Object [] data = new Object[3];
		data[0]=name;
		data[1]=new Integer(age); // int -> Integer
		data[2]=new Double(height); //double -> Double

		return data;

	}
}
