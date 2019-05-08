<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<head>
    <title>用户管理 | UserInfo</title>
    <jsp:include page="../../includes/header.jsp"/>

</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">
    <%--顶部导航--%>
    <jsp:include page="../../includes/top_navigate_backstage.jsp"/>
    <%--侧边菜单--%>
    <jsp:include page="../../includes/leftside_menu_navigate.jsp"/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                用户管理 | <small>操作</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-users"></i> Operate </a></li>
                <li class="active">Users</li>
            </ol>
        </section>

        <br/><br/>
        <div class="col-xs-12">
            <%--danger alert--%>
            <c:if test="${msg.msg != null}" >
                <div class="alert alert-${msg.status == 200 ? "success" : "danger"} alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <h4><i class="icon fa fa-ban"></i>${msg.msg}</h4>
                </div>
            </c:if>
            <%--danger alert--%>
            <div class="box">
                <%--用户表单--%>
                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">用户新增</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <form class="form-horizontal" action="/admin/userinsert" method="post">
                        <div class="box-body">

                            <%--uname--%>
                            <div class="form-group">
                                <label for="inputUname" class="col-sm-2 control-label">用户名</label>
                                <div class="col-sm-10">
                                    <input type="text" name="uname" class="form-control" id="inputUname"
                                           placeholder="请输入用户名">
                                </div>
                            </div>

                            <%--email--%>
                            <div class="form-group">
                                <label for="inputEmail" class="col-sm-2 control-label">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</label>

                                <div class="col-sm-10">
                                    <input type="email" name="uemail" class="form-control" id="inputEmail" placeholder="请输入邮箱">
                                </div>
                            </div>

                            <%--pwd--%>
                            <div class="form-group">
                                <label for="inputPwd" class="col-sm-2 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</label>

                                <div class="col-sm-10">
                                    <input type="password" name="upwd" class="form-control" id="inputPwd" placeholder="请输入密码">
                                </div>
                            </div>

                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                            <button type="submit" class="btn btn-info pull-right">提交</button>
                        </div>
                        <!-- /.box-footer -->
                    </form>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- /.content-wrapper -->

<%--版权--%>
<jsp:include page="../../includes/copyright.jsp"/>
<%--css--%>
<jsp:include page="../../includes/footer.jsp"/>

</body>
</html>
