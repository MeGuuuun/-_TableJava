<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>로그인 페이지</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="css/login.css">
</head>
<body>
	<div class="container">
		<form action="login" method="post">
			<img src="image/logo.png">
			<div class="input-group">
				<label for="user_id">아이디</label>
				<input type="text" name="user_id" required>
			</div>
			<div class="input-group">
				<label for="user_pwd">비밀번호</label>
				<input type="text" name="user_pwd" required>
			</div>
			<button type="submit" value="로그인" class="login-btn">로그인<br></button>
		</form>
		<div class="links">
			<button id="joinBtn" class="link-btn">회원가입</button>
			<button id="findIDBtn" class="link-btn">아이디 찾기</button>
			<button id="findPWBtn" class="link-btn">비밀번호 찾기</button>
		</div>
	</div>
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