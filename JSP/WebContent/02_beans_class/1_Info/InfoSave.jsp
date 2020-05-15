<%@ page contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8"%>

<%@ page import="info.beans.InfoBean" %>

<% request.setCharacterEncoding("utf-8");%>
<!-- //InfoBean bean = new InfoBean(); -->
<jsp:useBean id="bean" class="info.beans.InfoBean">
	<jsp:setProperty name="bean" property="*"/>
<%-- 		<jsp:setProperty name="bean" property="id"/> --%>
	
</jsp:useBean>

<!DOCTYPE html>
<html>
<body>
	<h2>  당신의 신상명세서 확인 </h2>
	이   름  : <jsp:getProperty name="bean" property="id"/><br/>
	주민번호 :<jsp:getProperty name="bean" property="name"/> <br/>
	성  별   :<jsp:getProperty name="bean" property="gender"/> <br/>  
	bean.getId()
</body>
</html>