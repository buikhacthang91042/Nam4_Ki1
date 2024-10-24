package enitties;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class PhongBan {
	
	@Id
	private String maPhongBan;
	
	private String tenPhongBan;
	private String sDT;
	
	@OneToMany(mappedBy = "phongBan", fetch = FetchType.LAZY)
	private List<NhanVien> nhanViens;

	public String getMaPhongBan() {
		return maPhongBan;
	}

	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}

	public String getTenPhongBan() {
		return tenPhongBan;
	}

	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}

	public String getsDT() {
		return sDT;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public List<NhanVien> getNhanViens() {
		return nhanViens;
	}

	public void setNhanViens(List<NhanVien> nhanViens) {
		this.nhanViens = nhanViens;
	}

	public PhongBan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongBan(String maPhongBan, String tenPhongBan, String sDT, List<NhanVien> nhanViens) {
		super();
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		this.sDT = sDT;
		this.nhanViens = nhanViens;
	}
	
	
}
