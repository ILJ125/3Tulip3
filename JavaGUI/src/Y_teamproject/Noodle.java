package Y_teamproject;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Noodle extends JPanel{

	public Noodle(JButton a, JButton b, JButton c, JButton d){
		super(new GridLayout(2,2));
		setBackground(Color.WHITE);
		add(a);
		add(b);
		add(c);
		add(d);
	}
}
