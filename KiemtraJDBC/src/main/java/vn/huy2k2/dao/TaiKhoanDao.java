package vn.huy2k2.dao;

import vn.huy2k2.model.TaiKhoanModel;

public interface TaiKhoanDao {
	
	TaiKhoanModel FindTaiKhoanDao(String tendangnhap);
	//register
	public void insert(TaiKhoanModel taikhoan);
	boolean checkExistEmail(String email);
	boolean checkExistTenDangNhap(String tendangnhap);
	// Update pass
	TaiKhoanModel findByEmail(String email);
	public void updatePasswordByEmail(String email, String newMatKhau);

}
