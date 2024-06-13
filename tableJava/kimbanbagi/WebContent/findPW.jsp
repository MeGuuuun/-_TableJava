<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기 페이지</title>
<link rel="stylesheet" href="css/findPW.css">
</head>
<body>
	<div class="container">
		<h1>비밀번호 찾기</h1>
		<form action="findPW" method="post">
			<div class="input-group">
				ID : <br>
				<input type="text" name="userID" >
			</div>
			<div class="input-group">
				<br> NAME : <br>
				<input type="text" name="userName">
			</div>
			<input type="submit" value="비밀 번호 찾기" class="submit-btn"></button>
		</form>
	</div>
</body>
</html>