<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import='temp.*'%>

<!--     폼의 입력값을 얻어오기 아이디,비밀번호,이름,전화번호,주소 -->
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pass = request.getParameter("password");
	String name = request.getParameter("name");
	String tel = request.getParameter("tel");
	String addr = request.getParameter("adr");
%>

<%
	tempVO vo = new tempVO();

	vo.setId(id);
	vo.setPass(pass);
	vo.setName(name);
	vo.setTel(tel);
	vo.setAddr(addr);

	TempDao dao = TempDao.getInstance();
	dao.insert(vo);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 result</title>
</head>
<body>
	<h3>입력한 값</h3>
	<br /> 아이디:<%=id%><br /> 비밀번호:<%=pass%><br /> 이름:<%=name%><br />
	전화번호:<%=tel%><br /> 주소:<%=addr%><br />

</body>
</html>