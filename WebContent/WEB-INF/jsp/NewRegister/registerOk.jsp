<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>会員登録完了</title>
</head>
<body>
	<p>会員登録完了しました</p><br>
	<p>あなたの会員番号は<c:out value="${registerForm}"/>です。</p><br>
	
	<form action="menu.html">
		<input type="submit" value="予約メニュー">
	</form>　<form action="reserveForm.html">
		<input type="submit" value="新規予約">
	</form>
	
</body>
</html>