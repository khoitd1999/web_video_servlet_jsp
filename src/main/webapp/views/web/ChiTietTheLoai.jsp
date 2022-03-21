<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Page Content -->
  <div class="container">
	<br>
	<br>
    <div class="row">
      <!-- Blog Entries Column -->
      <div class="col-md-8">

		<c:forEach var="item" items="${video}">
			<div class="card mb-8">
				<div class="embed-responsive embed-responsive-21by9">
				 ${item.content}
				</div>
	          <div class="card-body">
	            <h2 class="card-title"><a href="/chi-tiet-video?idV=${item.idV}" style="text-decoration: none;">${item.title}</a></h2>
	            <p class="card-text">${item.shortdescription}</p>
	            <a href="/chi-tiet-video?idV=${item.idV}" class="btn btn-primary">Bình luận &rarr;</a>
	          </div>
          </div>
      <input type="hidden" id="idCate" name="idCate" value="${item.idCate}">
		</c:forEach>

        <!-- Pagination -->
      <form id="formSubmit"> 
       <ul class="pagination justify-content-center mb-4">
       
          <li class="page-item">
            <button type="button" class="page-link" id="btnFirst" name="btnFirst" value="1">&larr; First</button>
          </li>
          <c:if test="${current == 1}">
          	<li class="page-item">
	            <button type="button" class="page-link" value="${current}">Previous</button>
	      	</li>
          </c:if>
          <c:if test="${current > 1}">
          	<li class="page-item">
	            <button type="button" class="page-link" value="${current-1}">Previous</button>
	      	</li>
          </c:if>
          <c:forEach var="item" items="${pageShow}">
          	<li class="page-item">
	            <button type="button" class="page-link" value="${item}">${item}</button>
	        </li>
          </c:forEach>
          <c:if test="${current == pageLast}">
          	<li class="page-item">
	            <button type="button" class="page-link" value="${current}">Next</button>
	      	</li>
          </c:if>
          <c:if test="${current < pageLast}">
          	<li class="page-item">
	            <button type="button" class="page-link" value="${current+1}">Next</button>
	      	</li>
          </c:if>
          <li class="page-item">
          	<button type="button" class="page-link" id="btnLast" name="btnLast" value="${pageLast}">Last &rarr;</button>
          </li>
        </ul>
       </form> 
      </div>
    </div>
    <!-- /.row -->
  </div>
  <!-- /.container -->
  <script type="text/javascript">
    $('form').find('button').click(function (e) { 
      e.preventDefault();
      var page = $(this).val();
      var limit = 5;
      var idCate = $('#idCate').val();
      window.location.href = "/chi-tiet-the-loai?idCate="+idCate+"&page="+page+"&limit="+limit;
    });
  </script>
</body>
</html>