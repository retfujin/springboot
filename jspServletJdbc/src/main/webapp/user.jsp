<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.zkbr.mystudy.jspservletjdbc.model.Product"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<% 
List<Product> sanatorium = (ArrayList<Product>)request.getAttribute("sanatorium");
String title = (String)request.getAttribute("title");
%>

<div class="row">
<div class="span6">
<h1><%=title %></h1>
</div>
</div>
<br />
<div class="row">
<div class="span8">
<table class="table table-bordered table-hover ">
	<thead>
		<tr>
			<th>名称11</th>
			<th>类型</th>
			<th>数量</th>
		</tr>
	</thead>
	<tbody>
		<%if(sanatorium != null) {
			for (Product housing : sanatorium) {%>
		<tr>
			<td><a href='?action=srp&id=<%=housing.getProId() %>'><%=housing.getProName() %></td>
                        <td><%=housing.getProTypeName() %></a></td>
			<td><%=housing.getNumber() %></a></td>
			
		</tr>
		<%}}%>
	</tbody>
</table>
</div>
</div>