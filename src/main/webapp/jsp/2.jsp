<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>JSP 2페이지입니다.</h1>
<%
String name = "자바";
%>
  
  <jsp:useBean id="dept" class="com.shinhan.model.dept.DeptDTO" scope="session"/>
  
  <h2>1.jsp페이지에서 Bean값 얻기</h2>
  부서번호: <jsp:getProperty property="department_id" name="dept"/><br>
  부서명 : <jsp:getProperty property="department_name" name="dept"/>

</body>
</html>