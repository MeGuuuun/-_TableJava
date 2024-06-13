<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Restaurant Registration</title>
    <link rel="stylesheet" href="css/register.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
	<img class="logo" src="image/logo.png">
    <div class="container">
        <h1>식당 등록하기</h1>
        <form action="register" method="post" enctype="multipart/form-data">
        	<input type="hidden" name="userId" value="${userId }">
            <div class="form-group">
                <label for="restaurantId">사업자 번호 : </label>
                <input type="text" id="restaurantId" name="restaurantId" required>
            </div>
            <div class="form-group">
                <label for="restaurantName">식당 이름 : </label>
                <input type="text" id="restaurantName" name="restaurantName" required>
            </div>
            <div class="form-group">
                <label for="restaurantHead">총 수용 인원 : </label>
                <input type="text" id="restaurantHead" name="restaurantHead" required>
            </div>
            <div class="form-group">
                <label for="restaurantCity">도시 : </label>
                <input type="text" id="restaurantCity" name="restaurantCity" placeholder="시 제외 도시 명만 입력. 예) 천안, 아산" required>
            </div>
            <div class="form-group">
                <label for="restaurantAddress">상세 주소:</label>
                <input type="text" id="restaurantAddress" name="restaurantAddress" required>
            </div>
            <div class="form-group">
                <label for="restaurantNumber">식당 전화번호:</label>
                <input type="text" id="restaurantNumber" name="restaurantNumber" required>
            </div>
            <div class="inline-group">
                <label for="reservationAvailable">예약 여부 : </label>
                <input type="checkbox" id="reservationAvailable" name="reservationAvailable" value="예약" checked>
                <label for="waitingAvailable">웨이팅 여부 : </label>
                <input type="checkbox" id="waitingAvailable" name="waitingAvailable" value="웨이팅">
            </div>
            <div class="form-group">
                <label for="restaurantPhoto">식당 사진 : </label>
                <input type="file" id="restaurantPhoto" name="restaurantPhoto" accept="image/*" required>
            </div>
            <div class="form-group">
                <button type="submit" id="registerBtn">가게 등록</button>
            </div>
        </form>
    </div>
    
    <script>
    	var btn = document.getElementById('registerBtn');
    	
    	btn.addEventListener('click', ()=> {
    		alert("식당 등록이 완료 되었습니다.");
    	});
    </script>
</body>
</html>
