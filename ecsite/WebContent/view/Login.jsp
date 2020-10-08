<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<form action="/ecsite/login" method="POST">
ID
<input type="text" name="name"><br>
PASS
<input type="password" name="pass"><br>
<input type="submit" value="ログイン">
</form>
<%String error =(String)request.getAttribute("error"); %>
<%if(error!=null){ %>
<%= error %>
<% }%>

</body>
</html>