<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>로그인 페이지</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<form action="login" method="post">
<h1>로그인</h1>
<input type="text" name="user_id"><br>
비밀번호 <br>
<input type="text" name="user_pwd"> <br>
<button id="joinBtn">회원가입</button> &ensp; &ensp; &ensp;
<button type="submit" value="로그인">로그인<br></button>
</form>
<button id="findIDBtn">아이디 찾기</button>
<button id="findPWBtn">비밀번호 찾기</button>
<script>
	var findIdBtn = document.getElementById('findIDBtn');
	var findPwBtn = document.getElementById('findPWBtn');
	var joinBtn = document.getElementById('joinBtn');
	
	findIdBtn.addEventListener('click', function(event) {
		event.preventDefault();
		window.location.href="findID.jsp";
	});
	
	findPwBtn.addEventListener('click', function(event) {
		event.preventDefault();
		window.location.href="findPW.jsp";
	});
	
	joinBtn.addEventListener('click', function(event) {
		event.preventDefault();
		window.location.href="join.jsp";
	});
</script>
</body>
</html>