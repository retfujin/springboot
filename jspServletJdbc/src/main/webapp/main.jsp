<%@page import="mypackage.model.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String title = (String) request.getAttribute("title");
	String content = (String) request.getAttribute("content");
%>

<!DOCTYPE html>
<html lang="ru">
<head>
<meta charset="utf-8">
<title><%=title%></title>
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<style>
body {padding-top: 60px;}
.brand {margin-left: 50px !important;}
.navbar-text {margin-right: 50px;}
.span4 > div{padding: 12px;border: 1px solid #ddd !important;border-radius:3px !important;}

</style>
</head>
<body>
	<div class="container">
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="navbar-inner">
				<a class="brand" href="<%=request.getContextPath() %>">Санаторий</a>
				<%
				User userInfo = (User)request.getSession().getAttribute("userInfo");
				if(userInfo== null) {
				%>
				<p class="navbar-text pull-right">Гость | <a href="<%=request.getContextPath() %>/login">Войти</a></p>
				<%} else {%>
				<p class="navbar-text pull-right"><a href="<%=request.getContextPath() %>/manager"><%=userInfo.getUserName() %></a> | <a href="<%=request.getContextPath() %>/logout">Выйти</a></p>
				<%} %>
			</div>
		</div>
		<div class="row">
			<div class="span12">
				<jsp:include page="<%=content%>" />
			</div>
		</div>

	</div>
	<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/jquery.validate.min.js"></script>
	<script>

		$(function() {
			$.extend($.validator.messages, {
				required: "Это поле необходимо заполнить.",
				number: "Пожалуйста, введите число.",
				digits: "Пожалуйста, вводите только цифры."

			});
		    $('#loginForm, #addForm').validate({
                 errorClass:'error help-inline',
                 validClass:'success',
                 errorElement:'span',
                 highlight: function (element, errorClass, validClass) { 
                   $(element).parents("div.control-group").addClass(errorClass).removeClass(validClass); 

                 }, 
                 unhighlight: function (element, errorClass, validClass) { 
                         $(element).parents(".error").removeClass(errorClass).addClass(validClass); 
                 }
		    });			
			
			$('#add')
					.click(
							function() {
								$("#newDiv").empty();
								$("#selectHousingId").attr("disabled",
										"disabled");
								$(
										'<div class="control-group"><label class="control-label" for="inputCorpsName">Имя корпуса</label>'
												+ '<div class="controls"><input type="text" name="cname" id="inputCorpsName" placeholder="" class="required">'
												+ '</div></div>')
										.fadeIn('slow').appendTo('#newDiv');
							});
		});
	</script>
</body>
</html>