<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="user.entity.User"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>
   	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
	<script type="text/javascript" src="js/bootstrap.js"></script>
	
    <style>

        #main{
            margin: 0 auto;
            width: 1500px;
            /* height: 700px; */
            /* border: solid 1px red; */
        }
        .head{
            text-align: center;
            font-family: 隶书;
            font-size: 50px;
            color: #103567;
            line-height: 100px;
            width: 1500px;
            height: 100px;
            /* border: solid green 1px; */
        }
        .body{
            width: 1500px;
            height: 700px; 
            /* border: solid 1px red; */
            background-color: #EBEFF1;
        }
        
        .subbody{
            width: 1500px;
            /* height: 600px; */
           /* border: solid blue 1px; */
            float: left;
            overflow: hidden;
        }
        
       .pagination{
			padding-left: 650px;
		}
		#nav a{
			display: inline-block;
			color: white;
		}
		#nav a:hover{
			background-color: #EBEFF1;
			color: #103567;
		}
		
		.ul1 li{
			list-style: none;
		}
		.left {
			height: 600px;
			width: 600px;
			/* border: solid blue 1px; */ 
			float: left;
   			margin-top: 15px;
			overflow: hidden;
		}

		.right {
			height: 600px;
			width: 800px;
 			/* border: solid blue 1px;  */
			margin-top: 10px;
			overflow: hidden;
			padding-left:30px;
			padding-top:50px;
		}
		.p1{
			font-size: 18px;
			margin-left: 200px;
		}
    </style>
</head>
<body>

<div id="main">
	<div class="head">酒店客房管理系统</div>
	
    <div class="body">
    	<%User user = (User)session.getAttribute("user"); %>
		<nav class="navbar navbar-default" role="navigation" style="background-color: #103567">
    		<div class="container-fluid" id="nav">
    		<div class="navbar-header">
        		<a class="navbar-brand" href="selectByStatus.do">首页</a>
    		</div>
    		<div>
        		<ul class="nav navbar-nav">
            		<li><a href="selectByName.do?username=${username }">个人信息</a></li>
            		<li><a href="selectRoom1.do">客房查询</a></li>
            		<li><a href="selectByUsername.do?username=${username }">我的订单</a></li>
        		</ul>
    		</div>
    		<div><a class="navbar-brand" href="login.jsp" style="float: right;">退出</a></div>
    		</div>
		</nav>

		<div class="subbody">
			<div class="left">
						<p><a href="selectByPath.do?path=${r.path}"><img style="margin-left: 100px" src="img/${r.path}" width="400px"
							height="300px"></a><p>
						<table class="table table-bordered" style="width: 400px; margin-left: 100px">
							<tr>
								<td>房间号：</td>
								<td>${r.roomid }</td>
							</tr>
							<tr>
								<td>房间类型：</td>
								<td>${r.roomtype }</td>
							</tr>
							<tr>
								<td>房间价格：</td>
								<td>￥${r.price }/天</td>
							</tr>
							<tr>
								<td>房间状态：</td>
								<td>${r.roomstatus }</td>
							</tr>
						</table>
					
		</div>
		<div class="right">
		<h3 style="padding-left: 250px; ">预定客房</h3>
		
			<form action="reserve.do" method="post">
				<table class="table table-bordered" style="width: 400px; margin-left: 100px">
					<tr>
						<td>姓名:</td>
						<td><input type="text" value="${username }" name="username" readonly></td>
					</tr>
					<tr>
						<td>房间号：</td>
						<td><input type="text" name="roomid" size="4"></td>
					</tr>
					<tr>
						<td>到店日期：</td>
						<td><input type="date" value="" name="arrive"></td>
					</tr>
					<tr>
						<td>离店日期：</td>
						<td><input type="date" value="" name="leave"></td>
					</tr>
					<tr>
						<td>订单状态</td>
						<td><select name="status">
						       <option value="已预定">已预定</option>
								<option value="已入住">已入住</option>
							</select>
						</td>
					</tr>		
				</table>
				
              <input type="submit" value="预定" class="btn btn-primary"  style="margin-left:250px">&nbsp;&nbsp;
              <a href="selectByStatus.do"  class="btn btn-primary">返回</a>
			</form>
		</div>
			
		</div>
	</div>
</div>
</body>
</html>