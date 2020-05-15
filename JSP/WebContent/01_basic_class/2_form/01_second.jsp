<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="temp.*" %>

<!-- 클라이언트 -> 서버 : request(요청) 
 서버 -> 클라이언트 : response(응답) -->


<%
	String user = request.getParameter("User");
	String pass = request.getParameter("Pass");
	String success=null;
	
	//1.TempVO 객체에 멤버로 위의 값들을 지정
	tempVO vo =new tempVO();
	vo.setId(user);
	vo.setPass(pass);
	//2.TempDAO 의 login()를 호출하기
TempDao dao = TempDao.getInstance();
	boolean result= dao.login(vo);
	//로그인 성공 여부 출력하기
	if(result){
		success="성공";
	}
// 	if(!result){
// 		response.sendRedirect("01_first.jsp");
// 	}else if(result){
// 		success="성공";
// 	}
	
%> 
   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 폼의 입력값 처리 </title>
</head>
<body>
	<h2>폼의 입력값 넘겨받아 처리</h2>
	로그인 성공 여부 : <%=result%><br/>
	입력한 아이디 :<%=user %>  <br/>
	입력한 패스워드 : <%=pass %> 
</body>
</html>