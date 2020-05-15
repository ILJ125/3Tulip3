package info.beans;

//Bean : VO
public class InfoBean {
	//멤버 변수 =Property
	private String name;
	private String id;
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGender() {
		String gender="";
		char sex = id.charAt(7);
		if(sex=='1'|sex=='3') { gender ="남자";}
		else if(sex=='2'|sex=='4') {gender="여자";}
		return gender;
	}
}
