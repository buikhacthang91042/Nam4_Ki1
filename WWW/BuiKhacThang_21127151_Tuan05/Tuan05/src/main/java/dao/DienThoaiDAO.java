package dao;

import java.util.List;

import entities.DienThoai;

public interface DienThoaiDAO {
	public List<DienThoai> findAll();
	public void addDienThoai(DienThoai d);
	public void deleteDienThoai(int maDT);
}
