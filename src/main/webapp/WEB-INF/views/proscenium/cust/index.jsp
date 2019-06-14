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
								<div>
									<%--出发地--%>
									<div class="form-group" data-toggle="distpicker" id="current_city">
										出发地：
											<select class="form-control" data-province="-- 选择省 --"></select>
											<select class="form-control" data-city="-- 选择市 --"></select>
											<select class="form-control" data-district="-- 选择区 --"></select>
										<div class="form-group">
											<button class="btn btn-primary" id="reset" type="button">重置</button>
										</div>
									</div>
									<%--目的地--%>
									<div class="form-group" data-toggle="distpicker" id="des_city">
										目的地：
										<select class="form-control" data-province="-- 选择省 --"></select>
										<select class="form-control" data-city="-- 选择市 --"></select>
										<select class="form-control" data-district="-- 选择区 --"></select>
										<div class="form-group">
											<button class="btn btn-primary" id="reset" type="button">重置</button>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
					<br>

					<%--交通查询表单--%>
					<div class="container col-lg-12">
						<table id="traffic_table" class="table table-bordered table-striped">
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

					<%--景点选择--%>
					<div class="container">
						<p class="btn bg-orange btn-flat margin" style="cursor: default">目的景点</p>
					</div>
					<div class="container" id="view_cust"></div>

						<br>
						<br>
						<hr>

					<%--酒店选择--%>
					<div class="container">
						<p class="btn bg-orange btn-flat margin" style="cursor: default">目的酒店</p>
					</div>
					<%--结果--%>
					<div class="container" id="hotel_cust"></div>
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

		<%--省市区联动插件--%>
		<script src="/static/assets/plugins/jQueryDistpicker20160621/js/distpicker.data.js"></script>
		<script src="/static/assets/plugins/jQueryDistpicker20160621/js/distpicker.js"></script>

	<script>

        $.fn.distpicker.setDefaults({
            autoSelect:false
        });


        var currentCity= "";
        var desCity="";
        $("#current_city select").on("change", function () {
            $this = $(this);
            currentCity = $this.children("option:selected").val();
            if(currentCity==""){
                currentCity = $this.prev().children("option:selected").val();
                if(typeof currentCity == "undefined"){
                    currentCity = "";
                }
            }
            console.log(currentCity,desCity);
            ajax_city(currentCity, desCity);
        });

        $("#des_city select").on("change", function () {
            $this = $(this);
            desCity = $this.children("option:selected").val();
            if(desCity==""){
                desCity = $this.prev().children("option:selected").val();
                if(typeof desCity == "undefined"){
                    desCity = "";
                }
            }
            console.log(currentCity,desCity);
            ajax_city(currentCity, desCity);
        });

        // 交通表异步加载
        function ajax_city(currentCity, desCity) {
            $("#traffic_table tbody").empty();
            $("#view_cust").empty();
            $("#hotel_cust").empty();
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
                            var tpCurrentTime = new Date(data[i].tpCurrentTime).Format("yyyy-MM-dd:hh:mm:ss");
                            var tpArriveTime = new Date(data[i].tpArriveTime).Format("yyyy-MM-dd:hh:mm:ss");
                            console.log(data[i].tpArriveTime - data[i].tpCurrentTime);
                            var tpSpendTime = new Date(data[i].tpArriveTime - data[i].tpCurrentTime).Format("hh:mm:ss");
                            $("#traffic_table tbody").append(
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
                            tpDestination = data[i].tpDestination;
                        }
                        ajax_viewPoint_cust(desCity);
                        ajax_hotel_cust(desCity);
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

                        $("#view_cust").append(
                            '<div class="col-sm-6 col-md-4 col-lg-3 viewpages">'
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

        // 酒店ajax
        function ajax_hotel_cust(tpDestination) {
            var _checkbox = App.getCheckbox();
            console.log(_checkbox.length);
            $.ajax({
                url: '/cust/hotel',
                type: 'GET',
                data: {
                    local: tpDestination
                },

                success: function (data) {
                     console.log(data);
                    for (var i = 0; i < data.length; i++) {
                        var title = data[i].title.substring(1, 9);

                        $("#hotel_cust").append(

                            '<div class="col-sm-6 col-md-4 col-lg-5">'
	                        + '<div class="thumbnail"  style="height: 450px;">'
                            + '<a href="/hotel/content?hid=' + data[i].hid + '">'
                            + '<img src="' + data[i].imgUrl + '">'
                            + '</a>'
                            + '<div class="caption">'
                            + '<h3>' + data[i].title + '</h3>'
                            + '<ol>'
                            + '<li><p style="color: #ffa309">城市：' + data[i].local + '|房屋类型：' + data[i].houseType + '|床类型：' + data[i].bedType + '</p> </li>'
                            + '<li><p style="color: #0b93d5">价格：￥' + data[i].price + '| 详细地址：' + data[i].zip + '</p></li>'
                            + '</ol>'
                            + '</div>'
                            + '<div class="form-group" style="text-align: right;">'
                            + '<a class="btn" style="color: #0b97c4" href="/hotel/content?hid=' + data[i].hid + '">查看详情»</a>'
                            + '</div>'
                            + '</div>'
                            + '</div>'
	                        + '<div class="col-lg-1"></div>'
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