<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
	<title>Hotel | 酒店</title>
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
					酒店 | Hotel
					<small>最新发布</small>
				</h1>
				<ol class="breadcrumb">
					<br>
					<li><a href="/hotel/index"><i class="fa fa-dashboard"></i>酒店</a></li>
					<li><a href="#">Hotel</a></li>

				</ol>

			</section>
			<br>
			<section>
				<div class="container">
					<div class="col-lg-10"></div>
					<div class="box-tools col-lg-2">
						<form action="/hotel/hotelPointSearch" method="get">
							<div class="input-group input-group-sm" style="width: 150px;">

								<input type="text" name="keyword" class="form-control pull-right" placeholder="酒店搜索...">

								<div class="input-group-btn">
									<button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</section>
			<br>
			<br>
			<!-- ROOM -->
			<section class="section-room bg-white">

				<div class="row">
					<c:forEach items="${hotels}" var="hotel">
						<!-- ITEM -->
						<div class="col-lg-1"></div>
						<div class="col-sm-6 col-md-4 col-lg-5">
							<div class="thumbnail"  style="height: 450px;">
								<a href="/hotel/content?hid=${hotel.hid}">
										<%--<img src="${viewPoint.tpVpic}" alt="..." class="img-rounded">--%>
									<img src="${hotel.imgUrl}" alt="...">
								</a>
								<div class="caption">
									<h3>${hotel.title}</h3>
									<ol>
										<li><p style="color: #ffa309">城市：${hotel.local}|房屋类型：${hotel.houseType}|床类型：${hotel.bedType}</p> </li>
										<li><p style="color: #0b93d5">价格：￥${hotel.price} | 详细地址：${hotel.zip}</p></li>
									</ol>
								</div>
								<div class="form-group" style="text-align: right;">
									<a class="btn" style="color: #0b97c4"
									   href="/hotel/content?hid=${hotel.hid}">查看详情»</a>
								</div>
							</div>
						</div>
						<!-- END / ITEM -->
					</c:forEach>
				</div>
			</section>
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