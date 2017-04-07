<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.zkbr.mystudy.jspservletjdbc.model.Sanatorium"%>
<%
	String title = (String) request.getAttribute("title");
List<Sanatorium> sanatorium = (ArrayList<Sanatorium>) request.getAttribute("structure");
%>

<form action="manager" method="post" class="form-horizontal" id="addForm">
	<fieldset>
		<legend><%=title %></legend>
		

		<div class="control-group">
			<label class="control-label" for="selectHousingId">选择存储模块</label>
			<div class="controls">
				<select name="sid" id="selectHousingId" class="required">
					<option value="">选择存储模块</option>
					<%

									for (Sanatorium housing : sanatorium) {
					%>
					<option value="<%=housing.getStructureId()%>"><%=housing.getCorpsName()%></option>
					<%
						}
					%>
				</select> <a href="#" id="add" class="btn btn-link btn-mini">新增功能
					机箱</a>
			</div>
		</div>
		<div id="newDiv"></div>
		
		<div class="control-group">
			<label class="control-label" for="inputNumber">号码</label>
			<div class="controls">
				<input type="text" name="number" id="inputNumber" placeholder="" class="digits">
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="inputQuantity">数目</label>
			<div class="controls">
				<input type="text" name="quantity" id="inputQuantity" placeholder="" class="digits">
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="inputRecreation">娱乐设施</label>
			<div class="controls">
				<input type="text" name="recreation" id="inputRecreation" placeholder="">
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="inputProcedures">程序</label>
			<div class="controls">
				<input type="text" name="procedures" id="inputProcedures" placeholder="">
			</div>
		</div>

		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn">程序</button>
			</div>
		</div>
	</fieldset>
</form>