<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
	<title>Forum | 论坛</title>
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
					论坛 | FORUM
					<small>最新发布</small>
				</h1>
				<ol class="breadcrumb">
					<br>
					<li><a href="/forum/index"><i class="fa fa-dashboard"></i>新闻论坛</a></li>
					<li><a href="#">FORUM</a></li>
					<div class="box-tools">
						<form action="/forum/forumPointSearch" method="get">
							<div class="input-group input-group-sm" style="width: 150px;">
								<input type="text" name="keyword" class="form-control pull-right" placeholder="帖子搜索...">

								<div class="input-group-btn">
									<button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
								</div>
							</div>
						</form>
					</div>
				</ol>
			</section>
			<br>
			<section class="content">

				<div class="row">

					<%--自定义内容--%>
					<div class="col-sm-12 col-md-12 col-lg-12">
						<div class="thumbnail">
							<div class="caption">
								<div class="container-fluid">
									<div class="row">
										<%--danger alert--%>
										<c:if test="${msg.msg != null}">
											<div class="alert alert-${msg.status == 200 ? "success" : "danger"} alert-dismissible">
												<button type="button" class="close" data-dismiss="alert"
												        aria-hidden="true">×
												</button>
												<h4>${msg.msg}</h4>
											</div>
										</c:if>
										<%--danger alert--%>

										<%--发点什么?--%>
										<div class="box-header">
											<div class="col-lg-2" style="padding-left: 12px; padding-top: 10px;">
												<a href="/forum/issue?uid=${user.uid}" type="button"
												   class="btn btn-block btn-primary btn-lg">发点什么?</a>
											</div>
										</div>
										<%--遍历帖子--%>
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
														作者:${forum.tpAuthor} Create By
														<fmt:formatDate value="${forum.tpIssueTime}" pattern="yyyy-MM-dd:HH:mm:dd"/>
													</p>
													<div class="tags">
															${forum.tpTag}
													</div>
													<hr>
												</div>
												<!-- 如果开启评论功能 -->
											</div>
										</c:forEach>
										<!-- 分页 -->
										<ul class="pager">
											<li class="next">
												<a href="/archives/2/">下一页 →</a>
											</li>
										</ul>
									</div>

								</div>

							</div>

						</div>

					</div>

				</div>
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
	</script>

</body>
</html>