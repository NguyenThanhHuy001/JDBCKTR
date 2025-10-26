<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Đăng ký tài khoản</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card shadow-lg rounded-3">
                <div class="card-header text-center bg-primary text-white">
                    <h4>Đăng ký tài khoản</h4>
                </div>
                <div class="card-body">

                    <!-- Hiển thị thông báo lỗi -->
                    <c:if test="${not empty alert}">
                        <div class="alert alert-warning text-center">${alert}</div>
                    </c:if>

                    <form action="${pageContext.request.contextPath}/khachhang/register" method="post">

                        <div class="mb-3">
                            <label for="email" class="form-label">Email:</label>
                            <input type="email" class="form-control" id="email" name="email"
                                   placeholder="Nhập email của bạn" required
                                   value="${param.email}">
                        </div>

                        <div class="mb-3">
                            <label for="tendangnhap" class="form-label">Tên đăng nhập:</label>
                            <input type="text" class="form-control" id="tendangnhap" name="tendangnhap"
                                   placeholder="Nhập tên đăng nhập" required
                                   value="${param.tendangnhap}">
                        </div>

                        <div class="mb-3">
                            <label for="matkhau" class="form-label">Mật khẩu:</label>
                            <input type="password" class="form-control" id="matkhau" name="matkhau"
                                   placeholder="Nhập mật khẩu" required>
                        </div>

                        <div class="mb-3">
                            <label for="nhaplaimatkhau" class="form-label">Nhập lại mật khẩu:</label>
                            <input type="password" class="form-control" id="nhaplaimatkhau" name="nhaplaimatkhau"
                                   placeholder="Nhập lại mật khẩu" required>
                        </div>

                        <div class="d-grid">
                            <button type="submit" class="btn btn-primary">Đăng ký</button>
                        </div>

                    </form>

                    <div class="text-center mt-3">
                        <p>Đã có tài khoản?
                            <a href="${pageContext.request.contextPath}/system/login">Đăng nhập</a>
                        </p>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<script>
    // Focus tự động vào ô bị lỗi
    const focusField = '<c:out value="${focusField}" />';
    if (focusField) {
        document.getElementById(focusField)?.focus();
    }
</script>

</body>
</html>
