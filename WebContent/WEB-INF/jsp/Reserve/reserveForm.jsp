<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>予約情報入力</title>
</head>
<body>
	<span ><c:out value="${memError}" /></span>
	<span ><c:out value="${zeroError}" /></span>
	<span ><c:out value="${dateError}" /></span>
	<form action="reserveSerch.html" method="post">
		<table border="1">
			<tr>
				<th>会員No</th>
				<td><input type="text" name="memNum"><form:errors cssClass="error" path="reserveModel.memNum" /></td>
			</tr>
			<tr>
				<th>車種タイプ</th>
				<td><select name="categNum">
						<c:forEach var="obj" items="${category.categList}">
							<option value="${obj.categNum}"><c:out
									value="${obj.name}" /></option>
						</c:forEach>
				</select><form:errors cssClass="error" path="reserveModel.categNum" /></td>
			</tr>
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
		<br> <input type="submit" value="検索">　<input type="reset"
			value="クリア">　<input type="button" value="戻る"
			onClick="history.back()">
	</form><hr><br>
	<c:if test="${dep != null}">
	<form action="reserveConf.html" method="post">
		<h3>●会員情報</h3>
		<table border="1">
			<c:forEach var="obj" items="${reserveInfo.memList}">
				<tr>
					<th>会員番号</th>
					<td><c:out value="${memNum}" /><input type="hidden"
						value="${obj.memNum}" name="memNum"></td>
				</tr>
				<tr>
					<th>氏名</th>
					<td><c:out value="${obj.name}" /><input type="hidden"
						value="${obj.name}" name="memName"></td>
				</tr>
				<tr>
					<th>電話番号</th>
					<td><c:out value="${obj.phoneNum}" /><input type="hidden"
						value="${obj.phoneNum}" name="phoneNum"></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<h3>●予約条件</h3>
		<table border="1">
			<tr>
				<th>ご出発日</th>
				<td><c:out value="${dep}" /><input type="hidden"
					value="${dep}" name="depDate"></td>
			</tr>
			<tr>
				<th>ご返却日</th>
				<td><c:out value="${arr}" /><input type="hidden"
					value="${arr}" name="arrDate"></td>
			</tr>
			<tr>
				<th>車種タイプ</th>
				<c:forEach var="obj" items="${reserveInfo.categList}">
					<td><c:out value="${obj.name}" /><input type="hidden"
						value="${obj.name}" name="categName"></td>
				</c:forEach>
			</tr>
		</table>
		<br>

		<h3>●予約車一覧</h3>
		<table border="1">
			<tr>
				<th>選択</th>
				<th>車登録コード</th>
				<th>車名</th>
				<th>メーカー</th>
				<th>排気量</th>
				<th>レンタル金額（1日毎）</th>
			</tr>
			<c:forEach var="obj" items="${reserveInfo.carList}">
				<tr>
					<td><input type="checkbox" value="${obj.carNum}" name="carNum"></td>
					<td><c:out value="${obj.carNum}" /></td>
					<td><c:out value="${obj.carName}" /><input type="hidden"
						value="${obj.carName}" name="carName"></td>
					<td><c:out value="${obj.maker}" /><input type="hidden"
						value="${obj.maker}" name="maker"></td>
					<td><c:out value="${obj.gas}" /><input type="hidden"
						value="${obj.gas}" name="gas"></td>
					<td><c:out value="${obj.price}" /><input type="hidden"
						value="${obj.price}" name="price"></td>
				</tr>
			</c:forEach>
		</table><br>
		<input type="submit" value="確認">
	</form>
	</c:if>
</body>
</html>