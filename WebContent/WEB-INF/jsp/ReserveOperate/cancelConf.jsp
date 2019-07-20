<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>予約キャンセル確認</title>
</head>
<body>
	<form action="cancelDo.html" method="post">
		<h3>●会員情報</h3>
		<table border="1">
			<c:forEach var="obj" items="${resInfo.memList}">
				<tr>
					<th>会員No</th>
					<td><c:out value="${memNum}" /></td>
				</tr>
				<tr>
					<th>氏名</th>
					<td><c:out value="${obj.name}" /></td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td><c:out value="${obj.phoneNum}" /></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<h3>●予約条件</h3>
		<table border="1">
			<tr>
				<th>ご出発日</th>
				<td><c:out value="${dep.substring(0, 10)}" /></td>
			</tr>
			<tr>
				<th>ご返却日</th>
				<td><c:out value="${arr.substring(0, 10)}" /></td>
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
				<th>レンタル金額(1日毎)</th>
			</tr>
			<c:forEach var="obj" items="${resInfo.carList}">
				<tr>
					<td><c:out value="${obj.carNum}" /></td>
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
				<th>ご予約日数</th>
				<td><c:out value="${days}"/></td>
			</tr>
			<tr>
				<th>ご利用料金</th>
				<td><c:out value="${price}"/></td>
			</tr>

			<tr>
				<th>消費税</th>
				<td><c:out value="${tax}"/></td>
			</tr>
			<tr>
				<th>合計</th>
				<td><c:out value="${total}"/></td>
			</tr>
		</table>
		<br> <input type="submit" value="実行">　<input type="button" value="戻る" onClick="history.back()">
	</form>
</body>
</html>