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
  		function deleteRoom(roomid){
  			if(confirm("确定删除吗？")){
  				location.href = "deleteRoom.do?roomid="+roomid;
  			}
  		}
  		function updateRoom(roomid){
  		//异步查询
  			$.ajax({
  				url:'selectByRoomid.do',
  				data:'roomid='+roomid,
  				type:'post',
  				dataType:'json',
  				//js里写html代码
  				success:function(result){
  					var input = "";
  					input+="<p>房间号：<input type='text' name='roomid' value='"+result.roomid+"'></p>";
  					input+="<p>类型：<input type='text' name='roomtype' value='"+result.roomtype+"'></p>";
  					input+="<p>价格：<input type='text' name='price' value='"+result.price+"'></p>";
  					input+="<p>状态：<input type='text' name='roomstatus' value='"+result.roomstatus+"'></p>";
  					input+="<p>路径：<img src='img/"+result.path+"' class='img-thumbnail'></p>";
  					$("#for").html(input);
  				}
  			});
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
  				<caption>房间信息</caption>
  				<thead>
    				<tr>
      					<th>房间号</th>
      					<th>类型</th>
      					<th>价格</th>
   						<th>状态</th>
     					<th>图片</th>
     					<th>操作</th>
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
      						<td>
      							<button type="button" class="btn btn-primary" onclick="deleteRoom(${r.roomid})">删除</button>
      							<button class="btn btn-primary" data-toggle="modal" data-target="#myModal" onclick="updateRoom(${r.roomid})">修改</button>
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
                				<h4 class="modal-title" id="myModalLabel">修改客房信息</h4>
            			</div>
            
            			<form action="updateRoom.do" method="post">
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
			
	
    		<ul class="pagination">
    			<c:if test="${index>1}">
    				<li><a href="selectRoom.do?index=${index-1}">&laquo;</a></li>
    			</c:if>
    			<li><a href="selectRoom.do?index=1">1</a></li>
    			<li><a href="selectRoom.do?index=2">2</a></li>
    			<li><a href="selectRoom.do?index=3">3</a></li>
    			<li><a href="">...</a></li>
    			<li><a href="selectRoom.do?index=${total}">末页</a></li>
    			<c:if test="${index<total}">
    				<li><a href="selectRoom.do?index=${index+1}">&raquo;</a></li>
    			</c:if>
			</ul>
		</div>    
	</div>
</div>

</body>
</html>