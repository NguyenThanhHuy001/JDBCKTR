<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm loại sách</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container py-4">

    <h2 class="mb-4">➕ Thêm loại sách mới</h2>

    <form method="post"
          action="${pageContext.request.contextPath}/admin/loaisach?action=insert"
          enctype="multipart/form-data"
          class="border p-4 rounded shadow-sm bg-light">

        <div class="mb-3">
            <label class="form-label">Tên loại:</label>
            <input type="text" name="tenLoai" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Mô tả:</label>
            <textarea name="moTa" class="form-control" rows="3"></textarea>
        </div>

        <div class="mb-3">
            <label class="form-label">Ảnh:</label>
            <input type="file" name="image" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Trạng thái:</label>
            <select name="status" class="form-select">
                <option value="1" selected>Hoạt động</option>
                <option value="0">Ngừng</option>
            </select>
        </div>

        <button type="submit" class="btn btn-success">💾 Lưu</button>
        <a href="${pageContext.request.contextPath}/admin/loaisach" class="btn btn-secondary">⬅️ Quay lại</a>
    </form>

</body>
</html>
