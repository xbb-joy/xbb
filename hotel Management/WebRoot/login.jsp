<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	
	<style>
        *{
            padding: 0;
            margin: 0;
        }
        body{
        	background-image:url(img/background.jpg);
        	background-repeat: no-repeat;
        	background-size:100% 100%; 
        	background-attachment: fixed;
        }
        .p1{
            padding: 10px;
            text-align: center;
            font-size: 20px;
            color: white;
        }
        .head{
        	height: 100px; 
            margin: 100px auto;
            font-family: 隶书;
            font-size: 50px;
            text-align: center;
            color: white;
        }
        .body{
            width: 400px;
            height: 200px;
            margin: 100px auto;
            
        }
        input{
            font-size: 18px;
            color: black;
        }
    </style>
    
    <script>
		function login(){
	 		//获取uname的值
			var username = $("#username").val();
			
			//获取密码的值
			var upwd = $("#upwd").val();
			//定义ajax
			$.ajax({
				url:'login.do', //要访问的地址
				data:'username='+username +'&upwd='+upwd, //传递的参数
				type:'post', //提交方式
				dataType:'json', //返回的数据类型，json格式
				success:function(result){ //回调函数，从后台获取的数据
					//后台传什么数据，result就是什么数据
					//alert(result.uname);
					if(result != null){
						if(result.identity == "管理员"){
							location.href = "selectUser.do";
						}if(result.identity == "普通用户"){
							location.href = "selectByStatus.do";
						}	
					}else{
						location.href = "login.jsp";
					}
				}
			}); 
		}
		
	</script>
    
  </head>
  
  <body>
    <div class="head"><p>酒店客房管理系统</p></div>
	<div class="body">
    	<form method="post">
        	<p class="p1">姓名：<input type="text" name="username" id="username"></p>
        	<p class="p1">密码：<input type="text" name="upwd" id="upwd"></p>
        	<p class="p1">
          	  	<button type="button" class="btn btn-default" onclick="login()">登录</button>&nbsp;&nbsp;&nbsp;
          	  	<button type="button" class="btn btn-default" data-toggle="modal" data-target="#myModal">注册</button>
       	 	</p>
    	</form>
	</div>
	
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    	<div class="modal-dialog">
			<div class="modal-content">
            	<div class="modal-header">
                	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                	<h4 class="modal-title" id="myModalLabel">注册</h4>
           	 	</div>
            
            	<form action="register.do" method="post">
            		<div class="modal-body" id="for">
                		<p>编号：<input type="text" name="userid"></p>
    					<p>姓名：<input type="text" name="username"></p>
    					<p>密码：<input type="text" name="upwd"></p>
       					<p>身份：<input type="radio" name="identity" value="管理员" id="admin">管理员 &nbsp;&nbsp;
         						<input type="radio" name="identity" value="普通用户" id="user">普通用户</p>          
            		</div>
            
            		<div class="modal-footer">
                		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                		<button type="submit" class="btn btn-primary">提交</button>
           			</div>
             	</form>
        	</div><!-- /.modal-content -->
    	</div><!-- /.modal -->
	</div>
	
  </body>
</html>
