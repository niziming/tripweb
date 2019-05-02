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
				用户管理|
				<small>操作</small>
			</h1>
			<ol class="breadcrumb">
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
					<h4><i class="icon fa fa-ban"></i>${msg.msg}</h4>
				</div>
			</c:if>
			<%--/.alert--%>
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">用户列表</h3>
					<div class="row" style="padding-left: 12px; padding-top: 10px;">
						<a href="/userform" type="button" class="btn-primary btn-sm"><i class="fa fa-plus"></i>新增</a>&nbsp;&nbsp;
						<a href="#" type="button" class="btn-primary btn-sm"><i class="fa fa-trash-o"></i>删除</a>&nbsp;&nbsp;
						<a href="#" type="button" class="btn-primary btn-sm"><i class="fa fa-download"></i>导入</a>&nbsp;&nbsp;
						<a href="#" type="button" class="btn-primary btn-sm"><i class="fa fa-upload"></i>导出</a>
					</div>
					<div class="box-tools">
						<form action="/search" method="post">
							<div class="input-group input-group-sm" style="width: 150px;">
								<input type="text" name="keywords" class="form-control pull-right" placeholder="搜索...">

								<div class="input-group-btn">
									<button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
								</div>
							</div>
						</form>
					</div>
				</div>

				<div class="box-body table-responsive no-padding">
					<table class="table table-hover">
						<thead></thead>
						<tbody>
						<tr>
							<th>用户ID|Uid</th>
							<th>用户名|Uname</th>
							<th>邮箱|Email</th>
							<th>年龄|Age</th>
							<th>性别|Gender</th>
							<th>电话|phone</th>
							<th>注册时间|RegDate</th>
							<th>最后操作|UpData</th>
							<th>编辑|Edit</th>
						</tr>
						<c:forEach items="${users}" var="user">
							<tr>
								<td>${user.uid}</td>
								<td>${user.uname}</td>
								<td><span class="label label-primary">${user.uemail}</span></td>
								<td>${user.uage}</td>
								<td>${user.gender}</td>
								<td>${user.phone}</td>
								<td>${user.regDate}</td>
								<td>${user.updateTime}</td>
								<td>
									<button type="button" class="btn btn-success btn-xs"><i class="fa fa-search"></i>查看
									</button>
									<button type="button" class="btn btn-primary btn-xs"><i class="fa fa-edit"></i>编辑
									</button>
									<button type="button" class="btn btn-danger  btn-xs"><i class="fa fa-trash"></i>删除
									</button>
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

</body>
</html>
