package enitties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class NhanVien {
	@Id
	private String maNhanVien;
	
	private String tenNhanVien;
	private int tuoi;
	private String sDT;
	private String diaChi;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maPhongBan", nullable = false)
	private PhongBan phongBan;

	
	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public String getsDT() {
		return sDT;
	}

	public void setsDT(String sDT) {
		this.sDT = sDT;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	

	public NhanVien(String maNhanVien, String tenNhanVien, int tuoi, String sDT, String diaChi, PhongBan phongBan) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.tuoi = tuoi;
		this.sDT = sDT;
		this.diaChi = diaChi;
		this.phongBan = phongBan;
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
