<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.ArrayList"%>
   <%@ page import="model.CartBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>購入確認画面</title>
</head>
<body>
<h1>購入確認画面</h1>
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
		<td><%= cb.getPro_price() %></td>
		<td><%= cb.getStock_no() %></td>
	</tr>
	<%	total += cb.getPro_price()*cb.getStock_no(); %>
<%} %>
	<tr>

	<%  t=(int)((double)total*tax); %>
	<% tfinal=total+t; %>

		<th colspan="2">消費税</th>
		<td><%=t %></td>
	</tr>

	<tr>
	<th colspan="2">合計</th>
	<td><%=tfinal%></td>

</table>
<%String error =(String)request.getAttribute("error"); %>
<%if(error!=null){ %>
<%= error %>
<% }%>
<form action="/ecsite/Confirmation" method="POST">
<button type="submit"name="total" value=<%=tfinal%>>はい</button>
</form>
<form action="/ecsite/Back" method="POST">
<input type="submit" value="いいえ">
</form>
</body>
</html>