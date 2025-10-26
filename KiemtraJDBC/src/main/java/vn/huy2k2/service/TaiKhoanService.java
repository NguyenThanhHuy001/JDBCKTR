package vn.huy2k2.service;

import vn.huy2k2.model.TaiKhoanModel;

public interface TaiKhoanService {
	TaiKhoanModel loginservice(String tendangnhap, String matkhau);
	TaiKhoanModel FindUserService(String tendangnhap);
	// Register
	public void insert(TaiKhoanModel taikhoan);
	boolean register( String tendangnhap,String matkhau, String email);
	boolean checkExistEmailservice(String email);
	boolean checkExistTenDangNhap(String tendangnhap);
	// Updatepass(Quên MK)
	 boolean resetPassword(String email);

}
