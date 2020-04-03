package Y_teamproject;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Setmenu extends JPanel{
	
	public Setmenu(JButton a,JButton b, JButton c, JButton d){
		super(new GridLayout(2,2));//패널을 생성자함수로 생성과 동시에 GridLayout
		setBackground(Color.WHITE);//배경화면 화이트가 무슨 소용이 있는가
		add(a);	
		add(b);
		add(c);
		add(d);
	}

}
