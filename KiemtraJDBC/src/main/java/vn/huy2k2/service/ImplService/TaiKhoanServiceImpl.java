package vn.huy2k2.service.ImplService;

import vn.huy2k2.model.TaiKhoanModel;

import vn.huy2k2.service.TaiKhoanService;

import java.sql.Date;
import java.util.UUID;

import vn.huy2k2.config.SendMail;
import vn.huy2k2.dao.TaiKhoanDao;
import vn.huy2k2.dao.ImplDao.TaiKhoanDaoImpl;

public class TaiKhoanServiceImpl implements TaiKhoanService {
	TaiKhoanDao taikhoandao = new TaiKhoanDaoImpl();

	@Override
	public TaiKhoanModel loginservice(String tendangnhap, String matkhau) {
		TaiKhoanModel taikhoan = this.FindUserService(tendangnhap);
		if (taikhoan != null && matkhau.equals(taikhoan.getMatKhau())) {
			return taikhoan;
		}
		return null;
	}

	@Override
	public TaiKhoanModel FindUserService(String tendangnhap) {
		return taikhoandao.FindTaiKhoanDao(tendangnhap);
	}

	@Override
	public void insert(TaiKhoanModel taikhoan) {
		taikhoandao.insert(taikhoan);
	}

	@Override
	public boolean register(String tendangnhap, String matkhau, String email) {
		if (taikhoandao.checkExistTenDangNhap(tendangnhap)) {
			return false;
		}
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		taikhoandao.insert(new TaiKhoanModel(0, tendangnhap, matkhau, 3, date, 1, email));
		return true;

	}

	@Override
	public boolean checkExistEmailservice(String email) {
		return taikhoandao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistTenDangNhap(String tendangnhap) {
		return taikhoandao.checkExistTenDangNhap(tendangnhap);
	}

	@Override
	public boolean resetPassword(String email) {
		TaiKhoanModel tk = taikhoandao.findByEmail(email);
		if (tk == null) {
			return false;
		}

		// String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,}$";
		String newPassword = UUID.randomUUID().toString().substring(0, 8);

		// Update vào DB
		taikhoandao.updatePasswordByEmail(email, newPassword);

		// Gửi mail
		try {
			SendMail.sendEmail(email, "Reset mật khẩu", "Mật khẩu mới của bạn là: <b>" + newPassword + "</b>");
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
