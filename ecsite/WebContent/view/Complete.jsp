<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入完了</title>
</head>
<body>
<h1>購入ありがとうございました。</h1>

<form action="/ecsite/Back" method="get">
<input type="submit" value="買い物を続ける">
</form>
<form action="/ecsite/Logout" method="POST">
<input type="submit" value="ログアウト">
</form>
</body>
</html>