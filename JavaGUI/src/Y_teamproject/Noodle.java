package Y_teamproject;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Noodle extends JPanel{

	JButton a = new JButton("a",new ImageIcon("src/pc_plus/Imgs/캡처8.PNG"));
	JButton b = new JButton("b",new ImageIcon("src/pc_plus/Imgs/캡처9.PNG"));
	JButton c = new JButton("c",new ImageIcon("src/pc_plus/Imgs/캡처10.PNG"));
	JButton d = new JButton("d",new ImageIcon("src/pc_plus/Imgs/캡처11.PNG"));
	
	public Noodle(){
		setBackground(Color.WHITE);
		setLayout(new GridLayout(2,2));
		add(a);
		add(b);
		add(c);
		add(d);
	}
}
