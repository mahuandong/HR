<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="edu.hebeu.entity.*" %>
<%@ page import="edu.hebeu.util.MTimeUtil"%>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>HR - 工资列表</title>
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

</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>员工工资列表</h5>
                </div>
                <div class="ibox-content">
                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>姓名</th>
                            <th>年</th>
                            <th>月</th>
                            <th>工号</th>
                            <th>岗位工资</th>
                            <th>等级工资</th>
                            <th>工龄</th>
                            <th>学历</th>
                            <th>考勤</th>
                            <th>社保</th>
                            <th>绩效</th>
                            <th>个人所得税</th>
                            <th>实发工资</th>

                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<Wage> list = (List<Wage>)request.getAttribute("aList");
                            for(Wage wage : list){
                        %>
                        <tr class="gradeA">
                            <td><%=wage.getName()%></td>
                            <td><%=wage.getYear()%></td>
                            <td><%=wage.getMonth()%></td>
                            <td><%=wage.getEmployeeNumber() %></td>
                            <td><%=wage.getGangwei() %></td>
                            <td><%=wage.getGrade() %></td>
                            <td><%=wage.getGongling() %></td>
                            <td><%=wage.getXueli() %></td>
                            <td><%=wage.getKaoqin() %></td>
                            <td><%=wage.getShebao() %></td>
                            <td><%=wage.getJixiao() %></td>
                            <td><%=wage.getGeren() %></td>
                            <td><%=wage.getSalary() %></td>
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
<script>
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
</script>
</body>
</html>
