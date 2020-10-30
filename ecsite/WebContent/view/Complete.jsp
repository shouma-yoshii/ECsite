<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入完了</title>
<link rel="stylesheet" href="/ecsite/CSS/submit.css" type="text/css" />

<style>

body{
font-family:"Yu Gothic";
background-color:#2c3338;
width:700px;
margin-right: auto;
margin-left : auto;
color:#3CB371;

}

h1 {
  position: relative;
  padding-left: 25px;
}

h1:before {
  position: absolute;
  content: '';
  bottom: -3px;
  left: 0;
  width: 0;
  height: 0;
  border: none;
  border-left: solid 15px transparent;
  border-bottom: solid 15px rgb(119, 195, 223);
}
h1:after {
  position: absolute;
  content: '';
  bottom: -3px;
  left: 10px;
  width: 100%;
  border-bottom: solid 3px rgb(119, 195, 223);
}


</style>
</head>
<body>

<h1>購入ありがとうございました。</h1>
<div class="form_conf">
<form action="/ecsite/Back" method="get">
<input id="submit_button" type="submit" value="買い物を続ける">
</form>
<form action="/ecsite/Logout" method="POST">
<input id="submit_button" type="submit" value="ログアウト">
</form>
</div>
</body>
</html>