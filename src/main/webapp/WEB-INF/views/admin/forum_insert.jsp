<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<head>
	<title>论坛管理|Forum</title>
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
				论坛管理|
				<small>操作</small>
			</h1>

			<ol class="breadcrumb">
				<br>
				<li><a href="#"><i class="fa fa-users"></i> Operate </a></li>
				<li class="active">Hotel</li>
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
						<br>
						<h3 class="box-title">帖子新增</h3>
					</div>
					<!-- /.box-header -->
					<!-- form start -->
					<form class="form-horizontal" action="/admin/forumInsert" method="post">
						<div class="box-body">

							<%--uname--%>
							<div class="form-group">
								<label for="tpAuthor" class="col-sm-2 control-label">作者</label>
								<div class="col-sm-10">
									<input type="text" name="tpAuthor" class="form-control" id="tpAuthor">
								</div>
							</div>

							<%--email--%>
							<div class="form-group">
								<label for="tpTitle" class="col-sm-2 control-label">标题</label>

								<div class="col-sm-10">
									<input type="text" name="tpTitle" class="form-control" id="tpTitle">
								</div>
							</div>

							<%--email--%>
							<div class="form-group">
								<label for="tpSubTitle" class="col-sm-2 control-label">副标题</label>

								<div class="col-sm-10">
									<input type="text" name="tpSubTitle" class="form-control" id="tpSubTitle">

								</div>
							</div>

							<%--age--%>
							<div class="form-group">
								<label for="tpTag" class="col-sm-2 control-label">标签</label>

								<div class="col-sm-10">
									<input type="text" name="tpTag" class="form-control" id="tpTag">
								</div>
							</div>

							<%--Content Edit--%>
							<div class="form-group">
								<label for="tpTcontent" class="col-sm-2 control-label">内容编辑</label>

								<div class="col-sm-10">

									<input type="text" name="tpTcontent" id="tpTcontent" class="form-control"
									       placeholder="编辑">

									<%--wangEditor编辑--%>
									<div id="editor">
										${forum.tpTcontent}
									</div>
								</div>
							</div>

						</div>
						<!-- /.box-body -->

						<div class="box-footer">
							<button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
							<button id="btnSunmit" type="submit" class="btn btn-info pull-right" onclick="">提交
							</button>
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
</body>
<script>
    $(function () {
        // wangEditor
        var E = window.wangEditor;
        var editor = new E('#editor');

        // 配置服务器端地址
        editor.customConfig.uploadImgServer = '/upload/fourmContentUpload';

        // 将图片大小限制为 3M 默认为5MB
        editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;
        // 限制一次最多上传 20 张图片
        editor.customConfig.uploadImgMaxLength = 20;
        // 自定义 fileName
        editor.customConfig.uploadFileName = 'dropFile';
        editor.create();
        editor.customConfig.uploadImgHooks = {
            before: function (xhr, editor, files) {

            }
        };

        $("#btnSunmit").bind("click", function () {
            var contentHtml = editor.txt.html();
            console.log(contentHtml);//有内容的
            $("#tpTcontent").val(contentHtml);
            // return false;
        });
    });
</script>
</html>
