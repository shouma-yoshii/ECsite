<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="model.CartBean"%>
 	<%@ page import="model.ProductBean"%>
 	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カート</title>
<link rel="stylesheet" href="/ecsite/CSS/submit.css" type="text/css" />
<style>

body{
font-family:"Yu Gothic";
background-color:#2c3338;
width:700px;
margin-right: auto;
margin-left : auto;
color:white;
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
  padding: 1rem .5rem;
}

h1:before,
h1:after {
  position: absolute;
  left: 0;
  width: 100%;
  height: 4px;
  content: '';
  background-image: -webkit-gradient(linear, right top, left top, from(#30cfd0), to(#330867));
  background-image: -webkit-linear-gradient(right, #30cfd0 0%, #330867 100%);
  background-image: linear-gradient(to left, #30cfd0 0%, #330867 100%);
}

h1:before {
  top: 0;
}

h1:after {
  bottom: 0;
}

</style>

</head>
<body>
<%@ include file="Header.jsp" %>
<h1>カート</h1>

<%ArrayList<CartBean> cart =(ArrayList<CartBean>)session.getAttribute("cart"); %>
	<%if(cart!=null){ %>
<%CartBean cb = new CartBean();%>
<%double tax =0.1; %>
<%int t; %>
<%int total=0; %>
<table border="1">
	<tr>
		<th>商品名</th>
		<th>単価</th>
		<th>数量</th>
	</tr>
	<%for (int i = 0;i<cart.size();i++){ %>
	<%cb=cart.get(i); %>

	<tr>
		<td><%= cb.getPro_name() %></td>
		<td>&yen;<%=String.format( "%,d",cb.getPro_price()) %></td>
		<td><%= cb.getStock_no() %>個</td>
	</tr>
	<%	total += cb.getPro_price()*cb.getStock_no(); %>
<%} %>
	<tr>

	<%  t=(int)((double)total*tax); %>

		<th colspan="2">消費税</th>
		<td>&yen;<%=String.format( "%,d",t) %></td>
	</tr>

	<tr>
	<th colspan="2">合計</th>
	<td>&yen;<%=String.format("%,d",total+t)%></td>

</table>
<div class="form_conf">
<form action="/ecsite/Back" method="POST">
<input id="submit_button" type="submit"  value=買い物を続ける>
</form>
<form action="/ecsite/Cart" method="POST">
<input id="submit_button" type="submit" value=購入>
</form>

<%}else{ %>
	<h1>カートに何も入っていません。</h1>
	<form action="/ecsite/Back" method="POST">
	<input id="submit_button" type="submit"  value=買い物を続ける>
	</form>
	</div>
	<%} %>

</body>
</html>