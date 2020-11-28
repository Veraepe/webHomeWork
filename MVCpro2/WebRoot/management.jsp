<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>MANAGEMENTMODE</title>
		<script type="text/javascript">
			window.onload=function(){
				
				var uimg=document.getElementById("uimg");
				var imgliDEul=document.getElementById("imgliDEul");
				var flag=0;
			
				uimg.onclick=function(){
					if(flag==0){
					imgliDEul.style.display="block";
					flag=1;
					}
					else
					{
						imgliDEul.style.display="none";
						flag=0;
					}
					event.cancelBubble=true;//åæ¶è§¦ååæ³¡äºä»¶
				}
				
				window.onclick=function(event){
					imgliDEul.style.display="none";
					flag=0;
					
				}
			}
		</script>
		
		
		<style type="text/css">
			*{
				box-sizing: border-box;
				background: #FBFEFB;
				margin: 0px;
			}
			
			
			#header{
				 padding-left: 15px;
				 padding-top: 15px;
				 margin: 0px;
				 padding-bottom: 0px;
				 text-align: left;
				 background-color: #EFE5DC;
				 color: black;
				 font-family:"courier new";
				 display: flex;
			}
			
			
			#wennzi{
				background: #EFE5DC;
				padding-left: 10px;
				color: white;
				font-size: 25px;
				font-family:"gill sans mt";
				flex:80%;
				margin-bottom: 0px;
				padding-bottom: 0px;
			}
			
			#imgdiv{
				background: #EFE5DC;

				font-size: 20px;
				font-family:"gill sans mt";
				padding-right: 15px;
				flex:20%;
				text-align: right;
				padding-bottom: 0px;
				margin-bottom: 0px;

			}
			

			#uimg{
				width:  30px;
				height: 30px;
				background: #EFE5DC;
				margin-right: 20px;
				margin-bottom: 0px;
				padding-bottom: 0px;
			}      
			        
			#imgliDEul{
			    display: none;
			    position: absolute;
			    right: 35px;
				background-color: #f9f9f9;
				min-width: 190px;
				padding: 0px;
				box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
				z-index: 1;
			}
			#imgliDEul a{
				color: black;
				padding: 12px 16px;
				text-decoration: none;
				display: block;
				text-align: right;
				background: #FBFEFB;
				margin: 0px;
			}
			
			#imgliDEul a:hover{
				background: #D0B8AC;
				color: #F9F9F9;
			}
			
			#titlediv{
				padding: 40px;
				margin: 0px;
				text-align: center;
				background-color: #F3D8C7;
				color: black;
				font-family:"ms serif";
				color:white;
				font-size: 25px;
			}		
			
			#middleDiv{
				padding: 30px;
				margin: 0px;
				text-align: center;
				color: #EFE5DC;
				font-family:"imprint mt shadow";
				font-size: 30px;
				letter-spacing:10px;
			}
			
			#downloaddiv{
				background: #F3D8C7;
				padding: 30px;
				
				margin-left: 0px;
				margin-right: 0px;
				
			}
			
			#submitdiv input:focus{
			border: 5px solid white;
			background-color: lightblue;
		}
		
			#downloadform{
				background: #F3D8C7;
			}
			
			#addDownloadMsgValue{
				border: 2px solid #D0B8AC;
				 border-radius: 4px;
				 height: 40px;
				 width: 80%;
				 font-size: 20px;
			}
			
			#addDownloadMsg{
				height: 40px;
				width: 15%;
				border: 2px solid #D0B8AC;
				border-radius: 4px;
				font-size: 20px;
			}
			
			
			#downloadmsg{
				display: block;	
				background: #EFE5DC;
				font-size: 25px;
				margin-bottom: 5px;
			}
		
			#msgpart{
				float:left;
				background: #EFE5DC;
			}
			
			#submitpart{
				flex:30%;
				text-align: right;
				background: #EFE5DC;			
			}
			
			#submitpart a{
				background: #D0B8AC;
				color: #F1F1F1;
			}
			#submitpart a:hover{
				background:#F1F1F1;
				color:#D0B8AC;
			}
			
			li{
				text-decoration: 0px;
				list-style-type: none;
			}
			
			#upsmiddleDiv{
				padding: 20px;
				margin: 0px;
				background: #D0B8AC;
			}
			
			#smiddleDiv{
				padding: 8px 30px;
				margin-bottom: 30px;
				text-align: center;
				color: #EFE5DC;
				font-family:"imprint mt shadow";
				font-size: 30px;
				letter-spacing:10px;
			}
			
			#userdiv
			{
				background: #F3D8C7;
				padding: 30px 15px;
				margin-left: 50px;
				margin-right: 50px;
				border: 30px solid #EFE5DC;
			}
			
			#usersubmitdiv input:focus{
				border: 5px solid white;
				background-color: lightblue;
			}
			
			#userform{
					background: #F3D8C7;
				}
				
			#addUserMsgValue{
					border: 2px solid #EFE5DC;
					 border-radius: 4px;
					 height: 40px;
					 width: 80%;
					 font-size: 20px;
				}
				
				#addUserMsg{
					height: 40px;
					width: 15%;
					border: 2px solid #EFE5DC;
					border-radius: 4px;
					font-size: 20px;
				}
			
				#usermsg{
					display: block;	
					background:#F3D8C7;
					color:#D0B8AC;
					font-size: 25px;
					margin-bottom: 5px;
				}
			
				#usermsgpart{
					float:left;
					background:#F1F1F1;
					color:#D0B8AC;
				}
				
				#usersubmitpart{
					flex:30%;
					text-align: right;
					background:#F1F1F1;
					color:#D0B8AC;			
				}
				
				#usersubmitpart a{

					background:#F1F1F1;
					color:#D0B8AC;
				}
				#usersubmitpart a:hover{
					background: #D0B8AC;
					color: #F1F1F1;
				}
				
				#bottom{
					padding: 40px;
					margin-top: 100px;
					text-align: center;
					background-color: #F3D8C7;
					color: black;
					font-family:"ms serif";
					color:white;
					font-size: 25px;
				}
				
		</style>
		
	</head>
	<body>
		<div id="header">
			<div id="wennzi">USER:</div>
			<div id="imgdiv">

					<img id="uimg" src="#"></img>

					<div id="imgliDEul">
					       <a href="#">主页面</a><br>
					       <a href="#">退出</a><br>
					       <a href="#">安全退出</a>
					</div>
					
			</div>
		</div>
		<div id="titlediv">
			ManagePage
		</div>
		
		<div id="middleDiv">
			DOWNLOADMSG
		</div>
		
		<div id="downloaddiv">
			<div id="submitdiv">
			<form id="downloadform" action="#" method="post">
				<input type="text" name="addDownloadMsgValue" id="addDownloadMsgValue"
				value="请输入名称,文件名,大小,星级............"
				/>
				<input type="submit" name="addDownloadMsg" id="addDownloadMsg" value="SUBMIT"/>
			</form>
			</div>
			<br>
			<c:forEach items="${downloadListt}" var="download">
			<div id="downloadmsg">
					<div id="msgpart">
					NAME:${download.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;SIZE:${download.size}
					</div>
					<div id="submitpart">
					<a>&nbsp;&nbsp;DELETE&nbsp;&nbsp;</a>
					
					</div>
			
			</div>
			</c:forEach>
		</div>
		<div id="upsmiddleDiv">
			
		</div>
		
		<div id="smiddleDiv">
			USERMSG
		</div>
		
		<div id="userdiv">
			<div id="usersubmitdiv">
			<form id="userform" action="#" method="post">
				<input type="text" name="addUserMsgValue" id="addUserMsgValue"
				value="请输入用户名,密码,角色............."
				/>
				<input type="submit" name="addUserMsg" id="addUserMsg" value="SUBMIT"/>
			</form>
			</div>
			<br><br><br>
			<c:forEach items="${userList}" var="user">
			<div id="usermsg">
					<div id="usermsgpart">
						USERNAME:&nbsp;${user.userName} &nbsp;&nbsp;ROLE:&nbsp;${user.role}
					</div>
					<div id="usersubmitpart">
					<a>&nbsp;&nbsp;DELETE&nbsp;&nbsp;</a>
					</div>
			</div>
			</c:forEach>
		</div>
		
		<div id="bottom">
			BY VERAPER
		</div>
	</body>
</html>
