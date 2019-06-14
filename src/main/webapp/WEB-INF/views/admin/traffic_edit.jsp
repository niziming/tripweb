<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
			<%--danger alert--%>
			<c:if test="${msg.msg != null}">
				<div class="alert alert-${msg.status == 200 ? "success" : "danger"} alert-dismissible">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
					<h4>${msg.msg}</h4>
				</div>
			</c:if>
			<%--danger alert--%>
			<div class="box">
				<%--用户表单--%>
				<div class="box box-info">
					<div class="box box-info">
						<div class="box-header with-border">
							<h3 class="box-title">交通编辑</h3>
						</div>
						<!-- /.box-header -->
						<!-- form start -->
						<form class="form-horizontal" action="/admin/trafficEditHandle" method="post">
							<div class="box-body">

								<%--uid--%>
								<div class="form-group">
									<label for="tpTid" class="col-sm-2 control-label">编码</label>
									<div class="col-sm-10">
										<input type="text" readonly name="tpTid" value="${traffic.tpTid}"
										       class="form-control" id="tpTid" placeholder="${traffic.tpTid}">
									</div>
								</div>

								<%--uname--%>
								<div class="form-group">
									<label for="tpType" class="col-sm-2 control-label">交通类型</label>
									<div class="col-sm-10">
										<input type="text" name="tpType" value="${traffic.tpType}" class="form-control" id="tpType"
										       placeholder="${traffic.tpType}">
									</div>
								</div>

								<%--email--%>
								<div class="form-group">
									<label for="tpCurrent" class="col-sm-2 control-label">出发地</label>

									<div class="col-sm-10">
										<input type="text" name="tpCurrent" value="${traffic.tpCurrent}" class="form-control" id="tpCurrent"
										       placeholder="${traffic.tpCurrent}">
									</div>
								</div>

								<%--email--%>
								<div class="form-group">
									<label for="tpDestination" class="col-sm-2 control-label">终点站</label>

									<div class="col-sm-10">
										<input type="text" name="tpDestination" value="${traffic.tpDestination}" class="form-control" id="tpDestination"
										       placeholder="${traffic.tpDestination}">

									</div>
								</div>

								<%--pwd--%>
								<div class="form-group">
									<label for="currentTime" class="col-sm-2 control-label">出发时间</label>

									<div class="col-sm-10">
										<input type="text" name="currentTime" value="<fmt:formatDate value="${traffic.tpCurrentTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" class="form-control" id="currentTime"
										       placeholder="<fmt:formatDate value="${traffic.tpCurrentTime}" pattern="yyyy-MM-dd HH:mm:ss"/>">
									</div>
								</div>

								<%--age--%>
								<div class="form-group">
									<label for="arriveTime" class="col-sm-2 control-label">到达时间</label>

									<div class="col-sm-10">
										<input type="text" name="arriveTime" value="<fmt:formatDate value="${traffic.tpArriveTime}" pattern="yyyy-MM-dd HH:mm:ss"/>" class="form-control" id="arriveTime"
										       placeholder="<fmt:formatDate value="${traffic.tpArriveTime}" pattern="yyyy-MM-dd HH:mm:ss"/>">
									</div>
								</div>


								<%--详细地址--%>
								<div class="form-group">
									<label for="tpTprice" class="col-sm-2 control-label">价格</label>

									<div class="col-sm-10">
										<input type="text" name="tpTprice" value="${traffic.tpTprice}" class="form-control" id="tpTprice"
										       placeholder="${traffic.tpTprice}">
									</div>
								</div>

							</div>
							<!-- /.box-body -->

							<div class="box-footer">
								<button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
								<button id="btnSunmit" type="submit" class="btn btn-info pull-right" onclick="">提交
								</button>
							</div>
							<!-- /.box-footer -->
						</form>
					</div>
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
