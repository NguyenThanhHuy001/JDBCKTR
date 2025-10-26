<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<%-- Lấy tiêu đề từ trang con --%>
<title>${title} | Trang Quản Trị</title>

<!-- Link Bootstrap CSS và Icons -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

<style>
    /* CSS Tùy Chỉnh để định hình Layout 2 cột */
    :root {
        --sidebar-width: 250px;
        --topbar-height: 60px;
    }
    
    /* Container chính: Bật Flexbox cho Layout 2 cột */
    #wrapper {
        display: flex; 
        min-height: 100vh;
    }

    /* Vẫn cần CSS cho Sidebar để định vị và kích thước */
    .sidebar {
        width: var(--sidebar-width);
        min-width: var(--sidebar-width);
        background-color: #212529;
        color: white;
        padding-top: var(--topbar-height);
        position: fixed; 
        height: 100vh;
        z-index: 1030; 
    }
    .sidebar-header {
        position: fixed;
        top: 0;
        left: 0;
        width: var(--sidebar-width);
        height: var(--topbar-height);
        background-color: #0d6efd; 
        display: flex;
        align-items: center;
        padding-left: 15px;
        z-index: 1031;
    }
    .sidebar-menu a {
        padding: 12px 20px;
        transition: background-color 0.2s;
        border-left: 4px solid transparent;
    }
    .sidebar-menu a:hover, 
    .sidebar-menu a.active {
        background-color: #343a40;
        border-left-color: #ffc107;
    }

    /* Content Wrapper */
    #content-wrapper {
        flex-grow: 1;
        margin-left: var(--sidebar-width); /* Đẩy nội dung qua khỏi sidebar */
        background-color: #f8f9fa;
    }
    
    /* Topbar */
    .topbar {
        height: var(--topbar-height);
        background-color: white; 
        border-bottom: 1px solid #dee2e6;
        padding: 0 15px;
        z-index: 1020;
    }

    /* Responsive cho Mobile */
    @media (max-width: 768px) {
        .sidebar { margin-left: calc(-1 * var(--sidebar-width)); }
        #content-wrapper { margin-left: 0 !important; }
        .sidebar.active { margin-left: 0; }
    }
</style>

${head} <%-- SiteMesh chèn nội dung <head> bổ sung --%>
</head>
<body>

<%-- Cấu trúc Layout 2 cột --%>
<div id="wrapper">
    
    <!-- 1. LEFT (SIDEBAR) -->
    <jsp:include page="/common/admin/Left.jsp" /> 

    <!-- 2. CONTENT WRAPPER (HEADER + BODY + FOOTER) -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- HEADER (Topbar chứa thông tin user) -->
        <jsp:include page="/common/admin/header.jsp" /> 

        <!-- MAIN CONTENT (Body của trang con) -->
        <main class="p-3 flex-grow-1">
            <sitemesh:write property="body"/>
        </main>
        
        <!-- FOOTER -->
        <jsp:include page="/common/admin/footer.jsp" />
        
    </div>

</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
    // Script xử lý mở/đóng Sidebar trên Mobile
    document.addEventListener('DOMContentLoaded', function() {
        const sidebarToggle = document.getElementById('sidebarToggle');
        const sidebarMenu = document.getElementById('sidebarMenu');
        
        if (sidebarToggle && sidebarMenu) {
             sidebarToggle.addEventListener('click', function() {
                sidebarMenu.classList.toggle('active');
            });
        }
    });
</script>
</body>
</html>
