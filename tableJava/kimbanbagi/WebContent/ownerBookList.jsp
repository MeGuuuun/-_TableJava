<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ownerBookList</title>
<link rel="stylesheet" href="css/ownerBookList.css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	// 예약 확정 처리 ajax
	function confirmStatus(rId, bId, rName, uId) {
		var status = "1";
		var restaurantId = rId;
		var bookId = bId; //예약한 사용자의 ID
		var restaurantName = rName;
		var userId = uId; // 사장님의 ID

		var cbutton = document.getElementById("confirmBtn");
		var ebutton = document.getElementById("endBtn");

		$.ajax({
			type : "POST",
			url : "OwnerBookList",
			data : {
				action : "status",
				status : status,
				userId : userId,
				restaurantId : restaurantId,
				restaurantName : restaurantName,
				bookId : bookId
			},
			success : function(response) {
				alert("예약 확정되었습니다.");
				window.location.reload();
			},
			error : function() {
				alert("예약 확정에 실패했습니다. 다시 시도해주세요.");
			}
		});
	}

	// 예약 종료 처리 ajax
	function endStatus(rId, bId, rName, uId) {
		var status = "4";
		var restaurantId = rId;
		var bookId = bId;
		var restaurantName = rName;
		var userId = uId;

		var button = document.getElementById("endBtn");

		$.ajax({
			type : "POST",
			url : "OwnerBookList",
			data : {
				action : "status",
				status : status,
				userId : userId,
				restaurantId : restaurantId,
				restaurantName : restaurantName,
				bookId : bookId
			},
			success : function(response) {
				alert("예약 종료되었습니다.");
				window.location.reload();
			},
			error : function() {
				alert("예약 종료에 실패했습니다. 다시 시도해주세요.");
			}
		});
	}

	// 예약 취소 처리 ajax
	function cancelStatus(rId, bId, rName, uId) {
		var status = "3";
		var restaurantId = rId;
		var bookId = bId;
		var restaurantName = rName;
		var userId = uId;

		var button = document.getElementById("cancelBtn");

		$.ajax({
			type : "POST",
			url : "OwnerBookList",
			data : {
				action : "status",
				status : status,
				userId : userId,
				restaurantId : restaurantId,
				restaurantName : restaurantName,
				bookId : bookId
			},
			success : function(response) {
				alert("예약 취소되었습니다.");
				window.location.reload();
			},
			error : function() {
				alert("예약 취소에 실패했습니다. 다시 시도해주세요.");
			}
		});
	}
</script>
</head>
<body>
	<div class="nav">
		<img src="image/logo1.png" alt="로고 이미지">
		<div class="buttons-container">
			<form method="POST" action="ownerMain">
				<input type="hidden" name="userId" value="${userId }"> <input
					type="hidden" name="restaurantId" value="${restaurantId }">
				<button type="submit">메인 화면</button>
			</form>
			<button onclick="location.reload()">예약/웨이팅</button>
			<form method="post" action="Notification">
				<input type="hidden" name="userId" value="${userId }"> <input
					type="hidden" name="restaurantId" value="${restaurantId }">
				<button type="submit" name="action" value="ownerNotification">알림
					화면</button>
			</form>
			<form method="POST" action="MyPage">
				<input type="hidden" name="userId" value="${userId }"> <input
					type="hidden" name="restaurantId" value="${restaurantId }">
				<button type="submit" name="action" value="getOwnerInfo">마이
					페이지</button>
			</form>
		</div>
	</div>

	<div class="container">
		<div class="optionDiv">
			<div class="btnDiv">
				<button onclick="location.reload()" id="btn">예약 내역</button>
			</div>
			<div class="btnDiv">
				<form method="post" action="OwnerWaitList">
					<input type="hidden" name="userId" value="${userId }"> <input
						type="hidden" name="restaurantId" value="${restaurantId }">
					<button type="submit" name="action" value="waitList" id="btn">웨이팅
						내역</button>
				</form>
			</div>
		</div>
		<div class="contentDiv">
			<div class="labelDiv">
				<h1>예약 내역</h1>
			</div>
			<c:forEach items="${bookList}" var="book">
				<div class="bookDiv">
					<div class="bookContent">
						<div class="status">
							<div><h3>${book.status }</h3></div>
						</div>
						예약자 : ${book.user_id } <br> 예약 날짜 : ${book.date } <br>
						예약 시간 : ${book.time } <br> 예약 인원 수 : ${book.a_count + book.k_count }
						명 <br> 유모차 사용 : ${book.s_count } 개<br> 휠체어 사용 :
						${book.w_count } 개<br> 요청 사항 : ${book.requirement } <br>
					</div>
					<div class="bookBtnDiv">
						<c:if test="${book.status ==  '예약 대기'}">
							<button type="button"
								onclick="confirmStatus('${restaurantId}', '${book.user_id }', '${book.restaurant_name}', '${userId }')"
								id="confirmBtn">예약 확정</button>
							<button type="button"
								onclick="cancelStatus('${restaurantId}', '${book.user_id }', '${book.restaurant_name}', '${userId }')"
								id="cancelBtn">예약 취소</button>
						</c:if>
						<c:if test="${book.status ==  '예약 확정'}">
							<button type="button"
								onclick="endStatus('${restaurantId}', '${book.user_id }', '${book.restaurant_name }', '${userId }')"
								id="endBtn">예약 종료</button>
							<button type="button" disabled>예약 취소</button>
						</c:if>
						<c:if
							test="${book.status ==  '예약 종료' || book.status == '예약 취소' || book.status == '예약 거절'}">
						</c:if>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>