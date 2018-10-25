<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="edu.hebeu.entity.*" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>计算工资</title>
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
                    <h5>计算工资</h5>
                </div>
                <div class="ibox-content">
                    <form method="post" class="form-horizontal" id="commentForm" action="<%=path %>/wage/add.do">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">工号</label>
                            <div class="col-sm-7">
                                <% Employee employee = (Employee)request.getAttribute("employee"); %>
                                <input type="text" class="form-control" name="employeeNumber" value="<%=employee.getEmployeeNumber() %>" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">姓名</label>
                            <div class="col-sm-7">
                                <% Integer name = (Integer)request.getAttribute("name"); %>
                                <input type="text" class="form-control" placeholder="" name="name"  value="<%=employee.getName() %>" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">年</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="" name="year">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">月</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" placeholder="" name="month">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">岗位工资</label>
                            <div class="col-sm-7">
                                <input id="gangwei" type="text" class="form-control" placeholder="" name="gangwei">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">等级工资</label>
                            <div class="col-sm-7">
                                <input id="grade" type="text" class="form-control" placeholder="" name="grade">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">工龄工资</label>
                            <div class="col-sm-7" >
                                <input id="gongling" type="text" class="form-control" placeholder="" name="gongling" >
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学历工资</label>
                            <div class="col-sm-7">
                                <input id="xueli" type="text" class="form-control" placeholder="" name="xueli">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">出勤天数</label>
                            <div class="col-sm-7">
                                <% Integer late = (Integer)request.getAttribute("late"); %>
                                <input  type="text" class="form-control" placeholder="" value="<%=late %>" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">加班天数</label>
                            <div class="col-sm-7">
                                <% Integer overtime = (Integer)request.getAttribute("overtime"); %>
                                <input type="text" class="form-control" placeholder=""  value="<%=overtime %>" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">考勤工资</label>
                            <div class="col-sm-7">
                                <input id="kaoqin" type="text" class="form-control" placeholder="" name="kaoqin">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">社保</label>
                            <div class="col-sm-7">
                                <input id="shebao" type="text" class="form-control" placeholder="" name="shebao">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">绩效</label>
                            <div class="col-sm-7">
                                <input id="jixiao" type="text" class="form-control" placeholder="" name="jixiao">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">个人所得税</label>
                            <div class="col-sm-7">
                                <input id="geren" type="text" class="form-control" placeholder="" name="geren">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">实际所发</label>
                            <div class="col-sm-7">
                                <input id="salary" type="text" class="form-control" placeholder="" name="salary" readonly="readonly">
                            </div>
                        </div>
                        <div class="hr-line-dashed"></div>
                        <div class="form-group">
                            <div class="col-sm-4 col-sm-offset-8">
                                <button class="btn btn-success" type="submit">添&nbsp;&nbsp;加</button>&nbsp;&nbsp;&nbsp;&nbsp;
                                <button class="btn btn-white" type="reset">取&nbsp;&nbsp;消</button>
                            </div>
                        </div>
                    </form>
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

<!-- 表单验证 -->
<script src="<%=path %>/js/plugins/validate/jquery.validate.min.js"></script>
<script src="<%=path %>/js/plugins/validate/messages_zh.min.js"></script>

<!-- layer javascript -->
<script src="js/plugins/layer/layer.min.js"></script>
<script>
    var gangwei,grade,gongling,xueli,kaoqin,shebao,jixiao,geren,salary;
    $("#geren").bind('input propertychange',function () {
        gangwei = $("#gangwei").val()*1;
        grade = $("#grade").val()*1;
        gongling = $('input[name="gongling"]').val()*1;
        xueli = $('input[name="xueli"]').val()*1;
        kaoqin = $('input[name="kaoqin"]').val()*1;
        shebao = $('input[name="shebao"]').val()*1;
        jixiao = $('input[name="jixiao"]').val()*1;
        geren = $('input[name="geren"]').val()*1;
        salary = gangwei + grade+gongling+xueli+kaoqin-shebao+jixiao-geren;
        console.log(salary);
        $('#salary').val(salary);
    })
    $().ready(function() {
        $("#commentForm").validate();
    });
    $.validator.setDefaults({
        submitHandler: function() {
            parent.layer.alert('添加成功！',{icon: 1}),
                form.submit();
        }
    });

</script>
</body>
</html>
