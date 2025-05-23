<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.servletContext.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
  <script src="loginExternal.js"></script>
</head>
<body>
<h1>현재 접속자수: ${activeSessions}</h1>
<h1>로그인</h1>
<div class="container mt-3">
  <h2>기본경로(contextPath) : ${cpath}</h2>
  <!-- default path : http://localhost:9090 -->
  <form id="myfrm" action="${cpath}/auth/login" method="post">
    <div class="mb-3 mt-3">
      <label for=userid>사용자아이디(직원번호):</label>
      <input type="number" class="form-control" id="userid" placeholder="id입력" name="userid">
    </div>
    <div class="mb-3">
      <label for="pwd">Password(email):</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pswd">
    </div>
    <div class="form-check mb-3">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember" value="ok"> Remember me
      </label>
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
    <a class="btn btn-warning" href="${cpath}/emp/emplist.do">직원정보조회</a>
    <br>
    <h2>parameter test하기</h2>
    <label class="form-check-label">
      <input class="form-check-input" type="checkbox" name="subject" value="java"> 자바
    </label>
    <label class="form-check-label">
      <input class="form-check-input" type="checkbox" name="subject" value="db"> 데이터베이스
    </label>
    <label class="form-check-label">
      <input class="form-check-input" type="checkbox" name="subject" value="web"> 웹
    </label>
  </form>
  <%-- <p>${info}</p> --%>
<script>
var message = "${info}";
if(message != "") {
	alert("알림: " + message);
}
</script>
<c:set var="info" value="" scope="session"/>
<%-- session.setAttribute("info", "") --%>
</div>  
</body>
</html>