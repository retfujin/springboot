<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.zkbr.mystudy.jspservletjdbc.model.Product"%>
<%
	String title = (String) request.getAttribute("title");
List<Product> sanatorium = (ArrayList<Product>) request.getAttribute("structure");
%>

<form action="manager" method="post" class="form-horizontal" id="addForm">
	<fieldset>
		<legend><%=title %></legend>
		

		<div class="control-group">
			<label class="control-label" for="selectHousingId">选择类型</label>
			<div class="controls">
				<select name="sid" id="selectHousingId" class="required">
					<option value="">选择类型</option>
					<%

									for (Product housing : sanatorium) {
					%>
					<option value="<%=housing.getProTypeId()%>"><%=housing.getProTypeName()%></option>
					<%
						}
					%>
				</select> <a href="#" id="add" class="btn btn-link btn-mini">新增</a>
			</div>
		</div>
		<div id="newDiv"></div>
		
		<div class="control-group">
			<label class="control-label" for="inputNumber">数量</label>
			<div class="controls">
				<input type="text" name="number" id="inputNumber" placeholder="" class="digits">
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="inputQuantity">型号</label>
			<div class="controls">
				<input type="text" name="model" id="inputQuantity" placeholder="">
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="inputRecreation">产品名称</label>
			<div class="controls">
				<input type="text" name="proName" id="inputRecreation" placeholder="">
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="inputProcedures">备注</label>
			<div class="controls">
				<input type="text" name="proRemark" id="inputProcedures" placeholder="">
			</div>
		</div>

		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn">提交</button>
			</div>
		</div>
	</fieldset>
</form>