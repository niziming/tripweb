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
			<br>
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
						<h3 class="box-title">用户编辑</h3>
					</div>
					<!-- /.box-header -->
					<!-- form start -->
					<form class="form-horizontal" action="/admin/useredithandle" method="post">
						<div class="box-body">

							<%--upic--%>
							<div class="form-group">
								<label for="upic" class="col-sm-2 control-label">头像上传</label>

								<div class="col-sm-10">
									<input type="text" readonly name="upic"
									       class="form-control" id="upic" placeholder="Url...">
									<div id="dropz" class="dropzone"></div>
								</div>
							</div>

							<%--uid--%>
							<div class="form-group">
								<label for="inputUid" class="col-sm-2 control-label">用户ID</label>
								<div class="col-sm-10">
									<input type="text" readonly name="uid" value="${user.uid}" class="form-control" id="inputUid" placeholder="${user.uid}">
								</div>
							</div>
							<%--uname--%>
							<div class="form-group">
								<label for="inputUname" class="col-sm-2 control-label">用户名</label>
								<div class="col-sm-10">
									<input type="text" name="uname" class="form-control" id="inputUname" placeholder="${user.uname}">
								</div>
							</div>

							<%--email--%>
							<div class="form-group">
								<label for="inputEmail" class="col-sm-2 control-label">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</label>

								<div class="col-sm-10">
									<input type="email" name="uemail" class="form-control" id="inputEmail" placeholder="${user.uemail}">
								</div>
							</div>

							<%--pwd--%>
							<div class="form-group">
								<label for="inputPwd" class="col-sm-2 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</label>

								<div class="col-sm-10">
									<input type="password" name="upwd" class="form-control" id="inputPwd" placeholder="${user.upwd}">
								</div>
							</div>

							<%--age--%>
							<div class="form-group">
								<label for="inputAge" class="col-sm-2 control-label">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</label>

								<div class="col-sm-10">
									<input type="text" name="age" class="form-control" id="inputAge" placeholder="${user.age}">
								</div>
							</div>

							<%--gender--%>
							<div class="form-group">
								<label for="inputGender" class="col-sm-2 control-label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</label>

								<div class="col-sm-10">
									<input type="text" name="gender" class="form-control" id="inputGender" placeholder="${user.gender}">
								</div>
							</div>

							<%--PHONE--%>
							<div class="form-group">
								<label for="inputPhone" class="col-sm-2 control-label">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话</label>

								<div class="col-sm-10">
									<input type="text" name="phone" class="form-control" id="inputPhone" placeholder="${user.phone}">
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
<script>
    Dropzone.options.dropz = {
        url: "/upload/useravatar",
        method: "post",
        autoQueue: true,
        dictDefaultMessage: '拖动文件至此或者点击上传', // 设置默认的提示语句
        paramName: "dropFile",// 传到后台的参数名称
        init: function () {
            this.on("success", function (file, data) {
                $("#upic").val(data.fileName);
                // 上传成功触发的事件
            });
        }
    };
</script>
</body>
</html>
