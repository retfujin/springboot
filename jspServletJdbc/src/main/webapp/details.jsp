<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String title = (String) request.getAttribute("title");
Sanatorium housing = (Sanatorium) request.getAttribute("discription");
%>
<%@page import="com.zkbr.mystudy.jspservletjdbc.model.Sanatorium"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<div class="row">
	<div class="span7 offset1">
		<h1><%=title%></h1>
	</div>
</div>
<br />
<dl class="dl-horizontal">
	<dt>名称</dt>
	<dd><%=housing.getCorpsName() %></dd>
	<%if(housing.getQuantity()!=0) {%>
	<dt>议席的数目</dt>
	<dd><%=housing.getQuantity()%></dd>
	<%} else if(housing.getRecreation() != null) {%>
	<dt>娱乐设施</dt>
	<dd><%=housing.getRecreation()%></dd>
	<%} else if(housing.getProcedures() != null) {%>
	<dt>程序</dt>
	<dd><%=housing.getProcedures()%></dd>
	<%} %>
</dl>