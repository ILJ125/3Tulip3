package G_tabpane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class VideoShop extends JFrame implements ActionListener{
	
	VideoAdmin video;
	RentAdmin rent;
	CustomerAdmin customer;
	
	public VideoShop (){
		video = new VideoAdmin();
		rent = new RentAdmin();
		customer= new CustomerAdmin();
	
	//붙이기
		JTabbedPane pane = new JTabbedPane();
		pane.add("비디오관리",video);
		pane.add("대여관리",rent);
		pane.add("고객관리",customer);
		
		add(pane);
		setSize(1000, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void Actionproc()
	{
		customer.button.addActionListener(this);
	}

	public static void main(String[] args) {
		
		VideoShop vs=new VideoShop();
		vs.Actionproc();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton evt = (JButton)e.getSource();
		if(evt==customer.button) {
			JOptionPane.showMessageDialog(null, "이거원하니?");
		}
		
	}

}
