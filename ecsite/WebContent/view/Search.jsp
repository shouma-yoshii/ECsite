<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="model.CategoryBean"%>
 	<%@ page import="model.ProductBean"%>
 	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>検索画面</title>
<style>
body{
font-family:"Yu Gothic";
background-color:#2c3338;
background-size:  cover;
width:700px;
margin-right: auto;
margin-left : auto;
color:red;
}

a{
color:red;
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

 form input[type="submit"] {
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
form input[type="submit"]:hover{
background: #16aa56;
}

</style>

</head>
<body>
<%@ include file="Header.jsp" %>
<center>
<form action="/ecsite/serch" method ="POST">
<input type="text" name="keyword" size="25" placeholder="キーワード検索">

<select name="category">
<option value ="0">すべて</option>
<%CategoryBean cb = new CategoryBean(); %>
<%ArrayList<CategoryBean> list = (ArrayList<CategoryBean>)session.getAttribute("Category");%>
<%for(int i= 0;i<list.size();i++){
	 cb =list.get(i);%>

	<option value ="<%=cb.getCat_id() %>"><%=cb.getCat_name() %> </option>
	<%} %>
</select>
<input type="submit" value="検索"><br>


</form>

<form action="/ecsite/Cart" method="get">
<input type="submit" value="カートへ">
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
	 <% if(pb.getStock_no()==0){%>
<tr>
	<td><%=pb.getPro_name() %></td>
	<td>&yen;<%=String.format("%,d",pb.getPro_price())%></td>
	<td>SOLDOUT</td>
</tr>


<%}else{ %>

<tr>
	<td><a href="/ecsite/serch?name=<%=pb.getPro_name()%>"><%=pb.getPro_name() %></a></td>
	<td>&yen;<%=String.format("%,d",pb.getPro_price())%></td>
	<td><%=pb.getStock_no() %>個</td>
</tr>
<%} %>
<%} %>
</table>
<%} %>

<%String error =(String)request.getAttribute("error"); %>
<%if(error!=null){ %>
<%= error %>
<% }%>

</center>
</body>
</html>