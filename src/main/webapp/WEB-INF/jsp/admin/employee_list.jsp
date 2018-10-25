<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="edu.hebeu.entity.*" %>
<%@ page import="com.baomidou.mybatisplus.plugins.Page" %>
<%@page import="edu.hebeu.util.MTimeUtil"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>在职员工列表</title>
	<meta name="keywords" content="">
	<meta name="description" content="">

	<link rel="shortcut icon" href="favicon.ico">
	<link href="<%=path %>/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
	<link href="<%=path %>/css/font-awesome.css?v=4.4.0" rel="stylesheet">

	<!-- Data Tables -->
	<link href="<%=path %>/css/plugins/dataTables/dataTables.bootstrap.css"
		rel="stylesheet">
	<link href="<%=path %>/css/animate.css" rel="stylesheet">
	<link href="<%=path %>/css/style.css?v=4.1.0" rel="stylesheet">
	
	<link rel="stylesheet" type="text/css" href="<%=path %>/dist/sweetalert.css">
</head>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>在职员工列表</h5>
					</div>
					<div class="ibox-content">
						<div style="margin-bottom: 8px">
							<a href="<%=path %>/employee/toAdd.do" class="btn btn-success">添加员工</a>
						</div>
						<table class="table table-striped table-bordered table-hover dataTables-example">
							<thead>
								<tr>
									<th>工号</th>
									<th>姓名</th>
									<th>性别</th>
									<th>身份证号</th>
									<th>电话</th>
									<th>部门名称</th>
									<th>职称</th>
									<th>入职时间</th>
									<th>管理</th>
								</tr>
							</thead>
							<tbody>
							<%
                                List<Employee> list = (List<Employee>)request.getAttribute("page");
                                for(Employee employee : list){
                            %>
								<tr class="gradeA">
									<td><%=employee.getEmployeeNumber() %></td>
									<td><%=employee.getName() %></td>
									<td><%=employee.getGender() %></td>
									<td><%=employee.getIdcard()%></td>
									<td><%=employee.getTelephone() %></td>
									<td><%=employee.getDepartmentName() %></td>
									<td><%=employee.getPositionName() %></td>
								<%
									String intime = MTimeUtil.dateFormat(employee.getInTime());
								%>
									<td><%=intime %></td>
									<td><a href="<%=path %>/employee/<%=employee.getId() %>/detial.do" class="btn btn-info">查看</a>&nbsp;&nbsp;
										<a href="<%=path %>/employee/<%=employee.getId() %>/toUpdate.do" class="btn btn-primary">修改</a>&nbsp;&nbsp;
										<a onclick="del(<%=employee.getId() %>)" class="btn btn-danger delete">删除</a></td>
								</tr>
							<%
                           		 }
                             %>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 全局js -->
	<script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
	<script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>
	<script src="<%=path %>/js/plugins/jeditable/jquery.jeditable.js"></script>

	<!-- Data Tables -->
	<script src="<%=path %>/js/plugins/dataTables/jquery.dataTables.js"></script>
	<script src="<%=path %>/js/plugins/dataTables/dataTables.bootstrap.js"></script>

	<!-- 自定义js -->
	<script src="<%=path %>/js/content.js?v=1.0.0"></script>

 	<!-- layer javascript -->
    <script src="js/plugins/layer/layer.min.js"></script>
    
	<script type="text/javascript">
        $(document).ready(function () {
            $('.dataTables-example').dataTable();

            var oTable = $('#editable').dataTable();

            oTable.$('td').editable('../example_ajax.php', {
                "callback": function (sValue, y) {
                    var aPos = oTable.fnGetPosition(this);
                    oTable.fnUpdate(sValue, aPos[0], aPos[1]);
                },
                "submitdata": function (value, settings) {
                    return {
                        "row_id": this.parentNode.getAttribute('id'),
                        "column": oTable.fnGetPosition(this)[2]
                    };
                },
                "width": "90%",
                "height": "100%"
            });
        });
	function del(id){
		parent.layer.confirm('确认删除？', {
		    btn: ['确认','取消'], //按钮
		    shade: false //不显示遮罩
		}, function(){
		    parent.layer.msg('删除成功！', {icon: 1});
		    location.href="./"+ id +"/delete.do";
		});
	}
	</script>
</body>
</html>
