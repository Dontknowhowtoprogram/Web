<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>求助信</title>
		<link rel="stylesheet" type="text/css" href="img/style.css">
		<script type="text/javascript">
	    	function mail(form){
	        	if(form.elements["username"].value == ""){
					alert("要发送的用户不能为空！");
					return false;
	        	}
	        
	    	}
	    </script>
	</head>
    
	<body background="img/bg1.jpg">
		<div align="center" style="position:relative;">
			<div align="center" class="div3">
				<table align="center" width="100%" border="0" bgcolor="#C1C1C1"
					cellpadding="1" cellspacing="1">
					<tr>
						<td colspan="2" align="center" height="30" bgcolor="#941F53">
							<font class="title2">求助信</font>
							<a name="mail"></a>
						</td>
					
				</tr>
				<form action="/zuorui/sendmail?titleid=${requestScope.m.titleid}" method="post"onsubmit="return mail(this);">
					<tr bgcolor="#FAFAFA">
						<td align="right">
							<b>题目：</b>
						</td>
						<td>
							<input type="text" class="inputgri" name="title" value="${requestScope.m.title}" readonly="readonly"  />
						</td>
					</tr>
					<tr bgcolor="#FAFAFA">
						<td align="right">
							<b>内 容：</b>
						</td>
						<td>
						<input type="text" class="inputgri" name="textwork" value="${requestScope.m.textwork}" readonly="readonly"  />
						</td>
					</tr>
					
					
				<tr bgcolor="#FAFAFA">
						<td align="right">
							<b>当前用户：</b>
						</td>
						<td>
						
						<input type="text" class="inputgri" name="name" value="${sessionScope.username}" readonly="readonly"  />
						</td>
					</tr>
					
					<tr bgcolor="#FAFAFA">
						<td align="right" height="25"maxlength="10">
							<b>要发送的用户：</b>
						</td>
						<td>
						<input type="text" class="inputgri" name="username" value=""   />
						</td>
					</tr>
					<tr bgcolor="#FAFAFA">
						<td align="right">
						
						</td>
						<td>
							
								<table border="0">
									<tr>
								
											<input type="submit" value="回 复" />
											 <p align="right"><font size=1> <a href="/zuorui/xianshi?username=${sessionScope.username}"> 返回</a></font></p>
										
									</tr>
										</form>
									
								</table>
						
						</td>
						
					</tr>
			
				</table>
				
			</div>	
		</div>
		<div style="position: absolute;right: 162px;top: 40px;border: 1px solid;WIDTH: 200; HEIGHT: 200; BACKGROUND-COLOR: #ffffff; OVERFLOW: scroll; scrollbar-face-color:#70807d;scrollbar-arrow-color:#ffffff;scrollbar-highlight-color:#ffffff; scrollbar-3dlight-color:#70807d; scrollbar-shadow-color:#ffffff;scrollbar-darkshadow-color:#70807d; scrollbar-track-color:#ffffff">
		<table>
		
		<c:forEach var="u" items="${requestScope.list}">
		<tr>
			<td>${u.username}<c:if test="${u.mark==1}">(在线)</c:if>&nbsp;${u.grade}年级</td>
		</tr>
		</c:forEach>
		
		</table>
		</div>  
		
				<style tyle="roll/css">
						.div3 {
							width: 800;
							background-color: #FFFFFF;
							padding: 40px 250px 40px 63px;
						}
					.rollDiv{
							border-style: solid ; 
							border-width: 50px ; 
							border-color: pink ;
							
							position: absolute ;
							top:200px ;
							left:300px ;
							height:200px ;
							width:300px ;
							
							
							
							overFlow-x: scroll ;
							overFlow-y: hidden ; 
							
							
							scrollBar-face-color: green; 
							scrollBar-hightLight-color: red; 
							scrollBar-3dLight-color: orange; 
							scrollBar-darkshadow-color:blue; 
							scrollBar-shadow-color:yellow; 
							scrollBar-arrow-color:purple; 
							scrollBar-track-color:black; 
							scrollBar-base-color:pink; 


}
         
</style>
	</body>
</html>
