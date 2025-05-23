<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table, th, td { 
		border: 1px solid black;
		border-collapse: collapse;
		text-align: center;
	}
	th, td { padding: 3px; }
</style>
<script>
window.onload = function() {
	validateCheckbox;
}

function validateCheckbox() {
	const checkboxes = document.querySelectorAll("input[name='del']:checked");
	if(checkboxes.length < 1) {
		alert("하나 이상의 항목을 선택해주세요.");
		return false;
	}
	return confirm('선택한 부서를 삭제하시겠습니까?');
}
</script>
</head>
<body>
  <%-- 정적자원, jsp를 합쳐서 컴파일한다. (URL로 접근한 게 아니기 때문에 상대경로 사용) --%>
  <%@ include file="../common/header.jsp" %>
  <h1>${myName}</h1>
  <%-- ${deptListData} --%>
  <h1>부서목록 조회</h1>
  <button onclick="location.href='${pageContext.request.servletContext.contextPath}'">돌아가기</button>
  <form action="${cpath}/dept/deptdelete" method="post"
		onsubmit="return validateCheckbox();">
  <input type="submit" value="선택삭제"/>
  <table border="1"> <!-- class="table table-striped" -->
	<thead>
	  <tr>
		<th>선택</th>
		<th>부서코드</th>
		<th>부서이름</th>
		<th>매니저번호</th>
		<th>지역코드</th>
		<th>삭제</th>
	  </tr>
	</thead>
	<tbody>
	  <c:forEach items="${deptListData}" var="dept">
	    <tr>
	      <td><input type="checkbox" name="del" value="${dept.department_id}"></td>
	      <td><a href="deptdetail?deptid=${dept.department_id}">${dept.department_id}</a></td>
	      <td>${dept.department_name}</td>
	      <td>${dept.manager_id}</td>
	      <td>${dept.location_id}</td>
	      <td><a href="deptdelete?deptid=${dept.department_id}"><img src="../images/delete.png"></a></td>
	    </tr>
	  </c:forEach>
	</tbody>
  </table>
  </form>
</body>
</html>