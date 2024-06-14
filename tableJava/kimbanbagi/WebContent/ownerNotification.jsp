<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사장님 알림 화면</title>
</head>
<body>
	<div id="container">
		<div class="nav">
            <form method="POST" action="ownerMain">
            	<input type="hidden" name="userId" value="${userId }">
            	<input type="hidden" name="restaurantId" value="${restaurantId }">
            	<button type="submit">메인 화면</button>
            </form>
            <form method="POST" action="OwnerBookList">
            	<input type="hidden" name="userId" value="${userId }">
            	<input type="hidden" name="restaurantId" value="${restaurantId }">
            	<button type="submit" name="action" value="bookList">예약/웨이팅</button>
            </form>
            <button onclick="location.reload()">알림</button>
            <form method="POST" action="MyPage">
            	<input type="hidden" name="userId" value="${userId }">
            	<input type="hidden" name="restaurantId" value="${restaurantId }">
            	<button type="submit" name="action" value="getOwnerInfo">마이 페이지</button>
            </form>
    	</div>
    	<h1>알림 내역</h1>
    	<div>
			<c:forEach items="${notification }" var="notification">
				<div>
					${notification.rName } <br>
					${notification.comments }
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>