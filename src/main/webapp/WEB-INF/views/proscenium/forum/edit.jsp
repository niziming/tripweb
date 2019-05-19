<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	Date date = new Date();
	String nowDate = sdf.format(date);
%>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
	<title>Issue | 发帖</title>
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
					发布帖子 | Issue
					<small>最新发布</small>
				</h1>
				<ol class="breadcrumb">
					<br>
					<li><a href="/view/point"><i class="fa fa-dashboard"></i>发布帖子</a></li>
					<li><a href="#">SHOW</a></li>

				</ol>
			</section>
			<br>
			<section class="content">
				<br>
				<%--danger alert--%>
				<c:if test="${msg.msg != null}">
					<div class="alert alert-${msg.status == 200 ? "success" : "danger"} alert-dismissible">
						<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×
						</button>
						<h4>${msg.msg}</h4>
					</div>
				</c:if>
				<%--danger alert--%>

				<div class="box box-info">
					<div class="box box-info">
						<div class="box-header with-border">
							<h3 class="box-title">帖子编辑</h3>
							<br>
						</div>
						<!-- /.box-header -->
						<!-- form start -->
						<form class="form-horizontal" action="/forum/savecontent" method="post">
							<div class="box-body">

								<%--uid--%>
								<div class="form-group">
									<label for="tpAuthorId" class="col-sm-2 control-label">作者ID</label>
									<div class="col-sm-10">
										<input type="text" readonly name="tpAuthorId"
										       value="${user.uid}"
										       class="form-control" id="tpAuthorId"
										       placeholder="${user.uid}">
									</div>
								</div>

								<%--uname--%>
								<div class="form-group">
									<label for="tpAuthor" class="col-sm-2 control-label">作者名称</label>
									<div class="col-sm-10">
										<input type="text" readonly name="tpAuthor" value="${user.uname}" class="form-control"
										       id="tpAuthor"
										       placeholder="${user.uname}">
									</div>
								</div>

								<%--email--%>
								<div class="form-group">
									<label for="tpTitle" class="col-sm-2 control-label">帖子标题</label>

									<div class="col-sm-10">
										<input type="text" name="tpTitle" class="form-control"
										       id="tpTitle"
										       placeholder="${forum.tpTitle}">
									</div>
								</div>

								<%--email--%>
								<div class="form-group">
									<label for="tpSubTitle" class="col-sm-2 control-label">副标题</label>

									<div class="col-sm-10">
										<input type="text" name="tpSubTitle" class="form-control"
										       id="tpSubTitle"
										       placeholder="${forum.tpSubTitle}">
									</div>
								</div>


								<%--age--%>
								<div class="form-group">
									<label for="tpTag" class="col-sm-2 control-label">标签</label>

									<div class="col-sm-10">
										<input type="text" name="tpTag" class="form-control"
										       id="tpTag"
										       placeholder="${forum.tpTag}">
									</div>
								</div>


								<%--Content Edit--%>
								<div class="form-group">
									<label for="tpTcontent" class="col-sm-2 control-label">内容</label>
									<div class="col-sm-10">
										<input type="text" name="tpTcontent" id="tpTcontent"
										       class="form-control"
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
								<button type="button" class="btn btn-default" onclick="history.go(-1);">
									返回
								</button>
								<button id="btnSunmit" type="submit" class="btn btn-info pull-right"
								        onclick="">提交
								</button>
							</div>
							<!-- /.box-footer -->
						</form>
					</div>
					<!-- /.box-body -->
				</div>

				<hr>
			</section>
			<br>
			<!-- /.container -->
		</div>
		<!-- /.content-wrapper -->
	</div>

	<%--版权--%>
	<jsp:include page="../../../includes/copyright.jsp"/>
	<!-- ./wrapper -->
	<%--js--%>
	<jsp:include page="../../../includes/footer.jsp"/>
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
</body>
</html>