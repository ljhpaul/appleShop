<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.servletContext.contextPath}"></c:set>
<%-- <%
	EmpDTO emp = (EmpDTO) request.getAttribute("emp");
	out.print(emp);
%> --%>
<%-- ${emp} --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#emp_id_input { background-color: #E1F6FA }
</style>
</head>
<body>
	<%-- 정적자원, jsp를 합쳐서 컴파일한다. (URL로 접근한 게 아니기 때문에 상대경로 사용) --%>
	<%@ include file="../common/header.jsp" %>
	<h1>${emp.last_name} 직원 상세보기</h1>
	<hr>
	<form action="${cpath}/emp/empupdate.do" method="post">
		<input type="hidden" name="job" value="update">
		<fieldset>
			<label>직원번호: </label><input id="emp_id_input" readonly="readonly" type="number" name="employee_id" value="${emp.employee_id}"><br>
			<label>성: </label><input type="text" name="first_name" value="${emp.first_name}"><br>
			<label>이름: </label><input type="text" name="last_name" required="required" value="${emp.last_name}"><br>
			<label>이메일: </label><input name="email" required="required" value="${emp.email}"><br>
			<label>급여: </label><input type="number" name="salary" required="required" value="${emp.salary}"><br>
			<label>부서: </label>
			<select name="department_id">
				<c:forEach items="${deptlist}" var="dept">
					<option ${dept.department_id==emp.department_id?"selected":""} value="${dept.department_id}">${dept.department_name}</option>
				</c:forEach>
			</select><br>
			<label>커미션: </label><input type="number" name="commission_pct" value="${emp.commission_pct}"><br>
			<label>매니저: </label><input type="number" name="manager_id" value="${emp.manager_id}"><br>
			<label>전화번호: </label><input name="phone_number" value="${emp.phone_number}"><br>
			<label>직책: </label>
			<select name="job_id">
				<c:forEach items="${joblist}" var="job">
					<option ${job.jobId==emp.job_id?"selected":""} value="${job.jobId}">${job.jobTitle}</option>
				</c:forEach>
			</select><br>
			<label>입사일: </label><input type="date" name="hire_date" required="required" value="${emp.hire_date}"><br>
		</fieldset>
		<fieldset>
			<input type="button" onclick="location.href='${cpath}/emp/emplist.do'" value="확인">
			<input type="submit" value="수정">
		</fieldset>
	</form>
</body>
</html>