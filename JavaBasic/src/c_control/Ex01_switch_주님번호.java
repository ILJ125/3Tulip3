package c_control;

public class Ex01_switch_주님번호 {
	public static void main(String[] args) {
		
		String id="200316-4534567";
		char id_hometown= id.charAt(8);
		String home ="";
		
		switch(id_hometown) {
		case '0' : home = "서울"; break;
		case '1' : home = "인천/부산"; break;
		case '3' : home ="경기도";break;
		default : home = "한국인";break;
		}System.out.println("출신지"+home);
		
		
	}
	

}
