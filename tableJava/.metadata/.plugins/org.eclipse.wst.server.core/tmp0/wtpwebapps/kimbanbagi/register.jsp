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
    <div class="container">
        <h1>Register a Restaurant</h1>
        <form action="register" method="post" enctype="multipart/form-data">
        <input type="hidden" name="userId" value="${requestScope.userId }">
            <div class="form-group">
                <label for="restaurantId">Restaurant ID:</label>
                <input type="text" id="restaurantId" name="restaurantId" required>
            </div>
            <div class="form-group">
                <label for="restaurantName">Restaurant Name:</label>
                <input type="text" id="restaurantName" name="restaurantName" required>
            </div>
            <div class="form-group">
                <label for="restaurantHead">Restaurant Head:</label>
                <input type="text" id="restaurantHead" name="restaurantHead" required>
            </div>
            <div class="form-group">
                <label for="restaurantCity">Restaurant City:</label>
                <input type="text" id="restaurantCity" name="restaurantCity" placeholder="시 제외 도시 명만 입력. 예) 천안, 아산" required>
            </div>
            <div class="form-group">
                <label for="restaurantAddress">Restaurant Address:</label>
                <input type="text" id="restaurantAddress" name="restaurantAddress" required>
            </div>
            <div class="form-group">
                <label for="restaurantNumber">Restaurant Number:</label>
                <input type="text" id="restaurantNumber" name="restaurantNumber" required>
            </div>
            <div class="form-group">
                <label for="reservationAvailable">Reservation Available:</label>
                <input type="checkbox" id="reservationAvailable" name="reservationAvailable" value="예약" checked>
            </div>
            <div class="form-group">
                <label for="waitingAvailable">Waiting Available:</label>
                <input type="checkbox" id="waitingAvailable" name="waitingAvailable" value="웨이팅">
            </div>
            <div class="form-group">
                <label for="restaurantPhoto">Restaurant Photo:</label>
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
