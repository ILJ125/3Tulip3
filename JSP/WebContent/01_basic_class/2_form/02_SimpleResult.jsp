<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<% String name =request.getParameter("name"); %>
<% String gender=request.getParameter("gender"); %>
<% String job=request.getParameter("occupation"); %>
<% String [] hobby=request.getParameterValues("hobby");%>
<% String result="";
for(int i=0;hobby!=null && i<hobby.length;i++){
result+=hobby[i];
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02_SimpleResult</title>
</head>
<body>
<h2>폼의 입력값 넘겨받아 처리</h2>
	입력한 이름 :<%=name %>  <br/>
	입력한 성별 : <%=gender %> <br/>
	입력한 직업 : <%=job %> <br/>
	입력한 취미 : <%=result %>
<%-- 	입력한 취미 : <%if(hobby==null){%> --%>
<%-- <%="입력한 취미가 없습니다." %> --%>
<%-- 	<% }else{ --%>
<%-- 		for(int i=0;i<hobby.length;i++){%>  --%>
<!-- 	} -->
<%-- 	<%=hobby[i]%> --%>
<%-- 	<% }//for문%> --%>
<%-- 	<% }//else if 문%>	 --%>
</body>
</html>