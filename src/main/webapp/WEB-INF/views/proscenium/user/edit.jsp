<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
	<title>Edit | 用户</title>
	<jsp:include page="../../../includes/header.jsp"/>
</head>

<body class="skin-blue layout-top-nav" style="height: auto; min-height: 100%;">

<div class="wrapper" style="height: auto; min-height: 100%;">

	<jsp:include page="../../../includes/top_navigation_reception.jsp"/>

	<!-- Full Width Column -->
	<div class="content-wrapper" style="min-height: 471px;">
		<div class="container">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<br>
				<h1>
					个人信息 | show
					<small>个人信息展示</small>
				</h1>
				<ol class="breadcrumb">
					<br>
					<li><a href="/user/personal"><i class="fa fa-dashboard"></i> 个人信息</a></li>
					<li><a href="#">SHOW</a></li>
				</ol>
			</section>
			<br>
			<jsp:include page="../../../includes/user_saidbar.jsp" />

			<%--信息--%>
			<section class="content col-lg-10 left">
				<%--信息页面--%>
				<div class="box box-info">
					<div class="box-header with-border">
						<h3 class="box-title">用户编辑</h3>
					</div>
					<!-- /.box-header -->
					<!-- form start -->
					<jsp:include page="../../../includes/msg_alert.jsp"/>
					<form class="form-horizontal" action="/user/useredithandle" method="post">
						<%--<img src="${path}/static/assets/img/user2-160x160.jpg" class="img-circle" alt="User Image">--%>
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
									<input type="text" readonly name="uid" value="${user.uid}" class="form-control"
									       id="inputUid" placeholder="${user.uid}">
								</div>
							</div>
							<%--uname--%>
							<div class="form-group">
								<label for="inputUname" class="col-sm-2 control-label">用户名</label>
								<div class="col-sm-10">
									<input type="text" name="uname" value="${user.uname}" class="form-control"
									       id="inputUname" placeholder="${user.uname}">
								</div>
							</div>

							<%--email--%>
							<div class="form-group">
								<label for="inputEmail"
								       class="col-sm-2 control-label">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</label>

								<div class="col-sm-10">
									<input type="email" name="uemail" class="form-control" id="inputEmail"
									       placeholder="${user.uemail}">
								</div>
							</div>

							<%--pwd--%>
							<div class="form-group">
								<label for="inputPwd"
								       class="col-sm-2 control-label">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</label>

								<div class="col-sm-10">
									<input type="password" name="upwd" class="form-control" id="inputPwd"
									       placeholder="${user.upwd}">
								</div>
							</div>

							<%--age--%>
							<div class="form-group">
								<label for="inputAge"
								       class="col-sm-2 control-label">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄</label>

								<div class="col-sm-10">
									<input type="text" name="age" class="form-control" id="inputAge"
									       placeholder="${user.age}">
								</div>
							</div>

							<%--gender--%>
							<div class="form-group">
								<label for="inputGender"
								       class="col-sm-2 control-label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</label>

								<div class="col-sm-10">
									<input type="text" name="gender" class="form-control" id="inputGender"
									       placeholder="${user.gender}">
								</div>
							</div>

							<%--PHONE--%>
							<div class="form-group">
								<label for="inputPhone"
								       class="col-sm-2 control-label">电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话</label>

								<div class="col-sm-10">
									<input type="text" name="phone" class="form-control" id="inputPhone"
									       placeholder="${user.phone}">
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
			</section>

			<br>
		</div>
		<!-- /.container -->

	</div>
	<!-- /.content-wrapper -->

	<%--版权--%>
	<jsp:include page="../../../includes/copyright.jsp"/>
</div>
<!-- ./wrapper -->

<%--js--%>
<jsp:include page="../../../includes/footer.jsp"/>
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