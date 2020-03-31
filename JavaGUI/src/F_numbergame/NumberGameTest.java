package F_numbergame;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;


public class NumberGameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberGame numgame = new NumberGame();
		numgame.showAnswer();

	}

}

class NumberGame extends JFrame
//1.멤버 변수 선언
{	
	JButton [][] b=new JButton[4][4];
	NumberGame(){
		//2.객체 생성
		//3.화면 구성
		setLayout(new GridLayout(4,4));

		for(int i =0;i<4;i++) {
			for(int j=0; j<4;j++) {
				b[i][j]=new JButton(i+","+j);
				add(b[i][j]);
			}
		}

		//화면에 출력

		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	void showAnswer() {
		//시간을 잠깐 멈추게 함 1초 후에 함수 수행 
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		for(int i =0;i<4;i++) {
			for(int j=0; j<4;j++) {
				b[i][j].setText(null);
			}
		}
	}

}
