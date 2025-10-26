<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách loại sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container py-4">

    <h2 class="mb-4 text-center">📚 Danh sách loại sách</h2>

    <!-- Form tìm kiếm -->
    <form class="d-flex mb-3" method="get" action="${pageContext.request.contextPath}/admin/loaisach">
        <input type="hidden" name="action" value="search">
        <input type="text" class="form-control me-2" name="keyword" placeholder="Nhập tên loại sách..." value="${param.keyword}">
        <button class="btn btn-primary" type="submit">🔍 Tìm kiếm</button>
    </form>

    <!-- Nút thêm -->
    <a href="${pageContext.request.contextPath}/admin/loaisach?action=new" class="btn btn-success mb-3">➕ Thêm loại sách</a>

    <!-- Bảng hiển thị -->
    <table class="table table-bordered table-striped align-middle">
        <thead class="table-dark text-center">
            <tr>
                <th>Mã loại</th>
                <th>Tên loại</th>
                <th>Mô tả</th>
                <th>Ảnh</th>
                <th>Trạng thái</th>
                <th>Hành động</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${list}">
                <tr class="text-center">
                    <td>${item.maLoai}</td>
                    <td>${item.tenLoai}</td>
                    <td>${item.moTa}</td>
                    <td>
                        <c:if test="${not empty item.image}">
                            <img src="${pageContext.request.contextPath}/uploads/${item.image}" width="90" height="90" class="rounded shadow">
                        </c:if>
                    </td>
                    <td>
                        <span class="badge ${item.status == 1 ? 'bg-success' : 'bg-secondary'}">
                            ${item.status == 1 ? 'Còn bán' : 'Ngừng bán'}
                        </span>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/loaisach?action=edit&id=${item.maLoai}" class="btn btn-warning btn-sm">✏️ Sửa</a>
                        <a href="${pageContext.request.contextPath}/admin/loaisach?action=delete&id=${item.maLoai}"
                           class="btn btn-danger btn-sm"
                           onclick="return confirm('Bạn có chắc muốn xóa loại sách này không?');">🗑️ Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Khi không có dữ liệu -->
    <c:if test="${empty list}">
        <div class="alert alert-info text-center mt-3">Không có loại sách nào!</div>
    </c:if>

</body>
</html>
