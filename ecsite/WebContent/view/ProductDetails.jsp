<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.ProductBean"%>
    <%@ page import="dao.ProductDao"%>
    <%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品詳細</title>
</head>
<body>
<% ProductBean pb =(ProductBean) request.getAttribute("pb"); %>
<% String name =(String)request.getAttribute("cat_name");%>


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
		<td><%=pb.getPro_price() %></td>
	</tr>
	<tr>
		<th>在庫</th>
		<td><%=pb.getStock_no() %></td>
	</tr>
	<tr>
		<th>商品説明</th>
		<td><%=pb.getPro_msg() %></td>
	</tr>

	</table>

個数<form action="/ecsite/product" method="POST">
<%request.setAttribute("pb",pb); %>
<select name="stock">
	<%for(int a=1;a<=pb.getStock_no();a++) {%>
		<% int b =a;%>
		<option value ="<%= b %>"><%=b %></option>
	<%} %>
</select>
<button type="submit" name="cd" value=<%=pb.getPro_cd()%>>カートへ</button>
</form>
<form action="/ecsite/Back" method="POST">
<input type="submit" value="戻る">
</form>


</body>
</html>