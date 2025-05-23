<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="empAll.js"></script>
<script type="text/javascript">
$(()=>{
	//()=>{} 화살표함수에서의 this는 window, bind함수로 object를 bind()하여 this설정가능
	$("#search2").on("keyup", function() {
		var inputData = $(this).val();
		console.log(inputData);
		$("tbody tr").hide();
		$(`td:contains(\${inputData})`).parent().show();  //<tr><td>aa</td></tr>
	});
});
</script>
<link rel="stylesheet" href="empAll.css"/>
</head>
<body>
  <!-- 정적자원, jsp를 합쳐서 컴파일한다. (URL로 접근한 게 아니기 때문에 상대경로 사용) -->
  <%@ include file="../common/header.jsp" %>
  <!-- 동적자원, 각 jsp를 컴파일 후 합침 | JSTL은 자동으로 contextpath(/appleShop : 절대경로) 인식 -->
  <%-- <c:import url="/common/header.jsp"></c:import> --%>
  <!-- HTML 태그는 contextpath 인식 못함 -->
  <%-- <img src="${cpath}/images/delete.png"/> --%>
  
  
  <div id="container">
    <h1 class="title">직원목록 조회</h1>
	<button onclick="location.href='${cpath}/emp/empinsert.do'" class="btn btn-light">신규직원등록</button>
	<hr>
	  <label>급여: </label>
	  <input id="inputSalary">
	  <button id=search1>직원찾기(스타일변경)</button>
	  <label>|</label>
	  <label>특정문자로 직원찾기: </label>
	  <input type="text" id=search2></button>
	<hr>
	<button onclick="location.href='${cpath}'" class="btn btn-light">돌아가기</button>
	<table class="table table-striped"> <!-- class="table" -->
	  <thead>
		<tr>
		  <th>순서</th>
		  <th>로그인여부</th>
		  <th>직원번호</th>
		  <th>성</th>
		  <th>이름</th>
		  <th>이메일</th>
		  <th>급여</th>
		  <th>부서</th>
		  <th>커미션</th>
		  <th>매니저</th>
		  <th>전화번호</th>
		  <th>직책</th>
		  <th>입사일</th>
		  <th>삭제</th>
		</tr>
	  </thead>
	  <tbody>
	    <!-- HTML주석 : HTML해석기가 해석 안함을 의미, ${aa} -->
	    <%-- JSP주석 : JSP해석기가 해석 안함 Tomcat이 JSP를 해석후 HTML로 만듦. 
	    	 HTML문서에는 남지 않음. ${}
	    	 request.getAttribute(emplist); 
	    	 
	    	 ${emp.employee_id} => ${emp} => EmpDTO emp = getAttribute("emp")
	    	 emp.getEmployee_id()
	    	 
	    	 --%>
		<c:forEach items="${emplist}" var="emp" varStatus="status">
		<tr>
		  <td>${status.index} 🥰 ${status.count} 🙌 ${status.first?"처음":""} ${status.last?"마지막":""} </td>
		  <td>
		    <c:if test="${loginEmp.employee_id == emp.employee_id}">
		      <span class="login">접속중</span> 
		    </c:if>
		    <c:if test="${loginEmp.employee_id != emp.employee_id}">
		      <span class="logout"> - </span> 
		    </c:if>
		  </td>
		  <td><a href="${cpath}/emp/empdetail.do?empid=${emp.employee_id}">${emp.employee_id}</a></td>
		  <td>${emp.first_name}</td>
		  <td>${emp.last_name}</td>
		  <td>${emp.email}</td>
		  <td>${emp.salary}</td>
		  <td class="emp_salary">
		  	<fmt:formatNumber type="currency" currencySymbol="$"
		  	groupingUsed="true" value="${emp.salary}" />
		  </td>
		  <td>${emp.department_id}</td>
		  <td>${emp.commission_pct}</td>
		  <td>${emp.manager_id}</td>
		  <td>${emp.phone_number}</td>
		  <td>${emp.job_id}</td>
 		  <td>
		  	<fmt:formatDate pattern="YYYY-MM-dd hh:mm:ss"
		  	value="${emp.hire_date}" />
		  </td>
		  <td>${emp.hire_date}</td>
		  <td><a href="empdelete.do?empid=${emp.employee_id}" 
		  	     onclick="return confirm('${emp.employee_id}번 직원을 삭제하시겠습니까?')">
		  	   <c:if test="${status.index%2==0}">
		  	     <img src="${cpath}/images/delete.png" />
		  	   </c:if>
		  	   <c:if test="${status.index%2==1}">
		  	     <img src="${cpath}/images/delete3.png" width="33" />
		  	   </c:if>
		  	  </a>
		  </td>
		</tr>
		</c:forEach>
	  </tbody>
	</table>
  </div>
</body>
</html>