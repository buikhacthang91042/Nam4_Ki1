package dao;

import java.util.List;

import entities.NhaCungCap;

public interface NhaCCDAO {
	public List<NhaCungCap> findAll();
	public void addNCC (NhaCungCap ncc);
}
