<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:url var="APIuser" value="/api-user"/>
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
                      <th>Username</th>
                      <th>Password</th>
                      <th>Fullname</th>
                      <th>Bình luận</th>
                      <th>Ngày Tạo</th>
                      <th>Role</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="item" items="${user}">
                    <tr>
                   		 <th><input type="checkbox" id="check_${item.idU}" value="${item.idU}" ></th>
		                 <td> ${item.username}</td>
		                 <th>${item.password}</th>
		                 <td>${item.fullname} </td>
		                 <td><a href="/admin-comment?idU=${item.idU}" style="text-decoration: none;">Các bình luận của ${item.username}</a></td>
		                 <td>${item.createdDate}</td>
		                 <c:if test="${item.idR == 1}">
	                      	<th>Admin</th>
	                     </c:if>
	                     <c:if test="${item.idR == 2}">
	                      	<th>User</th>
	                     </c:if>
                    </tr>
                    <input type="hidden" id="idR" name="idR" value="${item.idR}">
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>

        </div>
    </form>    
        <!-- /.container-fluid -->
	<script type="text/javascript">
		var idR = $('#idR').val();
		$('#btnDelete').click(function (e) { 
			var data ={};
			var ids = $('#checkAll').closest('table').find('tbody input[type=checkbox]:checked').map(function () {
				return $(this).val();
			}).get();
			data['ids'] = ids;
			deleteVideo(data);
		});
		function deleteVideo(data) {
			$.ajax({
				type: "DELETE",
				url: "${APIuser}",
				data: JSON.stringify(data),
				contentType: "application/json",
				dataType: "json",
				success: function (response) {
					window.location.href="/admin-user?idR="+idR+"&message=delete_success&alert=success";
				},
				error: function (response) {
					window.location.href="/admin-user?idR="+idR+"&message=delete_fail&alert=danger";
				}
			});
		}
    </script>
</body>
</html>