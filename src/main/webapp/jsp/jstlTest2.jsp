<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
pageContext.setAttribute("score", 65);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>JSTL2.jsp 페이지입니다.</h1>
<pre>
1. ${score1} -- ${score2} -- ${score3} -- ${score4}
2. ${score21} -- ${score22} -- ${score23} -- ${score24}
<c:choose>
  <c:when test="${score>90}">
    <p>A학점</p>
  </c:when>
  <c:when test="${score>80}">
    <p>B학점</p>
  </c:when>
  <c:when test="${score>70}">
    <p>C학점</p>
  </c:when>
  <c:when test="${score>60}">
    <p>D학점</p>
  </c:when>
  <c:when test="${score<=60}">
    <p>F학점</p>
  </c:when>
</c:choose>

  <c:set var="total" value="0"/>
  <c:forEach begin="1" end="10" step="1" var="num">
    ${num}
    <c:set var="total" value="${total + num}"/>
  </c:forEach>
합계: ${total}
<%
pageContext.setAttribute("fruits", "망고, 바나나, 사과, 귤");
%>
<c:forTokens items="${fruits}" delims=", " var="f" varStatus="status">
  ${status.count} -- ${f}
</c:forTokens>
</pre>
<h1>지금 JSTL &nbsp; &nbsp; &nbsp; 연습중</h1>
<p>부서상세보기</p>
<c:redirect url="/dept/deptdetail">
  <c:param name="deptid" value="60"></c:param>
</c:redirect>
</body>
</html>