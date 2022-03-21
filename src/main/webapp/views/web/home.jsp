<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!-- Page Content -->
  <div class="container">

	<br />
	<c:forEach var="itemBig" items="${videoByCategory}">
    <c:url var="theLoai" value="/chi-tiet-the-loai">
    	<c:param name="idCate" value="${itemBig.idV}"/>  <!-- idV thay cho idCate -->
    </c:url>
    <a href="${theLoai}"><button type="button" class="btn btn-primary">${itemBig.title}</button></a>	<!-- idtitle thay cho nameCate -->
    <br>
    <br>
    <div class="row text-center">
		<c:forEach var="item" items="${itemBig.listResult}">
	      <div class="col-lg-3 col-md-6 mb-4">
	        <div class="card h-100">
				  ${item.thumbnail}
	          <div class="card-body">
	            <h4 class="card-title"><a href="/chi-tiet-video?idV=${item.idV}" style="text-decoration: none;">${item.title}</a></h4>
	            	<p class="card-text">${item.shortdescription.substring(0,53)}...</p>
	         </div>
	        </div>
	      </div>
      	</c:forEach>
    </div>
    </c:forEach>
    <!-- /.row -->

  </div>
  <!-- /.container -->