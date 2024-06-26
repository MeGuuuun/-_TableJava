<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ page import="dc.human.kimbanbagi.tableJava.dto.RestaurantDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Restaurant Information</title>
</head>
<body>

    <div class="container">
        <div class="header">
            <h1>사장님 메인 화면</h1>
            
        </div>
        <div class="nav">
            <button onclick="location.reload()">메인 화면</button>
            <form method="POST" action="OwnerBookList">
            	<input type="hidden" name="userId" value="${userId }">
            	<input type="hidden" name="restaurantId" value="${restaurantId }">
            	<button type="submit" name="action" value="bookList">예약/웨이팅</button>
            </form>
            <form method="post" action="Notification">
            	<input type="hidden" name="userId" value="${userId }">
            	<input type="hidden" name="restaurantId" value="${restaurantId }">
            	<button type="submit" name="action" value="ownerNotification">알림 화면</button>
            </form>
            <form method="POST" action="MyPage">
            	<input type="hidden" name="userId" value="${userId }">
            	<input type="hidden" name="restaurantId" value="${restaurantId }">
            	<button type="submit" name="action" value="getOwnerInfo">마이 페이지</button>
            </form>
        </div>
            <div class="info">
                <p><strong>식당 이름:</strong> ${restaurant.r_name}</p>
                <p><strong>사업자 번호:</strong> ${restaurant.r_id}</p>
                <p><strong>식당 인원수:</strong> ${restaurant.r_head}</p>
                <p><strong>식당 도시:</strong> ${restaurant.r_city}</p>
                <p><strong>식당 상세주소:</strong> ${restaurant.r_address}</p>
                <p><strong>식당 번호:</strong> ${restaurant.r_number}</p>
                <p><strong>식당 예약 여부:</strong> ${restaurant.r_status}</p>
                <p><strong>식당 웨이팅 여부:</strong> ${restaurant.w_status}</p>
            </div>      
        </div>
        <div class="footer">
            <p>Copyright © 2024 TableJava. All rights reserved.</p>
        </div>
    </div>
</body>
</html>
