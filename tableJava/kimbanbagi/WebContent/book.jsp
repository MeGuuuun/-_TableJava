<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 화면</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function() {
		var a_count = parseInt($("#a_count").text()); // 성인 인원
		var k_count = parseInt($("#k_count").text()); // 유아 인원
		var s_count = parseInt($("#s_count").text()); // 유모차 개수
		var w_count = parseInt($("#w_count").text()); // 휠체어 개수

		// 성인 인원 증가/감소
		$('#a_increaseCount').on('click', function(event) {
			event.preventDefault();
			a_count++;
			$("#a_count").text(a_count);
			$('#hiddenAdultCount').val($("#a_count").text());
		});

		$('#a_decreaseCount').on('click', function(event) {
			event.preventDefault();
			if (a_count > 0) {
				a_count--;
				$("#a_count").text(a_count);
				$('#hiddenAdultCount').val($("#a_count").text());
			}
		});

		// 유아 인원 증가/감소
		$('#k_increaseCount').on('click', function(event) {
			event.preventDefault();
			k_count++;
			$("#k_count").text(k_count);
			$('#hiddenKidCount').val($("#k_count").text());
		});

		$('#k_decreaseCount').on('click', function(event) {
			event.preventDefault();
			if (k_count > 0) {
				k_count--;
				$("#k_count").text(k_count);
				$('#hiddenKidCount').val($("#k_count").text());
			}
		});

		// 유모차 개수 증가/감소
		$('#s_increaseCount').on('click', function(event) {
			event.preventDefault();
			s_count++;
			$("#s_count").text(s_count);
			$('#hiddenStroller').val($("#s_count").text());
		});

		$('#s_decreaseCount').on('click', function(event) {
			event.preventDefault();
			if (s_count > 0) {
				s_count--;
				$("#s_count").text(s_count);
				$('#hiddenStroller').val($("#s_count").text());
			}
		});

		// 휠체어 개수 증가/감소
		$('#w_increaseCount').on('click', function(event) {
			event.preventDefault();
			w_count++;
			$("#w_count").text(w_count);
			$('#hiddenWheelchair').val($("#w_count").text());
		});

		$('#w_decreaseCount').on('click', function(event) {
			event.preventDefault();
			if (w_count > 0) {
				w_count--;
				$("#w_count").text(w_count);
				$('#hiddenWheelchair').val($("#w_count").text());
			}
		});

		// 전 페이지로 돌아가기
		$("#goBackBtn").on('click', function(event) {
			event.preventDefault();
		})
	});
</script>
</head>
<body>
	<form action="book" method="post" id="frm">
		<input type="hidden" name="userId" value="${userId }"> <input
			type="hidden" name="restaurantId" value="${restaurantId }"> <input
			type="hidden" name="restaurantName" value="${restaurantName}">
		<div id="container">
			<div id="store_div">
				<div>사진</div>
				<div>
					가게 정보<br> 식당 이름 : ${restaurantName } <br>
				</div>
			</div>
			<div id="book_div">
				인원 <br> 성인 <span id="a_count">0</span>
				<button type="button" id="a_increaseCount">+</button>
				<button type="button" id="a_decreaseCount">-</button>
				<input type="hidden"> 유아 <span id="k_count">0</span>
				<button type="button" id="k_increaseCount">+</button>
				<button type="button" id="k_decreaseCount">-</button>
				유모차 <span id="s_count">0</span>
				<button type="button" id="s_increaseCount">+</button>
				<button type="button" id="s_decreaseCount">-</button>
				휠체어 <span id="w_count">0</span>
				<button type="button" id="w_increaseCount">+</button>
				<button type="button" id="w_decreaseCount">-</button>

				<input type="hidden" name="adultCount" id="hiddenAdultCount"
					value="0"> <input type="hidden" name="kidCount"
					id="hiddenKidCount" value="0"> <input type="hidden"
					name="stroller" id="hiddenStroller" value="0"> <input
					type="hidden" name="wheelchair" id="hiddenWheelchair" value="0">

				<label for="dateInput">Select Date:</label> <input type="date"
					id="dateInput" name="dateValue"> <label for="timeInput">Select
					Time:</label> <input type="time" id="timeInput" name="timeValue">

				<textarea name="requirement" value="요청사항"></textarea>

				<button id="goBackBtn">뒤로가기</button>
				<button type="submit" name="action" value="addBook">예약하기</button>
			</div>
		</div>
	</form>
</body>
</html>