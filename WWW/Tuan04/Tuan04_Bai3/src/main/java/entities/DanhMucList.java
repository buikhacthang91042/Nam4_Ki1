package entities;

import java.util.ArrayList;
import java.util.List;

public class DanhMucList {
	private static final List<DanhMuc> ds = new ArrayList<DanhMuc>();
	static {
		initData();
	}
	public static List<DanhMuc> queryProducts(){
		System.out.println(ds);
		return ds;
	}
	private static void initData() {
		DanhMuc dm = new DanhMuc();
		dm.setTenDanhMuc("Thế giới");
		dm.setGhiChu("Tình hình thế giới");
		dm.setNguoiQuanLy("Thang");
		ds.add(dm);
		
		
	}
}
