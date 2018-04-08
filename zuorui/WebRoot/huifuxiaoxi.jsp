<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>回复留言</title>
		<link rel="stylesheet" type="text/css" href="img/style.css">
	</head>
  
	<body background="img/bg1.jpg">
		<div align="center">
			<div align="center" class="div2">
				<table align="center" width="100%" border="0" bgcolor="#C1C1C1"
					cellpadding="1" cellspacing="1">
					<tr>
						<td colspan="2" align="center" height="30" bgcolor="#941F53">
							<font class="title2">留言</font>
						</td>
					</tr>
					<form action="/zuorui/huifuxiaoxi?huifuid=${requestScope.f.huifuid }" method="post">
					<tr bgcolor="#FAFAFA">
						<td align="right" height="25" width="100">
							<b>对方姓名：</b>
						</td>
						<td>
						<input  name="username" value="${requestScope.f.name}" readonly="readonly"  />
						</td>
					</tr>
					
					
					<tr bgcolor="#FAFAFA">
						<td align="right">
							<b>id：</b>
						</td>
						<td>
						<input  name="textid" value="${requestScope.f.textid}" readonly="readonly"  />
						</td>
					</tr>
				
					
					<tr bgcolor="#FAFAFA">
						<td align="right" height="25">
							<b>我：</b>
						</td>
						<td>
						<input  name="name" value="${sessionScope.username}" readonly="readonly"  />
						</td>
					</tr>
					<tr bgcolor="#FAFAFA">
						<td align="right"maxlength="100">
							<b>回复留言：</b>
						</td>
						<td>
							
								<table border="0">
									<tr>
										<td>
											<td valign="middle" align="left">
											<textarea rows="4" cols="30" class="inputgri" name="intext"  tabindex="0"></textarea>
										</td>
										<td align="center" valign="middle">
											<input type="submit" value="回 复" />
											 <p align="right"><font size=1> <a href="/zuorui/xianshi?username=${sessionScope.username}"> 返回</a></font></p>
										</td>
									</tr>
								</table>
						
						</td>
						
					</tr>
					</form>
				</table>
			</div>
		</div>
	</body>
</html>
