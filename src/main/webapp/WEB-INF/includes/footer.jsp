<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9] 让IE8支持媒体查询 -->
<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<!-- [endif] -->

<!-- jQuery 3 -->
<script src="${path}/static/assets/bower_components/jquery/dist/jquery.min.js"></script>

<!-- jQuery UI 1.11.4 -->
<script src="${path}/static/assets/bower_components/jquery-ui/jquery-ui.min.js"></script>

<!-- Bootstrap 3.3.7 -->
<script src="${path}/static/assets/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- Slimscroll -->
<script src="${path}/static/assets/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>

<!-- FastClick -->
<script src="${path}/static/assets/bower_components/fastclick/lib/fastclick.js"></script>

<!-- AdminLTE App -->
<script src="${path}/static/assets/js/adminlte.min.js"></script>

<!-- iCheck -->
<script src="${path}/static/assets/plugins/iCheck/icheck.min.js"></script>

<%--App--%>
<script src="${path}/static/assets/app/app.js"></script>

<!-- DataTables -->
<script src="${path}/static/assets/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${path}/static/assets/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>

<%--wangEditor--%>
<script src="${path}/static/assets/plugins/wangEditor/release/wangEditor.min.js"></script>

<%--图片上传组件 dropzone--%>
<script src="${path}/static/assets/plugins/dropzone/min/dropzone.min.js"></script>

<%--图片上传组件 dropzone--%>
<script src="${path}/static/assets/plugins/dropzone/min/dropzone.min.js"></script>

<%--日期时间组件 dropzone--%>
<script src="${path}/static/assets/plugins/my/bootstrap-datetimepicker.min.js"></script>


<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
    $.widget.bridge('uibutton', $.ui.button);
</script>