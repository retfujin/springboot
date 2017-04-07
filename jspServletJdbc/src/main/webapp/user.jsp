<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="mypackage.model.Sanatorium"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<% 
List<Sanatorium> sanatorium = (ArrayList<Sanatorium>)request.getAttribute("sanatorium");
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
			<th>#</th>
			<th>Название корпуса</th>
			<th>Номер корпуса</th>
		</tr>
	</thead>
	<tbody>
		<%if(sanatorium != null) {
			for (Sanatorium housing : sanatorium) {%>
		<tr>
			<td><%=housing.getHousintId() %></td>
			<td><a href='?action=srp&id=<%=housing.getHousintId() %>'><%=housing.getCorpsName() %></a></td>
			<td>
			<% if(housing.getNumber()!=0) {%>
				<a href='?action=sn&number=<%=housing.getNumber() %>'><%=housing.getNumber() %></a>
			<%} %>
			</td>
		</tr>
		<%}}%>
	</tbody>
</table>
</div>
</div>