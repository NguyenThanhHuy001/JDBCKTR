package vn.huy2k2.service;

import java.util.List;

import vn.huy2k2.model.LoaiSachModel;

public interface LoaiSachService {
	List<LoaiSachModel> findAll();
    LoaiSachModel findById(int id);
    List<LoaiSachModel> searchByTenLoai(String keyword);
    void insert(LoaiSachModel loaiSach);
    void update(LoaiSachModel loaiSach);
    void delete(int id);


}
