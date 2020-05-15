<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.beans.*" %>
<!-- 하나씩 천천히 도전합시다 -->
<% request.setCharacterEncoding("utf-8");%>

<jsp:useBean id="mem"  class="member.beans.Member">
	<jsp:setProperty name="mem" property="*"/>
</jsp:useBean>

<%
	MemberDao dao =MemberDao.getInstance();
	dao.insertMember(mem);
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 회원가입 확인  </title>
</head>
<body>
	아이디 :<%=mem.getId() %> <br>
	패스워드 :<%=mem.getPassword() %><br>
	이름 :<%=mem.getName() %> <br>
	전화 : <%=mem.getTel() %><br>
	주소 :<%=mem.getAddr() %> <br>
</body>
</html>