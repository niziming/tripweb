<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--侧边导航栏--%>
<section class="content col-lg-2">
	<%--侧边栏--%>
	<div>
		<a href="/user/info?uid=${user.uid}" class="list-group-item">个人信息</a>
		<a href="/user/edit" class="list-group-item">编辑信息</a>
		<a href="/user/forum?uid=${user.uid}" class="list-group-item" >我的发表</a>
	</div>
</section>