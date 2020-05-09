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
            height: 850px; 
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
			padding-left: 600px;
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
		#roomInfo{
			margin-left: 200px;
			width: 1200px;
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
			<table class="table table-hover" id="roomInfo">
  				<caption>房间信息</caption>
  				<thead>
    				<tr>
      					<th>房间号</th>
      					<th>类型</th>
      					<th>价格</th>
   						<th>状态</th>
     					<th>图片</th>
    				</tr>
  				</thead>
  				<tbody>
  					<c:forEach items="${list }" var="r">
    					<tr>
      						<td>${r.roomid }</td>
							<td>${r.roomtype }</td>
    						<td>${r.price }</td>
    						<td>${r.roomstatus }</td>
    						<td><img class="img-rounded" style="height: 150px; width: 200px" src="img/${r.path}"></td>
      						
    					</tr>
    				</c:forEach> 				
  				</tbody>
			</table>
			
			<ul class="pagination">
    			<c:if test="${index>1}">
    				<li><a href="selectRoom1.do?index=${index-1}">&laquo;</a></li>
    			</c:if>
    			<li><a href="selectRoom1.do?index=1">1</a></li>
    			<li><a href="selectRoom1.do?index=2">2</a></li>
    			<li><a href="selectRoom1.do?index=3">3</a></li>
    			<li><a href="">...</a></li>
    			<li><a href="selectRoom1.do?index=${total}">末页</a></li>
    			<c:if test="${index<total}">
    				<li><a href="selectRoom1.do?index=${index+1}">&raquo;</a></li>
    			</c:if>
			</ul>
		</div>
	</div>
	
</div>
</body>
</html>