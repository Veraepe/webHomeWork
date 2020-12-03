<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>下载</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<meta charset="utf-8">
		<title></title>
		<style type="text/css">
			*{
			    box-sizing: border-box;//一定要设置哦~
			}
			
			body{
				background:#68D8D6;
				margin: 0px;
			}
			
			#header{
				 padding-left: 0px;
				 padding-right: 80px;
				 padding-bottom: 10px;
				 padding-top: 10px;
				 margin: 0px;
				 text-align: left;
				 background: #07BEB8;
				 color: white;
			}
			
			#header p{
				font-family: "agency fb";
				text-align: center;
				letter-spacing:5px;
				font-size: 20px;
				font-weight: bold;
			}
			
			#maindiv{
				
				width: 80%;
				background: #9ceaef;
				margin:50px auto;
				padding-left:50px;
				padding-right: 50px;
				padding-bottom: 30px;
				padding-top: 20px;
				color: #333333;
				
			}
			
			#uimg{
				float: left;
				margin-left: 0px;
				margin-right: 50px;
				margin-bottom: 50px;
				width:  80px;
				height: 80px;
				
			}
			
			#maindiv ul{
				list-style: none;
			}
			
			#wordname{
				font-size: 20px;
			}
			
			#wordname{
				letter-spacing:3px;
				font-size: 25px;
				font-weight: bold;
				font-family: "arial narrow";
			}
			
			#protary{
				letter-spacing:1px;
				font-size: 15px;
				font-weight: bold;
			}
			
			#somethingAbout{
				font-size: 15px;
				font-weight: bold;
			}
			
			#downloadLink:link , #downloadLink:visited{
						
				 	letter-spacing:6px;
					color:#FFFFFF;
				 	background-color:#3dccc7;
					display: flex;
				 	width: auto;
					padding-top:7px;
					padding-bottom:7px;
					padding-left: 5px;
				 	text-decoration:none;
					margin-top: 10px;
			}
			
			#downloadLink:hover{
				color:#000000;
				background-color:#68D8D6;
				font-weight: bold;
			}
			
			#tuichu:link , #downloadLink:visited{
						
				 	letter-spacing:6px;
					color:#FFFFFF;
				 	background-color:#3dccc7;
					display: flex;
					padding-top:7px;
					padding-bottom:7px;
					padding-left: 5px;
				 	text-decoration:none;
					margin-top: 10px;
					justify-content: center;
					align-items: center;
			}
			
			#tuichu:hover{
				color:#000000;
				background-color:#68D8D6;
				font-weight: bold;
			}
			
			
			#Footerheader{
				 padding-left: 0px;
				 padding-right: 80px;
				 padding-bottom: 10px;
				 padding-top: 10px;
				 margin: 0px;
				 text-align: left;
				 background: white;
				 color: black;
			}
			
			#Footerheader p{
				font-family: "agency fb";
				text-align: center;
				letter-spacing:5px;
				font-size: 20px;
				font-weight: bold;
			}
			
			#footer {
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
			    background-color: #07BEB8;
			    padding: 120px;
				color: #F1F1F1;
				
			}
			
			#side p{
				display: flex;
				text-align: center;
				font-size: 20px;
				justify-content: center;//felx居中必备
				align-items: center;
			}
			
			/* 主要的内容区域 */
			#main {   
			    -ms-flex: 70%; /* IE10 */
				flex: 70%;
			    background-color: #3DCCC7;
			    padding: 120px;
			}
			
			
			#imgfoot{
				width: 80px;
				height: 80px;
				display: flex;
				justify-content: center;//felx居中必备
				align-items: center;
				margin: 0 auto;
			}
			
			#mainpage:link , #downloadLink:visited{
						
				 	letter-spacing:6px;
					
					width: 100%;
					display: flex;
					padding-top:7px;
					padding-bottom:7px;
					padding-left: 5px;
				 	text-decoration:none;
					margin-top: 10px;
					justify-content: center;
					align-items: center;
					color:#000000;
					background-color:#68D8D6;
			}
			
			#mainpage:hover{
				color:#FFFFFF;
				 background-color:#03bcc3;
				font-weight: bold;
			}
			
		</style>
	</head>
	<body>
		<div id="header">
			<p>DOWNLOAD PAGE</p>
		</div>
		
		<c:forEach items="${downloadList}" var="download">
		<div id="maindiv">
			<ul>
				<li>
				<p id="wordname">${download.name}</p>
				<div id="part">
				<img id="uimg" src="${download.image}"></img>
				<p>
					<span id="protary">${download.description}</span><br>
					<br>
					<span id="somethingAbout">	
					<i>时间：${download.time}</i>
					<i>大小：${download.size}</i>
					<i>星级：${download.star}</i>
					</span>
				</p><br>	
				<a id="downloadLink" href="DownloadController.do?id=${download.id}" title="等待下载">下载</a>
				</div>
				</li>
			</ul>
		</div>
		</c:forEach>
		
		<div id="Footerheader">
			<p>FOOTER</p>
		</div>
		
		<div id="footer">
			<div id="side">
				<p>当前登录</p>
				<img id="imgfoot" src="#"></img>
				<br>
				<p>${sessionScope.userName}</p>
				<a id="tuichu" href="out.do" title="退出">退出</a>
			</div>
			<div id="main">
				
				<a id="mainpage" href="/ajaxlogin/main.jsp" title="主页面">主页面</a>
				
			</div>
		</div>
	</body>
</html>
