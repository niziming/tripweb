<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<head>
	<title>酒店管理|Hotel</title>
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
				酒店管理|
				<small>操作</small>
			</h1>

			<ol class="breadcrumb">
				<br>
				<li><a href="#"><i class="fa fa-users"></i> Operate </a></li>
				<li class="active">Hotel</li>
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
					<h3 class="box-title">酒店列表</h3>
					<div class="row" style="padding-left: 12px; padding-top: 10px;">
						<a href="/admin/hotelInsertForm" type="button" class="btn-primary btn-sm"><i class="fa fa-plus"></i>酒店新增</a>&nbsp;&nbsp;
						<span style="cursor: pointer" type="button" class="btn-primary btn-sm viewsectiondelete">
							<i class="fa fa-trash-o"></i>批量删除</span>&nbsp;&nbsp;
					</div>
					<div class="box-tools">
						<form action="/admin/hotelPointSearch" method="get">
							<div class="input-group input-group-sm" style="width: 150px;">
								<input type="text"  name="keyword" class="form-control pull-right" placeholder="搜索...">

								<div class="input-group-btn">
									<button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
								</div>
							</div>
						</form>
					</div>
				</div>

				<div class="box-body table-responsive">
					<table id="myuserstable" class="table table-bordered table-striped">
						<thead>
						<tr>
							<th>
								<label>
									<input type="checkbox" class="minimal icheck_master">
								</label>
							</th>
							<th>编号|Id</th>
							<th>户型|House</th>
							<th>标题|Title</th>
							<th>床型|Bed</th>
							<th>电话|Poh</th>
							<th>人数|Num</th>
							<th>地址|Zip</th>
							<th>大小|Size</th>
							<th>价格|Pic</th>
							<th>缩图|Img</th>
							<th>操作|Oper</th>
						</tr>
						</thead>
						<tbody>
						<c:forEach items="${hotels}" var="hotel">
							<tr>
								<td>
									<label>
										<input name="hotel" value="${hotel.hid}" type="checkbox" class="minimal minimal-myminor">
									</label>
								</td>
								<td>${hotel.hid}</td>
								<td><span class="label label-primary">${hotel.houseType}</span></td>
								<td>${fn:substring(hotel.title,0,3)}...</td>
								<td><span class="label label-primary">${hotel.bedType}</span></td>
								<td>${hotel.phone}</td>
								<td><span class="label label-primary">${hotel.peopleNum}</span></td>
								<td>${fn:substring(hotel.zip,0,8)}...</td>
								<td><span class="label label-primary">${hotel.houseSize}</span></td>
								<td><span class="label label-primary">${hotel.price}</span></td>
								<td><img style="width: 50px;height: 30px;" src="${hotel.imgUrl}" /></td>
								<td>
									<a href="/admin/hotelcontent?hid=${hotel.hid}" class="btn btn-success btn-xs"><i class="fa fa-search"></i>内容
									</a>
									<a href="/admin/hoteledit?hid=${hotel.hid}" class="btn btn-primary btn-xs"><i class="fa fa-edit"></i>编辑
									</a>
									<a href="/admin/hoteldelete?hid=${hotel.hid}" class="btn btn-danger  btn-xs"><i
											class="fa fa-trash"></i>删除
									</a>
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
<!-- page script -->
<script>
    $(function () {
        // 前端分页
        $('#myuserstable').DataTable({
            'paging': true,
            'lengthChange': true,
            'searching': false,
            'ordering': true,
            'info': true,
            'autoWidth': true
        });

        // 前端复选框选择器
        var _checkbox = App.getCheckbox();
        console.log(_checkbox.length);

        // 复选框选择传数组到后台,处理完成后前台接收
        $(".viewsectiondelete").click(function () {
            var hids = [];
            var seletes = $(".minimal-myminor");
            console.log(seletes);
            for(var i=0;i<seletes.length;i++){
                if($(seletes[i]).prop("checked")){
                    hids.push($(seletes[i]).val());
                }
            }

            $.ajax({
                url: "hotelMutiDelete",
                type: "GET",
                data: {
                    "hids": hids
                },
                traditional: true,
                success: function (message) {
                    if(message == "1"){
                        window.location.href = "/admin/hotellist";
                    }
                }
            });
        });
    })
</script>
</body>
</html>
