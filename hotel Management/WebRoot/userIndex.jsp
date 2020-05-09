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
    		<div><a class="navbar-brand" href="login.jsp" style="float: right;">${username} 退出</a></div>
    		</div>
		</nav>

		<div class="subbody">
			<ul class="ul1">
                <li style="overflow: hidden;">
                    <c:forEach items="${list}" var="r">
                        <div style="float:left; padding-left: 30px">
                            <a href="selectByPath.do?path=${r.path}">
								<img class="img-rounded" src="img/${r.path}" style="width: 200px; height: 150px; margin: 20px">
						    </a>
                        	
                        	<div style="text-align:center">房间号: ${r.roomid }</div>
                        	<div style="text-align:center">房间状态: ${r.roomstatus }</div>
                            	
                        </div>
                    </c:forEach>
                </li>
            </ul>
			
			
		</div>
	</div>
</div>
</body>
</html>