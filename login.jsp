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
			
			
				
				
				
	<!-- 	<c:choose>
			<c:when test="${empty user}">
				<form action="/zuorui/login" method="post" onsubmit="return login(this);">
					<input type="hidden" name="method" value="userLogin">
					<table border="0" width="750" align="center" cellpadding="1" cellspacing="1"  bgcolor="#F0F0F0">
						<tr bordercolor="#FFFFFF">
							<td colspan="2" align="center" height="32" bgcolor="#E6941A">
								<font class="title2">用户登录</font>
								<a name="login"></a>
							</td>
						</tr>
						<tr>
							<td height="20"></td>
						</tr>
						<tr bordercolor="#FFFFFF">
							<td align="right">用户名：</td>
							<td>
								<input type="text" name="username"maxlength="10">注：用户名小于十个字符
							</td>
						</tr>
						<tr bordercolor="#FFFFFF">
							<td align="right">密 码：</td>
							<td>
								<input type="password" name="password" class="input1"maxlength="10">注：密码小于十个字符
							</td>
							
						</tr>
						<tr>
							<td height="20"></td>
						</tr>
						<td valign="middle" align="right">
									<a href="regist.jsp">注册</a>
								</td>
						<tr bordercolor="#FFFFFF">
							<td colspan="2" align="center" height="50">
								<input type="submit" value="登 录" />
								<input type="reset" value="重 置" />
								<a href="forgetpassword.jsp">忘记密码</a>
							</td>
						</tr>
					</table>
				</form>
			</c:when>
		</c:choose>
		 -->
	</body>
</html>
