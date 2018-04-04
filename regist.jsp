<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>'登陆界面'</title>
		 <link rel="stylesheet" type="text/css" href="img/style.css"/>
		<script type="text/javascript">
	    	function login(form){
	        	if(form.elements["username"].value == ""){
					alert("用户名不能空！");
					return false;
	        	}
	        	if(form.elements["password"].value == ""){
					alert("密码不能空！");
					return false;
	        	}
	        	if(form.elements["grade"].value == ""){
					alert("年级不能空！");
					return false;
	        	}
	        	if(form.elements["identification"].value == ""){
					alert("身份证号不能空！");
					return false;
	        	}
	    	}
	    	
	    </script>

		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
			<script>
			$(document).ready(function() {
					$('input[type=password]').keyup(function() {
								var pswd = $(this).val();
								if ( pswd.length < 8 ) {
								    $('#length').removeClass('valid').addClass('invalid');
								    $('.register').hide();
								} else {
								    $('#length').removeClass('invalid').addClass('valid');
								    $('.register').show();
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
		<c:choose>
			<c:when test="${empty user}">
			<h1>Register</h1>
			<div id="container">
				<form action="/zuorui/zhuce" method="post" onsubmit="return login(this);">
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
				            <label for="Sex">Sex:</label>
				            <span><input type="radio" name="sex" value="m" checked="checked" style="width:50px"/>Male
				            		<input type="radio" name="sex" value="f" style="width:50px"/>Female
				            </span>
				        </li>
				         <li>
				            <label for="Grade">Grade:</label>
				            <span><input type="text" name="grade" /></span>
				        </li>
				        <li>
				            <label for="identification">Identification NO.:</label>
				            <span><input type="text" name="identification" /></span>
				        </li>
				        <li>
							
				            <button type="submit" class="register" style="display:none">Register</button>
				            <a href="/zuorui/login.jsp"> 返回</a>
				        </li>
				    </ul>
				</form>
				
				<div id="pswd_info" style="bottom:190px;">
				    <h4>Password must meet the following requirements:</h4>
				    <ul>
				        <li id="length" class="invalid">Be at least <strong>8 characters</strong></li>
				    </ul>
				</div>
			</div>
			
			<!--  	<form action="/zuorui/zhuce" method="post" onsubmit="return login(this);">
					<input type="hidden" name="method" value="regist">
					<table border="0" width="750" align="center" cellpadding="1" cellspacing="1"  bgcolor="#F0F0F0">
						<tr bordercolor="#FFFFFF">
							<td colspan="2" align="center" height="32" bgcolor="#E6941A">
								<font class="title2">用户注册</font>
					</td>
					
							<tr>
								<td valign="middle" align="right" height="32"maxlength="10">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" />注：用户名不得超过十个字符
								</td>
							
							</tr>
				
							<tr>
								<td valign="middle" align="right" height="32"maxlength="10"/>
									密码:
								<td valign="middle" align="left">
									<input type="password" class="inputgri" id="pswd" name="password" />注：密码不得小于个字符
								</td>
							</tr>
							<tr>
								
								<td valign="middle" align="right"height="32">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="sex" value="m" checked="checked" style="width:50px"/>
									女
									<input type="radio" class="inputgri" name="sex" value="f" style="width:50px"/>
								</td>
							</tr>
							
							
							<tr>
								<td valign="middle" align="right"height="32"maxlength="1">
									年级:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="grade" />
								</td>
								
							</tr>
							<tr>
								<td valign="middle" align="right"height="32"maxlength="18">
									身份证号:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="identification" />
								</td>
								
							</tr>
							<tr bordercolor="#FFFFFF">
							<td colspan="2" align="center" height="50">
							<button type="submit" class="button" style="display:none">login</button>
							&nbsp;&nbsp;&nbsp;&nbsp;<a href="/zuorui/login.jsp"> 返回</a>
							
							
						</td>
						</tr>
						</table>
						</form> -->
						</c:when>
						</c:choose>
						
	</body>
	
</html>
