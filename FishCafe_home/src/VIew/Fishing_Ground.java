package VIew;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Fishing_Ground extends JFrame{
	//멤버변수 선언
	MainView main;
	EventView evnt;
	//메인화면구성
	public Fishing_Ground() {
		super("실내낚시터");
		//각각의 화면을 관리하는 클래스 객체 생성
		main=new MainView();
		evnt =new EventView();
		// 각 탭부여
		JTabbedPane pane = new JTabbedPane();
		pane.add("메인",main);
		pane.add("이벤트",evnt);
		// 화면사이즈
		add(pane);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(1980,1000);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		 new Fishing_Ground();
		}	
	}

