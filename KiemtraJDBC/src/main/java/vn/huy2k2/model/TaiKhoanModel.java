package vn.huy2k2.model;

import java.io.Serializable;
import java.sql.Date;

public class TaiKhoanModel implements  Serializable{
	private static final long serialVersionUID = 1L;
	
	private int MaTK;
	private String TenDangNhap;
	private String MatKhau;
	private int RoleID;
	private Date NgayTao;
	private int Status;
	private String Email;
	public int getMaTK() {
		return MaTK;
	}
	public void setMaTK(int maTK) {
		MaTK = maTK;
	}
	public String getTenDangNhap() {
		return TenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public int getRoleID() {
		return RoleID;
	}
	public void setRoleID(int roleID) {
		RoleID = roleID;
	}
	public Date getNgayTao() {
		return NgayTao;
	}
	public void setNgayTao(Date ngayTao) {
		NgayTao = ngayTao;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public TaiKhoanModel(int maTK, String tenDangNhap, String matKhau, int roleID, Date ngayTao, int status,
			String email) {
		super();
		MaTK = maTK;
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
		RoleID = roleID;
		NgayTao = ngayTao;
		Status = status;
		Email = email;
	}
	public TaiKhoanModel() {
		super();
	}
	@Override
	public String toString() {
		return "TaiKhoanModel [MaTK=" + MaTK + ", TenDangNhap=" + TenDangNhap + ", MatKhau=" + MatKhau + ", RoleID="
				+ RoleID + ", NgayTao=" + NgayTao + ", Status=" + Status + ", Email=" + Email + "]";
	}
	
	
}
