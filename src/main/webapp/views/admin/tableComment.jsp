<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp" %>
<c:url var="APIcomment" value="/api-comment"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Begin Page Content -->
	<c:if test="${not empty message}">
		<div class="alert alert-${alert}">
  			<strong> ${message } </strong>
		</div>
	</c:if>
	<form id="formSumbit">
        <div class="container-fluid">
          <div class="card shadow mb-4">
            <div class="card-body">
              <div class="table-responsive">
              	<div class="widget-box table-filter">
              		<div class="col-xs-12">
						<div class="table-btn-controls">
							<div class="pull-right tableTools-container">
								<div class="dt-buttons btn-overlap btn-group">
									<button id="btnDelete" type="button" disabled
										class="dt-button buttons-html5 btn btn-blue btn-bold"
										data-toogle="tooltip" title='Xóa video' >
										<span>
											<i class="fa fa-trash" aria-hidden="true"></i>
										</span>
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                
                  <thead>
                    <tr>
                      <th><input type="checkbox" id="checkAll"></th>
                      <th>Tiêu đề bài viết</th>
                      <th>Tài khoản bình luận</th>
                      <th>Nội dung</th>
                      <th>Ngày bình luận</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:if test="${not empty video}">
	                  <c:forEach var="item" items="${comment}">
	                    <tr>
	                   		 <th><input type="checkbox" id="check_${item.idCom}" value="${item.idCom}" ></th>
			                 <td> ${video.title}</td>
			                 <th>${item.username}</th>
			                 <td>${item.content} </td>
			                 <td>${item.createdDate}</td>
	                    </tr>
	                  </c:forEach>
                  </c:if>
                  <c:if test="${not empty user}">
	                  <c:forEach var="item" items="${comment}">
	                    <tr>
	                   		 <th><input type="checkbox" id="check_${item.idCom}" value="${item.idCom}" ></th>
			                 <td> ${item.title}</td>
			                 <th>${user.username}</th>
			                 <td>${item.content} </td>
			                 <td>${item.createdDate}</td>
	                    </tr>
	                  </c:forEach>
                  </c:if>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
			<input type="hidden" id="idV" name="idV" value="${video.idV}">
			<input type="hidden" id="idU" name="idU" value="${user.idU}">
        </div>
    </form>    
        <!-- /.container-fluid -->
	<script type="text/javascript">
		var idV = $('#idV').val();
		var idU = $('#idU').val();
		var id ;
		var name ;
		$('#btnDelete').click(function (e) { 
			var data ={};
			var ids = $('#checkAll').closest('table').find('tbody input[type=checkbox]:checked').map(function () {
				return $(this).val();
			}).get();
			data['ids'] = ids;
			if (idV == ""){
				id = idU;
				name = "idU";
			}
			else{
				id = idV ;
				name = "idV";
			}
			deleteVideo(data);
		});
		function deleteVideo(data) {
			$.ajax({
				type: "DELETE",
				url: "${APIcomment}",
				data: JSON.stringify(data),
				contentType: "application/json",
				dataType: "json",
				success: function (response) {
					window.location.href="/admin-comment?"+name+"="+id+"&message=delete_success&alert=success";
				},
				error: function (response) {
					window.location.href="/admin-comment?"+name+"="+id+"&message=delete_fail&alert=danger";
				}
			});
		}
    </script>
</body>
</html>