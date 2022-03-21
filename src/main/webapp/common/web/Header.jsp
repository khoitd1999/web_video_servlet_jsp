<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	.dropdown ul li:hover{
		background-color: darkgrey;
	}
  .dropdown ul li a{
    text-decoration: none;
    color: black;
  }
  .dropdown button{
  	background-color: black;
  }
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/trang-chu">VIDEO</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <c:if test="${empty model}">
	          <li class="nav-item">
	            <a class="nav-link" href="/dang-nhap?action=login">Login</a>
	          </li>
          </c:if>
          <c:if test="${not empty model}">
	          <li class="nav-item">
	            <a class="nav-link" href="#">Hello [${model.username}]</a>
	          </li>
	          <li class="nav-item">
	            <a class="nav-link" href="/dang-xuat?action=logout">Logout</a>
	          </li>
          </c:if>
        </ul>
        <div class="dropdown">
  			<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="true">Thể loại
  			<span class="caret"></span></button>
  			<ul class="dropdown-menu">
  				<c:forEach var="item" items="${category}">
  					<li><a href="/chi-tiet-the-loai?idCate=${item.idCate}">${item.name}</a></li>
  				</c:forEach>
  			</ul>
		  </div>
      </div>
    </div>
  </nav>
</body>
</html>