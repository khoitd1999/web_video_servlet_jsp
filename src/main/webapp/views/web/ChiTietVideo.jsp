<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp" %>
    <c:url var="APIcomment" value="/api-comment"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Video</title>
</head>
<body>
	<div class="container">

    <div class="row">
		<c:if test="${not empty message}">
			<div class="alert alert-${alert}">
	  			<strong> ${message } </strong>
			</div>
		</c:if>
      <!-- Post Content Column -->
      <div class="col-lg-12">
        <hr>

        <!-- Date/Time -->
        <p><b>Post on</b>:${video.createdDate}</p>

        <hr>

        <!-- Preview Image -->
			${video.content}
        <hr>

        <!-- Post Content -->


        <p><strong>${video.title}</strong></p>

        ${video.shortdescription}

        <hr>
		<p style="text-align: center;"><strong>CẦN ĐĂNG NHẬP ĐỂ BÌNH LUẬN</strong></p>
		<hr>
        <!-- Comments Form -->
        <div class="card my-4">
          <h5 class="card-header">Bình luận công khai:</h5>
          <div class="card-body">
            <form>
              <div class="form-group">
                <textarea class="form-control" rows="3" name="content" id="content"></textarea>
              </div>
              <button type="button" class="btn btn-primary" id="btnSubmit">Submit</button>
            </form>
          </div>
        </div>
        <div id="comments">
        <c:forEach var="item" items="${comment}">
	        <div class="media mb-4">
	   		  <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
	          <div class="media-body">
	            <h5 class="mt-0" id="username-comment">${item.username}</h5>
	            <p>${item.createdDate}</p>
	            <p id="content-coment">${item.content}</p>
	          </div>
	        </div>
        </c:forEach>
        </div>  
      </div>
		<input type="hidden" id="user" name="user" value="${model.idU}">
    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->
  
  <script type="text/javascript">
    var idV = ${video.idV};
    var idU = $('input[name="user"]').val();
    var data = {};
    var dem = ${index};
    $('#btnSubmit').click(function (e) { 
      e.preventDefault();
      if( idU == ""){
        window.location.href = "/chi-tiet-video?idV="+idV+"&message=not_login&alert=danger";
      }else{
        data["idV"] = idV;
        data["idU"] = idU;
        data["content"] = $('textarea[name="content"]').val();
        $.ajax({
          type: "POST",
          url: "${APIcomment}",
          data: JSON.stringify(data),
          contentType: "application/json",
          dataType: "json",
          success: function (data) {  
        	 $('#comments').prepend(
        		'<div class="media mb-4">'+
  	   		  '<img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">' +
  	          '<div class="media-body">' +
  	           ' <h5 class="mt-0" id="username-comment">'+data.username+'</h5>' +
  	           ' <p>'+data.createdDate+'</p> ' +
  	           ' <p id="content-coment">'+data.content+'</p> '+
  	         ' </div> ' +
  	        ' </div>' 
        	 );
          },
          error: function (data) {  
            window.location.href = "/chi-tiet-video?idV="+idV+"&message=not_comment&alert=danger";
          }
        });
      }
    });
  </script>
</body>
</html>