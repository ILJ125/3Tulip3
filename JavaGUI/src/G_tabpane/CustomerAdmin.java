package G_tabpane;
import java.awt.Color;

import javax.swing.*;
public class CustomerAdmin extends JPanel{
	
	JButton button=new JButton("확인");
	public CustomerAdmin (){
		//Color : r(red) + g(green) + b(blue) 
		//0~250
		setBackground(new Color(102,153,255));
		add(button);
	}
}
