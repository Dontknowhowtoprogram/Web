<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>评分</title>
		<link rel="stylesheet" type="text/css" href="img/style.css">
	</head>
  
	<body background="img/bg1.jpg">
		<div align="center">
			<div align="center" class="div2">				
				<table align="center" width="100%" border="0" bgcolor="#C1C1C1"
					cellpadding="1" cellspacing="1">
				
					<form action="/zuorui/intscore?textid=${requestScope.c.textid}" method="post">
					
					<tr>
					
						<td colspan="2" align="center" height="30" bgcolor="#941F53">
							<font class="title2">评分</font>
						</td>
					</tr>
					
					<tr bgcolor="#FAFAFA">
						<td align="right" height="25" width="100">
							<b>学生姓名：</b>
						</td>
						<td>
						<input type="text" class="inputgri" name="username" value="${requestScope.c.username}" readonly="readonly"  />
						</td>
					</tr>
					<tr bgcolor="#FAFAFA">
						<td align="right">
							<b>题目id：</b>
						</td>
						<td>
						<input type="text" class="inputgri" name="titleid" value="${requestScope.c.titleid}" readonly="readonly"  />
						</td>
					</tr>
					
					
				<tr bgcolor="#FAFAFA">
						<td align="right"maxlength="3">
							<b>分数：</b>
						</td>
						<td>
						
						<input type="text" class="inputgri" name="score" value="${requestScope.x.score}" />
						</td>
					</tr>
					
				
					<tr bgcolor="#FAFAFA">
						<td align="right">
						&nbsp;
						</td>						
						<td align="left" valign="middle">
							<input type="submit"style="width:60px" value="发送" />
							 <p align="left"><font size=1> <a href="/zuorui/xianshi?username=${sessionScope.username}"> 返回</a></font></p>
						</td>
					</tr>
					</form>
				</table>
			</div>
		</div>
	</body>
</html>
