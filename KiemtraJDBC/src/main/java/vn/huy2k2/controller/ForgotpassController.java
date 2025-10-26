package vn.huy2k2.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.huy2k2.service.ImplService.*;
import vn.huy2k2.service.*;

@WebServlet(urlPatterns = {"/forgotpassword"})
public class ForgotpassController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private TaiKhoanService tksv = new TaiKhoanServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String alertMsg = "";

		if (email == null || email.trim().isEmpty()) {
			alertMsg = "Bạn vui lòng nhập email!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
			return;
		}

		boolean result = tksv.resetPassword(email);
		if (result) {
			alertMsg = "Mật khẩu mới đã được gửi đến email của bạn!";
		} else {
			alertMsg = "Email không tồn tại trong hệ thống!";
		}

		req.setAttribute("alert", alertMsg);
		req.getRequestDispatcher("/views/forgotpassword.jsp").forward(req, resp);
	}

}
