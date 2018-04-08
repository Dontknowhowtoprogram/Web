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
	    	}
	    	
	    </script>
	</head>

	<body>
		<c:choose>
			<c:when test="${empty user}">
				<form action="/zuorui/login" method="post" onsubmit="return login(this);">
					<input type="hidden" name="method" value="userLogin">
					<table border="0" width="750" align="center" cellpadding="1" cellspacing="1"  bgcolor="#F0F0F0">
						<tr bordercolor="#FFFFFF">
							<td colspan="2" align="center" height="32" bgcolor="#E6941A">
								<font class="title2">用户登录</font>
								<a name="login"></a>
								<h1><font face="Bell MT" color="#3C57C4">注册成功</font></h1>
							</td>
						</tr>
						<tr>
							<td height="20"></td>
						</tr>
						<tr bordercolor="#FFFFFF">
							<td align="right"maxlength="10">用户名：</td>
							<td>
								<input type="text" name="username">注：用户名不得超过十个字符
							</td>
						</tr>
						<tr bordercolor="#FFFFFF">
							<td align="right"maxlength="10">密 码：</td>
							<td>
								<input type="password" name="password" class="input1">注：密码不得超过十个字符
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
							</td>
						</tr>
					</table>
				</form>
			</c:when>
		</c:choose>
	</body>
</html>
