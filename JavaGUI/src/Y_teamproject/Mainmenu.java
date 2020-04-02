package Y_teamproject;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Mainmenu extends JPanel{
	String []i=new String [4];
	

	
	public Mainmenu(){
		HERE:
		for(int j=0;j<i.length;) {
			i[j]=String.valueOf((int)(Math.random()*11));
			 for(int k=0;k<j;k++) {
				 if(i[j].equals(i[k])) {
					 continue HERE;
				 }
			 }
			 j++;
		}
		
		JButton a = new JButton("a",new ImageIcon("src/pc_plus/Imgs/캡처"+i[0]+".PNG"));
		JButton b = new JButton("b",new ImageIcon("src/pc_plus/Imgs/캡처"+i[1]+".PNG"));
		JButton c = new JButton("c",new ImageIcon("src/pc_plus/Imgs/캡처"+i[2]+".PNG"));
		JButton d = new JButton("d",new ImageIcon("src/pc_plus/Imgs/캡처"+i[3]+".PNG"));

		setBackground(Color.WHITE);
		setLayout(new GridLayout(2,2));
		add(a);
		add(b);
		add(c);
		add(d);
	}
	
}
