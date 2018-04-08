<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>全知道解题系统</title>
		<link rel="stylesheet" type="text/css" href="img/mainStyle.css">
		<script type="text/javascript">
		function main(form){
		if(form.elements["search"].value == ""){
					alert("搜索内容不能空！");
					return false;
	        	}
		}
		</script>
		
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script> 
    
    <style>
    			ul.top {
				    list-style-type: none;
				    margin: 0;
				    padding: 0;
				    overflow: hidden;
				    background-color: #333;
				    position: fixed;
				    top: 0;
				    width: 800px;
				}
    			li.top {
					    float: left;
					}
					
					li.top a {
					    display: block;
					    color: white;
					    text-align: center;
					    padding: 14px 16px;
					    text-decoration: none;
					}
				li.top a:hover:not(.active) {
				    background-color: #111;
				}
				
				.active {
				    background-color: #4CAF50;
				}
	</style>
	</head>
	<c:if test="${sessionScope.username==null}">
		<script language="JavaScript">
		 window.location.href = '/zuorui/login.jsp';
		</script>
</c:if>        
	<body>
			
		<table border="0" align="center" cellpadding="0" cellspacing="0" width="800">
			<tr background="img/bg1.jpg">
			
				<td>
					<table align="center" border="0" width="750" cellpadding="0" cellspacing="0" >
					<ul class="top">
					  <li class="top"><a class="active" href="/zuorui/xianshi?username=${sessionScope.username}">主页</a></li>
					  <li class="top"><a href="/zuorui/xianshicourse?username=${sessionScope.username}&cmark=1">数学</a></li>
					  <li class="top"><a href="/zuorui/xianshicourse?username=${sessionScope.username}&cmark=2">英语</a></li>
					  <li class="top"><a href="/zuorui/sum?username=${sessionScope.username}">查看${sessionScope.username}分数与等级</a></li>
					  <li class="top"><c:if test="${sessionScope.type==0}"><a href="/zuorui/homework.jsp">添加题目</a></c:if></li>
					  <li class="top"><a href="/zuorui/flogin?username=${sessionScope.username}">注销</a></li>
					  <li><form action="/zuorui/search" method="post" onsubmit="return main(this);">
					  			<input type="submit" class="button" value="我搜！我搜！ »">
								<input type="text" class="inputgri3" name="search" maxlength="20">&nbsp; 
									
						</form>
					  </li>
					 </ul>	
						
					<br><td valign="middle" align="left">
				<div align="right">
				
				<a href="/zuorui/xiaoxi?username=${sessionScope.username}">消息(${requestScope.count})</a> &nbsp;&nbsp;&nbsp;
				<a href="/zuorui/xianshimail?username=${sessionScope.username}">站内信(${requestScope.countm})</a></div>
									
								</td><br>
									<tr><td>
									
										<!-- 留言板内容 -->
										<table border="0" width="750" align="center" cellpadding="0"
											cellspacing="0">
											<tr>
												<td>
												   <div>
									
												      <ul>
													<button id="pageup" onclick="addpage()">上一页</button><button id="pagedown" onclick="subpage()">下一页</button>
												
																	
												
													<c:forEach var="h" items="${requestScope.list}" varStatus="status">
																	 <script>
																	$(document).ready(function(){
																				  $(".check"+"#"+"${h.titleid}").click(function(){
																				    $("."+"${h.titleid}").toggle();
																				    $("#"+"${h.titleid}"+".text").toggle();
																				  });
																				});
																	</script>
												          <div id="${status.count}" name="div" style="display:none" class="hover">
												         <li style="font-size:20px;">
												      
												            <span style="display:block;font-size:28px;color:#D52B6F;background:#f0f0f0;border:none solid;padding:10px 40px;width:700px;border-radius:25px;">
												              	<a  href="/zuorui/xianshi2?titleid=${h.titleid}" target="_blank" style="width:600px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;display:block;font-size:18px;font-family:微软雅黑;">${h.title}<c:if test="${h.picture!=null}"><a href="/zuorui/xianshipicture" style="display:block;font-size:18px;">显示图片</a></c:if></a>
											
												              	<div align="left"><font size=1> <c:if test="${sessionScope.type==0}">
												              	<a href="/zuorui/toupdate?titleid=${h.titleid}">修改题目</a>&nbsp;&nbsp;&nbsp;<a href="/zuorui/shanchuhomework?titleid=${h.titleid }&username=${sessionScope.username}">删除</a></c:if>&nbsp;&nbsp;&nbsp;
												              	<input type="button"id="${h.titleid}" class="check" value="评论" style="text-align:centre; width:50px;border-radius:20px; padding:1px 10px;"/>
												              	<form action="/zuorui/message?titleid=${h.titleid}&username=${sessionScope.username}" method="post" onsubmit="return pinglun(this);">
												              	<textarea rows="4" cols="30" class="${h.titleid}" name="text"  tabindex="0" style="display:none;"></textarea>
												              	<input type="submit" id="${h.titleid}" class="text" value="评论"  style="display:none;text-align:centre; width:50px;border-radius:20px; padding:1px 10px;"/>
												              	</form>
												              	</font>
												              	</div>
												        
												            </span>
												                  <p style="text-overflow: ellipsis;width:690px;hight:200px;overflow:hidden;white-space: nowrap;margin-left:20px;"> ${h.textwork }</p>
												         
												                <p align="right"><font size=1>${h.time}</font></p>    
												        
												         </li>
																	
												       
															        <script> 
																			$(document).ready(function(){
																			  $("button"+"#"+ "${h.titleid}"+"."+"show").click(function(){
																			    $("#"+ "${h.titleid}"+".panel").slideToggle("slow");
																			    });
																			});
																	</script>
																	
																	
																	
												        <font size=2> <button id="${h.titleid}" class="show"style="margin-left:20px;">显示评论</button></font>
												   
												         <div id="${h.titleid}" class="panel" style="display:none; margin-left:20px;">
												        <div style="WIDTH: 750; HEIGHT: 250; OVERFLOW: scroll; scrollbar-face-color:#70807d; scrollbar-arrow-color:#ffffff; scrollbar-highlight-color:#ffffff; scrollbar-3dlight-color:#70807d; scrollbar-shadow-color:#ffffff; scrollbar-darkshadow-color:#70807d; scrollbar-track-color:#ffffff">
														<c:forEach var="c" items="${requestScope.list1}">
														
														
																	
														<c:if test="${c.titleid==h.titleid}"> 
														<div style="margin-left:20px; margin-top:15px; padding:5px 40px; border:none solid; border-radius:25px; width:fit-content; background:#FFFFFF;"><font size=3;><span style="color:#113DEE;text-align:left;">${c.username}:</span>&nbsp;${c.text}<br>
														<c:forEach var="x" items="${requestScope.list3}">
														<c:if test="${x.textid==c.textid}"><span style="font-size:30%;color:red;text-align:right">(老师评分：${x.score})</span></c:if>
														</c:forEach></div></font>
														<div align="left" style="margin-left:50px;  font-size:50%;">
														
																	<script>
																		$(document).ready(function(){
																					  $(".check1"+"#"+"${c.textid}").click(function(){
																					    $("#"+"${c.textid}"+".reply").toggle();
																					    $("#"+"${c.textid}"+".text1").toggle();
																					  });
																					});
																	</script>
														<c:if test="${sessionScope.username!=c.username}">
															<input type="button" class="check1" id="${c.textid}" value="回复" style="text-align:centre; width:50px;border-radius:20px; padding:1px 10px;"/>
															<form action="/zuorui/huifuuser?textid=${c.textid}&titleid=${c.titleid}&username=${c.username}&name=${sessionScope.username}" method="post" onsubmit="return huifu(this);">
													        <textarea rows="4" cols="30" class="reply" id="${c.textid}" name="intext"  tabindex="0" style="display:none;"></textarea>
													        <input type="submit" class="text1" id="${c.textid}" value="评论" style="display:none;text-align:centre; width:50px;border-radius:20px; padding:1px 10px;"/>
													        </form>
													    </c:if>
														<c:if test="${sessionScope.type==0}"><c:if test="${c.mark==0}"><a href="/zuorui/toscore?textid=${c.textid}">评分</a></c:if><c:if test="${c.mark==1}"><a href="/zuorui/toupdatescore?textid=${c.textid}">修改评分</a></c:if></c:if>
														<c:if test="${sessionScope.type==1}"><c:if test="${sessionScope.username==c.username}"><a href="/zuorui/shanchu?textid=${c.textid }&username=${sessionScope.username}&titleid=${h.titleid}">删除</a></c:if></c:if>
														<c:if test="${sessionScope.type==0}"><a href="/zuorui/shanchu?username=${sessionScope.username}&textid=${c.textid }&titleid=${h.titleid}">删除</a></c:if> &nbsp; ${c.texttime}</div>
														<c:forEach var="a" items="${requestScope.list2}">
														<c:if test="${a.textid==c.textid}"><br><span style=" margin-left:50px;text-align:left; padding:5px 40px; border:none solid; border-radius:25px; background:#FFFFFF;"><span style="color:#113DEE;">${a.name}&nbsp;<span style="font-size:30%">回复&nbsp;</span>${a.username}</span>:&nbsp;${a.intext}</span>
														<div align="left"style="font-size:30%; margin-left:100px;margin-top:10px;"><c:if test = "${a.name!= a.username}">
														<script>
																		$(document).ready(function(){
																					  $(".check2"+"#"+"${a.huifuid}").click(function(){
																					    $("#"+"${a.huifuid}"+".inputgri2").toggle();
																					    $("#"+"${a.huifuid}"+".text2").toggle();
																					  });
																					});
																	</script>
														<font size=1>
															<c:if test="${sessionScope.username!=a.name}">
															<input type="button" class="check2" id="${a.huifuid}" value="回复" style="text-align:centre; width:50px;border-radius:20px; padding:1px 10px;"/>
															<form action="/zuorui/huifuhuifuuser?huifuid=${a.huifuid}&textid=${a.textid}&username=${a.name}&name=${sessionScope.username}&titleid=${h.titleid}" method="post" onsubmit="return huifu(this);">
													        <textarea rows="4" cols="30" id="${a.huifuid}" class="inputgri2" name="intext"  tabindex="0" style="display:none;"></textarea>
													        <input type="submit" class="text2" id="${a.huifuid}" value="评论" style="display:none;text-align:centre; width:50px;border-radius:20px; padding:1px 10px;"/>
													        </form>
															</c:if>
														</font>
														</c:if>
														<c:if test="${sessionScope.type==1}"><c:if test="${sessionScope.username==a.name}"><a href="/zuorui/shanchupinglun?huifuid=${a.huifuid }&username=${sessionScope.username}&titleid=${h.titleid }">删除</a></c:if></c:if>
														<c:if test="${sessionScope.type==0}"><a href="/zuorui/shanchupinglun?huifuid=${a.huifuid }&username=${sessionScope.username}&titleid=${h.titleid}">删除</a></c:if>&nbsp;${a.nowtime}</div>
														
														</c:if>
														</c:forEach> </c:if>
														
														
														</c:forEach>
																						         
														</div>
														</div>
														
														</div>
														
												   </c:forEach>  
												    
												      </ul>
												   
												   </div>
												</td>												
											
												</tr>
											
												

						<tr bordercolor="#FFFFFF" >
							<td height="10"></td>
						</tr>
					</table>
					</table>
					</table>
					<script>
					function display(id)
					{
					if(document.getElementById(id).style.display=='none')
					{
					document.getElementById(id).style.display='';
					}
					else{
					document.getElementById(id).style.display='none';
					}
					}
					</script>
					<script type="text/javascript">
				    
				    startpage = 1;
				    middlepage = 2;
				    endpage =3;
				    
				    function addpage(){
				     if(document.getElementById(startpage-1)){
				    startpage -= 3;
				     middlepage -= 3;
				    endpage -= 3;
				    }
				    else{
				    alert("这是第一页");
				    return;
				    }
				   
				 var div = document.getElementsByName("div");
				    for(var i=0; i<div.length;i++){
				    div[i].style.display="none";
				    }
				    
				  
				    document.getElementById(startpage).style.display='';
				    document.getElementById(middlepage).style.display=''; 
				    document.getElementById(endpage).style.display='';
				
				    
				    return;
				    }
				    function subpage(){
				    if(document.getElementById(endpage+1)){
				    startpage += 3;
				    middlepage += 3;
				    endpage += 3;
				    }
				    else{
				    alert("这是最后一页");
				    return;
				    }
				    var div = document.getElementsByName("div");
				    for(var i=0; i<div.length;i++){
				    div[i].style.display="none";
				    }
				    
				    
				    if(!document.getElementById(startpage)){
				    return;
				    }
				    document.getElementById(startpage).style.display='';
				     if(!document.getElementById(middlepage)){
				    return;
				    }
				    document.getElementById(middlepage).style.display='';
				     if(!document.getElementById(endpage)){
				   return;
				    }
				    document.getElementById(endpage).style.display='';
				    
				    
				    return;
				    }
				    
				   
				    if(document.getElementById("1")){
				    document.getElementById("1").style.display='';
				    }
				   
				     if(document.getElementById("2")){
				    document.getElementById("2").style.display='';
				    }
				    
				     if(document.getElementById("3")){
				    document.getElementById("3").style.display='';
				    }
				    
				  
				    
					</script>
					<style tyle="roll/css">
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
