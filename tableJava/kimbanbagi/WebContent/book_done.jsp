<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 완료 화면</title>
</head>
<body>
	<form>
		<h1>예약 완료 내역</h1>
			예약한 식당 : ${book.restaurant_name } <br>
			예약 날짜 : ${book.date } <br>
			예약 시간 : ${book.time } <br>
			<c:choose>
				<c:when test="${book.status == '1'}">
					예약 상태 : 예약 확정
				</c:when>
				<c:when test="${book.status == '2'}">
					예약 상태 : 예약 취소
				</c:when>
				<c:when test="${book.status == '3'}">
					예약 상태 : 예약 거절
				</c:when>
				<c:when test="${book.status == '4'}">
					예약 상태 : 예약 종료
				</c:when>
				<c:otherwise>
					예약 상태 : 예약 대기
				</c:otherwise>
			</c:choose>
			예약 인원 수 : ${book.a_count + book.k_count } 명 <br>
			유모차 사용 : ${book.s_count } 개<br>
			휠체어 사용 : ${book.w_count } 개<br>
			요청 사항 : ${book.requirement } <br>
	</form>
</body>
</html>