<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 성공</title>
<link rel="stylesheet" type="text/css" href="css/findID_ON.css">
</head>
<body>
    <div class="container">
    	<div class="first">
    		<h1>아이디 찾기 결과</h1>
    	</div>
        <div class="second">
        	<div class="second_msg">고객님의 아이디는 다음과 같습니다.</div> 
        	<div class="second_id"><strong>${userId }</strong></div>
        </div>
        <div class="btn">
        	<div>
        		<button onclick="location.href='login.jsp'">로그인</a></button>
        	</div>
        	<div>
        		<button onclick="location.href='findPW.jsp'">비밀번호 찾기</a></button>
        	</div>
        </div>
    </div>
</body>
</html>