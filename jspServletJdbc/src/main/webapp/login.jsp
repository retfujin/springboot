<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String error = (String) request.getAttribute("error");
	String title = (String) request.getAttribute("title");
	if (error != null) {
%>
<p class="text-error"><%=error%></p>
<%
	}
%>

<form action="" method="post" class="form-horizontal" id="loginForm">
<fieldset>
	<legend>Вход в админ-панель</legend>
	<div class="control-group">
		<label class="control-label" for="inputEmail">登录</label>
		<div class="controls">
			<input name="username" class="input-medium required" type="text"
				id="inputEmail" placeholder="Логин">
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="inputPassword">密码</label>
		<div class="controls">
			<input name="password" class="input-medium required" type="password"
				id="inputPassword" placeholder="Пароль">
		</div>
	</div>
	<div class="control-group">
		<div class="controls">
			<button type="submit" class="btn">登录</button>
		</div>
	</div>
	</fieldset>
</form>