<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  h1 { width: 2000px; }
</style>
</head>
<body>
  <h1>[오류: <%=request.getAttribute("javax.servlet.error.status_code")%>] 존재하지 않는 주소입니다.</h1>
  <p>${pageContext.request.servletContext.contextPath}</p>
  <%
    String requestURL = request.getRequestURL().toString();
    out.print("<p>" + requestURL + "</p>");
  %>
  <div id="here">여기</div>
  <script>
    here.innerHTML = location.href;
  </script>
</body>
</html>