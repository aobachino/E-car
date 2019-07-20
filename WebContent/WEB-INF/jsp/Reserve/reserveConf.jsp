<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>予約情報確認</title>
</head>
<body>
	<form action="reserveOk.html" method="post">
		<h3>●予約条件</h3>
		<table border="1">
			<tr>
				<th>ご出発日</th>
				<td><c:out value="${dep}" /><input type="hidden"
					value="${dep}" name="depDay"></td>
			</tr>
			<tr>
				<th>ご返却日</th>
				<td><c:out value="${arr}" /><input type="hidden"
					value="${arr}" name="arrDay"></td>
			</tr>
			<tr>
				<th>車種タイプ</th>
				<c:forEach var="obj" items="${reserveInfo.categList}">
					<td><c:out value="${obj.name}" /></td>
				</c:forEach>
			</tr>
		</table>
		<br>
		<h3>●予約車一覧</h3>
		<table border="1">
			<tr>
				<th>車登録コード</th>
				<th>車名</th>
				<th>メーカー</th>
				<th>排気量</th>
				<th>レンタル金額（1日毎）</th>
			</tr>
			<c:forEach var="obj" items="${reserveInfo.carList}">
				<tr>
					<td><c:out value="${obj.carNum}" /><input type="hidden"
						value="${obj.carNum}" name="carNum"></td>
					<td><c:out value="${obj.carName}" /></td>
					<td><c:out value="${obj.maker}" /></td>
					<td><c:out value="${obj.gas}" /></td>
					<td><c:out value="${obj.price}" /></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<h3>●料金</h3>
		<table border="1">

			<tr>
				<th>ご利用日数</th>
				<td><c:out value="${days}" />泊<c:out value="${days + 1}" />日</td>
			</tr>
			<tr>
				<th>ご利用料金</th>
				<td><c:out value="${price}" />円
				<input type="hidden" value="${price}" name="price"></td>
			</tr>
			<tr>
				<th>消費税</th>
				<td><c:out value="${tax}" />円</td>
			</tr>
			<tr>
				<th>合計</th>
				<td><c:out value="${total}" />円</td>
			</tr>
		</table>
		<br> <input type="submit" value="実行"> <input
			type="button" value="戻る" onClick="history.back()">
	</form>
</body>
</html>