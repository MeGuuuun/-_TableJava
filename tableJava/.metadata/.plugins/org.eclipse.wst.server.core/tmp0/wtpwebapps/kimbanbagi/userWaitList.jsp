<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userWaitList</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	var msg = "${msg}";

	if (msg != null && msg != "") {
		alert(msg);
		request.removeAttribute("msg");
	}

	function cancelStatus(rId, uId, rName) {
		var status = "2";
		var restaurantId = rId;
		var userId = uId;
		var restaurantName = rName;

		$.ajax({
			type : "POST",
			url : "UserWaitList",
			data : {
				action : "status",
				status : status,
				userId : userId,
				restaurantId : restaurantId,
				restaurantName : restaurantName
			},
			success : function(response) {
				alert("웨이팅 취소되었습니다.");
				window.location.reload();
			},
			error : function() {
				alert("웨이팅 취소에 실패했습니다. 다시 시도해주세요.");
			}
		});
	}
</script>
</head>
<body>
	<div class="nav">
		<form method="POST" action="userMain">
			<input type="hidden" name="userId" value="${userId }">
			<button type="submit">메인 화면</button>
		</form>
		<button onclick="location.reload()">예약/웨이팅</button>
		<form method="post" action="Notification">
			<input type="hidden" name="userId" value="${userId }">
			<button type="submit" name="action" value="userNotification">알림</button>
		</form>
		<form method="POST" action="MyPage">
			<input type="hidden" name="userId" value="${userId }">
			<button type="submit" name="action" value="getUserInfo">마이
				페이지</button>
		</form>
	</div>
	<form method="post" action="UserBookList">
		<input type="hidden" name="userId" value="${userId }">
		<button type="submit" name="action" value="bookList">예약 내역</button>
	</form>
	<button onclick="location.reload()">웨이팅 내역</button>
	<h1>웨이팅 내역</h1>
	<ul>
		<c:forEach items="${waitList}" var="wait">
			<div>
				<li>웨이팅한 식당 : ${wait.restaurantName} <br> 인원수 :
					${wait.headCount } <br> 웨이팅 상태 : ${wait.waitingStatus } <br>
					웨이팅숫자 : ${wait.waitingNumber} <br>
				</li>
			</div>
			<div>
				<c:if test="${wait.waitingStatus == '웨이팅 중' }">
					<div>
						<button type="button"
							onclick="cancelStatus('${wait.restaurantId}', '${userId }', '${wait.restaurantName })"
							id="statusBtn">웨이팅 취소</button>
					</div>
				</c:if>
				<c:if test="${wait.waitingStatus == '웨이팅 취소' || wait.waitingStatus == '웨이팅 거절' || wait.waitingStatus == '착석 완료' }">
					<button type="button" disabled>웨이팅 취소</button>
				</c:if>
			</div>
		</c:forEach>
	</ul>
</body>
</html>