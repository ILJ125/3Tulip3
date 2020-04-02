package io.json;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class MyFrame extends JFrame
{
	// 변수선언
	JTextField tfName, tfTel, tfJumin, tfGender, tfAge, tfHome;
	JButton bSave, bOpen;
	
	// 객체 생성
	public MyFrame(){		
		super("나의 첫 화면");
		tfName = new JTextField(15);
		tfTel = new JTextField(15);
		tfJumin = new JTextField(15);
		tfGender = new JTextField(15);
		tfAge = new JTextField(15);
		tfHome = new JTextField(15);
		
		bSave = new JButton("저장하기");
		bOpen = new JButton("읽어오기");
		
	}
	
	// 화면구성 및 보여주기
	public void addLayout(){
		
		JPanel p_center = new JPanel();
		p_center.setLayout( new GridLayout( 6, 2 ));
		p_center.add( new JLabel("이름"));
		p_center.add( tfName );
		p_center.add( new JLabel("전화"));
		p_center.add( tfTel );
		p_center.add( new JLabel("주민"));
		p_center.add( tfJumin );
		p_center.add( new JLabel("성별"));
		p_center.add( tfGender );
		p_center.add( new JLabel("나이"));
		p_center.add( tfAge );
		p_center.add( new JLabel("출신지"));
		p_center.add( tfHome );
		
		JPanel p_south = new JPanel();
		p_south.add( bSave );
		p_south.add( bOpen );
		
		add( p_center, BorderLayout.CENTER);
		add( p_south, BorderLayout.SOUTH);
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		
	}
	
	// 이벤트 연결
	public void eventProc()
	{
		/* 이벤트 핸들러 객체 생성*/
		BtnHandler bHandler = new BtnHandler();
		
		/* 컴포넌트와 이벤트핸들러 연결 */
		bSave.addActionListener(bHandler);
		bOpen.addActionListener(bHandler);
		
	
	}
	
	/* 이벤트 핸들러 선언 */
	class BtnHandler implements ActionListener
	{
		public void actionPerformed( ActionEvent ev)
		{
			Object btn = ev.getSource();
			//JButton btn = (JButton)ev.getSource();
			if( btn == bSave ) {
				//JOptionPane.showMessageDialog(null, "저장합니다.");
				saveData();
			}else if ( btn ==  bOpen) {
				//JOptionPane.showMessageDialog(null, "입력합니다.");
				readData();
			}
		}
	} // end of class BtnHandler
	
	/**
			http://code.google.com/p/json-simple/
			왼쪽 메뉴 > Download >  json_simple-1.1.jar를 직접 다운
			Add External Jar 추가
	 */
	void saveData() {		
	
		try {
			//화면에 입력한걸 Json구조로 묶어줘야함
			JSONObject obj = new JSONObject();
			obj.put("name",tfName.getText());
			obj.put("tel",tfTel.getText());
			obj.put("Id_number",tfJumin.getText());
			obj.put("sex",tfGender.getText());
			obj.put("age",tfAge.getText());
			obj.put("home",tfHome.getText());
			
//			System.out.println(obj);
			//파일 이름 이 test인데 json형
			FileWriter fw = new FileWriter("src\\io\\json\\test.json");
			//write에는 char형이나 char배열로 저장 됩니다.
			//Json형탱의 String형으로 저장 
			fw.write(obj.toJSONString());
			fw.close();
 
		} catch (Exception e) { 
			
			e.printStackTrace();
		}
	}
	
	
	void readData() {		
		 
		try {
			FileReader fr = new FileReader("src\\io\\json\\test.json");
			//JSONParser는 외부 파일에 문자열로 저장 되있는것을 JSOn형태로 저장해놨으니
			//의미있는 것들(키)별로 자르는 것
			JSONParser parser = new JSONParser();
			//parsing을 해야하는데 파일 읽어오는 통로를 파싱
			//Object형으로 return 하는 parser를 JSON형으로????????????
			JSONObject obj=(JSONObject)parser.parse(fr);
			
			tfName.setText( (String)obj.get("name"));
			tfTel.setText( (String)obj.get("tel"));
			tfJumin.setText( (String)obj.get("Id_number"));
			tfGender.setText( (String)obj.get("sex"));
			tfAge.setText( (String)obj.get("age"));
			tfHome.setText( (String)obj.get("home"));
			
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
} // end of class MyFrame

public class GuiTest {
	public static void main(String[] args) {
		MyFrame my = new MyFrame();
		my.addLayout();
		my.eventProc();
	}
}
