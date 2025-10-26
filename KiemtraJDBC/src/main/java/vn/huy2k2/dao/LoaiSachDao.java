package vn.huy2k2.dao;

import java.util.List;

import vn.huy2k2.model.LoaiSachModel;

public interface LoaiSachDao {
	List<LoaiSachModel> findAll();
    LoaiSachModel findById(int id);
    List<LoaiSachModel> searchByTenLoai(String keyword);
    void insert(LoaiSachModel loaiSach);
    void update(LoaiSachModel loaiSach);
    void delete(int id);

}
