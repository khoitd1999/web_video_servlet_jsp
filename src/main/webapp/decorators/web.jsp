<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<link href="<c:url value="/template/web/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/template/web/css/heroic-features.css" />" rel="stylesheet">
<link href="<c:url value="/template/web/css/blog-home.css" />" rel="stylesheet">
<link href="<c:url value="/template/web/css/blog-post.css" />" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<!-- header -->
	<%@ include file="/common/web/Header.jsp" %>
	
	<!-- body -->
	<dec:body />
	
	<!-- footer -->
	<%@ include file="/common/web/footer.jsp" %>
	
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="<c:url value="/template/web/vendor/jquery/jquery.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/template/web/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>

</body>
</html>