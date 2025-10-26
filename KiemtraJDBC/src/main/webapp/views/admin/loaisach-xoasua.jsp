<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${loaiSach != null ? 'Sửa loại sách' : 'Thêm loại sách'}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container py-4">
    <h2>${loaiSach != null ? '✏️ Sửa loại sách' : '➕ Thêm loại sách'}</h2>

    <form method="post" action="${pageContext.request.contextPath}/loaisach" enctype="multipart/form-data" class="mt-4">

        <input type="hidden" name="maLoai" value="${loaiSach.maLoai}">

        <div class="mb-3">
            <label class="form-label">Tên loại:</label>
            <input type="text" name="tenLoai" class="form-control" value="${loaiSach.tenLoai}" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Mô tả:</label>
            <textarea name="moTa" class="form-control" rows="3">${loaiSach.moTa}</textarea>
        </div>

        <div class="mb-3">
            <label class="form-label">Ảnh:</label>
            <input type="file" name="image" class="form-control">
            <c:if test="${not empty loaiSach.image}">
                <img src="${pageContext.request.contextPath}/uploads/${loaiSach.image}" width="100" class="mt-2 rounded shadow">
            </c:if>
        </div>

        <div class="mb-3">
            <label class="form-label">Trạng thái:</label>
            <select name="status" class="form-select">
                <option value="1" ${loaiSach.status == 1 ? 'selected' : ''}>Hoạt động</option>
                <option value="0" ${loaiSach.status == 0 ? 'selected' : ''}>Ngừng</option>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">💾 Lưu</button>
        <a href="${pageContext.request.contextPath}/system/sloaisach" class="btn btn-secondary">⬅️ Quay lại</a>
    </form>
</body>
</html>
