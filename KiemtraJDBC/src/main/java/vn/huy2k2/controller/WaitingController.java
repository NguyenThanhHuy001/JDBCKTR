package vn.huy2k2.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.huy2k2.model.TaiKhoanModel;

@WebServlet(urlPatterns = "/waiting")
public class WaitingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			TaiKhoanModel u = (TaiKhoanModel) session.getAttribute("account");
			req.setAttribute("tendangnhap", u.getTenDangNhap());
			if (u.getRoleID() == 1) {
				resp.sendRedirect(req.getContextPath() + "/admin/home");
			} else if (u.getRoleID() == 2) {
				resp.sendRedirect(req.getContextPath() + "/nhanvien/home");
			} else if (u.getRoleID() == 3) {
				resp.sendRedirect(req.getContextPath() + "/khachhang/home");
			} else {
				resp.sendRedirect(req.getContextPath() + "/login");
			}
		}
	}
}
