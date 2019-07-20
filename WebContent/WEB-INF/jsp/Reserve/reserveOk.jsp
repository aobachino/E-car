<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>予約番号発行</title>
</head>
<body>
	<h3>予約が完了しました</h3>
	<c:forEach var="obj" items="${colleNum.resList}">
		<p>
			予約Noは
			<c:out value="${obj.colleNum}" />
			です
		</p>
	</c:forEach>

	<form action="">
		<input type="submit" value="続けて予約" formaction="reserveForm.html">
		<input type="submit" value="予約情報照会" formaction="reserveDisplay.html">
	</form>
</body>
</html>