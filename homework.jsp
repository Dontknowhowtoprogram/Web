<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>插入题目</title>
		<link rel="stylesheet" type="text/css" href="img/style.css">
		<script type="text/javascript">
	    	function homework(form){
	        	if(form.elements["title"].value == ""){
					alert("用户名不能空！");
					return false;
	        	}
	        	if(form.elements["textwork"].value == ""){
					alert("密码不能空！");
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
							<a name="homework"></a>
						</td>
					</tr>
					<form action="/zuorui/tianjiahomework" method="post"onsubmit="return homework(this);">
					<tr bgcolor="#FAFAFA">
						<td align="right" height="25" width="100"maxlength="100">
							<b>题目：</b>
						</td>
						<td>
						<input  name="title" value=""   />
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
					
					<form action="/zuorui/tianjiahomework" method="post"onsubmit="return homework(this);">
					<tr bgcolor="#FAFAFA">
						<td align="right" height="25" width="100"maxlength="1">
							<b>学科编号(注：数学为  1，英语为  2)：</b>
						</td>
						<td>
						<input type="radio" name="cmark" value="1" checked="checked" style="width:50px"/>Math
				            		<input type="radio" name="cmark" value="2" style="width:50px"/>English
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
											<textarea rows="4" cols="30" class="inputgri" name="textwork"  tabindex="0"></textarea>
										</td>
										<td align="center" valign="middle">
											<input type="submit"style="width:60px" value="提交" />
											 <p align="right"><font size=1> <a href="/zuorui/xianshi"> 返回</a></font></p>
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
