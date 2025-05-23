<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <meta http-equiv="Refresh" content="3;url=emplist.do"> -->
<title>${resultMessage}</title>
<script>
  alert(`${resultMessage}`);
  location.href = `${pageContext.servletContext.contextPath}/emp/emplist.do`;
</script>
</head>
<body>
  <h1>${resultMessage}</h1>
  <a href="emplist.do">목록보기</a>
</body>
</html>