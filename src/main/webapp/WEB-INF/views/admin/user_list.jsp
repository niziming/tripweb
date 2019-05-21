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
				用户管理|
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
					<h3 class="box-title">用户列表</h3>
					<div class="row" style="padding-left: 12px; padding-top: 10px;">
						<a href="/admin/userform" type="button" class="btn-primary btn-sm"><i class="fa fa-plus"></i>用户新增</a>&nbsp;&nbsp;
						<span style="cursor: pointer" type="button" class="btn-primary btn-sm usersectiondelete"><i
								class="fa fa-trash-o"></i>批量删除</span>&nbsp;&nbsp;
					</div>
					<div class="box-tools">
						<form action="/admin/usersearch" method="get">
							<div class="input-group input-group-sm" style="width: 150px;">
								<input type="text" name="keyword" class="form-control pull-right" placeholder="搜索...">

								<div class="input-group-btn">
									<button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
								</div>
							</div>
						</form>
					</div>
				</div>

				<table id="myuserstable" class="table table-bordered table-striped">
					<thead>
					<tr>
						<th>
							<label>
								<input type="checkbox" class="minimal icheck_master">
							</label>
						</th>
						<th>用户ID|Uid</th>
						<th>用户名|Uname</th>
						<th>邮箱|Email</th>
						<th>年龄|Age</th>
						<th>性别|Gender</th>
						<th>头像|Avatar</th>
						<th>电话|phone</th>
						<th>注册时间|RegDate</th>
						<th>最后更新|UpData</th>
						<th>编辑|Edit</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>
								<label>
									<input name="uids" value="${user.uid}" type="checkbox"
									       class="minimal minimal-myminor">
								</label>
							</td>
							<td>${user.uid}</td>
							<td>${user.uname}</td>
							<td><span class="label label-primary">${user.uemail}</span></td>
							<td>${user.age}</td>
							<td>${user.gender}</td>
							<td><img src="${user.upic}" style="width: 50px;height: 30px;"/></td>
							<td>${user.phone}</td>
							<td><fmt:formatDate value="${user.regDate}" pattern="yyyy-MM-dd"/></td>
							<td><fmt:formatDate value="${user.updateTime}" pattern="yyyy-MM-dd:HH:mm:dd"/></td>
							<td>
									<%--<button type="button" class="btn btn-success btn-xs"><i class="fa fa-search"></i>查看--%>
									<%--</button>--%>
								<a href="/admin/useredit?uid=${user.uid}" class="btn btn-primary btn-xs"><i
										class="fa fa-edit"></i>编辑
								</a>
								<a href="/admin/userdelete?uid=${user.uid}" class="btn btn-danger  btn-xs"><i
										class="fa fa-trash"></i>删除
								</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<br>
				<!-- /.box-body -->
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

        $('#myuserstable').DataTable({
            'paging': true,
            'lengthChange': true,
            'searching': false,
            'ordering': true,
            'info': true,
            'autoWidth': true
        });

        var _checkbox = App.getCheckbox();
        console.log(_checkbox.length);

        $(".usersectiondelete").click(function () {
            var uids = [];
            var seletes = $(".minimal-myminor");
            console.log(seletes);
            for (var i = 0; i < seletes.length; i++) {
                if ($(seletes[i]).prop("checked")) {
                    uids.push($(seletes[i]).val());
                }
            }

            $.ajax({
                url: "usersectiondelete",
                type: "GET",
                data: {
                    "uids": uids
                },
                traditional: true,
                success: function (message) {
                    if (message == "1") {
                        window.location.href = "/admin/userlist";
                    }
                }
            });
        });
    })
</script>
</body>
</html>
