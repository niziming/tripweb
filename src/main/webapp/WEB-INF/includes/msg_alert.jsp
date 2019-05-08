<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--Denger alert--%>
<c:if test="${msg.msg != null}">
	<div class="alert alert-${msg.status == 200 ? "success" : "danger"} alert-dismissible">
		<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
			<%--${msg}--%>
		<h4>${msg.msg}</h4>
	</div>
</c:if>
<%--/.alert--%>