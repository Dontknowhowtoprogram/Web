<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>'忘记密码'</title>
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
	        	if(form.elements["identification"].value == ""){
					alert("身份证号不能空！");
					return false;
	        	}
	        	if(form.elements["password"].value != form.elements["password1"].value){
					alert("两次密码不一致");
					return false;
	        	}
	    	}
	    	
	    </script>
	</head>

	<body>
		<c:choose>
			<c:when test="${empty user}">
				<form action="/zuorui/findpassword" method="post" onsubmit="return login(this);">
					<input type="hidden" name="method" value="regist">
					<table border="0" width="750" align="center" cellpadding="1" cellspacing="1"  bgcolor="#F0F0F0">
						<tr bordercolor="#FFFFFF">
							<td colspan="2" align="center" height="32" bgcolor="#E6941A">
								<font class="title2">忘记密码</font>
					</td>
					
							<tr>
								<td valign="middle" align="right" height="32"maxlength="10">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right" height="32" maxlength="18">
									身份证号:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="identification" />
								</td>
							</tr>
					
							<tr>
								<td valign="middle" align="right"height="32"maxlength="10">
									新密码:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="password" />
								</td>
								
							</tr>
							<tr>
								<td valign="middle" align="right"height="32"maxlength="10">
									再输一次新密码:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="password1" />
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
