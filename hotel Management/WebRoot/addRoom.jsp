<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        .left{
            /* background-color: #103567; */
            font-family: 宋体;
            /* color: white; */
            width: 200px;
            height: 700px;
            /* border: solid 1px green; */
            float: left;
        }
        .right{
            width: 1290px;
            /* height: 600px; */
            /* border: solid blue 1px; */
            float: right;
            overflow: hidden;
        }
        .panel-body:hover {
        	background-color: #EBEFF1;
		}
		.pagination{
			padding-left: 500px;
		}
		
    </style>
    
   
</head>
<body>
<div id="main">
	<div class="head">酒店客房管理系统</div>
    <div class="body">

		<div class="left">
			<div class="panel-group" id="accordion">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion" 
				   				href="#collapseOne" style="text-decoration: none">
							用户管理
							</a>
						</h4>
					</div>
					<div id="collapseOne" class="panel-collapse collapse in">
						<div class="panel-body">
							<a href="selectUser.do" style="text-decoration: none; color: gray">用户查询</a>
						</div>
						<div class="panel-body">
							<a href="addUser.jsp" style="text-decoration: none; color: gray">用户添加</a>
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion" 
					   			href="#collapseTwo" style="text-decoration: none">
								客房管理
							</a>
						</h4>
					</div>
					<div id="collapseTwo" class="panel-collapse collapse">
						<div class="panel-body">
							<a href="selectRoom.do" style="text-decoration: none; color: gray">客房查询</a>
						</div>
						<div class="panel-body">
							<a href="addRoom.jsp" style="text-decoration: none; color: gray">客房添加</a>
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion" 
				  	 			href="#collapseThree" style="text-decoration: none">
								订单管理
							</a>
						</h4>
					</div>
					<div id="collapseThree" class="panel-collapse collapse">
						<div class="panel-body">
							<a href="selectReserve.do" style="text-decoration: none; color: gray">订单查询</a>
						</div>
						<div class="panel-body">
							<a href="addReserve.jsp" style="text-decoration: none; color: gray">订单添加</a>
						</div>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" data-parent="#accordion" 
						  	 href="#collapseFive" style="text-decoration: none">
								账单管理
							</a>
						</h4>
					</div>
					<div id="collapseFive" class="panel-collapse collapse">
						<div class="panel-body">
							<a href="selectBill.do" style="text-decoration: none; color: gray">账单查询</a>
						</div>
						<div class="panel-body">
							<a href="addBill.jsp" style="text-decoration: none; color: gray">账单添加</a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="right">
			<form action="addRoom.do" method="post">
				<table class="table table-bordered">
					<tr>
						<td>房间号</td>
						<td><input type="text" name="roomid">
						</td>
					</tr>
					<tr>
						<td>房间类型</td>
						<td><select name="roomtype">
						        <option value="单人间">单人间</option>
								<option value="双人间">双人间</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>房间状态</td>
						<td><select name="roomstatus">
						        <option value="空房">空房</option>
								<option value="已预定">已预定</option>
								<option value="已入住">已入住</option>
						</select>
						</td>
					</tr>
					<tr>
						<td>价格</td>
						<td><input type="text" name="price">
						</td>
					</tr>
					<tr>
						<td>图片</td>
						<td><input type="file" name="path">
						</td>
					</tr>
					
				</table>
				<button type="submit" class="btn btn-primary" style="margin-left: 300px">添加</button>&nbsp;&nbsp;
				<a href="selectRoom.do" class="btn btn-primary">返回</a>
			</form>
		</div>    
	</div>
</div>

</body>
</html>