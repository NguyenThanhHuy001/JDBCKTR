<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<!-- 
    Đây là fragment JSP chứa Sidebar (menu điều hướng trái) của giao diện Admin.
    Nó được include vào file decorators/admin.jsp.
    
    LƯU Ý: Biến request.requestURI được sử dụng để xác định link nào đang active.
-->

<div class="sidebar" id="sidebarMenu">
    
    <!-- Logo Header for Desktop -->
    <div class="sidebar-header d-none d-md-flex">
         <a class="text-white text-decoration-none fw-bold fs-5" href="${pageContext.request.contextPath}/admin/home">
            <i class="bi bi-person-workspace me-2"></i>ADMIN DASH
        </a>
    </div>
    
    <!-- Menu Items -->
    <ul class="nav flex-column sidebar-menu">
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/home" class="nav-link text-white ${fn:contains(request.requestURI, '/admin/home') ? 'active' : ''}">
                <i class="bi bi-speedometer2 me-2"></i> Dashboard
            </a>
        </li>
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/nhanvien/list" class="nav-link text-white ${fn:contains(request.requestURI, '/admin/nhanvien') ? 'active' : ''}">
                <i class="bi bi-people-fill me-2"></i> Quản lý Nhân viên
            </a>
        </li>
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/loaisach" class="nav-link text-white ${fn:contains(request.requestURI, '/admin/sanpham') ? 'active' : ''}">
                <i class="bi bi-box-seam-fill me-2"></i> Quản lý Loại Sách
            </a>
        </li>
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/donhang/list" class="nav-link text-white ${fn:contains(request.requestURI, '/admin/donhang') ? 'active' : ''}">
                <i class="bi bi-truck me-2"></i> Quản lý Đơn hàng
            </a>
        </li>
        <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/thongke" class="nav-link text-white ${fn:contains(request.requestURI, '/admin/thongke') ? 'active' : ''}">
                <i class="bi bi-graph-up me-2"></i> Thống kê
            </a>
        </li>
    </ul>
    
</div>
