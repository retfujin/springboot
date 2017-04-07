<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.zkbr.mystudy.jspservletjdbc.model.Sanatorium"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<% 
List<Sanatorium> sanatorium = (ArrayList<Sanatorium>)request.getAttribute("sanatorium");
String title = (String)request.getAttribute("title");
%>

<div class="row">
<div class="span12">
<h1><%=title %></h1>
</div>
</div>
<br />
<div class="row">
<div class="span8 offset1">
<a href="?action=add" class="btn btn-primary btn-large pull-right">Добавить корпус</a>
<br /><br />
		<%if(sanatorium != null) {
			for (Sanatorium housing : sanatorium) {%>
			<dl class="dl-horizontal">			
			<% if(housing.getCorpsName()!=null) {%>
				<h3><%=housing.getCorpsName() %></h3>
				
			<%} %>
			
			
			<% if(housing.getNumber()!=0) {%>
				<dt>Номер корпуса</dt>
				<dd><%=housing.getNumber() %></dd>
			<%} %>
			
			
			<% if(housing.getQuantity() != 0) {%>
				<dt>Кол-во мест</dt>
				<dd><%=housing.getQuantity() %></dd>
			<%} %>
			
			<% if(housing.getRecreation()!=null) {%>
				<dt>Услуги для отдыха</dt>
				<dd><%=housing.getRecreation() %></dd>
			<%} %>
			
			<% if(housing.getProcedures()!=null) {%>
				<dt>Виды процедур</dt>
				<dd><%=housing.getProcedures() %></dd>
			<%} %>
		</dl>
		<%}}%>

</div>
</div>