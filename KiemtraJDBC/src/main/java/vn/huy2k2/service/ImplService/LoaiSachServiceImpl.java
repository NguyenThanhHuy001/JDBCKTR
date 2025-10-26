package vn.huy2k2.service.ImplService;

import java.util.List;

import vn.huy2k2.dao.LoaiSachDao;
import vn.huy2k2.dao.ImplDao.LoaiSachDaoImpl;
import vn.huy2k2.model.LoaiSachModel;
import vn.huy2k2.service.LoaiSachService;

public class LoaiSachServiceImpl implements LoaiSachService{
	private LoaiSachDao dao = new LoaiSachDaoImpl();

	@Override
	public List<LoaiSachModel> findAll() {
		return dao.findAll();
	}

	@Override
	public LoaiSachModel findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<LoaiSachModel> searchByTenLoai(String keyword) {
		return dao.searchByTenLoai(keyword);
	}

	@Override
	public void insert(LoaiSachModel loaiSach) {
		dao.insert(loaiSach);

	}

	@Override
	public void update(LoaiSachModel loaiSach) {
		dao.update(loaiSach);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);

	}

}
