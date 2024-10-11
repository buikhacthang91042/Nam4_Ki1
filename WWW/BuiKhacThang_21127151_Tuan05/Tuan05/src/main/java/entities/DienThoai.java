package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "dienthoai")
public class DienThoai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long madt;

    @Column(name = "tendt", nullable = false)
    private String tenDienThoai;

    @Column(name = "namsanxuat")
    private Integer namSanXuat;

    @Column(name = "cauhinh")
    private String cauHinh;

    @ManyToOne
    @JoinColumn(name = "mancc", nullable = false)
    private NhaCungCap nhaCungCap;

    @Column(name = "hinhanh")
    private String hinhAnh;

    
	public DienThoai() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DienThoai [madt=" + madt + ", tenDienThoai=" + tenDienThoai + ", namSanXuat=" + namSanXuat
				+ ", cauHinh=" + cauHinh + ", nhaCungCap=" + nhaCungCap + ", hinhAnh=" + hinhAnh + "]";
	}

	public DienThoai(Long madt, String tenDienThoai, Integer namSanXuat, String cauHinh, NhaCungCap nhaCungCap,
			String hinhAnh) {
		super();
		this.madt = madt;
		this.tenDienThoai = tenDienThoai;
		this.namSanXuat = namSanXuat;
		this.cauHinh = cauHinh;
		this.nhaCungCap = nhaCungCap;
		this.hinhAnh = hinhAnh;
	}

	public Long getMadt() {
		return madt;
	}

	public void setMadt(Long madt) {
		this.madt = madt;
	}

	public String getTenDienThoai() {
		return tenDienThoai;
	}

	public void setTenDienThoai(String tenDienThoai) {
		this.tenDienThoai = tenDienThoai;
	}

	public Integer getNamSanXuat() {
		return namSanXuat;
	}

	public void setNamSanXuat(Integer namSanXuat) {
		this.namSanXuat = namSanXuat;
	}

	public String getCauHinh() {
		return cauHinh;
	}

	public void setCauHinh(String cauHinh) {
		this.cauHinh = cauHinh;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

    
}
