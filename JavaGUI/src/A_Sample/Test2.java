package A_Sample;

import java.awt.*;
import javax.swing.*;
public class Test2 extends JFrame{
	//멤버변수 선언
	//남자 라디오 버튼

	
	JRadioButton Mrb;
	JRadioButton Wrb;
	JRadioButton Adultrb;
	JRadioButton Minorrb;
	public Test2() {
		//객체 생성
		super("나의 창2");
		
		//객체 생성
		Mrb=new JRadioButton("Man");
		Wrb=new JRadioButton("Woman",true);
		Adultrb=new JRadioButton("Adult");
		Minorrb=new JRadioButton("Minor",true);
	    //그룹 만들기 
		ButtonGroup group = new ButtonGroup();
		group.add(Mrb);
		group.add(Wrb);
		ButtonGroup group2 = new ButtonGroup();
		group2.add(Adultrb);
		group2.add(Minorrb);
		
		//붙이기
		setLayout(new FlowLayout());
		add(Mrb);
		add(Wrb);
		add(Adultrb);
		add(Minorrb);
		//화면 출력
		setSize(500,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		
		Test2 t= new Test2();

	}

}
