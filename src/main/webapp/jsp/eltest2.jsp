<%@page import="com.shinhan.model.job.JobDTO"%>
<%@page import="com.shinhan.model.dept.DeptVO"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="com.shinhan.model.emp.EmpService"%>
<%@page import="com.shinhan.model.emp.EmpDTO"%>
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
<h1>EL / JSTL 연습</h1>
<pre style="font-size:20px; font-weight:bold;">
<%-- loginEmp.first_name => 
	 EmpDTO emp = session.getAttribute("loginEmp") 
	 out.print(emp.getFirst_name()) 
--%>
<%
EmpService empService = new EmpService();

EmpDTO bean = new EmpDTO();
bean.setFirst_name("스티븐");
bean.setLast_name("킹");
EmpDTO bean2 = empService.selectById(101);
List<EmpDTO> emplist = empService.selectByCondition(new Integer[]{60}, "IT_PROG", 1000, "2000-01-01");
/* List<EmpDTO> emplist = empService.selectByDept(60); */
Map<String, Integer> studentmap = new HashMap<>();

studentmap.put("김", 100);
studentmap.put("양", 100);
studentmap.put("박", 100);

Map<String, EmpDTO> empMap = new HashMap<>();
empMap.put("대장", empService.selectById(100));
empMap.put("부대장", empService.selectById(101));
empMap.put("쫄병", empService.selectById(102));
//각 key별로 직원의 이름과 입사일 출력

//has-a관계인 경우
DeptVO deptVo = new DeptVO();
JobDTO job = new JobDTO("play", "sleeping~~", 1000, 2000); 
deptVo.setDepartment_id(100);
deptVo.setDepartment_name("개발부");
deptVo.setJob(job);

pageContext.setAttribute("empbean", bean);
pageContext.setAttribute("empbean2", bean2);		//DTO 1건
pageContext.setAttribute("empbean3", emplist);		//List
pageContext.setAttribute("empbean4", studentmap);	//Map
pageContext.setAttribute("empbean5", empMap);		//Map
pageContext.setAttribute("empbean6", deptVo);		//has-a 관계인 경우
%>
1. bean 사용 : ${empbean.first_name} ${empbean.last_name}
2. bean 사용 : ${empbean2.first_name} ${empbean2.last_name}
3. bean 사용(collection) : ${empbean3[0].first_name} ${empbean3[0].last_name}
<c:forEach items="${empbean3}" var="emp">
  ${emp.first_name} ... ${emp.salary} ... ${emp.hire_date}
</c:forEach>
4. bean 사용(map) : ${empbean4.김}
4. bean 사용(map) : ${empbean4["김"]}
4. bean 사용(map) : ${empbean4["박"]}
<c:forEach items="${empbean4}" var="student">
  ${student.key} ===> ${student.value}
</c:forEach>
<hr>
5.map에 저장된 data 읽기 :
<c:forEach items="${empbean5}" var="emp">
  ${emp.key} ===> 이름: ${emp.value.first_name} ${emp.value.last_name}, 입사일: ${emp.value.hire_date}
</c:forEach>
<hr>
6.has-a : ${empbean6.job.jobId}
6.has-a : ${empbean6.job.jobTitle}
</pre>
</body>
</html>