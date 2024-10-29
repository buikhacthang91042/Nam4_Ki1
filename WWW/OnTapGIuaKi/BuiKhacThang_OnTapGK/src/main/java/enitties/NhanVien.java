package enitties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class NhanVien {
	@Id
	@NotEmpty(message = "Mã nhân viên không được để trống")
	private String maNhanVien;
	
	@NotEmpty(message = "Tên nhân viên không được để trống")
	@Size(max = 50 ,message = "Không được nhập quá 50 kí tự")
	private String tenNhanVien;
	@Min(value = 18, message = "Tuổi phải lớn hơn 18")
	private int tuoi;
	@NotEmpty(message = "Số điện thoại nhân viên không được để trống")
	private String sDT;
	
	@NotEmpty(message = "Địa chỉ nhân viên không được để trống")
	@Pattern(regexp = "^[a-zA-Z0-9!#$&-+.]+@(gmail.com| yahoo.com| outlook.com)",message = "Địa chỉ phải đúng định dạng")
	private String diaChi;
	
	@NotNull(message = "Phòng ban không được để trống")
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
