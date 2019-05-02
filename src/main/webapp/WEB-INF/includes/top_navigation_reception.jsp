<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
					<li class="active"><a href="#">首页SHOW<span class="sr-only">(current)</span></a></li>
					<li><a href="#">景点VIEWS</a></li>
					<li><a href="#">定制CUSTOMIZE</a></li>
					<li><a href="#">酒店HOTEL</a></li>
					<li><a href="#">信息FAQ</a></li>
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control" id="navbar-search-input" placeholder="搜索...">
					</div>
				</form>
			</div>
			<!-- /.navbar-collapse -->
			<!-- 登陆后navigate -->
			<div class="navbar-custom-menu">
				<c:if test="${user != null}">
					<ul class="nav navbar-nav">
						<!-- User Account Menu -->
						<li class="dropdown user user-menu">
							<!-- Menu Toggle Button -->
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<!-- The user image in the navbar-->
								<img src="static/assets/img/user2-160x160.jpg" class="user-image" alt="User Image">
								<!-- hidden-xs hides the username on small devices so only the image appears. -->
								<span class="hidden-xs">Alexander Pierce</span>
							</a>
							<ul class="dropdown-menu">
								<!-- The user image in the menu -->
								<li class="user-header">
									<img src="static/assets/img/user2-160x160.jpg" class="img-circle" alt="User Image">

									<p>
											${user.uname} - Web Developer
										<small></small>
									</p>
								</li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a href="#" class="btn btn-default btn-flat">个人</a>
									</div>
									<div class="pull-right">
										<a href="#" class="btn btn-default btn-flat">${user != null ? '注销' : '登陆'}</a>
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
								<span class="hidden-xs glyphicon glyphicon-user">欢迎登陆</span>
							</a>
							<ul class="dropdown-menu">
								<li>
									<div class="box box-info">
										<div class="box-header with-border">
											<h3 class="box-title">欢迎登陆</h3>
										</div>
										<!-- /.box-header -->
										<!-- form start -->
										<form class="form-horizontal">
											<div class="box-body">
												<div class="form-group">
													<label for="inputEmail3" class="col-sm-3 control-label">邮 箱:</label>

													<div class="col-sm-9">
														<input type="uemail" class="form-control" id="inputEmail3"
														       placeholder="Email">
													</div>
												</div>
												<div class="form-group">
													<label for="inputPassword3" class="col-sm-3 control-label">密
														码:</label>

													<div class="col-sm-9">
														<input type="password" class="form-control" id="inputPassword3"
														       placeholder="Password">
													</div>
												</div>
											</div>
											<!-- /.box-body -->
											<div class="box-footer">
												<button type="submit" class="btn btn-default">注册</button>
												<button type="submit" class="btn btn-info pull-right">登陆</button>
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