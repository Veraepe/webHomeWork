<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>MANAGEMENTMODE</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style>
			* {
			    box-sizing: border-box;//一定要设置哦~
			}
			
			body{
				margin: 0px;
			}
			
			#header{
				 padding-left: 0px;
				 padding-right: 80px;
				 padding-bottom: 30px;
				 padding-top: 10px;
				 margin: 0px;
				 text-align: left;
				 background: powderblue;
				 color: white;
			}
			
			#header h1{
				font-size: 40px;
			}
			
			/* 导航 */
			#navbar {
				overflow: hidden;
			    background-color: #333;
			}
			 
			/* 导航栏样式 */
			#navbar a {
			    float: left;
			    display: block;
			    color: white;
			    text-align: center;
			    padding: 15px 30px;
			    text-decoration: none;
			}
			 
			/* 鼠标移动到链接的颜色 */
			#navbar a:hover {
			    background-color:lightgray;
			    color: black;
			}
			 
			#navbar .right{
				float: right;
				display: block;
				color: white;
				text-align: center;
				padding: 5px 20px;
				margin: 12px;
				text-decoration: none;
			}
			
			#row {  
			    display: -ms-flexbox; /* IE10 */
			    display: flex;
			    -ms-flex-wrap: wrap; /* IE10 */
			    flex-wrap: wrap;
			}
			 
			/* 创建两个列 */
			/* 边栏 */
			#side {
			    -ms-flex: 30%; /* IE10 */
			    flex: 30%;
			    background-color: #f1f1f1;
			    padding: 120px;
			}
			
			#side a{
				font-size: 20px;
				color: #B0E0E6;

			}
			
			#side h3{
				font-size: 30px;
			}
			
			#side p{
				font-size: 20px;
				letter-spacing:3px;
			}
			/* 主要的内容区域 */
			#main {   
			    -ms-flex: 70%; /* IE10 */
				flex: 70%;
			    background-color: whitesmoke;
			    padding: 120px;
			}
			
			#img{
				height: 200px;
				width: 200px;
				background: #aaa;
				width: 100%;
				padding: 20px;
				
			}
			
			
			
		</style>
		
		<script type="text/javascript">
			window.onload=function(){
				var download=document.getElementById("download");
				var userName=document.getElementById("userName");
				
				if(userName.innerHTML=="")
				{
					userName.innerHTML="暂时没有登录";
				}
				download.onclick=function(){
					if(userName.innerHTML=="暂时没有登录")
						alert("您还没有登录哦~");
					else
					{
						download.href="GetDownloadList.do";
					}
				};
			};
		</script>
		
	</head>
	<body>
		<div id="header">
		  <h1>FirstHomeWork</h1>
		  <p>there is the things you will be like</p>
		</div>
		
		<div id="navbar">
		  <a id="download" href="#">下载资料</a>
		  <a href="#">了解我们</a>
		  <a href="GetManagementList.do">管理</a>
		  <input class="right" type="text"/>
		</div>
		
		<div id="row">
			<div id="side">
			
			<h3>当前登录用户为:</h3>
			<p id="userName" name="userName">${sessionScope.userName}</p>
			
			<form action="out.do" method="post"><input type="submit" value="退出"/></form>
			 </form>
			 <br>
			 <form action="Saveout.do" method="post"><input type="submit" value="安全退出"/>
			 </form>
			 <br>
			 <div id="img" name="touxiang">
			 <img src="#" />
			 </div>
			    
			  </div>
			  
			<div id="main">
			   
			</div>
			
		</div>
	</body>
</html>

