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
<div class="span12">
<h1><%=title %></h1>
</div>
</div>
<br />
<div class="row">
<div class="span8 offset1">
<a href="?action=add" class="btn btn-primary btn-large pull-right">添加产品</a>
<br /><br />
		<%if(sanatorium != null) {
                for (Product housing : sanatorium) {%>
                    <dl class="dl-horizontal">			
			<% if(housing.getProTypeName()!=null) {%>
				<h3><%=housing.getProTypeName() %></h3>
				
			<%} %>
			
			
			<% if(housing.getNumber()!=0) {%>
				<dt>数量</dt>
				<dd><%=housing.getNumber() %></dd>
			<%} %>
			
			
			<% if(housing.getModel() != null) {%>
				<dt>类型</dt>
				<dd><%=housing.getModel() %></dd>
			<%} %>
			
			<% if(housing.getProName()!=null) {%>
				<dt>产品名称</dt>
				<dd><%=housing.getProName() %></dd>
			<%} %>
			
			<% if(housing.getProRemark()!=null) {%>
				<dt>备注</dt>
				<dd><%=housing.getProRemark() %></dd>
			<%} %>
                    </dl>
		<%}}%>

</div>
</div>