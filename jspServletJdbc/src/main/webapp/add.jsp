<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="mypackage.model.Sanatorium"%>
<%
	String title = (String) request.getAttribute("title");
List<Sanatorium> sanatorium = (ArrayList<Sanatorium>) request.getAttribute("structure");
%>

<form action="manager" method="post" class="form-horizontal" id="addForm">
	<fieldset>
		<legend><%=title %></legend>
		

		<div class="control-group">
			<label class="control-label" for="selectHousingId">Выберите корпус</label>
			<div class="controls">
				<select name="sid" id="selectHousingId" class="required">
					<option value="">Выберите корпус</option>
					<%

									for (Sanatorium housing : sanatorium) {
					%>
					<option value="<%=housing.getStructureId()%>"><%=housing.getCorpsName()%></option>
					<%
						}
					%>
				</select> <a href="#" id="add" class="btn btn-link btn-mini">Новый
					корпус</a>
			</div>
		</div>
		<div id="newDiv"></div>
		
		<div class="control-group">
			<label class="control-label" for="inputNumber">Номер</label>
			<div class="controls">
				<input type="text" name="number" id="inputNumber" placeholder="" class="digits">
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="inputQuantity">Кол-во мест</label>
			<div class="controls">
				<input type="text" name="quantity" id="inputQuantity" placeholder="" class="digits">
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="inputRecreation">Услуги для отдыха</label>
			<div class="controls">
				<input type="text" name="recreation" id="inputRecreation" placeholder="">
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" for="inputProcedures">Виды процедур</label>
			<div class="controls">
				<input type="text" name="procedures" id="inputProcedures" placeholder="">
			</div>
		</div>

		<div class="control-group">
			<div class="controls">
				<button type="submit" class="btn">Добавить</button>
			</div>
		</div>
	</fieldset>
</form>