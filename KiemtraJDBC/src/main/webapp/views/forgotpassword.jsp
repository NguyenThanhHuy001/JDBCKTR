<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
}

.forgot-container {
	width: 400px;
	margin: 50px auto;
	background: #fff;
	padding: 30px 40px;
	border-radius: 10px;
	box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
}

.forgot-container h2 {
	text-align: center;
	margin-bottom: 25px;
	color: #333;
}

.forgot-container label {
	font-weight: bold;
	margin-top: 10px;
	display: block;
}

.forgot-container input {
	width: 100%;
	padding: 10px;
	margin-top: 5px;
	border-radius: 5px;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

.forgot-container button {
	width: 100%;
	padding: 12px;
	margin-top: 20px;
	border: none;
	border-radius: 5px;
	background-color: #2196F3;
	color: white;
	font-size: 16px;
	cursor: pointer;
}

.forgot-container button:hover {
	background-color: #1976D2;
}

.alert {
	color: red;
	text-align: center;
	margin-bottom: 15px;
}

.success {
	color: green;
	text-align: center;
	margin-bottom: 15px;
}
</style>
</head>
<body>
	<div class="forgot-container">
		<h2>Quên mật khẩu</h2>

		<!-- Hiển thị thông báo -->
		<c:if test="${not empty alert}">
			<div class="${alertType == 'error' ? 'alert' : 'success'}">${alert}</div>
		</c:if>

		<form action="${pageContext.request.contextPath}/forgotpassword"
			method="post">
			<label for="email">Nhập email đăng ký</label> <input type="text"
				name="email" placeholder="email" id="email">

			<button type="submit">Gửi mật khẩu mới</button>
		</form>
	</div>
</body>
</html>
