<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:url var="APIvideo" value="/api-admin-videos"/>
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
									<c:url var="ThemUrl" value="/admin-video">
										<c:param name="type" value="edit" />
									</c:url>
									<a
										class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
										data-toogle="tooltip" title='Thêm video' 
										href='<c:url value="${ThemUrl}"/>' >
										<span>
											<i class="fa fa-plus-circle bigger-110 purple"></i>
										</span>
									</a>
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
                      <th>Tiêu đề</th>
                      <th>Ảnh đại diện</th>
                      <th>Nội dung</th>
                      <th>Ngày tạo</th>
                      <th>Người tạo</th>
                      <th>Thể loại</th>
                      <th>Mô tả ngắn</th>
                      <th>Bình luận</th>
                      <th>Thao tác</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="item" items="${arrayVideo.listResult}">
                    <tr>
                   		 <th><input type="checkbox" id="check_${item.idV}" value="${item.idV}" ></th>
		                 <td> ${item.title}</td>
		                 <th>${item.thumbnail}</th>
		                 <td>${item.content} </td>
		                 <td>${item.createdDate}</td>
		                 <td>${item.createdBy}</td>
		                 <td>${tenCate.name}</td>
		                 <td>${item.shortdescription}</td>
		                 <td><a href="/admin-comment?idV=${item.idV}" style="text-decoration: none;">Các bình luận:${item.title}</a></td>
		                 <td>
		                 <c:url var="SuaUrl" value="/admin-video">
		                 	<c:param name="type" value="edit" />
		                 	<c:param name="idV" value="${item.idV}" />
		                 </c:url>
		                 <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
							title="Cập nhật bài viết" href='${SuaUrl}'>
							<i class="fa fa-space-shuttle" aria-hidden="true"></i>
						 </a>
						</td>
                    </tr>
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
				url: "${APIvideo}",
				data: JSON.stringify(data),
				contentType: "application/json",
				dataType: "json",
				success: function (response) {
					window.location.href="/admin-video?type=list&idCate="+${tenCate.idCate}+"&message=delete_success&alert=success";
				},
				error: function (response) {
					window.location.href="/admin-video?type=list&idCate="+${tenCate.idCate}+"&message=delete_fail&alert=danger";
				}
			});
		}
    </script>
</body>
</html>