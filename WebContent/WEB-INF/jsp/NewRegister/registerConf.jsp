<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会員情報確認</title>
</head>
<body>
	<form action="registerCheck.html" method="post">
		<table border="1" >
			<tr>
				<th>氏名</th>
				<td>
					<c:out value="${registerForm.name}"/>
					<input type="hidden" value="${registerForm.name}" name="name" />
				</td>			
			</tr>
			<tr>
			<tr>
				<th>年齢</th>
				<td>
					<c:out value="${registerForm.age}"/>
					<input type="hidden" value="${registerForm.age}" name="age" />
				</td>			
			</tr>
			<tr>
				<th>性別</th>
				<td>
					<c:out value="${registerForm.sex}"/>
					<input type="hidden" value="${registerForm.sex}" name="sex" />
				</td>			
			</tr>
			<tr>
				<th>郵便番号</th>
				<td>
					<c:out value="${registerForm.postCode}"/>
					<input type="hidden" value="${registerForm.postCode}" name="postCode" />
				</td>			
			</tr>
			<tr>
				<th>住所</th>
				<td>
					<c:out value="${registerForm.address}"/>
					<input type="hidden" value="${registerForm.address}" name="address" />
				</td>			
			</tr>
			<tr>
				<th>電話番号</th>
				<td>
					<c:out value="${registerForm.phoneNum}"/>
					<input type="hidden" value="${registerForm.phoneNum}" name="phoneNum" />
				</td>			
			</tr>
		</table><br>
		<input type="submit" value="実行" >　<input type="button" value="戻る" onClick="history.back()">
	</form>
</body>
</html>