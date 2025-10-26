package vn.huy2k2.controller.khachkhang;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.huy2k2.config.SendMail;
import vn.huy2k2.service.TaiKhoanService;
import vn.huy2k2.service.ImplService.TaiKhoanServiceImpl;

@WebServlet(urlPatterns = {"/khachhang/register"})
public class RegisterController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("tendangnhap") != null) {
            resp.sendRedirect(req.getContextPath() + "/khachhang");
            return;
        }

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("tendangnhap")) {
                    session = req.getSession(true);
                    session.setAttribute("tendangnhap", cookie.getValue());
                    resp.sendRedirect(req.getContextPath() + "/khachhang");
                    return;
                }
            }
        }

        req.getRequestDispatcher("/views/khachhang/register.jsp").forward(req, resp);
    }

    @SuppressWarnings("static-access")
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String tendangnhap = req.getParameter("tendangnhap");
        String matkhau = req.getParameter("matkhau");
        String email = req.getParameter("email");

        TaiKhoanService service = new TaiKhoanServiceImpl();
        String alertMsg = "";

        // Kiểm tra nhập Email
        if (email == null || email.trim().isEmpty()) {
            alertMsg = "Vui lòng nhập Email!";
            req.setAttribute("alert", alertMsg);
            req.setAttribute("focusField", "email");
            req.getRequestDispatcher("/views/khachhang/register.jsp").forward(req, resp);
            return;
        }

        // Kiểm tra email tồn tại
        if (service.checkExistEmailservice(email)) {
            alertMsg = "Email đã tồn tại, vui lòng nhập email khác!";
            req.setAttribute("alert", alertMsg);
            req.setAttribute("focusField", "email");
            req.getRequestDispatcher("/views/khachhang/register.jsp").forward(req, resp);
            return;
        }

        // Kiểm tra nhập Username
        if (tendangnhap == null || tendangnhap.trim().isEmpty()) {
            alertMsg = "Vui lòng nhập Tên đăng nhập!";
            req.setAttribute("alert", alertMsg);
            req.setAttribute("focusField", "tendangnhap");
            req.getRequestDispatcher("/views/khachhang/register.jsp").forward(req, resp);
            return;
        }

        // Kiểm tra nhập Mật khẩu
        if (matkhau == null || matkhau.trim().isEmpty()) {
            alertMsg = "Vui lòng nhập Mật khẩu!";
            req.setAttribute("alert", alertMsg);
            req.setAttribute("focusField", "matkhau");
            req.getRequestDispatcher("/views/khachhang/register.jsp").forward(req, resp);
            return;
        }

        // Đăng ký tài khoản
        boolean isSuccess = service.register(tendangnhap, matkhau, email);
        if (isSuccess) {
            try {
                SendMail.sendEmail(email, "Đăng ký tài khoản thành công",
                        "<h3>Xin chào " + tendangnhap + "!</h3>"
                        + "<p>Bạn đã đăng ký tài khoản thành công tại hệ thống của chúng tôi.</p>");
            } catch (Exception e) {
                e.printStackTrace();
            }

            HttpSession session = req.getSession();
            session.setAttribute("alert", "Đăng ký thành công! Vui lòng đăng nhập.");
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            alertMsg = "Đăng ký thất bại, vui lòng thử lại!";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/khachhang/register.jsp").forward(req, resp);
        }
    }
}
