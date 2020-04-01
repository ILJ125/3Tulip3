package F_numbergame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class NumberGameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberGame numgame = new NumberGame();
		numgame.initChar();
		numgame.showAnswer();

	}

}

class NumberGame extends JFrame implements ActionListener

//1.멤버 변수 선언
{	
	int getsu=4;
	JButton [][] b=new JButton[getsu][getsu];

	//2. 버튼위에 지정할 문자 변수 
	char [][] answers = new char[getsu][getsu];


	NumberGame(){

		//3.화면 구성
		setLayout(new GridLayout(4,4));

		for(int i =0;i<getsu;i++) {
			for(int j=0; j<getsu;j++) {
				b[i][j]=new JButton();
				add(b[i][j]);
				//문자 배열을 0으로 초기화
				answers[i][j]='0';
				b[i][j].addActionListener(this);
			}
		}

		//화면에 출력

		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	void initChar() {
		char alpha ='0';
		HERE:
			for(int num=0; num<getsu*getsu;) {
				//임의의 알파벳 만들기
				//나는 같은 알파벳을 2번 입력해야 한다. 그렇기 때문에 num이 0,2,4,6 등 짝수일 때 나는 alph에 값을 새로랜덤으로 지정해주고
				//홀수 num이 1,3,5, 등일 때는 새로 값을 지정해 주지 않고 그 값을 그대로 버튼에 입력 해 줄것이다.
				if(num%2 ==0) {
					alpha = (char)('A'+(int)(Math.random()*26));
					//기존에 이미 이 알파벳이 있는지 확인
					for(int i =0;i<getsu;i++) {
						for(int j=0; j<getsu;j++) {
							if(answers[i][j]==alpha) continue HERE;
						}
					}
				}
				//임의의 위치 선정하기
				//정해진 alpha값을 각 버튼에 지정해주기
				boolean ok=false;
				do {
					int row=(int)(Math.random()*getsu);
					int col=(int)(Math.random()*getsu);
					//아무 값이 지정되지 않아 '0'값을 가진 버튼에 알파벳 입력 해주고
					// 값이 있으면 아무것도  입력안해도 된다.
					// 값 하나 alpha값 위에서 받아온걸 값을 지정해주고 나서는 반복문을 나가도 된다.
					// 성공적으로 완료 했으니 i값을 증가 시켜주자
					// 가장 바깥쪽에 있는 반복문은 결국 16개만 입력하고 반복이 끝나도록 설정되어있다.
					if(answers[row][col] == '0') {
						answers[row][col]=alpha;
						num++;
						ok =true;
					}
				}while(!ok);


			}

	}
	void showAnswer() {
		//답을 보여주기
		for(int i =0;i<getsu;i++) {
			for(int j=0; j<getsu;j++) {
				b[i][j].setText(String.valueOf(answers[i][j]));
			}
		}
				//1분 후에 답 가리기 
//				try {
//					Thread.sleep(5000);
//				} catch (InterruptedException e) {
//				}
//		
//				for(int i =0;i<getsu;i++) {
//					for(int j=0; j<getsu;j++) {
//						b[i][j].setText(null);
//					}
//				}
	}
	
	
	
	JButton firstClick=null;
	int firstRow=0,firstCol=0;
	public void actionPerformed(ActionEvent e) {
		
		JButton evt=(JButton)e.getSource();
		for(int i =0;i<getsu;i++) {
			for(int j=0; j<getsu;j++) {
				if(evt==b[i][j]) {
					//첫번째 선택인가
					if(firstClick==null) {
						firstClick=evt;
						firstRow=i;
						firstCol=j;
						evt.setBackground(Color.PINK);
						evt.removeActionListener(this);
					}else {
						//두번째 선택인 경우
						//두개의 문자가 같다면
						if( answers[firstRow][firstCol]==answers[i][j]) {
							firstClick.setBackground(Color.BLUE);
							evt.setBackground(Color.BLUE);
							evt.removeActionListener(this);
						}else {
							firstClick.setBackground(null);
							evt.setBackground(null);
							firstClick.addActionListener(this);
							evt.addActionListener(this);
						}
//						evt.removeActionListener(this);
						
						firstClick = null;
						
					}
					//	evt.setBackground(Color.PINK);
				}
			}
		}
	}

}
