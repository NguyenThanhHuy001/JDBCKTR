<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

<nav class="navbar navbar-expand-lg navbar-dark bg-dark py-1">
    <div class="container-fluid container-lg">
        <ul class="navbar-nav me-auto">
            <li class="nav-item">
                <a class="nav-link text-white-50" href="#">GIỚI THIỆU</a>
            </li>
        </ul>
        
        <ul class="navbar-nav">
            <c:choose>
                <c:when test="${sessionScope.user != null}">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle text-white" href="#" role="button"
                           data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="bi bi-person-fill me-1"></i>
                            Xin chào, ${sessionScope.user.hoTen}
                        </a>
                        <ul class="dropdown-menu dropdown-menu-end">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/profile">Thông tin cá nhân</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">ĐĂNG XUẤT</a></li>
                        </ul>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="${pageContext.request.contextPath}/login">ĐĂNG NHẬP</a>
                    </li>
                    <li class="nav-item">
                        <span class="nav-link text-white-50 p-0 me-2">|</span>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="${pageContext.request.contextPath}/register">ĐĂNG KÝ</a>
                    </li>
                </c:otherwise>
            </c:choose>
            <li class="nav-item ms-3">
                <a class="nav-link text-white-50" href="#"><i class="bi bi-search"></i></a>
            </li>
        </ul>
    </div>
</nav>

<nav class="navbar navbar-expand-lg navbar-light bg-white shadow-sm py-3 sticky-top">
    <div class="container-fluid container-lg">
        
        <a class="navbar-brand fw-bolder text-primary" href="${pageContext.request.contextPath}/home">
            <i class="bi bi-star-fill me-1 text-danger"></i>IoT Star
        </a>
        
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#mainMenu"
            aria-controls="mainMenu" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="mainMenu">
            <ul class="navbar-nav mx-auto mb-2 mb-lg-0 fw-bold">
                <li class="nav-item me-3">
                    <a class="nav-link text-primary" href="${pageContext.request.contextPath}/home">TRANG CHỦ</a>
                </li>
                <li class="nav-item me-3">
                    <a class="nav-link text-dark" href="${pageContext.request.contextPath}/categories">DANH MỤC</a>
                </li>
                <li class="nav-item me-3">
                    <a class="nav-link text-dark" href="${pageContext.request.contextPath}/products">SẢN PHẨM</a>
                </li>
                <li class="nav-item me-3">
                    <a class="nav-link text-dark" href="${pageContext.request.contextPath}/contact">LIÊN HỆ</a>
                </li>
            </ul>

            <ul class="navbar-nav mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link text-dark fs-4 position-relative" href="${pageContext.request.contextPath}/cart" title="Giỏ Hàng">
                        <i class="bi bi-cart-fill"></i>
                        <%-- Số lượng sản phẩm trong giỏ --%>
                        <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
                            <c:out value="${sessionScope.cartCount ne null ? sessionScope.cartCount : 0}" />
                            <span class="visually-hidden">sản phẩm trong giỏ</span>
                        </span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>