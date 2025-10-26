<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kết quả tìm kiếm loại sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container py-4">

    <h2 class="mb-4">🔍 Kết quả tìm kiếm</h2>

    <form method="get" action="${pageContext.request.contextPath}/system/loaisach" class="d-flex mb-3">
        <input type="hidden" name="action" value="search">
        <input type="text" name="keyword" class="form-control me-2" placeholder="Nhập tên loại sách..." value="${param.keyword}">
        <button type="submit" class="btn btn-primary">Tìm lại</button>
    </form>

    <a href="${pageContext.request.contextPath}/system/loaisach" class="btn btn-secondary mb-3">⬅️ Quay lại danh sách</a>

    <table class="table table-bordered table-striped align-middle">
        <thead class="table-dark text-center">
            <tr>
                <th>Mã loại</th>
                <th>Tên loại</th>
                <th>Mô tả</th>
                <th>Ảnh</th>
                <th>Trạng thái</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="item" items="${searchResult}">
                <tr class="text-center">
                    <td>${item.maLoai}</td>
                    <td>${item.tenLoai}</td>
                    <td>${item.moTa}</td>
                    <td>
                        <c:if test="${not empty item.image}">
                            <img src="${pageContext.request.contextPath}/uploads/${item.image}" width="90" height="90">
                        </c:if>
                    </td>
                    <td>${item.status == 1 ? 'Hoạt động' : 'Ngừng'}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <c:if test="${empty searchResult}">
        <div class="alert alert-warning text-center mt-3">Không tìm thấy loại sách nào phù hợp.</div>
    </c:if>

</body>
</html>
