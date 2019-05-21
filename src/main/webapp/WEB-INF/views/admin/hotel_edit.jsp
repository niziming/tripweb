<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<head>
	<title>酒店管理|Hotel</title>
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
				酒店管理|
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
			<c:if test="${msg.msg != null}">
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
							<h3 class="box-title">景点新增</h3>
						</div>
						<!-- /.box-header -->
						<!-- form start -->
						<form class="form-horizontal" action="/admin/hoteledithandle" method="post">
							<div class="box-body">

								<%--图片上传组件--%>
								<div class="form-group">
									<label for="imgUrl" class="col-sm-2 control-label">略图上传</label>

									<div class="col-sm-10">
										<input type="text" readonly name="imgUrl" value="${hotel.imgUrl}"
										       class="form-control" id="imgUrl" placeholder="${hotel.imgUrl}">
										<div id="dropz" class="dropzone"></div>
									</div>
								</div>

								<%--uid--%>
								<div class="form-group">
									<label for="hid" class="col-sm-2 control-label">编码</label>
									<div class="col-sm-10">
										<input type="text" readonly name="hid" value="${hotel.hid}"
										       class="form-control" id="hid" placeholder="${hotel.hid}">
									</div>
								</div>

								<%--uname--%>
								<div class="form-group">
									<label for="local" class="col-sm-2 control-label">城市</label>
									<div class="col-sm-10">
										<input type="text" name="local" value="${hotel.local}" class="form-control" id="local"
										       placeholder="${hotel.local}">
									</div>
								</div>

								<%--email--%>
								<div class="form-group">
									<label for="title" class="col-sm-2 control-label">标题</label>

									<div class="col-sm-10">
										<input type="text" name="title" value="${hotel.title}" class="form-control" id="title"
										       placeholder="${hotel.title}">
									</div>
								</div>

								<%--email--%>
								<div class="form-group">
									<label for="houseType" class="col-sm-2 control-label">房屋类型</label>

									<div class="col-sm-10">
										<input type="text" name="houseType" value="${hotel.houseType}" class="form-control" id="houseType"
										       placeholder="${hotel.houseType}">

									</div>
								</div>

								<%--pwd--%>
								<div class="form-group">
									<label for="bedType" class="col-sm-2 control-label">床类型</label>

									<div class="col-sm-10">
										<input type="text" name="bedType" value="${hotel.bedType}" class="form-control" id="bedType"
										       placeholder="${hotel.bedType}">
									</div>
								</div>

								<%--age--%>
								<div class="form-group">
									<label for="phone" class="col-sm-2 control-label">联系电话</label>

									<div class="col-sm-10">
										<input type="text" name="phone" value="${hotel.phone}" class="form-control" id="phone"
										       placeholder="${hotel.phone}">
									</div>
								</div>

								<%--people--%>
								<div class="form-group">
									<label for="peopleNum" class="col-sm-2 control-label">入住人数</label>

									<div class="col-sm-10">
										<input type="text" name="peopleNum" value="${hotel.peopleNum}" class="form-control" id="peopleNum"
										       placeholder="${hotel.peopleNum}">
									</div>
								</div>


								<%--详细地址--%>
								<div class="form-group">
									<label for="zip" class="col-sm-2 control-label">详细地址</label>

									<div class="col-sm-10">
										<input type="text" name="zip" value="${hotel.zip}" class="form-control" id="zip"
										       placeholder="${hotel.zip}">
									</div>
								</div>

								<%--PHONE--%>
								<div class="form-group">
									<label for="houseSize" class="col-sm-2 control-label">房屋大小</label>

									<div class="col-sm-10">
										<input type="text" name="houseSize" value="${hotel.houseSize}" class="form-control" id="houseSize"
										       placeholder="${hotel.houseSize}">
									</div>
								</div>

								<%--PHONE--%>
								<div class="form-group">
									<label for="price" class="col-sm-2 control-label">价格</label>

									<div class="col-sm-10">
										<input type="text" name="price" value="${hotel.price}" class="form-control" id="price"
										       placeholder="${hotel.price}">
									</div>
								</div>
								<%--Content Edit--%>
								<div class="form-group">
									<label for="content" class="col-sm-2 control-label">内容编辑</label>

									<div class="col-sm-10">

										<input type="text" name="content" id="content" class="form-control"
										       placeholder="编辑">

										<%--wangEditor编辑--%>
										<div id="editor">
											${hotel.content}
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

	<script>
        $(function () {
            // wangEditor
            var E = window.wangEditor;
            var editor = new E('#editor');

            // 配置服务器端地址
            editor.customConfig.uploadImgServer = '/upload/hotelContentUpload';

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

            // 按钮绑定事件
            $("#btnSunmit").bind("click", function () {
                var contentHtml = editor.txt.html();
                console.log(contentHtml);//有内容的
                $("#content").val(contentHtml);
                // return false;
            });
        });

        Dropzone.options.dropz = {
            url: "/upload/hotelAvatar",
            method: "post",
            autoQueue: true,
            dictDefaultMessage: '拖动文件至此或者点击上传', // 设置默认的提示语句
            paramName: "dropFile",// 传到后台的参数名称
            init: function () {
                this.on("success", function (file, data) {
                    $("#imgUrl").val(data.fileName);
                    // 上传成功触发的事件
                });
            }
        };
	</script>
</body>
</html>
