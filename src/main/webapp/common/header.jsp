<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="cpath" value="${pageContext.servletContext.contextPath}"></c:set>

<!-- 빈 파비콘 (브라우저 요청 방지) -->
<link rel="icon" href="data:;base64,iVBORw0KGgo=">
  
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

<style>
  .myclass {
    background-color: beige;
    width: 250px;
  }
</style>
<p class="myclass">${loginEmp==null?"guest":loginEmp.first_name} ${loginEmp.last_name}님 환영합니다.</p>
<a class="${loginEmp==null?'btn btn-success':'btn btn-danger'}" href="${cpath}/auth/${loginEmp==null?'login':'logout.do'}">${loginEmp==null?'로그인':'로그아웃'}</a>
<hr>




