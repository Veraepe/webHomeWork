<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>出错啦！</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">		
		window.setInterval(changetime,1000);
		function changetime()
		{
			var realtime=document.getElementById("leaveTime");
		   var time=parseInt(realtime.innerText);
			time=time-1;
			if(time==0)
			{
			   window.location.href="login.html";
			}
			else
			{
				realtime.innerText=time;
			}
		}
	</script>
  </head>
  
  <body>
   	<div id="errordiv">
   	<p id="errorinfo">${info}</p>
   	<p><span id="leaveTime">10</span>秒后自动跳转回去~</p>
   	<p>如果您不能跳转，请<a href="login.html">点击这里</a></p>
   	</div>
  </body>
</html>
