<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"/>
    <style>
        body {
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            background: url('https://images.unsplash.com/photo-1542435503-956c469947f6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1974&q=80') 
                        no-repeat center center fixed;
            background-size: cover;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        .login-card {
            background: #FFFFFF;
            padding: 40px 30px;
            border-radius: 20px;
            box-shadow: 0 15px 50px rgba(0, 0, 0, 0.2);
            width: 380px;
            color: #555555;
        }

        .login-card h2 {
            text-align: center;
            margin-bottom: 25px;
            font-weight: bold;
            color: #333333;
        }

        .alert {
            text-align: center;
            font-size: 0.95rem;
            margin-bottom: 15px;
        }

        .form-control {
            border-radius: 10px;
            background: #F8F8F8;
            border: 1px solid #E0E0E0;
            color: #333333;
            transition: background 0.3s;
            height: 48px;
        }

        .form-control:focus {
            background: #FFFFFF;
            box-shadow: 0 0 0 0.25rem rgba(155, 89, 182, 0.25);
            border-color: #9B59B6;
        }

        .input-group-text, .toggle-password {
            background: #F8F8F8;
            border: 1px solid #E0E0E0;
            color: #8E44AD;
        }

        .input-group-text {
            border-right: none;
            border-radius: 10px 0 0 10px;
        }

        .toggle-password {
            cursor: pointer;
            padding: .375rem .75rem;
            border-left: none;
            border-radius: 0 10px 10px 0;
            display: flex;
            align-items: center;
        }

        .btn-login {
            width: 100%;
            padding: 12px;
            border-radius: 10px;
            border: none;
            background: linear-gradient(90deg, #a55eea, #ff79c6);
            font-weight: bold;
            color: #fff;
            font-size: 1.1rem;
            box-shadow: 0 5px 15px rgba(165, 94, 234, 0.4);
            transition: all 0.3s ease;
        }

        .btn-login:hover {
            background: linear-gradient(90deg, #ff79c6, #a55eea);
            box-shadow: 0 5px 20px rgba(255, 121, 198, 0.6);
            transform: translateY(-1px);
        }

        .forgot-link, .register-link a {
            color: #8E44AD;
            font-weight: bold;
            text-decoration: none;
            transition: color 0.3s;
        }

        .forgot-link:hover, .register-link a:hover {
            color: #a55eea;
        }

        .register-link {
            text-align: center;
            display: block;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="login-card">
        <h2>Login</h2>

        <!-- Hiển thị thông báo lỗi từ backend -->
        <c:if test="${alert != null}">
            <div class="alert alert-danger">${alert}</div>
        </c:if>

        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="mb-3 input-group">
                <span class="input-group-text"><i class="fa-solid fa-user"></i></span>
                <input type="text" class="form-control" name="tendangnhap" placeholder="TenDangNhap" required>
            </div>

            <div class="mb-3 input-group">
                <span class="input-group-text"><i class="fa-solid fa-lock"></i></span>
                <input type="password" class="form-control" name="matkhau" id="passwordInput" placeholder="MatKhau" required>
                <span class="toggle-password" id="togglePassword">
                    <i class="fa-solid fa-eye"></i>
                </span>
            </div>

            <div class="mb-3 d-flex justify-content-between align-items-center">
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="rememberMe">
                    <label class="form-check-label" for="rememberMe">Remember me</label>
                </div>
                <a href="${pageContext.request.contextPath}/forgotpassword" class="forgot-link">Forgot Password?</a>
            </div>

            <button type="submit" class="btn btn-login">Login</button>
        </form>

        <span class="register-link">
            Don't have an account? 
            <a href="${pageContext.request.contextPath}/khachhang/register">Register</a>
        </span>
    </div>
    <script>
        const togglePassword = document.getElementById('togglePassword');
        const passwordInput = document.getElementById('passwordInput');
        togglePassword.addEventListener('click', function () {
            const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
            passwordInput.setAttribute('type', type);
            const icon = this.querySelector('i');
            icon.classList.toggle('fa-eye');
            icon.classList.toggle('fa-eye-slash');
        });
    </script>
</body>
</html>
