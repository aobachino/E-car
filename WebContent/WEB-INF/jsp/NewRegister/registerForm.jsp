<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会員情報入力</title>
</head>
<body>
	<h3>■会員情報を入力してください</h3><br>
	<form action="registerConf.html" method="post">
	<table border="1">
		<tr>
			<th>氏名</th>
			<td><input type="text" name="name"><form:errors cssClass="error" path="registerModel.name" /></td>
		</tr>
		<tr>
			<th>年齢</th>
			<td><input type="text" name="age"><form:errors cssClass="error" path="registerModel.age" /></td>
		</tr>
		<tr>
			<th>性別</th>
			<td>
				<select name="sex">
					<option value="m">男性</option>
					<option value="f">女性</option>
				<form:errors cssClass="error" path="registerModel.sex" /></select>
			</td>
		</tr>
		<tr>
			<th>郵便番号</th>
			<td><input type="text" name="postCode"><form:errors cssClass="error" path="registerModel.postCode" /></td>
		</tr>
		<tr>
			<th>住所</th>
			<td><textarea name="address"></textarea><form:errors cssClass="error" path="registerModel.address" /></td>
		</tr>
		<tr>
			<th>電話番号</th>
			<td><input type="text" name="phoneNum"><form:errors cssClass="error" path="registerModel.phoneNum" /></td>
		</tr>						
	</table><br>
	<input type="submit" value="確認">　 <input type="reset" value="クリア">　<input type="button" value="戻る" onClick="history.back()">
</form>
</body>
</html>