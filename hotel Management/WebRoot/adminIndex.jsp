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
            height: 600px; 
            /* border: solid 1px red; */
            background-color: #EBEFF1;
        }
        .left{
            /* background-color: #103567; */
            font-family: 宋体;
            /* color: white; */
            width: 200px;
            height: 600px;
            /* border: solid 1px green; */
            float: left;
        }
        .right{
            width: 1290px;
            /* height: 600px; */
            /* border: solid blue 1px;  */
            float: right;
            overflow: hidden;
        }
        .panel-body:hover {
        	background-color: #EBEFF1;
		}
		
    </style>
    
    <script type="text/javascript">
    	function deleteUser(userid){
    		if(confirm("确定删除吗？")){
  				location.href = "deleteUser.do?userid="+userid;
  			}
    	}
    	function updateUser(userid){
    		$.ajax({
    			url: 'selectByUserid.do',
    			data: 'userid=' + userid,
    			type: 'post',
    			dataType: 'json',
    			success: function(result){
    				var input = "";
    				input += "<p>编号：<input type='text' name='userid' value='"+result.userid+"'></p>";
    				input += "<p>姓名：<input type='text' name='username' value='"+result.username+"'></p>";
    				input += "<p>密码：<input type='text' name='upwd' value='"+result.upwd+"'></p>";
    				input += "<p>身份：<input type='text' name='identity' value='"+result.identity+"'></p>";
    				$("#for").html(input);
    			}
    		});
    	}
    </script>
</head>
<body>
<div id="main">
	<div class="head">
		<p>酒店客房管理系统</p>	
	</div>
	
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
			<table class="table table-hover" id="user">
  				<caption>用户信息</caption>
  				<thead>
    				<tr>
      					<th>编号</th>
      					<th>姓名</th>
      					<th>密码</th>
      					<th>身份</th>
      					<th>操作</th>
    				</tr>
  				</thead>
  				<tbody>
  					<c:forEach items="${list }" var="u">
  						<tr>
      						<td>${u.userid }</td>
      						<td>${u.username }</td>
      						<td>${u.upwd }</td>
      						<td>${u.identity }</td>
      						<td>
      							<button type="button" class="btn btn-primary" onclick="deleteUser(${u.userid })">删除</button>
      							<button class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="updateUser(${u.userid })">修改</button>
      						</td>
    					</tr>
  					</c:forEach>    				
  				</tbody>
			</table>
			
			<!-- 模态框（Modal） -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    			<div class="modal-dialog">
        			<div class="modal-content">
            			<div class="modal-header">
                			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                				<h4 class="modal-title" id="myModalLabel">修改用户信息</h4>
            			</div>
            
            			<form action="updateUser.do" method="post">
            			<div class="modal-body" id="for">
                          
            			</div>
            
            			<div class="modal-footer">
                			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                			<button type="submit" class="btn btn-primary">提交更改</button>
           				</div>
             			</form>
        			</div><!-- /.modal-content -->
    			</div><!-- /.modal -->
			</div>
			
		</div>    
	</div>
</div>

</body>
</html>