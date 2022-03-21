<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp" %>
<!-- Sidebar -->
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">
	<!-- Sidebar - Brand -->
	<a class="sidebar-brand d-flex align-items-center justify-content-center" href="#">
		<div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laugh-wink"></i>
		</div>
		<div class="sidebar-brand-text mx-3">
			${model.fullname}
		</div>
	</a>
	<!-- Divider -->
	<hr class="sidebar-divider my-0" />



	<!-- Nav Item - Pages Collapse Menu -->
	<li class="nav-item">
		<a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#collapseTwo" aria-expanded="true"
			aria-controls="collapseTwo"> 
				<i class="fas fa-fw fa-cog"></i>
				 	<span>Thể loại</span>
		</a>
		<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
			data-parent="#accordionSidebar">
			<div class="bg-white py-2 collapse-inner rounded">
				<c:forEach var="item" items="${cate.listResult}">
					<c:url var="admin_video" value="/admin-video">
						<c:param name="type" value="list" />
						<c:param name="idCate" value="${item.idCate}" />
					</c:url>
					<a class="collapse-item" href="${admin_video}">
						${item.name}
					</a> 
				</c:forEach>
			</div>
		</div>
	</li>
	<li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
          <i class="fas fa-fw fa-wrench"></i>
          <span>Quản lí users</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities" data-parent="#accordionSidebar">
          <div class="bg-white py-2 collapse-inner rounded">
            <a class="collapse-item" href="/admin-user?idR=1">ADMIN</a>
			<a class="collapse-item" href="/admin-user?idR=2">USER</a>
          </div>
        </div>
      </li>
	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block" >

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

</ul>
<!-- End of Sidebar -->
