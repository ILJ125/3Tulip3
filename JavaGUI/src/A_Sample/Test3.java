package A_Sample;

import java.awt.*;
import javax.swing.*;
public class Test3 {
	//멤버변수 선언
	JFrame f;
	JButton b;
	JLabel l;
	JTextField tf;
	JTextArea ta;
	JCheckBox cb1;
	JCheckBox cb2;
	JList lst;
	public Test3() {
		//객체 생성
		f=new JFrame("나의 창");
		b=new JButton("확인");
		l=new JLabel("Name");
		tf=new JTextField("input",40);
		ta=new JTextArea("what",3,40);//(String ,행,열)
		cb1=new JCheckBox("woman");
		cb2=new JCheckBox("man");
		String []data = {"hambuger","gimbab","CHAMCHI"};
		lst=new JList(data);
		
		
		//붙이기  
		//붙이는 방식 =Layout
		//f.setLayout(new FlowLayout());
//		f.setLayout(new GridLayout(4,2));
		f.setLayout(new BorderLayout());
		f.add(b,BorderLayout.WEST);
		f.add(l,BorderLayout.EAST);
//		f.add (tf,BorderLayout.NORTH);
			JPanel p1 = new JPanel();
			p1.add(tf);
			p1.add(lst);
		f.add(p1,BorderLayout.NORTH);
		
		f.add(ta,BorderLayout.CENTER);
		//구분하기 위한 판때기 설정
			JPanel p2 = new JPanel();
//		f.add(cb1,BorderLayout.SOUTH);
//		f.add(cb2,BorderLayout.SOUTH);
			p2.add(cb1);
			p2.add(cb2);
		f.add(p2,BorderLayout.SOUTH);	
//		f.add(lst);
		
		//화면 출력
		f.setSize(500,400);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//화면 나가기
	}
	public static void main(String[] args) {
		
		Test3 t= new Test3();

	}

}
