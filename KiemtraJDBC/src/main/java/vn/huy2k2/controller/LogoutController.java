package vn.huy2k2.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/logout")
public class LogoutController extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. Xóa session
		HttpSession session = request.getSession(false); // không tạo mới nếu chưa có
		if (session != null) {
			session.invalidate();
		}

		// 2. Xóa cookie (ví dụ cookie lưu login)
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("tendangnhap".equals(cookie.getName()) || "matkhau".equals(cookie.getName())) {
					cookie.setValue(""); // xóa giá trị
					cookie.setPath("/"); // cần set path
					cookie.setMaxAge(0); // xóa cookie
					response.addCookie(cookie);
				}
			}
		}

		// 3. Redirect về trang login
		response.sendRedirect(request.getContextPath() + "/login");
	}

	// Optional: nếu dùng POST
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
