package jdbc.gui;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InfoModel {

	void insert(InfoVO vo) throws SQLException;
	ArrayList<InfoVO> selectAll() throws SQLException;
	void delete(String tel) throws SQLException;
	InfoVO selectByTel(String tel) throws SQLException;
	
	void modify(InfoVO vo) throws SQLException;
}
