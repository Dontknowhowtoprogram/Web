<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>题目内容</title>
		<link rel="stylesheet" type="text/css" href="img/style.css">


	</head>  
  
  <body>
  <c:forEach var="h" items="${requestScope.list}" varStatus="status">

   <img src="img/${h.picture }"  ></img>

   </c:forEach>
  </body>
</html>
