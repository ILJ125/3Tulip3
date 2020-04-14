package jdbc.gui;

public class InfoVO {
	//Value Object : 데이터 모아놓은거
	
	String name;
	String jumin;
	String tel;
	String gender;
	int age;
	String home;
	
	public InfoVO(){}
	public InfoVO(String name, String jumin, String tel, String gender, int age, String home){
		this.name=name;
		this.jumin =jumin;
		this.tel=tel;
		this.gender=gender;
		this.age=age;
		this.home=home;
	}
	public String toString() {
		
		return name + "\t" +jumin +"\t"+tel+"\t"+gender+"\t"+age+"\t"+home+"\n";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	

}
