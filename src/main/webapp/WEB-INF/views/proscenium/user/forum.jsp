<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
	<title>Info | 用户</title>
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
					<li><a href="/user/personal"><i class="fa fa-user"></i> 个人信息</a></li>
					<li><a href="#">SHOW</a></li>
				</ol>
			</section>
			<br>
			<jsp:include page="../../../includes/user_saidbar.jsp"/>

			<%--信息--%>
			<section class="content col-lg-10 left">
				<%--信息页面--%>
				<div class="box box-info">
					<div class="box-header with-border">
						<h2 class="box-title">发表查看</h2>
						<br>
						<hr>
						<c:forEach items="${forums}" var="forum">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="post-preview">
									<br>
									<a href="/forum/content?tpFid=${forum.tpFid}">
										<h2 class="post-title">${forum.tpTitle}</h2>
										<h4 class="post-subtitle" style="font-style: italic">
												${fn:substring(forum.tpSubTitle,0,20)}...
										</h4>
									</a>
									<p class="post-meta" style="margin: 10px 0; color: #0b93d5;">
										作者:${forum.tpAuthor} 发表于
										<fmt:formatDate value="${forum.tpIssueTime}" pattern="yyyy-MM-dd:HH:mm:dd"/>
									</p>
									<div class="tags">
											${forum.tpTag}
									</div>
								</div>
								<div>
									<%--左边--%>
									<div class="col-lg-11">

									</div>
									<%--右边--%>
									<div class="col-lg-1">
										<a href="/user/forumDelete?tpFid=${forum.tpFid}&uid=${user.uid}" class="btn btn-danger  btn-xs"><i
												class="fa fa-trash"></i>删除
										</a>
									</div>
									<br>
								</div>
								<br>
								<hr>
							</div>
						</c:forEach>
					</div>
					<!-- /.box-header -->
					<!-- form start -->
					<jsp:include page="../../../includes/msg_alert.jsp"/>

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
</body>
</html>