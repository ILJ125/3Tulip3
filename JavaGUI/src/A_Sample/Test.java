package A_Sample;

import java.awt.*;
public class Test {
	//멤버변수 선언
	Frame f;
	Button b;
	Label l;
	TextField tf;
	TextArea ta;
	Checkbox cb1;
	Checkbox cb2;
	List lst;
	public Test() {
		//객체 생성
		f=new Frame("나의 창");
		b=new Button("확인");
		l=new Label("Name");
		tf=new TextField("input",40);
		ta=new TextArea("what",3,40);//(String ,행,열)
		cb1=new Checkbox("woman");
		cb2=new Checkbox("man");
		lst=new List(3,false);
		lst.add("hambuger");
		
		//붙이기  
		//붙이는 방식 =Layout
		//f.setLayout(new FlowLayout());
//		f.setLayout(new GridLayout(4,2));
		f.setLayout(new BorderLayout());
		f.add(b,BorderLayout.WEST);
		f.add(l,BorderLayout.EAST);
		f.add(tf,BorderLayout.NORTH);
		f.add(ta,BorderLayout.CENTER);
		//구분하기 위한 판때기 설정
		Panel p = new Panel();
		p.setLayout(new GridLayout(2,1));
		f.add(cb1,BorderLayout.SOUTH);
		f.add(p,BorderLayout.SOUTH);
		f.add(cb2,BorderLayout.SOUTH);
//		f.add(lst);
		
		//화면 출력
		f.setSize(500,400);
		f.setVisible(true);
	}
	public static void main(String[] args) {
		
		Test t= new Test();

	}

}
