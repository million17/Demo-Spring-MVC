<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title><dec:title default="Home Web" /></title>
<link
	href="<c:url value= '/template/web/vendor/css/modern-business.css' />"
	rel="stylesheet">
<!-- Bootstrap core CSS -->
<link
	href="<c:url value= '/template/web/vendor/bootstrap/css/bootstrap.min.css' />"
	rel="stylesheet">



</head>
<body>

	<!-- header -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- end header -->

	<div class="container">
		<dec:body />
	</div>

	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- end footer -->
	<!-- Bootstrap core JavaScript -->
	<script src="<c:url value='/template/web/vendor/jquery/jquery.min.js' />"></script>
	<script
		src="<c:url value='/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js' /> "></script>
</body>
</html>