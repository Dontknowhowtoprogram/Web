<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>'登陆界面'</title>
		<link rel="stylesheet" type="text/css" href="img/style.css">
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
	</head>

	<body>
		<c:choose>
			<c:when test="${empty user}">
				<form action="/zuorui/zhuce" method="post" onsubmit="return login(this);">
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
					<td valign="middle" align="right">用户名重复</td>
							<tr>
								<td valign="middle" align="right" height="32"maxlength="10"/>
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" />注：密码不得超过十个字符
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right"height="32">
									性别:
								</td>
								<td valign="middle" align="left">
									男
									<input type="radio" class="inputgri" name="sex" value="m" checked="checked"/>
									女
									<input type="radio" class="inputgri" name="sex" value="f"/>
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
							<input type="submit" class="button" value="提交 &raquo;" />
							&nbsp;&nbsp;&nbsp;&nbsp;<a href="/zuorui/login.jsp"> 返回</a>
						</td>
						</tr>
						</table>
						
						
						
						
						
						</form>
						</c:when>
						</c:choose>
						
	</body>
	
</html>
