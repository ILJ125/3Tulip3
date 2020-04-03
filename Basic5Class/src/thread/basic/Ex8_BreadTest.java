package thread.basic;

class Bread 
{
	String bread;

	//## 
	boolean isCheck = false;

	public void setBread( String bread )
	{	//빵만들기
		this.bread = bread;
		//## 
		//set이 먼저 불려져야 한다.
		isCheck =true;
		synchronized (bread) {
			notifyAll();
		} // 블랑킷 되있는거 다아 부른다.
	

	}	

	public String getBread()
	{	//빵꺼내는거
		//## 		
		if(!isCheck) {
			try {
				synchronized (bread) {
					wait();//wait로 spleep이 끝날 때까지 기다려줄게
					//혼자서 못내려옴 꺼내 받아서 run()으로 다시 내려와야하는데
					//notifyall은 안에든거 전부 가져오는거
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else
		{
			
		}
		
		return bread;
	}
}

class Baker extends Thread
{	//빵만드는 베이커
	Bread bbang;

	Baker( Bread bbang )
	{
		this.bbang = bbang;
	}
	public void run()
	{
		bbang.setBread("진열된 완성된 맛있는 빵");
	}
}

class Customer extends Thread
{	//빵살련는 고객
	Bread bbang;

	Customer( Bread bbang )
	{
		this.bbang = bbang;
	}
	public void run()
	{
		System.out.println("빵을 사감 : " + bbang.getBread());
	}
}

class Ex8_BreadTest
{
	public static void main(String[] args) 
	{
		Bread  bread = new Bread();

		Baker  baker = new Baker( bread );
		Customer customer = new Customer( bread );
		customer.start();
		baker.start();

		try{
			customer.join();
			baker.join();			
		}catch( Exception ex ){}

	}
}
