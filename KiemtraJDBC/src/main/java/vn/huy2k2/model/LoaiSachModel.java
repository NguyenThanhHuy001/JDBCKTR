package vn.huy2k2.model;

import java.io.Serializable;

public class LoaiSachModel implements  Serializable {
	private static final long serialVersionUID = 1L;
	
	private int MaLoai;
	private String TenLoai;
	private String MoTa;
	private String Image;
	private int Status;
	public LoaiSachModel(int maLoai, String tenLoai, String moTa, String image, int status) {
		super();
		MaLoai = maLoai;
		TenLoai = tenLoai;
		MoTa = moTa;
		Image = image;
		Status = status;
	}
	public LoaiSachModel() {
		super();
	}
	public int getMaLoai() {
		return MaLoai;
	}
	public void setMaLoai(int maLoai) {
		MaLoai = maLoai;
	}
	public String getTenLoai() {
		return TenLoai;
	}
	public void setTenLoai(String tenLoai) {
		TenLoai = tenLoai;
	}
	public String getMoTa() {
		return MoTa;
	}
	public void setMoTa(String moTa) {
		MoTa = moTa;
	}
	public String getImage() {
		return Image;
	}
	public void setImage(String image) {
		Image = image;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	@Override
	public String toString() {
		return "LoaiSachModel [MaLoai=" + MaLoai + ", TenLoai=" + TenLoai + ", MoTa=" + MoTa + ", Image=" + Image
				+ ", Status=" + Status + "]";
	}
	
	
	

}
