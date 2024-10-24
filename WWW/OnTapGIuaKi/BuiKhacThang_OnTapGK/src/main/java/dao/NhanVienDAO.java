package dao;

import java.util.List;

import enitties.NhanVien;

public interface NhanVienDAO {
	public List<NhanVien> findAll();
	public List<NhanVien> hienThiDSNhanVienTheoPhongBan(String maPhongBan);
	public void themNhanVienMoi(NhanVien nv);
	public void xoaNhanVien(String maNhanVien);
}
