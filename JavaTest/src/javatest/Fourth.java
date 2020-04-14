package javatest;

public class Fourth {

	public static void main(String[] args) {
		account acc=new account("자바맨","123-456",10000);
		
		acc.deposit(15000);
		acc.withdraw(30000);//인출 = 출금

	}

}
