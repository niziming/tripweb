<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
	<title>Info | 用户</title>
	<jsp:include page="../../../includes/header.jsp"/>
</head>

<body class="hold-transition register-page">
<div class="register-box">
	<div class="register-logo">
		<b>Register</b>用户注册
	</div>

	<div class="register-box-body">
		<%--danger alert--%>
		<c:if test="${msg.msg != null}">
			<div class="alert alert-${msg.status == 200 ? "success" : "danger"} alert-dismissible">
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
				<h5>${msg.msg}</h5>
			</div>
		</c:if>
		<%--danger alert--%>
		<p class="login-box-msg">注册一个新用户</p>
		<form action="/user/regstform" method="post">

			<div class="form-group has-feedback">
				<input name="uname" type="text" class="form-control" placeholder="用户名">
				<span class="glyphicon glyphicon-user form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input name="uemail" type="email" class="form-control" placeholder="邮箱">
				<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input name="upwd" type="password" class="form-control" placeholder="密码">
				<span class="glyphicon glyphicon-lock form-control-feedback"></span>
			</div>
			<div class="form-group has-feedback">
				<input name="reupwd" type="password" class="form-control" placeholder="重复密码">
				<span class="glyphicon glyphicon-log-in form-control-feedback"></span>
			</div>
			<div class="row">
				<div class="col-xs-8">

				</div>
				<!-- /.col -->
				<div class="col-xs-4">
					<button type="submit" class="btn btn-primary btn-block btn-flat">注册</button>
				</div>
				<!-- /.col -->
			</div>
		</form>

		<a href="/index" class="text-center">已有账号?</a>
	</div>
	<!-- /.form-box -->
	<%--版权--%>
</div>
<!-- /.register-box -->
<!-- ./wrapper -->
<jsp:include page="../../../includes/footer.jsp"/>
<script>
    // iCheck
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' /* optional */
        });
    });
</script>

</body>
<%--js--%>
</html>