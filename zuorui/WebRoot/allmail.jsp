<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>站内信</title>
		<link rel="stylesheet" type="text/css" href="img/style.css">


	</head>  
  
<c:if test="${sessionScope.username==null}">
	<script language="JavaScript">
 window.location.href = '/zuorui/login.jsp';
</script>
</c:if>     
   
 <body background="img/bg1.jpg">
		<table border="0" align="center" cellpadding="0" cellspacing="0"
			width="800">
			<tr bgcolor="#FFFFFF">
				<td>
					<table align="center" border="0" width="750" cellpadding="0"
						cellspacing="0">
						

					
									</table>
									
										<!-- 留言板内容 -->
										<table border="0" width="750" align="center" cellpadding="0"
											cellspacing="0">
											<tr>
												<td>
												   <div>
									<p align="right"><font size=1> <a href="/zuorui/xianshi?username=${sessionScope.username}"> 返回</a></font></p>
												      <ul>
												      <!-- 留言标题 -->
												
												<c:forEach var="h" items="${requestScope.list}">
												  
												     <li >
												           <span style="display:block;font-size:28px;color:#D52B6F;background:#f0f0f0;">
												            	<p>大侠您的小弟${h.name}需要您的帮助请看题：</p>${h.title} <div align="right"><font size=1> </font></div>
												      <div align="right"> ${h.time}</div>
												            </span>
												            ${h.textwork }
												            <div align="right"><a href="/zuorui/xianshi2?titleid=${h.titleid}">去看看</a></div>
												      </li>              

												       </c:forEach>
												      </ul>
												   </div>
												</td>												
											
												</tr>
												

						<tr bordercolor="#FFFFFF" >
							<td height="10"></td>
						</tr>
					</table>
				
					
	</body>
 
 
 
 
 
 
 

</script>





</html>
