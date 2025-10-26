package vn.huy2k2.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.huy2k2.model.LoaiSachModel;
import vn.huy2k2.service.LoaiSachService;
import vn.huy2k2.service.ImplService.LoaiSachServiceImpl;

@WebServlet(urlPatterns = {"/admin/loaisach" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1MB bộ nhớ đệm
		maxFileSize = 1024 * 1024 * 5, // Tối đa 5MB mỗi file
		maxRequestSize = 1024 * 1024 * 10 // Tổng dung lượng tối đa 10MB
)
public class LoaiSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 LoaiSachService service = new LoaiSachServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");
		if (action == null)
			action = "list";

		switch (action) {
		case "new":
			req.getRequestDispatcher("/views/admin/loaisach-add.jsp").forward(req, resp);
			break;
		case "edit":
			int id = Integer.parseInt(req.getParameter("id"));
			req.setAttribute("loai", service.findById(id));
			req.getRequestDispatcher("/views/admin/loaisach-edit.jsp").forward(req, resp);
			break;
		case "delete":
			int maXoa = Integer.parseInt(req.getParameter("id"));
			service.delete(maXoa);
			resp.sendRedirect(req.getContextPath() + "/admin/loaisach");
			break;

		case "search":
			String keyword = req.getParameter("keyword");
			req.setAttribute("list", service.searchByTenLoai(keyword));
			req.getRequestDispatcher("/views/admin/loaisach-list.jsp").forward(req, resp);
			break;

		default:
			req.setAttribute("list", service.findAll());
			req.getRequestDispatcher("/views/admin/loaisach-list.jsp").forward(req, resp);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");

		String idStr = req.getParameter("id"); // dùng để biết là thêm hay sửa
		String tenLoai = req.getParameter("tenLoai");
		String moTa = req.getParameter("moTa");
		int status = Integer.parseInt(req.getParameter("status"));
		// Nhận file ảnh
		Part filePart = req.getPart("image");
		String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

		// Tạo thư mục lưu file nếu chưa có
		String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists())
			uploadDir.mkdir();

		// Lưu file
		if (!fileName.isEmpty()) {
			filePart.write(uploadPath + File.separator + fileName);
		}

		// Tạo model
		LoaiSachModel loaiSach = new LoaiSachModel();
		loaiSach.setTenLoai(tenLoai);
		loaiSach.setMoTa(moTa);
		loaiSach.setImage(fileName);
		loaiSach.setStatus(status);

		if (idStr == null || idStr.isEmpty()) {
			// Thêm mới
			service.insert(loaiSach);
		} else {
			// Cập nhật
			loaiSach.setMaLoai(Integer.parseInt(idStr));
			service.update(loaiSach);
		}
		// Sau khi xử lý xong -> quay về danh sách
		resp.sendRedirect(req.getContextPath() + "/admin/loaisach");
	}
}
