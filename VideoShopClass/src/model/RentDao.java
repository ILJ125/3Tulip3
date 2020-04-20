package model;

import java.util.ArrayList;

public interface RentDao {
	public String selectByTel(String tel) throws Exception;//전화번호 에서 엔터 치면 고객명 뜸
	public void rentVideo(String tel, String vnum) throws Exception; //비디오 빌려주기
	public void returnVideo(String vnum) throws Exception;//반납
	public ArrayList selectList() throws Exception;//미반납된 비디오 리스트
}
