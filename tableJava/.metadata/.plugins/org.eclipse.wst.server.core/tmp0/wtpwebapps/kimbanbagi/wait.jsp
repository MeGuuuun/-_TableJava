<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웨이팅 화면</title>
<!-- 인원수 입력받음 -->
<body>
	 <h1>가게 정보</h1>
    <div>
        <h2>인원 수 입력</h2>
        <form action="wait" method="post">
            <input type="hidden" name="restaurantId" value="${restaurant.r_id}">
            <input type="hidden" name="restaurantName" value="${restaurant.r_name}">
            <label for="headCount">인원수:</label>
            <input type="number" id="headCount" name="headCount" min="1" required>
            <input type="submit" value="웨이팅 하기" >
        </form>
    </div>
    
    <div>
        <h2>현재 웨이팅 순서</h2>
        <c:forEach var="waiting" items="${waitingList}">
            <p>${waiting.waitingNumber}: ${waiting.userId} (${waiting.headCount}명)</p>
        </c:forEach>
    </div>
</body>
</html>