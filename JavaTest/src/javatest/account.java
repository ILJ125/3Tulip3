package javatest;

public class account {

	String name;// 예금주
	String id; // 계좌 번호
	int balance;// 잔액

	public account(String name, String id, int balance) {
		this.name=name;
		this.id=id;
		this.balance=balance;
		System.out.println(toString());
	}
	// 인출
	public void withdraw(int out_money) {
		if (balance < out_money) {
			System.out.println("잔액이 부족합니다.");
		} else {
			balance -= out_money;
			System.out.println("인출한 금액" + out_money);
		}
	}

	// 입금
	public void deposit(int in_money) {
		balance += in_money;
		System.out.println("입금한 금액 : " + in_money + "\n입금 후 잔액 : " + balance);
	}
	
	public String toString() {
		
	return "예금주: "+this.name +", 계좌번호:"+this.id +", 잔액:"+balance ;	
	}

}
