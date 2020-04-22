package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Connect extends JFrame {
	Fishing_Ground fg;
	
	JPanel loginPanel = new JPanel(new GridLayout(3, 2));

	JLabel idLabel = new JLabel("아이디 ");

	JLabel pwLabel = new JLabel("비밀번호 ");

	JTextField idText = new JTextField();

	JPasswordField pwText = new JPasswordField();

	JButton loginBtn = new JButton("로그인");

	JButton idpwSearchBtn = new JButton("직원 정보");
	int confirm =0;
	public Connect() {
		super("로그인 창!");

		this.setContentPane(loginPanel);

		loginPanel.add(idLabel);

		loginPanel.add(pwLabel);
		loginPanel.add(idText);

		loginPanel.add(pwText);

		loginPanel.add(idpwSearchBtn);

		loginPanel.add(loginBtn, new BorderLayout().SOUTH);

		// 라벨 가운데 정렬

		idLabel.setHorizontalAlignment(NORMAL);

		pwLabel.setHorizontalAlignment(NORMAL);

		// 현재 프레임 창 가운데 정렬 setSize를 먼저 해주어야 정상적으로 프레임이 가운데 정렬이 됨!

		setSize(350, 150);

		this.setLocationRelativeTo(null);

		this.setVisible(true);
		
		

		eventProc();
		return;
	}
	//로그인 성공했는지 실패했는지 확인가능한 창 넘김
	public int Confirmnumber() {
		return confirm;
	}
	// 로그인 버튼을 눌렀을때
	public void eventProc() {
		LoginbtnEventHandler loginbutton = new LoginbtnEventHandler();
		loginBtn.addActionListener(loginbutton);
		searchIDActionListener search = new searchIDActionListener();
		idpwSearchBtn.addActionListener(search);
		pwText.addActionListener(loginbutton);
	}

	public class LoginbtnEventHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 아이디 비번 확인 테스트 코드~
			String id = idText.getText().trim();

			String pw = pwText.getText().trim();

			if (id.length() == 0 || pw.length() == 0) {

				JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력 하셔야 됩니다.", "아이디나 비번을 입력!",
						JOptionPane.DEFAULT_OPTION);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				return;

			}

			if (id.equals("kosmo") && pw.equals("kosmo")) {

				JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인!", JOptionPane.OK_OPTION);
				confirm = 1;
				System.out.println(confirm);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				fg=new Fishing_Ground();
				setVisible(false);
				return;
			}
			JOptionPane.showMessageDialog(null, "로그인 실패", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
			confirm= -1;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			return;
			
		}

	}

	// 아이디 비밀번호 찾기 버튼을 눌렀을때

	public class searchIDActionListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			JOptionPane.showMessageDialog(null, "3조company \n" + "사장 김나현\n" + "직원 김규택\n" + "알바 김지섭", "아이디/비밀번호 찾기",
					JOptionPane.DEFAULT_OPTION);

		}

	}
	

}