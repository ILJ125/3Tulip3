package thread.basic;

public class EX1_ThreadTest {

	public static void main(String[] args) {
		MakeCar1 work1=new MakeCar1("소리");
		work1.start();
		MakeCar1 work2=new MakeCar1("땡떙");
		work2.start();

	}

}
class MakeCar1 extends Thread{
	String work;
	
	MakeCar1(String work){
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
