<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.beans.*" %>

<% request.setCharacterEncoding("utf-8");%>
<%
	MemberDao dao =MemberDao.getInstance();
%>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 아이디 중복 확인 </title>
<script type="text/javascript" src='../lib/jquery-3.5.1.min.js'></script>
<script type="text/javascript">
$(function(){
	$('#selectid').click(function(){
		var id=$('input[name=userId]').val();
		alert(id);
		window.opener.document.frm.id.value=id;
		self.close();
	});
	
});
</script>
</head>
<body>
<%
String id=request.getParameter("userId");
	if(  dao.isDuplicatedId(id)) {
%>
		사용중인 아이디가 있습니다. 다시 입력하여 주십시오.
<%  }else { %>
		사용할 수 있는 아이디입니다.
<%  } %>

<form >
	<input type = "text" name='userId' value='<%=id %>'>
	<input type = "submit" value="중복확인">
	<input type = "button" id="selectid" value="아이디채택">
</form>

</body>
</html>