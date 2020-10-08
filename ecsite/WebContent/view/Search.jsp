<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="model.CategoryBean"%>
 	<%@ page import="model.ProductBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
</head>
<body>
<form action="/ecsite/serch" method ="POST">
<input type="text" name="keyword"><br>
<select name="category">
<option value ="0">すべて</option>
<%CategoryBean cb = new CategoryBean(); %>
<%ArrayList<CategoryBean> list = (ArrayList<CategoryBean>)session.getAttribute("Category");%>
<%for(int i= 0;i<list.size();i++){
	 cb =list.get(i);%>

	<option value ="<%=cb.getCat_id() %>"><%=cb.getCat_name() %> </option>
	<%} %>
</select><br>
<input type="submit" value="検索"><br>

</form>


<%ProductBean pb =new ProductBean(); %>
<%ArrayList<ProductBean> result =(ArrayList<ProductBean>)request.getAttribute("result"); %>
<%if(result!=null){ %>
<table border="1">
	<tr>
		<th>商品名</th>
		<th>価格</th>
		<th>在庫</th>
	</tr>

<%for(int i= 0;i<result.size();i++){
	 pb =result.get(i);%>


<tr>
	<td><a href="/ecsite/serch?name=<%=pb.getPro_name()%>"><%=pb.getPro_name() %></a></td>
	<td><%=pb.getPro_price() %></td>
	<td><%=pb.getStock_no() %></td>
</tr>
<%} %>
</table>
<%} %>

<%String error =(String)request.getAttribute("error"); %>
<%if(error!=null){ %>
<%= error %>
<% }%>
</body>
</html>