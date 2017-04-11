<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String title = (String) request.getAttribute("title");
Product housing = (Product) request.getAttribute("discription");
%>
<%@page import="com.zkbr.mystudy.jspservletjdbc.model.Product"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<div class="row">
	<div class="span7 offset1">
		<h1><%=title%></h1>
	</div>
</div>
<br />
<dl class="dl-horizontal">
	<dt>类型</dt>
	<dd><%=housing.getProTypeName()%></dd>
	
	<dt>数量</dt>
	<dd><%=housing.getNumber()%></dd>
	
	<dt>型号</dt>
	<dd><%=housing.getModel()%></dd>
	
	<dt>产品名称</dt>
	<dd><%=housing.getProName()%></dd>
        
        <dt>备注</dt>
	<dd><%=housing.getProRemark()%></dd>
	
</dl>