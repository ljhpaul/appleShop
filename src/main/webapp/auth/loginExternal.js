window.onload = function() {
	var remember = localStorage.getItem("remember");
	if(remember) {
		document.querySelector("#userid").value = localStorage.getItem("userid");
		document.querySelector("#pwd").value = localStorage.getItem("pwd");
		document.querySelector("input[name='remember']").checked = true;
	}
	
	
	//onsubmit: default 핸들러가 제공된다. 수행 후 서버에 전송된다.
	document.querySelector("#myfrm").onsubmit = function() {
		
		var userid = document.querySelector("#userid").value;
		var pwd = document.querySelector("#pwd").value;
		var remember = document.querySelector("input[name='remember']").checked;
		
		//localStorge: 브라우저에 저장, 브라우저가 닫혀도 사라지지 않고 남아있다.
		if(remember) {
			localStorage.setItem("userid", userid);
			localStorage.setItem("pwd", pwd);
			localStorage.setItem("remember", remember);
		} else {
			localStorage.removeItem("userid");
			localStorage.removeItem("pwd");
			localStorage.removeItem("remember");
		}
		
		//서버전송 취소시에 사용
		//return false;
	};
	
}