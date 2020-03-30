package C_infor;

import javax.swing.*;
import java.awt.*; 

//Panel 2개 6,2 /Grid(1,6)
public class InfoTest extends JFrame {

	// 1.멤버변수 선언

	JTextArea ta;
	JButton bAdd,bShow,bSearch,bDelete,bCancel,bExit;
	JTextField tfName,tfId, tfTel,tfSex,tfAge,tfHome;
	InfoTest() {
		// 2.객체 생성
		
		ta=new JTextArea();
		bAdd=new JButton("Add",new ImageIcon("src/c_infor/Imgs/001.PNG"));
		//텍스트가 수직으로 봤을 때는 밑에
		bAdd.setVerticalTextPosition(JButton.BOTTOM);
		//텍스트가 수평에서는 중간에
		bAdd.setHorizontalTextPosition(JButton.CENTER);
		//클릭했을 때
		bAdd.setPressedIcon(new ImageIcon("src/c_infor/Imgs/002.PNG"));
		//마우스가 올라갔을 때
		bAdd.setRolloverIcon(new ImageIcon("src/c_infor/Imgs/004.PNG"));
		//말풍선
		bAdd.setToolTipText("1번 말풍선");
		//버튼 alt+i를 입력하면 이미지바뀜 버튼 누르고 있는 이미지랑 같음
		bAdd.setMnemonic('i');
		
		bShow=new JButton("Show",new ImageIcon("src/c_infor/Imgs/002.PNG"));
		bSearch=new JButton("Search",new ImageIcon("src/c_infor/Imgs/003.PNG"));
		bDelete=new JButton("Delete",new ImageIcon("src/c_infor/Imgs/004.PNG"));
		bCancel=new JButton("Cancel",new ImageIcon("src/c_infor/Imgs/005.PNG"));
		bExit=new JButton("Exit",new ImageIcon("src/c_infor/Imgs/006.PNG"));
		tfName=new JTextField(15);
		tfId=new JTextField(15);
		tfTel=new JTextField(15);
		tfSex=new JTextField(15);
		tfAge=new JTextField(15);
		tfHome=new JTextField(15);
		
		
	}

	void display() {
		// 3.화면 구성 및 출력
		//붙이기
		setLayout(new BorderLayout());
			JPanel p = new JPanel();
			p.setLayout(new GridLayout(6,2));
			p.add(new JLabel("Name",new ImageIcon("src/c_infor/Imgs/007.PNG"),JLabel.CENTER));
			p.add(tfName);
			p.add(new JLabel("ID",new ImageIcon("src/c_infor/Imgs/008.PNG"),JLabel.CENTER));
			p.add(tfId);
			p.add(new JLabel("Tel",new ImageIcon("src/c_infor/Imgs/009.PNG"),JLabel.CENTER));
			p.add(tfTel);
			p.add(new JLabel("Sex",new ImageIcon("src/c_infor/Imgs/005.PNG"),JLabel.CENTER));
			p.add(tfSex);
			p.add(new JLabel("Age",new ImageIcon("src/c_infor/Imgs/001.PNG"),JLabel.CENTER));
			p.add(tfAge);
			p.add(new JLabel("Home",new ImageIcon("src/c_infor/Imgs/002.PNG"),JLabel.CENTER));
			p.add(tfHome);
		add(p,BorderLayout.WEST);
		
		add(ta,BorderLayout.CENTER);
		
			JPanel p2 = new JPanel();
			p2.setLayout(new GridLayout(1,6));
			p2.add(bAdd);
			p2.add(bShow);
			p2.add(bSearch);
			p2.add(bDelete);
			p2.add(bCancel);
			p2.add(bExit);
		add(p2,BorderLayout.SOUTH);
		
		
		
		
		
	
		setLocation(100,200);//??????????????????????????????????????
		setSize(700, 560);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InfoTest t = new InfoTest();
		t.display();
	}

}
