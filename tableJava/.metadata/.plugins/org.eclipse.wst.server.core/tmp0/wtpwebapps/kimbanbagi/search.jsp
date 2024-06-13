<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="search">
		<input type="text" value="${keywords } > 검색 결과" name="keywords">
		<input type="hidden" value="${userId }" name="userId">
		<button type="submit" >검색</button>
	</form>
	<div class="search_result">
		<c:forEach items="${searchResult}" var="result">
			<div>
				<div>
					식당 이름 : ${result.r_name } <br>
					식당 위치 : ${result.r_city } <br>
				</div>
				<div>
					<form method="post" action="restaurantDetail">
						<input type="hidden" name="restaurantId" value="${result.r_id }">
						<input type="hidden" name="userId" value="${userId }">
						<button type="submit">식당 상세 보기</button>
					</form>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>