<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>[오류: <%=request.getAttribute("javax.servlet.error.status_code")%>] 프로그램에 문제 발생</h1>
  <p><%=exception%></p>
  <p><%=exception.getMessage()%></p>
</body>
</html>