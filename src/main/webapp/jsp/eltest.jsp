<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>EL(Expression Language)</h1>
  <%
    String subject = "자바"; 
    pageContext.setAttribute("data", subject);
  %>
  <fieldset style="width: 1200px;">
    <pre style="font-size: 18px; font-weight: bold;"><!-- 입력한 양식대로 보여주기(엔터도 인식~!) -->
    1. Script Let 표현식 : <%=subject%>
    2. EL 표현식(변수접근불가) : ${subject==null?'null':subject}
    2. EL 표현식(getAttribute) : ${data}
    3. EL의 내장객체도 있음 : ${sessionScope.dept}
    4. data type : ${100} ${"문자"} ${10+20} ${"100"+1} ${100}점
    
    5. eq : ( 100 == 100 ) : ${100 == 100}
            ( "100" == "100" ) : ${"100" == "100"}
            ( "100" eq "100" ) : ${"100" eq "100"}
            ( data eq "자바!" ) : ${data eq "자바!"}
    
    6. 논리연산자 || : ${data eq "자바!" || "100" eq "100"}
    6. 논리연산자 or : ${data eq "자바!" or "100" eq "100"}
    6. 논리연산자 && : ${data eq "자바!" && "100" eq "100"}
    6. 논리연산자 and  : ${data eq "자바!" and "100" eq "100"}
    <%
    ArrayList<String> datas = new ArrayList<>();
    datas.add("자바");
    pageContext.setAttribute("datalist", datas);
    pageContext.setAttribute("lunch", "");
    %>
    7. empty : ${empty datalist}
    7. empty : ${empty lunch}
    7. not empty : ${empty datalist}
    7. not empty : ${empty lunch}
    
    8. EL의 내장객체 : scope(pageScope, requestScope, sessionScope, applicationScope)
    8. EL의 내장객체(param -> ?myname=이정헌) : ${param.myname}
    8. EL의 내장객체(param -> &myage=10&myage=20) : ${paramValues.myage}
    8. EL의 내장객체(header) : ${header["User-Agent"]}
    <c:forEach items="${paramValues.myage}" var="age">
      ${age}
    </c:forEach>
    8. Script Let Expression 이용 : <%=request.getParameter("myname")%>
    </pre>
  </fieldset>
</body>
</html>