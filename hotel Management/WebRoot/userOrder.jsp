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
            width: 600px;
            height: 600px;
            /* border: solid blue 1px; */
            margin-left: 500px;
            padding: 50px; 
            /* font-size: 18px;
            text-align: center;
            background-color: white; */
        }
		#nav a{
			display: inline-block;
			color: white;
		}
		#nav a:hover{
			background-color: #EBEFF1;
			color: #103567;
		}
    </style>
    
</head>
<body>
<div id="main">
	<div class="head">酒店客房管理系统</div>
	
    <div class="body">
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
			<h2>我的订单</h2><br><br>
			<form class="userOrder" action="updateReserve1.do" method="post">
				<table class="table table-bordered">
					<tr>
						<td>订单编号</td>
						<td><input type="text" name="dingdanid" value="${a.dingdanid }"
							readonly></td>
					</tr>
					<tr>
						<td>用户编号</td>
						<td><input type="text" name="userid" value="${a.u.userid }"
							readonly></td>
					</tr>
					<tr>
						<td>姓名</td>
						<td><input type="text" name="username" value="${a.u.username }"
							readonly></td>
					</tr>
					<tr>
						<td>房间号</td>
						<td><input type="text" name="roomid" value="${a.r.roomid}">
						</td>
					</tr>
					<tr>
						<td>到店日期</td>
						<td><input type="date" name="arrive" value="${a.arrive}">
						</td>
					</tr>
					<tr>
						<td>离店日期</td>
						<td><input type="date" name="leave" value="${a.leave}">
						</td>
					</tr>
					<tr>
						<td>订单状态</td>
						<td><select name="status">
						        <option value="已预订">已预定</option>
								<option value="已取消">已取消</option>
								<option value="已入住">已入住</option>
						</select>
						</td>
					</tr>
				</table>
				<button type="submit" class="btn btn-primary" style="margin-left: 100px">修改</button>&nbsp;&nbsp;
				
			</form>
			
		</div>
		
	</div>
</div>

</body>
</html>