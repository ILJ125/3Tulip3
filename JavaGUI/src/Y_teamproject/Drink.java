package Y_teamproject;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Drink extends JPanel{
	
	JButton a = new JButton("a",new ImageIcon("src/pc_plus/Imgs/캡처4.PNG"));
	JButton b = new JButton("b",new ImageIcon("src/pc_plus/Imgs/캡처5.PNG"));
	JButton c = new JButton("c",new ImageIcon("src/pc_plus/Imgs/캡처6.PNG"));
	JButton d = new JButton("d",new ImageIcon("src/pc_plus/Imgs/캡처7.PNG"));
	
	public Drink(){
		setBackground(Color.WHITE);
		setLayout(new GridLayout(2,2));
		add(a);
		add(b);
		add(c);
		add(d);
	}
}
