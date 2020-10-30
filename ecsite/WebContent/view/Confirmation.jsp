<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.ArrayList"%>
   <%@ page import="model.CartBean"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入確認画面</title>

<style>

body{
font-family:"Yu Gothic";
background-color:#2c3338;
background-size:  cover;
width:700px;
margin-right: auto;
margin-left : auto;
}

h1{
 margin:  0;                 /* デフォルトCSS打ち消し */
    position:  relative;        /* 位置調整 */
    color:white;
    font-weight:  normal;       /* 文字の太さ調整 */
    font-size: 40px;            /* 文字サイズ指定 */
    text-align:  center;        /* 文字位置指定 */
    padding: 20px 0 15px;       /* 余白指定 */
    border-top: solid 1px;      /* 線指定 */
    border-bottom:  solid 1px;  /* 線指定 */
    width:  320px;              /* 幅指定 */
    margin: 0 auto 35px;        /* 周りの余白指定 */
}
p {
    margin:  0;                 /* デフォルトCSS打ち消し */
    line-height: 2;             /* 行間調整 */
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
 button{
  background: #b5cd60;
   font-size:x-large;
  border: 0;
  width: 100%;
  height: 40px;
  border-radius: 3px;
  color: white;
  cursor: pointer;
  transition: background 0.3s ease-in-out;
}
button:hover{
background: #16aa56;
}
input{
 background: #b5cd60;
 font-size:x-large;
  border: 0;
  width: 100%;
  height: 40px;
  border-radius: 3px;
  color: white;
  cursor: pointer;
  transition: background 0.3s ease-in-out;
}
input:hover{
background: #16aa56;
}
.form_conf {
    text-align: center;
}
.form_conf form {
    display: inline-block;
    margin: 0 10px;
}

</style>
</head>
<body>
<%@ include file="Header.jsp" %>
<p><h1>購入を確定してもよろしいですか？</h1></p>
<%ArrayList<CartBean> cart =(ArrayList<CartBean>)session.getAttribute("cart"); %>
<%CartBean cb = new CartBean();%>
<%double tax =0.1; %>
<%int t; %>
<%int total=0; %>
<%int tfinal=0; %>
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
		<td>&yen;<%=String.format("%,d",cb.getPro_price()) %></td>
		<td><%= cb.getStock_no() %>個</td>
	</tr>
	<%	total += cb.getPro_price()*cb.getStock_no(); %>
<%} %>
	<tr>

	<%  t=(int)((double)total*tax); %>
	<% tfinal=total+t; %>

		<th colspan="2">消費税</th>
		<td>&yen;<%=String.format("%,d",t) %></td>
	</tr>

	<tr>
	<th colspan="2">合計</th>
	<td>&yen;<%=String.format("%,d",tfinal)%></td>

</table>
<%String error =(String)request.getAttribute("error"); %>
<%if(error!=null){ %>
<%= error %>
<% }%>
<div class="form_conf">
<form action="/ecsite/Confirmation" method="POST">
<button  type="submit"name="total" value=<%=tfinal%>>はい</button>
</form>
<form action="/ecsite/Back" method="POST">
<input id="submit_button" type="submit" value="いいえ">
</form>
</div>
</body>
</html>