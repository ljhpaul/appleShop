<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//default event에 대하여 ... 이미 제공되는 이벤트 핸들러가 있다.
	window.onload = function() {
		var frmObj = document.querySelector("#myfrm");
		
		//2)고전방식으로 이벤트와 이벤트 핸들러를 연결
		frmObj.onsubmit = function(event) {
			var deptnameObj = document.querySelector('input[name="department_name"]');
			var deptname = deptnameObj.value;
			if(deptname.length < 5) {
				alert("부서이름은 5자리 이상입니다.");
				deptnameObj.focus();
				//default event 취소하기
				// 1) return false;
				// 2) event.preventDefault();
				event.preventDefault();
				return;
			}
			
			alert("서버에 전송된다.");
		};
	};
	
	//1)inline방식으로 이벤트와 이벤트 핸들러를 연결
	function call() {
		var deptnameObj = document.querySelector('input[name="department_name"]');
		var deptname = deptnameObj.value;
		if(deptname.length < 5) {
			alert("부서이름은 5자리 이상입니다.");
			deptnameObj.focus();
			//default event 취소하기
			// 1) return false;
			return false;
			// 2) event.preventDefault();
			/* event.preventDefault();
			return; */
		}
		
		alert("서버에 전송된다.");
	}
</script>
</head>
<body>

<p>${sessionScope.dept }</p>

  <%-- 정적자원, jsp를 합쳐서 컴파일한다. (URL로 접근한 게 아니기 때문에 상대경로 사용) --%>
  <%@ include file="../common/header.jsp" %>
	<h1>부서입력</h1>
	<hr>
	<form id="myfrm" action="${pageContext.request.servletContext.contextPath}/dept/deptinsert" method="post">
		<input type="hidden" name="job" value="insert">
		<fieldset>
			<label>부서코드: </label><input type="number" name="department_id" required="required" autofocus="autofocus"> <br>
			<label>부서이름: </label><input name="department_name"> <br>
			<label>매니저번호: </label><input name="manager_id" placeholder="존재하는 직원번호"> <br>
			<label>지역코드: </label><input name="location_id" placeholder="존재하는 지역코드"> <br>
			<label>부서소개: </label><br> <textarea rows="5" cols="80"></textarea>
		</fieldset>
		<fieldset>
			<input type="submit" value="입력">
			<input type="reset" value="초기화">
			<input type="button" onclick="location.href='${cpath}'" value="취소">
		</fieldset>
	</form>
</body>
</html>