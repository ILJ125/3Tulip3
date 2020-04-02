package thread.basic;

public class Ex01_RunnableTest {
	public static void main(String[] args) {
		MakeCar2 mc1 = new MakeCar2("찿만들기");
		//Thread 에는 start 가 있으나 Runnable에는 없다.
		//start가 있는 Thread 객체를 만들어 줘야 한다.
		Thread t1 = new Thread(mc1);
		t1.start();
		
		//축약형
		new Thread(new MakeCar2("엔진부착악")).start();

	}

}

class MakeCar2 implements Runnable{
	String work;
	MakeCar2(String work){
		this.work=work;
	}
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println(work+"작업중");
			try {
				Thread.sleep(500);//0.5초 쉴레
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
