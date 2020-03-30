package c_collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

public class aArrayListEx3  {

	public static void main(String[] args) {
		ArrayList<Student> list=method();
		//여기서 출력
//		for(int i =0; i<list.size();i++) {
//			String data =(String)list.get(i);
//			System.out.println(data);
//		}
		//generics
		for(Student data : list) {
			System.out.println(data);
			//list가 Object 형이든 Student 형이든 overiding 되서 자동으로 toString()이 불려진다.
		}
		
	}
	static ArrayList<Student> method()  {
		//세명의 학생 정보들 저장 : ArrayList 이용
		Student a=new Student("김", 26);
		Student b=new Student("나", 25);
		Student c=new Student("현", 24);
		ArrayList<Student> list=new ArrayList<Student>();
		list.add(a);
		list.add(b);
		list.add(c);

		return list;
	}
}




//----------------------------------------------------------
class Student {
	String name;
	int age;
	Student(String name, int age){
		this.name = name;
		this.age = age;
	}
	public String toString() {
		return name +"학생은 " +  age + "세 입니다.";
	}
}
