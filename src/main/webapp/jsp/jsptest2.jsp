<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
application.setAttribute("score", 100);
session.setAttribute("score", 200);
request.setAttribute("score", 300);
pageContext.setAttribute("score", 400);
// pageContext > request > session > application

out.print("<h1>당신의 점수</h1>");
%>

<%
//강제 오류 발생
int a = 10/0;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <p>점수1 : ${applicationScope.score}	- [application]</p>
  <p>점수2 : ${sessionScope.score}	- [session]</p>
  <p>점수3 : ${requestScope.score}	- [request]</p>
  <p>점수4 : ${pageScope.score}	- [pageContext]</p>
  <p>점수5 : ${score}		(pageContext > request > session > application)</p>
</body>
</html>