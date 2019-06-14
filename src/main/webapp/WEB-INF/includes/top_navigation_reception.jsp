<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% Date nowDate = new Date();
	request.setAttribute("nowDate", nowDate); %>
<header class="main-header">
	<nav class="navbar navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<a href="/index" class="navbar-brand"><b>Trip</b> | 首页</a>
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
				        data-target="#navbar-collapse">
					<i class="fa fa-bars"></i>
				</button>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse pull-left" id="navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="/view/point">景点VIEWS</a></li>
					<li><a href="/hotel/index">酒店HOTEL</a></li>
					<li><a href="/forum/index">论坛FORUM</a></li>
					<li><a href="/cust/index">定制CUST</a></li>
					<li><a href="/about/index">我们US</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
			<!-- 登录后navigate -->
			<div class="navbar-custom-menu">

				<c:if test="${user != null}">
					<ul class="nav navbar-nav">

						<!-- User Account Menu -->
						<li class="dropdown user user-menu">

							<!-- Menu Toggle Button -->
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<!-- The user image in the navbar-->
								<img src="${user.upic}" class="user-image" alt="User Image">
								<!-- hidden-xs hides the username on small devices so only the image appears. -->
								<span class="hidden-xs">${user.uname}</span>
							</a>
							<ul class="dropdown-menu">

								<!-- The user image in the menu -->
								<li class="user-header">

									<img src="${user.upic}" class="img-circle" alt="User Image">

									<p>
											${user.uname} - 欢迎登录
										<small>登录时间:<fmt:formatDate value="${nowDate}" pattern="yyyy-MM-dd:HH:mm:ss"/></small>
									</p>
								</li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="/user/info?uid=${user.uid}" class="btn btn-default btn-flat">个人</a>
									</div>
									<div class="pull-right">
										<a href="/user/loginout" class="btn btn-default btn-flat">${user != null ? '注销' : '登录'}</a>
									</div>
								</li>
							</ul>
						</li>
					</ul>
				</c:if>
				<%--登录前navigate--%>
				<c:if test="${user == null}">
					<ul class="nav navbar-nav">
						<!-- User Account Menu -->
						<li class="dropdown user user-menu">
							<!-- Menu Toggle Button -->
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<!-- The user image in the navbar-->
								<!-- hidden-xs hides the username on small devices so only the image appears. -->
								<span class="hidden-xs glyphicon glyphicon-user">欢迎登录</span>
							</a>
							<ul class="dropdown-menu">
								<li>

									<div class="box box-info">

										<div class="box-header with-border">
												<%--Denger alert--%>
											<c:if test="${msg.msg != null}">
												<div class="alert alert-${msg.status == 200 ? "success" : "danger"} alert-dismissible">
													<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;
													</button>
														<%--${msg}--%>
													<p>${msg.msg}</p>
												</div>
											</c:if>
												<%--/.alert--%>
											<h3 class="box-title">欢迎登录</h3>
										</div>

										<!-- /.box-header -->
										<!-- form start -->
										<form class="form-horizontal" action="/user/login" method="post">
											<div class="box-body">
												<div class="form-group">
													<label for="inputEmail3" class="col-sm-3 control-label">邮 箱:</label>

													<div class="col-sm-9">
														<input type="email" class="form-control" id="inputEmail3"
														       placeholder="Email" name="uemail">
													</div>

												</div>
												<div class="form-group">
													<label for="inputPassword3" class="col-sm-3 control-label">密
														码:</label>

													<div class="col-sm-9">
														<input type="password" class="form-control" id="inputPassword3"
														       placeholder="Password" name="upwd">
													</div>
												</div>
											</div>
											<!-- /.box-body -->
											<div class="box-footer">
												<a href="/user/regst" type="submit" class="btn btn-default">注册</a>
												<button type="submit" class="btn btn-info pull-right">登录</button>
											</div>
											<!-- /.box-footer -->
										</form>
									</div>
								</li>
							</ul>
						</li>
					</ul>
				</c:if>
			</div>
			<!-- /.navbar-custom-menu -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</header>