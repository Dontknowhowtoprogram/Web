<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>回复留言</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<script type="text/javascript">
	    	function pinglun(form){
	        	if(form.elements["text"].value == ""){
					alert("回复不能空！");
					return false;
	        	}
	        	
	    	}
	    </script>
	</head>

	<body background="img/bg1.jpg">
		<div align="center">
			<div align="center" class="div2">
				<table align="center" width="100%" border="0" bgcolor="#C1C1C1"
					cellpadding="1" cellspacing="1">
					<tr>
						<td colspan="2" align="center" height="30" bgcolor="#941F53">
							<font class="title2">留言</font>
							<a name="pinglun"></a>
						</td>
					</tr>
					<tr bgcolor="#FAFAFA">
						<td align="right" height="25" width="100">
							<b>标 题：</b>
						</td>
						<td>
						<div name="title">
							&nbsp;&nbsp;&nbsp;${requestScope.c.title}</div>
						</td>
					</tr>
					<tr bgcolor="#FAFAFA">
						<td align="right">
							<b>内 容：</b>
						</td>
						<td>
						<div name="textwork">&nbsp;&nbsp;&nbsp;${requestScope.c.textwork}</div>
						</td>
					</tr>
					<form action="/zuorui/message?titleid=${requestScope.c.titleid }" method="post" onsubmit="return pinglun(this);">
					
				<tr bgcolor="#FAFAFA">
						<td align="right">
							<b>题目id：</b>
						</td>
						<td>
						
						<div name="titleid">&nbsp;&nbsp;&nbsp;${requestScope.c.titleid}</div>
						</td>
					</tr>
					
					<tr bgcolor="#FAFAFA">
						<td align="right" height="25">
							<b>网 友：</b>
						</td>
						<td>
						<input type="text" class="inputgri" name="username" value="${sessionScope.username}" readonly="readonly"  />
						</td>
					</tr>
					<tr bgcolor="#FAFAFA">
						<td align="right"maxlength="100">
							<b>评论：</b>
						</td>
						<td>
							
								<table border="0">
									<tr>
										<td>
											<td valign="middle" align="left">
											<textarea rows="4" cols="30" class="inputgri" name="text"  tabindex="0"></textarea>
										</td>
										<td align="center" valign="middle">
											<input type="submit" value="发送" />
											 <p align="right"><font size=1> <a href="/zuorui/xianshi2?titleid=${requestScope.c.titleid}"> 返回</a></font></p>
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
