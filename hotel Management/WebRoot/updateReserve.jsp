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
			<form action="updateReserve.do" method="post">
				<table class="table table-bordered">
					<tr>
						<td>订单编号</td>
						<td><input type="text" name="dingdanid" value="${res.dingdanid }" readonly>
						</td>
					</tr>
					<tr>
						<td>用户编号</td>
						<td><input type="text" name="userid" value="${res.u.userid }" >
						</td>
					</tr>
					<tr>
						<td>客房编号</td>
						<td><input type="text" name="roomid" value="${res.r.roomid }" >
						</td>
					</tr>
					<tr>
						<td>入住时间</td>
						<td><input type="date" name="arrive" value="${res.arrive }" >
						</td>
					</tr>
					<tr>
						<td>退房时间</td>
						<td><input type="date" name="leave" value="${res.leave }" >
						</td>
					</tr>
					<tr>
						<td>状态</td>
						<td><select name="status">
						        <option value="已预订">已预定</option>
								<option value="已取消">已取消</option>
								<option value="已入住">已入住</option>
						</select>
						</td>
					</tr>
				</table>
				<button type="submit" class="btn btn-primary" style="margin-left: 300px">修改</button>&nbsp;&nbsp;
				<a href="selectUser.do" class="btn btn-primary">返回</a>
			</form>
			
	
		</div>    
	</div>
</div>

</body>
</html>