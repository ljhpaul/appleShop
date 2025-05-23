<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	label {
		display: inline-block;
		width: 75px;
		text-align: center;
		padding: 1px;
	}
	select, input#calender {
		text-align: center;
		width: 170px;
	}
</style>
</head>
<body>
  <%-- 정적자원, jsp를 합쳐서 컴파일한다. (URL로 접근한 게 아니기 때문에 상대경로 사용) --%>
  <%@ include file="../common/header.jsp" %>
	<h1>신규 직원 등록</h1>
	<hr>
	<form action="${cpath}/emp/empinsert.do" method="post">
		<input type="hidden" name="job" value="insert">
		<fieldset>
			<label>직원번호: </label><input type="number" name="employee_id" required="required" autofocus="autofocus"><br>
			<label>성: </label><input type="text" name="first_name"><br>
			<label>이름: </label><input type="text" name="last_name" required="required"><br>
			<label>이메일: </label><input name="email" required="required"><br>
			<label>급여: </label><input type="number" name="salary" required="required"><br>
			<label>부서: </label>
			<select name="department_id">
			  <c:forEach items="${deptlist}" var="dept">
			    <option value="${dept.department_id}">${dept.department_name}</option>
			  </c:forEach>
			</select><br>
			<label>커미션: </label><input type="number" name="commission_pct"><br>
			<label>매니저: </label><!-- <input type="number" name="manager_id"><br> -->
			<select name="manager_id">
			  <option></option>
			  <c:forEach items="${emplist}" var="emp">
			    <option value="${emp.employee_id}">${emp.first_name} ${emp.last_name}</option>
			  </c:forEach>
			</select><br>
			<label>전화번호: </label><input name="phone_number"><br>
			<label>직책: </label>
			<select name="job_id">
			  <c:forEach items="${joblist}" var="job">
			    <option value="${job.jobId}">${job.jobTitle}</option>
			  </c:forEach>
			</select><br>
			<label>입사일: </label><input type="date" name="hire_date" required="required" id="calender"><br>
		</fieldset>
		<fieldset>
			<input type="submit" value="입력">
			<input type="reset" value="초기화">
			<input type="button" onclick="location.href='${cpath}/emp/emplist.do'" value="취소">
		</fieldset>
	</form>
</body>
</html>