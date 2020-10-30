<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.ProductBean"%>
    <%@ page import="dao.ProductDao"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
<link rel="stylesheet" href="/ecsite/CSS/submit.css" type="text/css" />

<style>

body{
font-family:"Yu Gothic";
background-image:url(/ecsite/jpg/グラウンドjpg.jpg);
background-size:  cover;
width:700px;
margin-right: auto;
margin-left : auto;

}
img {
    width: 600px;
  display: table-cell;
  vertical-align: middle;
  text-align: center;
}
table{
  width: 100%;
  border-collapse: collapse;
}

table tr{
  background-image: linear-gradient(40deg, #fce043 0%, #fb7ba2 74%);
}

table tr:last-child *{
  border-bottom: none;
}

table th,table td{
  text-align: center;
  border: solid 2px #fff;
  color: white;
  padding: 10px 0;
}


h1 {
  position: relative;
  line-height: 1.4;
  padding:0.25em 1em;
  display: inline-block;
  color:yellow;
  margin-right: auto;
  margin-left : auto;
}

h1:before, h1:after {
  content:'';
  width: 20px;
  height: 30px;
  position: absolute;
  display: inline-block;
}

h1:before {
  border-left: solid 1px #ff5722;
  border-top: solid 1px #ff5722;
  top:0;
  left: 0;
}

h1:after {
  border-right: solid 1px #ff5722;
  border-bottom: solid 1px #ff5722;
  bottom:0;
  right: 0;
}

.cp_ipselect {
	overflow: hidden;
	width: 90%;
	margin: 2em auto;
	text-align: center;
}
.cp_ipselect select {
	width: 100%;
	padding-right: 1em;
	cursor: pointer;
	text-indent: 0.01px;
	text-overflow: ellipsis;
	border: none;
	outline: none;
	background: transparent;
	background-image: none;
	box-shadow: none;
	-webkit-appearance: none;
	appearance: none;
}
.cp_ipselect select::-ms-expand {
    display: none;
}
.cp_ipselect.cp_sl01 {
	position: relative;
	border: 1px solid #bbbbbb;
	border-radius: 2px;
	background: #ffffff;
}
.cp_ipselect.cp_sl01::before {
	position: absolute;
	top: 0.8em;
	right: 0.9em;
	width: 0;
	height: 0;
	padding: 0;
	content: '';
	border-left: 6px solid transparent;
	border-right: 6px solid transparent;
	border-top: 6px solid #666666;
	pointer-events: none;
}
.cp_ipselect.cp_sl01 select {
	padding: 8px 18px 8px 8px;
	color: #666666;
}

</style>
</head>
<body>
<%@ include file="Header.jsp" %>
<% ProductBean pb =(ProductBean) request.getAttribute("pb"); %>
<% String name =(String)request.getAttribute("cat_name");%>

<center>
	<h1><%=pb.getPro_name() %></h1>
	<img src=<%=pb.getPro_img() %> alt="詳細画像" title="詳細画像">

	<table border=1>
	<tr>
		<th>商品名</th>
		<td><%= pb.getPro_name() %></td>
	</tr>
	<tr>
		<th>カテゴリー</th>
		<td><%=name %></td>
	</tr>
	<tr>
		<th>価格</th>
		<td>&yen;<%=String.format("%,d",pb.getPro_price()) %></td>
	</tr>
	<tr>
		<th>在庫</th>
		<td><%=pb.getStock_no() %>個</td>
	</tr>
	<tr>
		<th>商品説明</th>
		<td><%=pb.getPro_msg() %></td>
	</tr>

	</table>

<form action="/ecsite/product" method="POST" >
<%request.setAttribute("pb",pb); %>
<div class="cp_ipselect cp_sl01">
<select name="stock" >
	<%for(int a=1;a<=pb.getStock_no();a++) {%>
		<% int b =a;%>
		<option value ="<%= b %>"><%=b %>個</option>
	<%} %>
</select>
</div>
<div class="form_conf">
<button id="button" type="submit" name="cd" value=<%=pb.getPro_cd()%>>カートへ</button>
</form>
<form action="/ecsite/Back" method="POST">
<input id="submit_button" type="submit" value="戻る">
</form>
</div>
</center>


</body>
</html>