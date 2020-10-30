<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<link rel="stylesheet" href="/ecsite/CSS/Login.css?family=Open+Sans:400,700">
<style>
body{
font-family:"Yu Gothic";
color:red;
}

h1 {
  padding: 1rem 2rem;
  color: #fff;
  border-radius: 10px;
  background-image: -webkit-gradient(linear, left top, right top, from(#f83600), to(#f9d423));
  background-image: -webkit-linear-gradient(left, #f83600 0%, #f9d423 100%);
  background-image: linear-gradient(to right, #f83600 0%, #f9d423 100%);

}
</style>
</head>
<body>
<h1>ログイン</h1>
<center>
<%String set =(String)request.getAttribute("set"); %>
<%if(set!=null){ %>
<%= set %>
<% }%>
</center>
 <div id="login">
<form action="/ecsite/login" method="POST">
<span class="fontawesome-user"></span>

<input type="text" name="name" id="user" placeholder="Username">

<span class="fontawesome-lock"></span>
<input type="password" name="pass" id="pass" placeholder="Password">


<input type="submit" value="ログイン">

</form>
<form action="/ecsite/MakeAccount" method="get">
<input type="submit" value="アカウント作成">
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