<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>修改题目</title>
		<link rel="stylesheet" type="text/css" href="img/style.css">
	<script type="text/javascript">
	    	function update(form){
	        	if(form.elements["title"].value == ""){
					alert("题目不能为空");
					return false;
	        	}
	        	if(form.elements["textwork"].value == ""){
					alert("内容不能为空");
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
							<font class="title2">修改题目</font>
							<a name="update"></a>
						</td>
					</tr>
					<form action="/zuorui/update?titleid=${requestScope.h.titleid}" method="post" onsubmit="return update(this);">
					<tr bgcolor="#FAFAFA">
						<td align="right" height="25" width="100"maxlength="100">
							<b>题目：</b>
						</td>
						<td>
						<input  name="title" value="${requestScope.h.title}"   />
						</td>
					</tr>
					<tr bgcolor="#FAFAFA">
						<td align="right" height="25" width="100"maxlength="100">
							<b>图片地址：</b>
						</td>
						<td>
						<input type="file" name="picture" value=""   />
						</td>
					</tr>
					<tr bgcolor="#FAFAFA">
						<td align="right" height="25" width="100"maxlength="1">
							<b>学科编号(注：数学为  1，英语为  2)：</b>
						</td>
						<td>
						<input  name="cmark" value="${requestScope.h.cmark}"   />
						</td>
					</tr>
					<tr bgcolor="#FAFAFA">
						<td align="right"maxlength="100">
							<b>题干内容：</b>
						</td>
						<td>
							
								<table border="0">
									<tr>
										<td>
											<td valign="middle" align="left">
											<textarea rows="4" cols="30" class="inputgri" name="textwork"  tabindex="0">${requestScope.h.textwork}</textarea>
										</td>
										<td align="center" valign="middle">
											<input type="submit" value="提交" />
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
