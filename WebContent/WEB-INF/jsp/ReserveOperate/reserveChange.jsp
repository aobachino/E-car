<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>予約変更</title>
</head>
<body>
	<h3>●会員情報</h3>
	<span ><c:out value="${dateError}" /></span>
	<form action="changeConf.html" method="post">
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
	<table border="1">
		<tr>
			<th>ご出発日</th>
			<td><select name="depYear">
					<option value="">-</option>
					<option value="2018">2018</option>
					<option value="2019">2019</option>
					<option value="2020">2020</option>
					<option value="2021">2021</option>
					<option value="2022">2022</option>
					<option value="2023">2023</option>
					<option value="2024">2024</option>
					<option value="2025">2025</option>
					<option value="2026">2026</option>
					<option value="2027">2027</option>
					<option value="2028">2028</option>
					<option value="2029">2029</option>
					<option value="2030">2030</option>
			</select> 年 <select name="depMounth">
					<option value="">-</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
			</select> 月 <select name="depDay">
					<option value="">-</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
			</select> 日</td>
		</tr>

		<tr>
			<th>ご返却日</th>
			<td><select name="arrYear">
					<option value="">-</option>
					<option value="2018">2018</option>
					<option value="2019">2019</option>
					<option value="2020">2020</option>
					<option value="2021">2021</option>
					<option value="2022">2022</option>
					<option value="2023">2023</option>
					<option value="2024">2024</option>
					<option value="2025">2025</option>
					<option value="2026">2026</option>
					<option value="2027">2027</option>
					<option value="2028">2028</option>
					<option value="2029">2029</option>
					<option value="2030">2030</option>
			</select> 年 <select name="arrMounth">
					<option value="">-</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
			</select> 月 <select name="arrDay">
					<option value="">-</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
			</select> 日</td>
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
			<td><c:out value="${days}" /></td>
		</tr>
		<tr>
			<th>ご利用料金</th>
			<td><c:out value="${price}" /></td>
		</tr>

		<tr>
			<th>消費税</th>
			<td><c:out value="${tax}" /></td>
		</tr>
		<tr>
			<th>合計</th>
			<td><c:out value="${total}" /></td>
		</tr>
	</table>
	<br>
	<input type="submit" value="確認">　<input type="button" value="戻る" onClick="history.back()">
</form>
</body>
</html>