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
				<br>
				景点管理|
				<small>操作</small>
			</h1>

			<ol class="breadcrumb">
				<br>
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
					<h4>${msg.msg}</h4>
				</div>
			</c:if>
			<%--danger alert--%>
			<div class="box">
				<%--用户表单--%>
				<div class="box box-info">
				<div class="box box-info">
					<div class="box-header with-border">
						<h3 class="box-title">景点编辑</h3>
					</div>
					<!-- /.box-header -->
					<!-- form start -->
					<form class="form-horizontal" action="/admin/viewinsert" method="post">
						<div class="box-body">
							<%--uname--%>
							<div class="form-group">
								<label for="tpLocation" class="col-sm-2 control-label">景点归属</label>
								<div class="col-sm-10">
									<input type="text" name="tpLocation" class="form-control" id="tpLocation" placeholder="${viewPoint.tpLocation}">
								</div>
							</div>

							<%--email--%>
							<div class="form-group">
								<label for="tpTitle" class="col-sm-2 control-label">景点标题</label>

								<div class="col-sm-10">
									<input type="text" name="tpTitle" class="form-control" id="tpTitle" placeholder="${viewPoint.tpTitle}">
								</div>
							</div>

							<%--email--%>
							<div class="form-group">
								<label for="tpTitle" class="col-sm-2 control-label">景点名称</label>

								<div class="col-sm-10">
									<input type="text" name="tpVname" class="form-control" id="tpVname" placeholder="${viewPoint.tpVname}">
								</div>
							</div>

							<%--pwd--%>
							<div class="form-group">
								<label for="tpVtype" class="col-sm-2 control-label">景点类型</label>

								<div class="col-sm-10">
									<input type="text" name="tpVtype" class="form-control" id="tpVtype" placeholder="${viewPoint.tpVtype}">
								</div>
							</div>

							<%--age--%>
							<div class="form-group">
								<label for="tpVphone" class="col-sm-2 control-label">联系电话</label>

								<div class="col-sm-10">
									<input type="text" name="tpVphone" class="form-control" id="tpVphone" placeholder="${viewPoint.tpVphone}">
								</div>
							</div>

							<%--gender--%>
							<div class="form-group">
								<label for="tpLevel" class="col-sm-2 control-label">景点等级</label>

								<div class="col-sm-10">
									<input type="text" name="tpLevel" class="form-control" id="tpLevel" placeholder="${viewPoint.tpLevel}">
								</div>
							</div>

							<%--PHONE--%>
							<div class="form-group">
								<label for="tpPrice" class="col-sm-2 control-label">景点价格</label>

								<div class="col-sm-10">
									<input type="text" name="tpPrice" class="form-control" id="tpPrice" placeholder="${viewPoint.tpPrice}">
								</div>
							</div>

							<%--PHONE--%>
							<div class="form-group">
								<label for="tpPrice" class="col-sm-2 control-label">景点缩略</label>

								<div class="col-sm-10">
									<input type="text" readonly name="tpVpic" value="${viewPoint.tpVpic}"
									       class="form-control" id="tpVpic" placeholder="${viewPoint.tpVpic}">
									<div id="dropz" class="dropzone"></div>
								</div>
							</div>

							<%--PHONE--%>
							<div class="form-group">
								<label for="tpPrice" class="col-sm-2 control-label">详细地址</label>

								<div class="col-sm-10">
									<input type="text" name="tpZip" class="form-control" id="tpZip" placeholder="${viewPoint.tpZip}">
								</div>
							</div>

							<%--PHONE--%>
							<div class="form-group">
								<label for="tpPrice" class="col-sm-2 control-label">开放时间</label>

								<div class="col-sm-10">
									<input type="text" name="tpOpentime" class="form-control" id="tpOpentime"
									       placeholder="${viewPoint.tpOpentime}">
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
<%--版权--%>
<jsp:include page="../../includes/copyright.jsp"/>
<%--css--%>
<jsp:include page="../../includes/footer.jsp"/>
<!-- page script -->
	<script>
        Dropzone.options.dropz = {
            url: "/upload/viewAvatar",
            method: "post",
            autoQueue: true,
            dictDefaultMessage: '拖动文件至此或者点击上传', // 设置默认的提示语句
            paramName: "dropFile",// 传到后台的参数名称
            init: function () {
                this.on("success", function (file, data) {
                    $("#tpVpic").val(data.fileName);
                    // 上传成功触发的事件
                });
            }
        };
	</script>
</body>
</html>
