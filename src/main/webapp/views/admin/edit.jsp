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

	<c:if test="${not empty message}">
		<div class="alert alert-${alert}">
  			<strong> ${message } </strong>
		</div>
	</c:if>
	<form class="form-horizontal" id="formSubmit">
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Title</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="title" name="title" placeholder="Title" value="${video.title}">
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Thể loại</label>
		<div class="col-sm-10">
			<c:if test="${empty videoCate}">
			<select id="idCate" name="idCate">
				<option>Chọn thể loại</option>
				<c:forEach var="item" items="${cate.listResult}">
					<option value="${item.idCate}">${item.name}</option>
				</c:forEach>
			</select>
			</c:if>
			<c:if test="${not empty videoCate}">
			<select id="idCate" name="idCate">
				<option>Chọn thể loại</option>
				<c:forEach var="item" items="${cate.listResult}">
					<option value="${item.idCate}" <c:if test="${item.idCate == videoCate.idCate}">selected</c:if> >
						${item.name}
					</option>
				</c:forEach>
			</select>
			</c:if>
		</div>
	</div>
	<div class="form-group">
		<label for="message" class="col-sm-2 control-label">Thumbnail</label>
		<div class="col-sm-10">
			<textarea class="form-control" rows="4" name="thumbnail" id="thumbnail">${video.thumbnail}</textarea>
		</div>
	</div>
	<div class="form-group">
		<label for="message" class="col-sm-2 control-label">Shortdescription</label>
		<div class="col-sm-10">
			<textarea class="form-control" rows="4" name="shortdescription" id="shortdescription">${video.shortdescription}</textarea>
		</div>
	</div>
	<div class="form-group">
		<label for="message" class="col-sm-2 control-label">Content</label>
		<div class="col-sm-10">
			<textarea class="form-control" rows="4" name="content" id="content">${video.content}</textarea>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-10 col-sm-offset-2">
			<input id="btnSubmit1" type="button" value="sumbit" class="btn btn-primary">
		</div>
	</div>
	<input type="hidden" id="idV" name="idV" value="${video.idV}" >
</form>

<script type="text/javascript">
	var editor1 = '';
	var editor2 = '';
	var editor3 = '';
	$(document).ready(function () {	
		editor1 = CKEDITOR.replace('thumbnail'); // tham số là id của element
		editor2 = CKEDITOR.replace('shortdescription');
		editor3 = CKEDITOR.replace('content');
	});

	$('#btnSubmit1').click(function (e) { 
		var data = {};
		var array = $('#formSubmit').serializeArray();
		$.each(array, function (i,v) { 
			 data[""+v.name+""] = v.value;
		});
		data["thumbnail"] = editor1.getData();
		data["shortdescription"] = editor2.getData();
		data["content"] = editor3.getData();
		var id = $('#idV').val();
		if(id == ""){
			addVideo(data);
		}else{
			updateVideo(data);
		}
	});

	function addVideo(data) {
		$.ajax({
			type: "POST",
			url: "${APIvideo}",
			data: JSON.stringify(data),
			contentType: "application/json",
			dataType: "json",
			success: function (response) {
				window.location.href="/admin-video?type=edit&message=insert_success&alert=success";
			},
			error: function (response) {
				window.location.href="/admin-video?type=edit&message=insert_fail&alert=danger";
			}
		});
	}

	function updateVideo(data) {
		$.ajax({
			type: "PUT",
			url: "${APIvideo}",
			data: JSON.stringify(data),
			contentType: "application/json",
			dataType: "json",
			success: function (response) {
				window.location.href="/admin-video?type=edit&idV="+response.idV+"&message=edit_success&alert=success";
			},
			error: function (response) {
				window.location.href="/admin-video?type=list&message=edit_fail&alert=danger";
			}
		});
	}
</script>
</body>
</html>