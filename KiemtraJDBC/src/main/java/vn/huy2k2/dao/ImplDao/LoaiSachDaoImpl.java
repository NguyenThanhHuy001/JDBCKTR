package vn.huy2k2.dao.ImplDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vn.huy2k2.dao.LoaiSachDao;
import vn.huy2k2.model.LoaiSachModel;
import vn.huy2k2.config.ConnectSQL;

public class LoaiSachDaoImpl implements LoaiSachDao {

	@Override
	public List<LoaiSachModel> findAll() {
		List<LoaiSachModel> list = new ArrayList<>();
		String sql = "SELECT MaLoai, TenLoai, MoTa, Image, Status FROM LOAISACH";
		try (Connection conn = new ConnectSQL().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				list.add(new LoaiSachModel(rs.getInt("MaLoai"), rs.getString("TenLoai"), rs.getString("MoTa"),
						rs.getString("Image"), rs.getInt("Status")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public LoaiSachModel findById(int id) {
		String sql = "SELECT MaLoai, TenLoai, MoTa, Image, Status FROM LOAISACH WHERE MaLoai = ?";
		try (Connection conn = new ConnectSQL().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new LoaiSachModel(rs.getInt("MaLoai"), rs.getString("TenLoai"), rs.getString("MoTa"),
						rs.getString("Image"), rs.getInt("Status"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<LoaiSachModel> searchByTenLoai(String keyword) {
		List<LoaiSachModel> list = new ArrayList<>();
		String sql = "SELECT MaLoai, TenLoai, MoTa, Image, Status FROM LOAISACH WHERE TenLoai LIKE ?";
		try (Connection conn = new ConnectSQL().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new LoaiSachModel(rs.getInt("MaLoai"), rs.getString("TenLoai"), rs.getString("MoTa"),
						rs.getString("Image"), rs.getInt("Status")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
	}

	@Override
	public void insert(LoaiSachModel loaiSach) {
		String sql = "INSERT INTO LOAISACH (TenLoai, MoTa, Image, Status) VALUES (?, ?, ?, ?)";
		try (Connection conn = new ConnectSQL().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, loaiSach.getTenLoai());
			ps.setString(2, loaiSach.getMoTa());
			ps.setString(3, loaiSach.getImage());
			ps.setInt(4, loaiSach.getStatus());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(LoaiSachModel loaiSach) {
		String sql = "UPDATE LOAISACH SET TenLoai=?, MoTa=?, Image=?, Status=? WHERE MaLoai=?";
		try (Connection conn = new ConnectSQL().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, loaiSach.getTenLoai());
			ps.setString(2, loaiSach.getMoTa());
			ps.setString(3, loaiSach.getImage());
			ps.setInt(4, loaiSach.getStatus());
			ps.setInt(5, loaiSach.getMaLoai());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM LOAISACH WHERE MaLoai=?";
		try (Connection conn = new ConnectSQL().getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
