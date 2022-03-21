<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<c:url var="loginAPI" value="/api-login"/>
<c:url var="webURL" value="/trang-chu"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<c:if test="${not empty message}">
		<div class="alert alert-${alert}">
  			<strong> ${message } </strong>
		</div>
	</c:if>
	<div class="container h-100">
		<div class="d-flex justify-content-center h-100">
			<div class="user_card">
				<div class="d-flex justify-content-center">
					<div class="brand_logo_container">
						<img src="https://cdn.freebiesupply.com/logos/large/2x/pinterest-circle-logo-png-transparent.png" class="brand_logo" alt="Logo">
					</div>
				</div>
				<!-- form gửi dữ liệu -->
				<div class="d-flex justify-content-center form_container">
					<form action="<c:url value="/trang-chu"/>" id="formSubmit" method="post">
						<div class="input-group mb-3">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" id="username" name="username" class="form-control input_user" value="" placeholder="username">
						</div>
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" id="password" name="password" class="form-control input_pass" value="" placeholder="password">
						</div>
						<div class="form-group">
							<div class="custom-control custom-checkbox">
								<input type="checkbox" class="custom-control-input" id="customControlInline">
								<label class="custom-control-label" for="customControlInline">Remember me</label>
							</div>
						</div>
							<div class="d-flex justify-content-center mt-3 login_container">
				 				<button type="submit" id="btnSubmit" name="button" class="btn login_btn">Login</button>
				   			</div>
					</form>
				</div>
				
				<div class="mt-4">
					<div class="d-flex justify-content-center links">
						Bạn chưa có tài khoản? <a href="/dang-ki?action=register&idR=2" class="ml-2" style="text-decoration: none;">Đăng kí</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>