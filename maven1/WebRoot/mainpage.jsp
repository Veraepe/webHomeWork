<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>��ӭ��</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1,shrink-to-fit=no">
  <link rel="stylesheet" href="js/bootstrap-4.5.3-dist/css/bootstrap.min.css">
  <script src="js/jquery-3.5.1.min.js"></script>
  <script src="js/bootstrap-4.5.3-dist/popper.js/1.15.0/umd/popper.min.js"></script>
  <script src="js/bootstrap-4.5.3-dist/js/bootstrap.min.js"></script>
  <script src="js/json2.js"></script>
  <style type="text/css">
	
  	body{
		margin: 0px;
		overflow-x: hidden;
	}
	
	.bccolorOne{
		background: #f1f6f9;
	}
	
	.bccolorTwo{
		background:#14274e;
	}
	
	.bccolorThree{
		background: #394867;
	}
	
	.bccolorFour{
		background: #9ba4b4;
	}
	
	.colorOne{
		color: #f1f6f9;
	}
	
	.colorTwo{
		color:#14274e;
	}
	
	.colorThree{
		color: #394867;
	}
	
	.colorFour{
		color: #9ba4b4;
	}
	
	.fontOne{
		font-family: "����"; 
		letter-spacing:2px;
		font-size: 20px;
	}
	
	.fontTwo{
		font-family: "΢���ź�";
		letter-spacing: 8px;
		font-weight: bold;
		font-size: 50px;
	}
	
	.fontThree{
		font-family: "΢���ź�";
		letter-spacing: 3px;
		font-weight: bold;
		font-size: 25px;
	}
	
	.forHeaderButton{
		height: 80%;
	}
	
	dropdown{
		display: none;
	}
	
	dropdown:hover{
		display: block;
	}
	
	.carousel-inner img {
	      width: 100%;
		  height: 100%;
	  }
	
	#introduceNav a{
		color: #000000;
	}
	
	#introduceNav a:hover{
		 color: firebrick;
	}
	
	li:hover
	.dropdown-menu
	{
		display:block;
	}
  </style>
  <script type="text/javascript">
	  window.onload=function(){
		//�������Ĵ���
		$.ajax({
			type:"post",
			url:"getMenuContent.do",
			data:{},
			dataType:"json",
			success:function(response)
			{
				doMenu(response);
			}
		});
		
	//test	
	/*	var responsestr='[{"itemId":"shouye","parentId":"shouye","parentName":"��ҳ","itemName":"��ҳ","Link":"https://www.baidu.com"},';
		 responsestr+='{"itemId":"gszucheng","parentId":"gsgaikuang","parentName":"��˾�ſ�","itemName":"��˾���","Link":"https://www.baidu.com"},'; 
		responsestr+='{"itemId":"ryfenbu","parentId":"gsgaikuang","parentName":"��˾�ſ�","itemName":"��Ա���","Link":"https://www.baidu.com"},';  
		responsestr+='{"itemId":"sxgongzuo","parentId":"rczhaopin","parentName":"�˲���Ƹ","itemName":"ʵϰ����","Link":"https://www.baidu.com"}]';
		//JSON.parse()
		var response=JSON.parse(responsestr);
	*/			
		function bindLink(tool,str)
		{
			tool.click(
			function()
			{
				window.location.href=str;
				return false;
			}
			);
		}
		
		function doMenu(res)
		{
			for(var i=0;i<res.length;i++)
			{
				console.log(res[i].parentId);
				if(res[i].itemId==res[i].parentId)
				{
					var tool=$("#"+res[i].parentId.toString()).find("a");
					var str=res[i].Link;
					bindLink(tool,str);
				}
				else
				{
					//˵��Ҫ�������˵�
					if($("#"+res[i].parentId.toString()).find("div").length==0)
					{
						$("#"+res[i].parentId.toString()).append('<div class="dropdown-menu" style="color: #000000;">'+
													'<a class="dropdown-item" href="'+res[i].Link+'">'+res[i].itemName+'</a>'+
													'</div>');
					}
					else
					{
						$("#"+res[i].parentId.toString()).find("div").append('<a class="dropdown-item" href="'+res[i].Link+'">'+res[i].itemName+'</a>');
					}
				}
			}
		}
		 
		 
		 
		  
		/*var str="gongsigaikuang";
		$("#"+str).append('<a class="dropdown-item" href="#">Link 11'+
									'</a><a class="dropdown-item" href="#">Link 2</a>'+
									'<a class="dropdown-item" href="#">Link 3</a>');
	   $("#picInner").append(
	   '<div class="carousel-item">'
	     +'<img src="lunbo2.jpg">'
	     +'<div class="carousel-caption">'
	     +  '<p class="fontThree">������ף��ҵ���¼���԰������!</p>'
	    + '</div>'
	   +'</div>'
	   
	   );
	   
	   $("#zhkeji").find("div").eq(0).append('<a class="dropdown-item" href="#">Link 11'+
									'</a><a class="dropdown-item" href="#">Link 2</a>'+
									'<a class="dropdown-item" href="#">Link 3</a>');
	 
	 
	 
	  //console.log($("#shouye").children().eq(0).length);
	   if($("#shouye").find("div").eq(0).length==0)
	   {
		   
		    $("#shouye").append('<div class="dropdown-menu" style="color: #000000;">'+'<a class="dropdown-item" href="#">Link 11'+
									'</a><a class="dropdown-item" href="#">Link 2</a>'+
									'<a class="dropdown-item" href="#">Link 3</a>'+'</div>');
			
	   }
	   
	   $("#shouye").attr('href',"https://www.baidu.com");
	   */
	  
	  };
	  
  </script>

  </head>
  
  <body>
   <body>
	<div id="header" class="align-items-lg-center row bccolorThree p-2 text-white fontOne font-weight-light">
		<div class="col-md-2 ml-3">
		��ǰ��¼:
		<a id="login" href="#"><small>���ҵ�¼</small></a>
		</div>
		<div class="col-md-3 offset-md-6 mr-1 input-group h-75">	
			<input type="text" class="form-control"/>
			<div class="input-group-append">
			<button class="btn bccolorOne" type="submit">Q</button> 
			</div>
		</div>
	</div>
	<nav class="navbar navbar-expand-sm fontOne pl-5 pr-5 bccolorTwo navbar-dark">
		<a class="navbar-brand" href="#">
		    <img src="LOGO.png" alt="logo" style="width:90px;">
		  </a>
		 <ul class="navbar-nav" id="navDiv">
		    <li class="nav-item" id="shouye">
		      <a class="nav-link" href="javaScript:;" id="navbardrop" data-toggle="dropdown">
				  ��ҳ</a>
			   
		    </li>
			<li class="nav-item dropdown" id="gsgaikuang">
			      <a class="nav-link " href="#" id="navbardrop" data-toggle="dropdown">
			        ��˾�ſ�
			      </a>
			</li>
		    <li class="nav-item dropdown" id="zhkeji">
		          <a class="nav-link " href="#" id="navbardrop" data-toggle="dropdown">
		            �ǻۿƼ�
		          </a>
		    </li>
			<li class="nav-item dropdown" id="fwzhichi">
			      <a class="nav-link " href="#" id="navbardrop" data-toggle="dropdown">
			        ����֧��
			      </a>
			</li>
			<li class="nav-item dropdown" id="rczhaopin">
			      <a class="nav-link " href="#" id="navbardrop" data-toggle="dropdown">
			        �˲���Ƹ
			      </a>
			</li>
			<li class="nav-item dropdown" id="gywomen">
			      <a class="nav-link" href="#" id="navbardrop" data-toggle="dropdown">
			        ��������
			      </a>
			</li>
		</ul>
	</nav>
	
	<div id="demo" class="carousel slide" data-ride="carousel">
	 
	  <!-- ָʾ�� -->
	  <ul class="carousel-indicators">
	    <li data-target="#demo" data-slide-to="0" class="active"></li>
	    <li data-target="#demo" data-slide-to="1"></li>
	    <li data-target="#demo" data-slide-to="2"></li>
	  </ul>
	 
	  <!-- �ֲ�ͼƬ -->
	  <div class="carousel-inner" id="picInner">
	    <div class="carousel-item active">
	      <img src="lunbo1.jpg">
		  <div class="carousel-caption">
		    <p class="fontThree">��ˮ��ɽ���ǽ�ɽ��ɽ</p>
		  </div>
	    </div>
	    
		<div class="carousel-item">
		  <img src="lunbo3.jpg">
		<div class="carousel-caption">
		  <p class="fontThree">������ף�ҹ�˾��ҵ����ʵ���ҽ���!</p>
		</div>
		</div>
	   
	  </div>
	 
	  <!-- �����л���ť -->
	  <a class="carousel-control-prev" href="#demo" data-slide="prev">
	    <span class="carousel-control-prev-icon"></span>
	  </a>
	  <a class="carousel-control-next" href="#demo" data-slide="next">
	    <span class="carousel-control-next-icon"></span>
	  </a>
	</div>


	<div id="introduce" class="mt-5 w-100">
		<p class="text-center fontTwo">���ǵķ���</p>
	</div>
	
	<div id="introduceNav" class="container mb-5">
	<div class="border border-top-0 border-left-0 border-right-0 border-bottom d-flex text-center w-100 mb-5">
	    <div class="p-5 flex-fill"><a class="fontThree" href="javaScript:;">�������</a></div>
	    <div class="p-5 flex-fill"><a class="fontThree" href="javaScript:;">�������</a></div>
	    <div class="p-5 flex-fill"><a class="fontThree" href="javaScript:;">��Ⱦ���</a></div>
		<div class="p-5 flex-fill"><a class="fontThree" href="javaScript:;">����֤��</a></div>
	  </div>
	  <div class="d-flex flex-row">
		  <div class="border w-50 mr-5 ml-5 p-1">
		      <img src="jiance1.jpg" id="fuwu1pic" alt="John Doe" class="mr-1 mt-1 rounded d-flex mx-auto" style="width:100%; height: 70%;">
		      <div class="media-body">
		        <p id="funwu1text" class="fontOne text-center text-black">�������������</p>      
		      </div>
		    </div>
			<div class="border w-50 mr-5 ml-5 p-1">
			    <img src="jiance2.jpg" id="fuwu2pic" alt="John Doe" class="mr-1 mt-1 rounded d-flex mx-auto" style="width:100%; height: 70%;">
			    <div class="media-body">
			      <p id="funwu2text" class="fontOne text-center text-black">��Ч�ʸ��Լ۱�</p>      
			    </div>
			  </div>
	  </div>
	</div>
	
	<div id="bottomDiv" class="row bccolorThree colorOne mb-0 mr-0 ml-0 p-3">
		<div class="col-2">
			<a>��ϵ����:</a>
			<br>
			<a>&nbsp;tele:15975451557</a>
			<br>
			<a>&nbsp;Email:2077il@kunlun.com</a>
		</div>
		
		<div class="col-4 border border-secondary border-left-0 border-bottom-0 border-top-0 border-right">
		</div>
			
		<div class="col-3 offset-3">
			<a>���ػ�����Ƽ����޹�˾��Ȩ���� �0�8 2077 Copyrights all reserved ICP��xxxxx��-0x ����xxxxxxxxxxxxxx��</a>
		</div>
	</div>
  </body>
</html>
