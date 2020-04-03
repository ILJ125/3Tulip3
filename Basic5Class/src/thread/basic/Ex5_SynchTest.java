package thread.basic;

//실행 되는 동안에 다른 애들이 절대 실행하지 못하게 하는거  synchronized
class Count{
	int i;
	void increment() {
		synchronized(this) { //메소드를 막는건 너무 위험해 //객체를 넣어줘야한다.근데 쓸만한게 없어서 this로 준다.
			i++;
		}
	}
}

class ThreadCount extends Thread{
	Count cnt=new Count();

	ThreadCount(Count cnt){
		this.cnt = cnt;
	}

	public void run() {
		for(int i=0; i<100000000;i++) {
			cnt.increment();
		}
	}
}
public class Ex5_SynchTest {

	public static void main(String[] args) {

		Count cnt = new Count();
		ThreadCount tc1 = new ThreadCount(cnt);
		tc1.start();
		ThreadCount tc2 = new ThreadCount(cnt);
		tc2.start();
		//thread는 호출해놓고 안받는다. 받아야해!!
		//그래서 왜 2억 출력이 안된다

		try {
			tc1.join();
			tc2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}//thread 애들이 끝날 때 까지 잠깐만 기다려줘
		//thread는 여러가지 동시에 할 때 각 작업을 잘게 쪼개서 원하는대로 막 한다.  
		System.out.println("i결과 : "+cnt.i);
	}
}

