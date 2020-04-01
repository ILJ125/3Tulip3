package Y_teamproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Bob extends JPanel {
	
	public Bob(){
		JButton a = new JButton("불고기덮밥",new ImageIcon("src/pc_plus/Imgs/캡처0.PNG"));
		JButton b = new JButton("육회비빔밥",new ImageIcon("src/pc_plus/Imgs/캡처1.PNG"));
		JButton c = new JButton("치킨마요덮밥",new ImageIcon("src/pc_plus/Imgs/캡처2.PNG"));
		JButton d = new JButton("불쭈꾸미덮밥",new ImageIcon("src/pc_plus/Imgs/캡처3.PNG"));
		setBackground(Color.WHITE);
//		setLayout(new GridLayout(2,2));
//			JPanel p =new JPanel(new BorderLayout());
//			p.add(a,BorderLayout.CENTER);
//			p.add(new JLabel("불고기덮밥"),BorderLayout.SOUTH);
//			p.add(pricea,BorderLayout.CENTER);
		add(a);	
		add(b);
		add(c);
		add(d);
	}
}
