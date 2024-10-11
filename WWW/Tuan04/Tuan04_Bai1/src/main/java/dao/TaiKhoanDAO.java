package dao;

import java.util.List;

import entities.TaiKhoan;

public interface TaiKhoanDAO {
	public TaiKhoan save (TaiKhoan tk);
	public List<TaiKhoan> findAll();
}
