<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <script type="text/javascript">
  function realSysTime(time_now){
    	var now=new Date();			
    	var year=now.getFullYear();	
    	var month=now.getMonth();	
    	var date=now.getDate();		
    	var day=now.getDay();		
    	var hour=now.getHours();	
    	var minu=now.getMinutes();	
    	var sec=now.getSeconds();	
    	month=month+1;
    	var arr_week=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
    	var week=arr_week[day];		
    	var time=year+"年"+month+"月"+date+"日 "+week+hour+":"+minu;	
    	document.getElementById("time_now").innerHTML=time;	
    }
    window.onload=function(){
		window.setInterval("realSysTime(time_now)",1000);
    }
		
</script>
<div id="time_now"></div>
  </body>
</html>
