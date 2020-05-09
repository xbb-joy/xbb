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
    
    <script type="text/javascript">
  		function deleteReserve(dingdanid){
  			if(confirm("确定删除吗？")){
  				location.href = "deleteReserve.do?dingdanid="+dingdanid;
  			} 	
  		 }	
  	</script>
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
			<table class="table table-hover">
  				<caption>订单信息</caption>
  				<thead>
    				<tr>
      					<th>订单编号</th>
      					<th>用户编号</th>
   						<th>房间号</th>
     					<th>到店日期</th>
     					<th>离店日期</th>
     					<th>订单状态</th>
     					<th>操作</th>
    				</tr>
  				</thead>
  				<tbody>
  					<c:forEach items="${list }" var="res">
    					<tr>
      						<td>${res.dingdanid }</td>
      						<td>${res.u.userid }</td>
    						<td>${res.r.roomid }</td>
    						<td>${res.arrive }</td>
    						<td>${res.leave }</td>
    						<td>${res.status }</td>
      						<td>
      							<button type="button" class="btn btn-primary" onclick="deleteReserve(${res.dingdanid })">删除</button>
      							<a href="selectByDingdanid.do?dingdanid=${res.dingdanid }"><button class="btn btn-primary">修改</button></a>
      						</td>
    					</tr>
    				</c:forEach> 				
  				</tbody>
			</table>
	
	
		</div>    
	</div>
</div>

</body>
</html>