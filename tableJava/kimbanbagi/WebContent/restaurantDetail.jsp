<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>식당 상세 페이지</title>
</head>
<body>
	<h1>Restaurant Details</h1>
	<p>Restaurant Name: ${restaurant.r_name}</p>
    <p>Restaurant City: ${restaurant.r_city}</p>
    <p>Restaurant Address: ${restaurant.r_address}</p>
    <p>Restaurant Number: ${restaurant.r_number}</p>
    <!-- 예약 상태와 웨이팅 상태는 0일시 비활성이므로 회색 버튼으로 눌리지 않게 함.
          1일 시 활성 상태이므로 초록색 버튼으로 누르게 함. -->
    <c:choose>
    	<c:when test="${restaurant.r_status == '가능' }">
    		<form method="post" action="book">
				<input type="hidden" name="userId" value="${userId }">
				<input type="hidden" name="restaurantId" value="${restaurantId }">
				<input type="hidden" name="restaurantName" value="${restaurant.r_name }">
  				<button type="submit" name="action" value="bookBtn">예약 하기</button>
  			</form>
    	</c:when>
    	<c:otherwise>
    		<form method="post" action="book">
				<input type="hidden" name="userId" value="${userId }">
				<input type="hidden" name="restaurantId" value="${restaurantId }">
				<input type="hidden" name="restaurantName" value="${restaurant.r_name }">
  				<button type="submit" name="action" value="bookBtn" disabled>예약 하기</button>
  			</form>
    	</c:otherwise>
    </c:choose>
    <c:choose>
    	<c:when test="${restaurant.w_status == '가능' }">
    		<form method="post" action="wait">
				<input type="hidden" name="userId" value="${userId }">
				<input type="hidden" name="restaurantId" value="${restaurantId }">
				<input type="hidden" name="restaurantName" value="${restaurant.r_name }">
  				<button type="submit" name="action" value="waitBtn">웨이팅 하기</button>
  			</form>
    	</c:when>
    	<c:otherwise>
    		<form method="post" action="wait">
				<input type="hidden" name="userId" value="${userId }">
				<input type="hidden" name="restaurantId" value="${restaurantId }">
				<input type="hidden" name="restaurantName" value="${restaurant.r_name }">
  				<button type="submit" name="action" value="waitBtn" disabled>웨이팅 하기</button>
  			</form>
    	</c:otherwise>
    </c:choose>
</body>
</html>