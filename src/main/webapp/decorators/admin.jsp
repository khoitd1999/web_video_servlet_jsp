<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin home</title>
	<link href="<c:url value="/template/admin/vendor/fontawesome-free/css/all.min.css" />" rel="stylesheet" type="text/css">
  	<link href="<c:url value="/template/admin/css/sb-admin-2.min.css" />" rel="stylesheet">
  	<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
	 <link href="<c:url value="/template/admin/vendor/datatables/dataTables.bootstrap4.min.css" />" rel="stylesheet">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript" src="<c:url value="/template/gobal/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/ckeditor/ckeditor.js" />"></script>
</head>
<body>
	<div id="wrapper">
	
	<!-- menu -->
	<%@ include file="/common/admin/menu.jsp" %>
	
	<!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
	<!-- header -->
	<%@ include file="/common/admin/header.jsp" %>
	
	
	<!-- body -->
	<dec:body />
	
	<!-- footer -->
	<%@ include file="/common/admin/footer.jsp" %>
	</div>
	</div>
	
  <script src="<c:url value="/template/admin/vendor/jquery/jquery.min.js" />"
  	type="text/javascript"></script>
  <script src="<c:url value="/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js" />"
  	type="text/javascript"></script>
  <script src="<c:url value="/template/admin/vendor/jquery-easing/jquery.easing.min.js" />"
  	type="text/javascript"></script>
  <script src="<c:url value="/template/admin/js/sb-admin-2.min.js" />"
  	type="text/javascript"></script>
  <script src="<c:url value="/template/admin/vendor/chart.js/Chart.min.js" />"
  	type="text/javascript"></script>
  <script src="<c:url value="/template/admin/js/demo/chart-area-demo.js" />"
  	type="text/javascript"></script>
  <script src="<c:url value="/template/admin/js/demo/chart-pie-demo.js" />"
  	type="text/javascript"></script>

  <!-- Page level plugins -->
  <script src="<c:url value="/template/admin/vendor/datatables/jquery.dataTables.min.js" />"></script>
  <script src="<c:url value="/template/admin/vendor/datatables/dataTables.bootstrap4.min.js" />"></script>

  <!-- Page level custom scripts -->
  <script src="<c:url value="/template/admin/js/demo/datatables-demo.js" />"></script>
</body>
</html>