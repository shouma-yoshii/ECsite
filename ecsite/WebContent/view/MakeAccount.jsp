<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>アカウント作成</title>
<link rel="stylesheet" href="/ecsite/CSS/Login.css?family=Open+Sans:400,700">
<style>
body{
font-family:"Yu Gothic";
}

h1 {
  padding: 1rem 3rem;
  color: #fff;
  border-radius: 100vh;
  background-image: -webkit-gradient(linear, right top, left top, from(#9be15d), to(#00e3ae));
  background-image: -webkit-linear-gradient(right, #9be15d 0%, #00e3ae 100%);
  background-image: linear-gradient(to left, #9be15d 0%, #00e3ae 100%);
}

</style>
</head>
<body>
<h1>アカウント作成</h1>
 <div id="login">
<form action="/ecsite/MakeAccount" method="POST">

<span class="fontawesome-user"></span>

<input type="text" name="id" id="user" placeholder="Username">

<span class="fontawesome-lock"></span>
<input type="password" name="password" id="pass" placeholder="Password">
<input type="submit" value="アカウント追加">
</form>
<form action="/ecsite/login" method="get">
<input type="submit" value="ログイン">
</form>
</div>
<center>
<font color="red">
<%String error =(String)request.getAttribute("error"); %>
<%if(error!=null){ %>
<%= error %>
<% }%>
</font>
</center>
</body>
</html>