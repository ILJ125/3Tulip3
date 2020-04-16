package jfreechart;

import java.sql.*;
import java.util.*;

public class Database {

	String URL = "jdbc:oracle:thin:@192.168.0.66:1521:orcl";
	String USER ="scott";
	String PASS = "tiger";

	public ArrayList<ArrayList> getData() {

		ArrayList<ArrayList> data = new ArrayList<ArrayList>();
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(URL, USER , PASS);	
			
			//***************************************************************
			//String sql = "SELECT sal, ename FROM emp";
			String sql = "select up.sal sal,up.ename ename\r\n" + 
					"from (select nvl(sal,0)sal,ename from emp order by sal desc) up\r\n" + 
					"where rownum<=5";
			
			
			//***************************************************************
			
			PreparedStatement stmt = con.prepareStatement( sql );	

			ResultSet rset = stmt.executeQuery();

			
			while( rset.next() ){
				ArrayList temp = new ArrayList();
				temp.add( rset.getInt("sal"));	
				temp.add( rset.getString("ename"));				//****************
					//****************		
				data.add(temp);
			}
			rset.close();
			stmt.close();
			con.close();
		} catch(Exception ex){
			System.out.println("에러 : " + ex.getMessage() );
		}
		return data;
	}
}
