package vn.huy2k2.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.huy2k2.model.TaiKhoanModel;
import vn.huy2k2.service.TaiKhoanService;
import vn.huy2k2.service.ImplService.TaiKhoanServiceImpl;

@WebServlet(urlPatterns = {"/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
		}
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("tendangnhap")) {
					session = req.getSession(true);
					session.setAttribute("tendangnhap", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/waiting");
					return;
				}
			}
		}
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String tendangnhap = req.getParameter("tendangnhap");
		String matkhau = req.getParameter("matkhau");
		//boolean isRememberMe = false;
		//String remember = req.getParameter("remember");
		//if ("on".equals(remember)) {
			//isRememberMe = true;
		//}
		String alertMsg = "";
		if (tendangnhap.isEmpty() || matkhau.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
			return;
		}
		TaiKhoanService service = new TaiKhoanServiceImpl();
		TaiKhoanModel tk = service.loginservice(tendangnhap,matkhau);
		if (tk != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("account", tk);
			resp.sendRedirect(req.getContextPath() + "/waiting");
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
		}
	}

}
