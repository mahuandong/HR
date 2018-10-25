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
                    <h5>合同列表</h5>
                </div>
                <div class="ibox-content">
                    <div style="margin-bottom: 8px">
                        <a href="<%=path %>/contract/toAdd.do" class="btn btn-success">添加合同</a>
                    </div>
                    <table class="table table-striped table-bordered table-hover dataTables-example">
                        <thead>
                        <tr>
                            <th>员工编号</th>
                            <th>姓名</th>
                            <th>劳动合同到期时间</th>
                            <th>劳动合同签署状态</th>
                            <th>培训合同到期时间</th>
                            <th>培训合同签署状态</th>
                            <th>保密协议签署状态</th>
                            <th>管理</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<Contract> list = (List<Contract>)request.getAttribute("aList");
                            int index=1;
                            for(Contract contract : list){
                        %>
                        <tr class="gradeA">

                            <td><%=contract.getEmployeeNumber()%></td>
                            <td><%=contract.getName() %></td>
                            <td><%=contract.getLaborContractTime() %></td>
                            <%! String msg1,msg2,msg3 ;%>
                            <%  int staut1 = contract.getLaborContractStaut();
                                if (staut1 == 0 ){
                                    msg1 = "未签约";
                                }if (staut1 == 1){
                                    msg1 = "已签未到期";
                                }if (staut1 == 2){
                                    msg1 = "已到期";
                                }
                            %><%
                                int staut2 = contract.getTrainingContractStaut();
                                if (staut2 == 0 ){
                                    msg2 = "未签约";
                                }if (staut2 == 1){
                                    msg2 = "已签未到期";
                                }if (staut2 == 2){
                                    msg2 = "已到期";
                                }
                                int staut3 = contract.getSecrecyStaut();
                                if (staut3 == 0 ){
                                    msg3 = "未签约";
                                }if (staut3 == 1){
                                    msg3 = "已签未到期";
                                }if (staut3 == 2){
                                    msg3 = "已到期";
                                }
                            %>
                            <td><%= msg1 %></td>
                            <td><%=contract.getTrainingContractTime() %></td>
                            <td><%=msg2 %></td>
                            <td><%=msg3 %></td>
                            <td>
                                <a href="<%=path %>/contract/<%=contract.getId() %>/contractUpdate.do" class="btn btn-primary">修改</a>&nbsp;&nbsp;
                                <a herf="<%=path %>/contract/<%=contract.getId() %>/delete.do" class="btn btn-danger delete">删除</a></td>
                            </td>
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
