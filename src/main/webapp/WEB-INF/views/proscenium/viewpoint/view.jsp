<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
	<title>View | 景点</title>
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
					旅游景点 | View
					<small>最新发布</small>
				</h1>
				<ol class="breadcrumb">
					<br>
					<li><a href="/view/point"><i class="fa fa-dashboard"></i>旅游景点</a></li>
					<li><a href="#">SHOW</a></li>
					<div class="box-tools">
						<form action="/view/viewPointSearch" method="get">
							<div class="input-group input-group-sm" style="width: 150px;">
								<input type="text" name="keyword" class="form-control pull-right" placeholder="景点搜索...">

								<div class="input-group-btn">
									<button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
								</div>
							</div>
						</form>
					</div>
				</ol>
			</section>
			<br><br><hr>
			<section class="content">
				<div class="row">
					<c:forEach items="${viewPoints}" var="viewPoint">
						<%--自定义内容--%>
						<div class="col-sm-6 col-md-4 col-lg-3 viewpages">
							<div class="thumbnail" style="height: 420px;">
								<a href="/view/content?tpVid=${viewPoint.tpVid}">
									<img src="${viewPoint.tpVpic}" alt="..." class="img-rounded">
								</a>
								<div class="caption">
									<div class="container-fluid">
										<div class="row">
											<div class="col-md-12">
												<h3>${fn:substring(viewPoint.tpTitle,0,30)}</h3>
												<h5>
													[${viewPoint.tpVname}&nbsp;<small>| ${viewPoint.tpLocation}</small>
													]
												</h5>
												<strong>等级: ${viewPoint.tpLevel}</strong>|<strong>开放时间: ${viewPoint.tpOpentime}</strong>|<strong>类型: ${viewPoint.tpVtype}</strong><br>
												详细地址:${fn:substring(viewPoint.tpZip,0,7)}...<br/>电话: ${viewPoint.tpVphone}
												<div class="form-group" style="text-align: right;">
													<a class="btn" style="color: #0b97c4"
													   href="/view/content?tpVid=${viewPoint.tpVid}">查看更多 »</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
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