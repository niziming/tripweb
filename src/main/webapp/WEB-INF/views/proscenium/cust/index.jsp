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
					定制 | Cust
					<small>最新发布</small>
				</h1>
				<ol class="breadcrumb">
					<br>
					<li><a href="/hotel/index"><i class="fa fa-dashboard"></i>定制</a></li>
					<li><a href="#">Hotel</a></li>

				</ol>
			</section>
			<br>
			<hr>
			<br>
			<section>
				<div class="box box-info">
					<%--交通--%>
					<div class="container">
						<br>
						<p class="btn bg-orange btn-flat margin" style="cursor: default">选择您的出行</p>
						<br>
						<br>
						<%--出发地--%>
						<div class="docs-methods">
							<form class="form-inline">
								<div id="distpicker">
									<div class="form-group">
										<label class="sr-only">Province</label>
										<select class="form-control" id="current_city">
											<option value="" data-code="">—— 出发地点 ——</option>
											<option value="绵阳" selected>绵阳</option>
											<option value="北京市" data-code="110000">北京市</option>
											<option value="天津市" data-code="120000">天津市</option>
											<option value="河北省" data-code="130000">河北省</option>
											<option value="山西省" data-code="140000">山西省</option>
											<option value="内蒙古自治区" data-code="150000">内蒙古自治区</option>
											<option value="辽宁省" data-code="210000">辽宁省</option>
											<option value="吉林省" data-code="220000">吉林省</option>
											<option value="黑龙江省" data-code="230000">黑龙江省</option>
											<option value="上海市" data-code="310000">上海市</option>
											<option value="江苏省" data-code="320000">江苏省</option>
											<option value="浙江省" data-code="330000">浙江省</option>
											<option value="安徽省" data-code="340000">安徽省</option>
											<option value="福建省" data-code="350000">福建省</option>
											<option value="江西省" data-code="360000">江西省</option>
											<option value="山东省" data-code="370000">山东省</option>
											<option value="河南省" data-code="410000">河南省</option>
											<option value="湖北省" data-code="420000">湖北省</option>
											<option value="湖南省" data-code="430000">湖南省</option>
											<option value="广东省" data-code="440000">广东省</option>
											<option value="广西壮族自治区" data-code="450000">广西壮族自治区</option>
											<option value="海南省" data-code="460000">海南省</option>
											<option value="重庆市" data-code="500000">重庆市</option>
											<option value="四川省" data-code="510000">四川省</option>
											<option value="贵州省" data-code="520000">贵州省</option>
											<option value="云南省" data-code="530000">云南省</option>
											<option value="西藏自治区" data-code="540000">西藏自治区</option>
											<option value="陕西省" data-code="610000">陕西省</option>
											<option value="甘肃省" data-code="620000">甘肃省</option>
											<option value="青海省" data-code="630000">青海省</option>
											<option value="宁夏回族自治区" data-code="640000">宁夏回族自治区</option>
											<option value="新疆维吾尔自治区" data-code="650000">新疆维吾尔自治区</option>
											<option value="台湾省" data-code="710000">台湾省</option>
											<option value="香港特别行政区" data-code="810000">香港特别行政区</option>
											<option value="澳门特别行政区" data-code="820000">澳门特别行政区</option>
										</select>
									</div>
									<div class="form-group">
										<label class="sr-only">City</label>
										<select class="form-control" id="des_city">
											<option value="" data-code="">—— 到达地点 ——</option>
											<option value="成都市" selected>成都市</option>
										</select>
									</div>
									<div class="form-group">
										<button class="btn btn-primary" id="reset" type="button">重置</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<br>
					<%--交通查询表单--%>
					<div class="container col-lg-12">
						<table id="myuserstable" class="table table-bordered table-striped">
							<thead>
							<tr>
								<th>类型</th>
								<th>出发地</th>
								<th>目的地</th>
								<th>出发时间</th>
								<th>到达时间</th>
								<th>花费时间</th>
								<th>价格</th>
							</tr>
							</thead>
							<tbody>

							</tbody>
						</table>
					</div>
					<br>

					<br>
					<hr>

					<div class="container">
						<p class="btn bg-orange btn-flat margin" style="cursor: default">景点选择</p>
					</div>
					<!-- /.box-body -->
					<%--酒店选择--%>
					<div class="container" id="hotel_cust"></div>

					<%--酒店选择--%>
					<div class="container">
						<p class="btn bg-orange btn-flat margin" style="cursor: default">酒店选择</p>
						<%--出发地--%>
						<div class="hotel-group">

						</div>
					</div>
					<%--结果--%>
					<div class="box-body table-responsive">

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

        $("#current_city").on("change", function () {
            var currentCity = $("#current_city option:selected").val();
            var desCity = $("#des_city option:selected").val();
            ajax_city(currentCity, desCity);
        });

        $("#des_city").on("change", function () {
            var currentCity = $("#current_city option:selected").val();
            var desCity = $("#des_city option:selected").val();
            ajax_city(currentCity, desCity);
        });

        function ajax_city(currentCity, desCity) {
            if (currentCity != "" && desCity != "") {
                // console.log(currentCity);
                // console.log(desCity);
                $.ajax({
                    url: '/traffic/selectByCurrentAndDestination',
                    type: 'GET',
                    data: {
                        currentCity: currentCity,
                        desCity: desCity
                    },
                    success: function (data) {
                        console.log(data);
                        var tpDestination;
                        for (var i = 0; i < data.length; i++) {
                            var tpCurrentTime = new Date(data[i].tpCurrentTime).Format("yyyy-MM-dd");
                            var tpArriveTime = new Date(data[i].tpArriveTime).Format("yyyy-MM-dd");
                            console.log(data[i].tpArriveTime - data[i].tpCurrentTime);
                            var tpSpendTime = new Date(data[i].tpArriveTime - data[i].tpCurrentTime).Format("hh:mm:ss");
                            $("#myuserstable tbody").append(
                                '<tr>'
                                + '<td><span class="label label-primary">' + data[i].tpType + '</span></td>'
                                + '<td>' + data[i].tpCurrent + '</td>'
                                + '<td>' + data[i].tpDestination + '</td>'
                                + '<td>' + tpCurrentTime + '</td>'
                                + '<td>' + tpArriveTime + '</td>'
                                + '<td>' + tpSpendTime + '</td>'
                                + '<td><span class="label label-primary">￥' + data[i].tpTprice + '</span></td>'
                                + '</tr>'
                            );
                            tpDestination = data[i].tpDestination
                        }
                        ajax_viewPoint_cust(tpDestination);
                    }
                });
            }
        }

        // 景点AJAX
        function ajax_viewPoint_cust(tpDestination) {
            var _checkbox = App.getCheckbox();
            console.log(_checkbox.length);
            $.ajax({
                url: '/cust/viewPoint',
                type: 'GET',
                data: {
                    tpLocation: tpDestination
                },
                success: function (data) {
                    // console.log(data);
                    for (var i = 0; i < data.length; i++) {
                        var title = data[i].tpTitle.substring(1, 9);

                        $("#hotel_cust").append(
                            '<div class="col-sm-6 col-md-4 col-lg-3 viewpages">'
                            + '<input value=" ' + data[i].tpVid + ' " type="checkbox" class="minimal minimal-myminor" style="position: absolute; top:2px; left: 15px;">'
                            + '<div class="thumbnail" style="height: 400px;">'
                            + '<a href="/view/content?tpVid= ' + data[i].tpVid + ' ">'
                            + '<img src="/static/upload/viewavatar/' + data[i].tpVpic + ' " alt="..." class="img-rounded">'
                            + '</a>'
                            + '<div class="col-md-12">'
                            + '<h3> ' + title + ' ...</h3>'
                            + '<h5> [ ' + data[i].tpVname + ' &nbsp;<small>| ' + data[i].tpLocation + ' </small>] </h5>'
                            + '<strong>等级: ' + data[i].tpLevel + ' </strong>| '
                            + '<strong> 开放时间:  ' + data[i].tpOpentime + ' </strong>|'
                            + '<strong>类型:  ' + data[i].tpVtype + ' </strong>'
                            + '<br> 详细地址:  ' + data[i].tpZip + ' '
                            + '<br/> 电话:  ' + data[i].tpVphone + ' '
                            + '<div class="form-group" style="text-align: right;">'
                            + '<a class="btn" style="color: #0b93d5" href="/view/content?tpVid=  ' + data[i].tpVid + ' ">查看更多 »</a>'
                            + '</div> </div> </div> </div> '
                        );
                    }
                }
            });
        }

        Date.prototype.Format = function (fmt) { //author: meizz
            var o = {
                "M+": this.getMonth() + 1,                  //月份
                "d+": this.getDate(),                       //日
                "h+": this.getHours(),                      //小时
                "m+": this.getMinutes(),                    //分
                "s+": this.getSeconds(),                    //秒
                "q+": Math.floor((this.getMonth() + 3) / 3),//季度
                "S": this.getMilliseconds()                 //毫秒
            };
            if (/(y+)/.test(fmt))
                fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
            for (var k in o)
                if (new RegExp("(" + k + ")").test(fmt))
                    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            return fmt;
        }

	</script>
</body>
</html>