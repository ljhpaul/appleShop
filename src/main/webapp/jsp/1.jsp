<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>JSP 1페이지입니다.</h1>
  <%-- Bean(객체) 만들기 --%>
  <%-- DeptDTO dept = new com.shinhan.model.dept.DeptDTO(); 
  	   dept.setDepartment_id(21);
  	   dept.setDepartment_name("개발부"); --%>
  <%-- <jsp:useBean id="dept" class="com.shinhan.model.dept.DeptDTO" scope="page"/> --%>
  <%-- <jsp:useBean id="dept" class="com.shinhan.model.dept.DeptDTO" scope="request"/> --%>
  
  <jsp:useBean id="dept" class="com.shinhan.model.dept.DeptDTO" scope="session"/>
  <jsp:setProperty property="department_id" value="21" name="dept"/>
  <jsp:setProperty property="department_name" value="개발부" name="dept"/>
  
  <hr>
  <h2>1.jsp페이지에서 Bean값 얻기</h2>
  부서번호: <jsp:getProperty property="department_id" name="dept"/><br>
  부서명 : <jsp:getProperty property="department_name" name="dept"/>
  
  
  <%-- 표준(jsp로 시작) 액션태그
  	include는 page를 컴파일 후 합친다.
  	(그 페이지에 있는 변수 사용불가)
   --%>
  <%-- <jsp:include page="2.jsp"></jsp:include> --%>
  <jsp:forward page="2.jsp"></jsp:forward>
  <%-- <%@ include file="2.jsp" %> --%>
  <%-- <%=name %> --%>
</body>
</html>