<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
					<h3 class="box-title">帖子列表</h3>
					<div class="row" style="padding-left: 12px; padding-top: 10px;">
						<a href="/admin/forumInsertForm" type="button" class="btn-primary btn-sm"><i
								class="fa fa-plus"></i>帖子新增</a>&nbsp;&nbsp;
						<span style="cursor: pointer" type="button" class="btn-primary btn-sm forumMutiDelete">
							<i class="fa fa-trash-o"></i>批量删除</span>&nbsp;&nbsp;
					</div>
					<div class="box-tools">
						<form action="/admin/forumPointSearch" method="get">
							<div class="input-group input-group-sm" style="width: 150px;">
								<input type="text" name="keyword" class="form-control pull-right" placeholder="搜索...">

								<div class="input-group-btn">
									<button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
								</div>
							</div>
						</form>
					</div>
				</div>

				<div class="box-body table-responsive">
					<table id="myuserstable" class="table table-bordered table-striped">
						<thead>
						<tr>
							<th>
								<label>
									<input type="checkbox" class="minimal icheck_master">
								</label>
							</th>
							<th>编号|Id</th>
							<th>作者ID|Aid</th>
							<th>作者|Author</th>
							<th>标题|Title</th>
							<th>副标题|Sub</th>
							<th>发布日期|Date</th>
							<th>标签|Tag</th>
							<th>操作|Oper</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${forums}" var="forum">
							<tr>
								<td>
									<label>
										<input name="hotel" value="${forum.tpFid}" type="checkbox"
										       class="minimal minimal-myminor">
									</label>
								</td>
								<td>${forum.tpFid}</td>
								<td>${forum.tpAuthorId}</td>
								<td><span class="label label-primary">${forum.tpAuthor}</span></td>
								<td>${fn:substring(forum.tpTitle,0,3)}...</td>
								<td>${forum.tpSubTitle}</td>
								<td><fmt:formatDate value="${forum.tpIssueTime}" pattern="yyyy-MM-dd:HH:mm:dd"/></td>
								<td>${forum.tpTag}</td>
								<td>
									<a href="/admin/forumEditForm?tpFid=${forum.tpFid}" class="btn btn-primary btn-xs"><i
											class="fa fa-edit"></i>编辑
									</a>
									<a href="/admin/forumDelete?tpFid=${forum.tpFid}" class="btn btn-danger  btn-xs"><i
											class="fa fa-trash"></i>删除
									</a>
								</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
					<br>
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
        // 前端分页
        $('#myuserstable').DataTable({
            'paging': true,
            'lengthChange': true,
            'searching': false,
            'ordering': true,
            'info': true,
            'autoWidth': true
        });

        // 前端复选框选择器
        var _checkbox = App.getCheckbox();
        console.log(_checkbox.length);

        // 复选框选择传数组到后台,处理完成后前台接收
        $(".forumMutiDelete").click(function () {
            var tpFids = [];
            var seletes = $(".minimal-myminor");
            console.log(seletes);
            for (var i = 0; i < seletes.length; i++) {
                if ($(seletes[i]).prop("checked")) {
                    tpFids.push($(seletes[i]).val());
                }
            }

            $.ajax({
                url: "forumMutiDelete",
                type: "GET",
                data: {
                    "tpFids": tpFids
                },
                traditional: true,
                success: function (message) {
                    if (message == "1") {
                        window.location.href = "/admin/forumList";
                    }
                }
            });
        });
    })
</script>
</body>
</html>
