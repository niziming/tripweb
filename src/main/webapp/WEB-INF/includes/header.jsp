<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet" href="${path}/static/assets/bower_components/bootstrap/dist/css/bootstrap.min.css">
<%--bootstrap-4.3.1-dist--%>
<%--<link rel="stylesheet" href="${path}/static/assets/plugins/bootstrap-4.3.1-dist/css/bootstrap.min.css"/>--%>

<!-- Font Awesome -->
<link rel="stylesheet" href="${path}/static/assets/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="${path}/static/assets/bower_components/Ionicons/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${path}/static/assets/css/AdminLTE.min.css">

<!-- iCheck -->
<link rel="stylesheet" href="${path}/static/assets/plugins/iCheck/square/blue.css"/>
<link rel="stylesheet" href="${path}/static/assets/plugins/iCheck/all.css"/>

<!-- DataTables -->
<link rel="stylesheet" href="${path}/static/assets/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">

<%--图片上传--%>
<link rel="stylesheet" href="${path}/static/assets/plugins/dropzone/dropzone.css" />
<link rel="stylesheet" href="${path}/static/assets/plugins/dropzone/min/basic.min.css" />

<!-- AdminLTE Skins. Choose a skin from the css/skins
folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet" href="${path}/static/assets/css/skins/_all-skins.min.css">

<%--wangEdit富文本编辑器--%>
<link rel="stylesheet" href="${path}/static/assets/plugins/wangEditor/release/wangEditor.min.css
">

<%--回复功能--%>
<link rel="stylesheet" href="${path}/static/assets/plugins/layui/css/layui.css"/>

<%--日期时间组件--%>
<link rel="stylesheet" href="${path}/static/assets/plugins/my/bootstrap-datetimepicker.min.css"/>

<%--省市联动--%>
<%--<link rel="stylesheet" href="${path}/static/assets/app/demo.css"/>--%>


<%--谷歌字体--%>
<link href='https://fonts.font.im/css?family=Roboto:400,500' rel='stylesheet' type='text/css'>
