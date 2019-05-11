<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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

			<%--Denger alert--%>
			<c:if test="${msg.msg != null}">
				<div class="alert alert-${msg.status == 200 ? "success" : "danger"} alert-dismissible">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
						<%--${msg}--%>
					<h4>${msg.msg}</h4>
				</div>
			</c:if>
			<%--/.alert--%>
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">景点内容</h3>
				</div>
				<div class="box-body table-responsive">
					<table id="myuserstable" class="table table-bordered table-striped">
						<thead>
						<tr>
							<th>参数</th>
							<th>值</th>
						</tr>
						</thead>
						<tbody>
						<tr>
							<td>景点编码</td>
							<td>${viewPoint.tpVid}</td>
						</tr>
						<tr>
							<td>经典归属地</td>
							<td><span class="label label-primary">${viewPoint.tpLocation}</span></td>
						</tr>
						<tr>
							<td>景点标题</td>
							<td>${viewPoint.tpTitle}</td>
						</tr>
						<tr>
							<td>景点名称</td>
							<td>${viewPoint.tpVname}</td>
						</tr>
						<tr>
							<td>景点类型</td>
							<td>${viewPoint.tpVtype}</td>
						</tr>
						<tr>
							<td>联系电话</td>
							<td>${viewPoint.tpVphone}</td>
						</tr>
						<tr>
							<td><span>景点等级</span></td>
							<td><span class="label label-primary">${viewPoint.tpLevel}</span></td>
						</tr>
						<tr>
							<td>景点价格</td>
							<td>${viewPoint.tpPrice}</td>
						</tr>
						<tr>
							<td>缩略图</td>
							<td><img src="${viewPoint.tpVpic}" alt="" style="width: 50px;height: 50px"></td>
						</tr>
						<tr>
							<td>详细地址</td>
							<td>${viewPoint.tpZip}</td>
						</tr>
						<tr>
							<td>开放时间</td>
							<td>${viewPoint.tpOpentime}</td>
						</tr>
						<tr>
							<td>发布时间</td>
							<td><fmt:formatDate value="${viewPoint.tpCreattime}" pattern="yyyy-MM-dd"/></td>
						</tr>
						</tbody>
					</table>
					<br>
					<div class="">
						${viewPoint.tpVcontent}
					</div>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>

	</div>
	<!-- /.content-wrapper -->
	<%--版权--%>
	<jsp:include page="../../includes/copyright.jsp"/>

</div>
<%--css--%>
<jsp:include page="../../includes/footer.jsp"/>

<!-- page script -->
<script>
    $(function () {
        // wangEditor
        var E = window.wangEditor;
        var editor = new E('#editor');
        editor.create();

        // 前端分页
        $('#myuserstable').DataTable({
            'paging': false,
            'lengthChange': true,
            'searching': false,
            'ordering': true,
            'info': false,
            'autoWidth': true
        });

        // 前端复选框选择器
        var _checkbox = App.getCheckbox();
        console.log(_checkbox.length);

        // 复选框选择传数组到后台,处理完成后前台接收
        $(".viewsectiondelete").click(function () {
            var tpVids = [];
            var seletes = $(".minimal-myminor");
            console.log(seletes);
            for (var i = 0; i < seletes.length; i++) {
                if ($(seletes[i]).prop("checked")) {
                    tpVids.push($(seletes[i]).val());
                }
            }

            $.ajax({
                url: "viewsectiondelete",
                type: "GET",
                data: {
                    "tpVids": tpVids
                },
                traditional: true,
                success: function (message) {
                    if (message == "1") {
                        window.location.href = "/admin/viewlist";
                    }
                }
            });
        });
    })
</script>

</body>
</html>
