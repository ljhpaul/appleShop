<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<c:set var="score1" value="100" scope="page"/>
<c:set var="score2" value="200" scope="request"/>
<c:set var="score3" value="300" scope="session"/>
<c:set var="score4" value="400" scope="application"/>
<%
pageContext.setAttribute("score21", 99);
pageContext.setAttribute("score22", 88);
pageContext.setAttribute("score23", 77);
pageContext.setAttribute("score24", 66);
pageContext.setAttribute("score25", 55);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<pre>
1. ${score1} -- ${score2} -- ${score3} -- ${score4}
2. ${score21} -- ${score22} -- ${score23} -- ${score24}
</pre>
<c:import url="jstlTest2.jsp"></c:import>
</body>
</html>