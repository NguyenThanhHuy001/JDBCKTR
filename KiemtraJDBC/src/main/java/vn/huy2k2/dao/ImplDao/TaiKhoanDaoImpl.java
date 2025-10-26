package vn.huy2k2.dao.ImplDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.huy2k2.config.ConnectSQL;
import vn.huy2k2.dao.TaiKhoanDao;
import vn.huy2k2.model.TaiKhoanModel;

public class TaiKhoanDaoImpl implements TaiKhoanDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public TaiKhoanModel FindTaiKhoanDao(String tendangnhap) {
		String sql = "SELECT * FROM [TAIKHOAN] WHERE TenDangNhap = ? ";
		try {
			conn = new ConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tendangnhap);
			rs = ps.executeQuery();
			while (rs.next()) {
				TaiKhoanModel taikhoan = new TaiKhoanModel();
				taikhoan.setMaTK(rs.getInt("matk"));
				taikhoan.setTenDangNhap(rs.getString("tendangnhap"));
				taikhoan.setMatKhau(rs.getString("matkhau"));
				taikhoan.setRoleID(Integer.parseInt(rs.getString("roleid")));
				taikhoan.setNgayTao(rs.getDate("ngaytao"));
				taikhoan.setStatus(Integer.parseInt(rs.getString("status")));
				taikhoan.setEmail(rs.getString("email"));
				return taikhoan;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(TaiKhoanModel taikhoan) {
		String sql = "INSERT INTO [TAIKHOAN](tendangnhap,matkhau,roleid,email) VALUES (?,?,?,?)";
		try {
			conn = new ConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, taikhoan.getTenDangNhap());
			ps.setString(2, taikhoan.getMatKhau());
			ps.setInt(3, taikhoan.getRoleID());
			ps.setString(4, taikhoan.getEmail());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public boolean checkExistEmail(String email) {
		boolean check = false;
		String query = "SELECT * FROM [TAIKHOAN] WHERE LOWER(Email) = LOWER(?)";
		try (Connection conn = new ConnectSQL().getConnection(); PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setString(1, email);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					check = true;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace(); // log lỗi ra để debug
		}
		return check;
	}
	@Override
	public boolean checkExistTenDangNhap(String tendangnhap) {
		boolean check = false;
		String query = "select * from [TAIKHOAN] where TenDangNhap = ?";
		try {
			conn = new ConnectSQL().getConnection();
			ps = conn.prepareStatement(query);
			ps.setString(1, tendangnhap);
			rs = ps.executeQuery();
			if (rs.next()) {
				check = true;
			}
			ps.close();
			conn.close();
		} catch (Exception ex) {
		}
		return check;
	}

	@Override
	public TaiKhoanModel findByEmail(String email) {
		String sql = "SELECT * FROM [TAIKHOAN] WHERE Email = ? ";
		try (Connection conn = new ConnectSQL().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, email);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					TaiKhoanModel taikhoan = new TaiKhoanModel();
					taikhoan.setMaTK(rs.getInt("matk"));
					taikhoan.setEmail(rs.getString("email"));
					taikhoan.setTenDangNhap(rs.getString("tendangnhap"));
					taikhoan.setMatKhau(rs.getString("matkhau"));
					taikhoan.setRoleID(rs.getInt("roleid"));
					taikhoan.setNgayTao(rs.getDate("ngaytao"));
					taikhoan.setStatus(rs.getInt("status"));
					return taikhoan;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updatePasswordByEmail(String email, String newMatKhau) {
		String sql = "UPDATE TAIKHOAN SET MatKhau=? WHERE Email=?";
		try (Connection conn = new ConnectSQL().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, newMatKhau); // password mới
			ps.setString(2, email); // email cần cập nhật
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
