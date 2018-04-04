<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>消息</title>
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
									<p align="right"><font size=1> <a href="/zuorui/xianshi?username=${sessionScope.username}"> 返回</a>&nbsp;&nbsp;<a href="/zuorui/allxiaoxi?username=${sessionScope.username}"> 历史消息</a></font></p>
												      <ul>
												      <!-- 留言标题 -->
												
												<c:forEach var="h" items="${requestScope.list}">
												  
												     <li >
												           <span style="display:block;font-size:28px;color:#D52B6F;background:#f0f0f0;">
												            	${h.name}:&nbsp;&nbsp;&nbsp; ${h.intext }<div align="right"><font size=1> <a href="/zuorui/xianshi2?titleid=${h.titleid}&huifuid=${h.huifuid}">查看</a></font></div>
												      
												            </span>
												            <div align="right"> ${h.nowtime}</div>
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
