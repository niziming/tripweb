<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<head>
	<title>交通信息 | Traffic</title>
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
				交通信息|
				<small>操作</small>
			</h1>

			<ol class="breadcrumb">
				<br>
				<li><a href="#"><i class="fa fa-users"></i> Traffic </a></li>
				<li class="active">列表</li>
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
					<h3 class="box-title">交通列表</h3>
					<div class="row" style="padding-left: 12px; padding-top: 10px;">
						<%--新增按钮--%>
						<a href="/admin/trafficInsert" type="button" class="btn-primary btn-sm"><i class="fa fa-plus"></i>交通新增</a>&nbsp;&nbsp;
						<span style="cursor: pointer" type="button" class="btn-primary btn-sm trafficMutiDelete"><i
								class="fa fa-trash-o"></i>批量删除</span>&nbsp;&nbsp;
					</div>
					<div class="box-tools">
						<%--模糊搜索框--%>
						<form action="/admin/trafficPointSearch" method="get">
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
						<th>编码|Tid</th>
						<th>交通类型|Type</th>
						<th>出发地|Start</th>
						<th>终点站|End</th>
						<th>出发时间|Time</th>
						<th>到达时间|Time</th>
						<th>价格|Price</th>
						<th>编辑|Edit</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${traffics}" var="traffic">
						<tr>
							<td>
								<label>
									<input name="tpTids" value="${traffic.tpTid}" type="checkbox"
									       class="minimal minimal-myminor">
								</label>
							</td>
							<td>${traffic.tpTid}</td>
							<td><span class="label label-primary">${traffic.tpType}</span></td>
							<td>${traffic.tpCurrent}</td>
							<td>${traffic.tpDestination}</td>
							<td><fmt:formatDate value="${traffic.tpCurrentTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td><fmt:formatDate value="${traffic.tpArriveTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
							<td><span class="label label-primary">${traffic.tpTprice}</span></td>
							<td>
									<%--<button type="button" class="btn btn-success btn-xs"><i class="fa fa-search"></i>查看--%>
									<%--</button>--%>
								<a href="/admin/trafficEdit?tpTid=${traffic.tpTid}" class="btn btn-primary btn-xs"><i
										class="fa fa-edit"></i>编辑
								</a>
								<a href="/admin/trafficDelete?tpTid=${traffic.tpTid}" class="btn btn-danger  btn-xs"><i
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
    $('#myuserstable').DataTable({
        'paging': true,
        'lengthChange': true,
        'searching': false,
        'ordering': true,
        'info': true,
        'autoWidth': true
    });
    $.fn.datetimepicker.dates['zh'] = {
        days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
        daysShort: ["日", "一", "二", "三", "四", "五", "六", "日"],
        daysMin: ["日", "一", "二", "三", "四", "五", "六", "日"],
        months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
        monthsShort: ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"],
        meridiem: ["上午", "下午"],
        //suffix:      ["st", "nd", "rd", "th"],
        today: "今天"
    };
    $("#currentTime,#arriveTime").datetimepicker({
        language: 'zh',  //用自己设置的时间文字
        //weekStart: 1,  //一周从那天开始，默认为0，从周日开始，可以设为1从周一开始
        // startDate:"2018-5-20", //开始时间，可以写字符串，也可以直接写日期格式new Date(),在这之前的日期不能选择
        //endDate:"2018-6-20",
        //daysOfWeekDisabled: [0,4,6],  //一周的周几不能选
        pickDate: true,
        pickTime: true,
        todayBtn: 1,  //是否显示今天按钮，0为不显示
        autoclose: 1, //选完时间后是否自动关闭
        todayHighlight: 1,  //高亮显示当天日期
        startView: 2, //0从小时视图开始，选分;1	从天视图开始，选小时;2从月视图开始，选天;3从年视图开始，选月;4从十年视图开始，选年
        minView: 0,//最精确时间，默认0；0从小时视图开始，选分；1从天视图开始，选小时；2从月视图开始，选天；3从年视图开始，选月；4从十年视图开始，选年
        //maxView:4,  //默认值：4, ‘decade’
        keyboardNavigation: true,  //是否可以用键盘方向键选日期，默认true
        forceParse: 0, //强制解析,你输入的可能不正规，但是它胡强制尽量解析成你规定的格式（format）
        format: 'yyyy-mm-dd hh:ii:ss',// 格式,注意ii才是分，mm或MM都是月
        minuteStep: 5, //选择分钟时的跨度，默认为5分钟
        //pickerPosition:"top-right",  // ‘bottom-left’，’top-right’，’top-left’’bottom-right’
        showMeridian: 0 //在日期和小时选择界面，出现上下午的选项,默认false
        // showSecond: false,
        // showMillisec: true,
        //timeFormat: 'hh:mm:ss:l',
        //bootcssVer: 3,
    });
</script>
</body>
</html>
