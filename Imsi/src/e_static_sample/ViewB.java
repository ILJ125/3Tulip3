package e_static_sample;

public class ViewB {
	DBConect db;//조합형은 자동 초기화 null

	public ViewB() {
		db = DBConect.getInstance();
	}

	public void use() {
		System.out.println("디비 작업 중");
	}
}
