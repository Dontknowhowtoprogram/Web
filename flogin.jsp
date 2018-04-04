<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>'登陆界面'</title>
		<link rel="stylesheet" type="text/css" href="img/style.css"/>
		
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
			<script>
			$(document).ready(function() {
					$('input[type=password]').keyup(function() {
								var pswd = $(this).val();
								if ( pswd.length < 8 ) {
								    $('#length').removeClass('valid').addClass('invalid');
								     $('.login').hide();
								} else {
								    $('#length').removeClass('invalid').addClass('valid');
								     $('.login').show();
								}
								}).focus(function() {
								    $('#pswd_info').show();
								}).blur(function() {
								    $('#pswd_info').hide();
								});

										});
			
			</script>

	</head>

	<body>
	<h1>User login</h1>
		<h2 align="center" style="color:#FF0000">username or password wrong</h2>
			<div id="container">
				<form action="/zuorui/login" method="post" onsubmit="return login(this);">
				    <ul>
				        <li>
				            <label for="username">Username:</label>
				            <span><input id="username" name="username" type="text" /></span>
				        </li>
				        <li>
				            <label for="pswd">Password:</label>
				            <span><input id="pswd" type="password" name="password" /></span>
				        </li>
				        <li>
				            <button type="submit" class="login" style="display:none">login</button>
				            <a href="forgetpassword.jsp">忘记密码</a>
				        </li>
				    </ul>
				</form>
				<form method="get" action="regist.jsp">
							    <button type="submit" style="width:100px;">Register</button>
				</form>
				<div id="pswd_info">
				    <h4>Password must meet the following requirements:</h4>
				    <ul>
				        <li id="length" class="invalid">Be at least <strong>8 characters</strong></li>
				    </ul>
				</div>
			</div>
	</body>
</html>
