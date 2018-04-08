<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人得分</title>
<link rel="stylesheet" type="text/css" href="css/styleq1.css" />
<link rel="stylesheet" type="text/css" href="css/body.css"/> 
</head>

<c:if test="${sessionScope.username==null}">
	<script language="JavaScript">
 window.location.href = '/zuorui/login.jsp';
</script>
</c:if>     
<body>
<div class="container">
	<section id="content">
		<form action="">
			<h1>成绩</h1>
			<div>
									<p align="right"><font size=1> <a href="/zuorui/xianshi?username=${sessionScope.username}"> 返回</a></font></p>
												      <ul>
												      <!-- 留言标题 -->
												
												
												  
												     <li >
												           <div  style="display:block;font-size:28px;color:#D52B6F;">
												            	姓名：${sessionScope.username}<br>
												            	总分：${requestScope.sum}<br>
												            	<c:if test="${requestScope.sum>0}"><c:if test="${requestScope.sum<100}">等级：<br><img src="img/1.gif" width="200" height="30"></c:if></c:if>
												            	<c:if test="${requestScope.sum>101}"><c:if test="${requestScope.sum<250}">等级：<br><img src="img/2.gif" width="200" height="30"></c:if></c:if>
												            	<c:if test="${requestScope.sum>251}"><c:if test="${requestScope.sum<450}">等级：<br><img src="img/3.gif" width="200" height="30"></c:if></c:if>
												            	<c:if test="${requestScope.sum>451}"><c:if test="${requestScope.sum<700}">等级：<br><img src="img/4.gif" width="200" height="30"></c:if></c:if>
												            	<c:if test="${requestScope.sum>701}"><c:if test="${requestScope.sum<1001}">等级：<br><img src="img/5.gif" width="200" height="30"></c:if></c:if>
												            </div>
												         
												      </li>              

												  
												      </ul>
												   </div>
		</form><!-- form -->
		 <div class="button">
			<span class="help-block u-errormessage" id="js-server-helpinfo">&nbsp;</span>	
		</div> <!-- button -->
	</section><!-- content -->
</div>
<!-- container -->


<br><br><br><br>

</body>
</html>