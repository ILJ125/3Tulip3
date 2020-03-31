package C_infor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar; 

//Panel 2개 6,2 /Grid(1,6)
public class InfoTest2 extends JFrame {

	// 1.멤버변수 선언

	JTextArea ta;
	JButton bAdd,bShow,bSearch,bDelete,bCancel,bExit;
	JTextField tfName,tfId, tfTel,tfSex,tfAge,tfHome;
	InfoTest2() {
		// 2.객체 생성

		ta=new JTextArea();
		bAdd=new JButton("Add");
		bShow=new JButton("Show");
		bSearch=new JButton("Search");
		bDelete=new JButton("Delete");
		bCancel=new JButton("Cancel");
		bExit=new JButton("Exit");
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
		p.add(new JLabel("Name"));
		p.add(tfName);
		p.add(new JLabel("ID"));
		p.add(tfId);
		p.add(new JLabel("Tel"));
		p.add(tfTel);
		p.add(new JLabel("Sex"));
		p.add(tfSex);
		p.add(new JLabel("Age"));
		p.add(tfAge);
		p.add(new JLabel("Home"));
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


		setLocation(100,200);
		setSize(700, 560);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //기본적으로 x 버튼 누르면 나간다

	}
	public void eventProc() {
		//객체 생성
		MyEvent me=new MyEvent();

		//연결
		bAdd.addActionListener(me);
		bShow.addActionListener(me);
		bSearch.addActionListener(me);
		bDelete.addActionListener(me);
		bCancel.addActionListener(me);
		bExit.addActionListener(me);

		// 아이디 텍스트 필드에서 엔터쳤을 때 이벤트처리

		tfId.addActionListener(new ActionListener(){ 
			public void actionPerformed(ActionEvent e) {
				String msg =tfId.getText();
				//ID 텍스트에서 입력하고 엔터 치면 tfsex 텍스트 창에 입력할레
				//주민번호에서 성별을 구하는 코딩
				char sung = msg.charAt(7);
				//sung 변수에 값이 1,3이면 "남자"출력
				//그렇지 않고 sung 변수에 값이 2,4이면 '여자'출력
				
				if(sung =='1'|sung=='3'|sung=='9') {
					tfSex.setText("남자");
				}else if(sung=='2'|sung=='4'|sung=='0'){
					tfSex.setText("여자");
				}
				
				//주민번호에서 출신지를 구해서 출신지 텍스트 필드에 출력
				char id_hometown= msg.charAt(8);	
				switch(id_hometown) {
				case '0' : tfHome.setText("서울"); break;
				case '1' : tfHome.setText("인천/부산"); break;
				case '3' :tfHome.setText("경기도");break;
				default : tfHome.setText("한국인");break;
				}		
				//주민번호에서 나이를 구해서 나이 텍스트 필드에 출력
				Calendar c =Calendar.getInstance();
				int this_year=c.get(Calendar.YEAR);
				int i_nai=Integer.parseInt(msg.substring(0,2));
				int age=0;
				if(sung=='1'|sung=='2') //1900년대
				{
					age=this_year-(1900+i_nai)+1;
				}else if(sung=='3'|sung=='4')//2000년대
				{
					age=this_year-(2000+i_nai)+1;
				}else if(sung=='0'|sung=='9')//1800년대
				{
					age=this_year-(1800+i_nai)+1;
				}
				tfAge.setText(""+age);
//				JOptionPane.showMessageDialog(null,"Id: "+ msg);	
			}
		});
		//윈도우에 x 버튼 눌렀을 때의 이벤트처리
		//윈도우 이벤트 여서 addWindow, 마우스는 addMouse 
	addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			int result =JOptionPane.showConfirmDialog(null, "진짜로 나갈거야?");//예 ,아니오, 취소 가뜨는데 그걸 클릭하면 결과는 상수로 받는다
			if(result==JOptionPane.OK_OPTION)
			System.exit(0);//x버튼 누르면 나가짐
		}

	});
	}

	class MyEvent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton evt=(JButton)e.getSource();
			if(evt == bAdd) {
				JOptionPane.showMessageDialog(null,"Add");
			}else if(evt == bShow) {
				JOptionPane.showMessageDialog(null,"Show");
			}else if(evt == bSearch) {
				JOptionPane.showMessageDialog(null,"Search");
			}else if(evt == bDelete) {
				JOptionPane.showMessageDialog(null,"Delete");
			}else if(evt == bCancel) {
				JOptionPane.showMessageDialog(null,"Cancel");
			}else if(evt == bExit) {
				JOptionPane.showMessageDialog(null,"종료하시겠습니까?");
				System.exit(0);//위 메세지 창에서 확인을 누르면 그다음 코딩 실행됨
			}

		}

	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InfoTest2 t = new InfoTest2();
		t.display();
		t.eventProc();
	}

}
