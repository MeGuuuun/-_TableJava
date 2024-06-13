<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userBookList</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function cancelStatus(rId, uId, rName) {
    var status = "2";
    var restaurantId = rId;
    var userId = uId;
    var restaurantName = rName;
    
    $.ajax({
        type: "POST",
        url: "UserBookList",
        data: { action: "status", status : status, userId : userId, restaurantId : restaurantId, restaurantName : restaurantName },
        success: function(response) {
            alert("예약 취소 되었습니다.");
            window.location.reload();
        },
        error: function() {
            alert("예약 취소에 실패했습니다. 다시 시도해주세요.");
        }
    });
}
	
</script>
</head>
<body>
	<div class="navbar">
		<form method="post" action="userMain">
			<input type="hidden" name="userId" value="${userId }">
			<button type="submit">메인 화면</button>
		</form>
        <button onclick="location.reload()">예약/웨이팅</button>
        <form method="post" action="Notification">
        	<input type="hidden" name="userId" value="${userId }">
        	<button type="submit" name="action" value="userNotification">알림</button>
        </form>
        <form method="post" action="MyPage">
        	<input type="hidden" name="userId" value="${userId }">
        	<button type="submit" name="action" value="getUserInfo">마이 페이지</button>
        </form>
    </div>
    
	<button onclick="location.reload()">예약 내역</button>
	<form method="post" action="UserWaitList">
		<input type="hidden" name="userId" value="${userId }">
		<button type="submit" name="action" value="waitList">웨이팅 내역</button>
	</form>
	
	<h1>예약 내역</h1>
	<ul>
		<c:forEach items="${bookList}" var="book">
			<div>
				<li>
					예약한 식당 : ${book.restaurant_name } <br>
					예약 날짜 : ${book.date } <br>
					예약 시간 : ${book.time } <br>
					예약 인원 수 : ${book.a_count + book.k_count } 명 <br>
					유모차 사용 : ${book.s_count } 개<br>
					휠체어 사용 : ${book.w_count } 개<br>
					요청 사항 : ${book.requirement } <br>
				</li>
				<div>
					예약 상태 : ${book.status }
				</div>
				<div>
					<button type="button" onclick="cancelStatus('${book.restaurant_id}', '${userId }', '${book.restaurant_name}')" id="statusBtn">예약 취소</button>
				</div>
			</div>
		</c:forEach>
	</ul>
</body>
</html>