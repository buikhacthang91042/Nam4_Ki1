package entities;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "nhacungcap")
public class NhaCungCap {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mancc;

    @Column(name = "tennhacc", nullable = false)
    private String tenNhaCungCap;

    @Column(name = "diachi")
    private String diaChi;

    @Column(name = "sodienthoai")
    private String soDienThoai;

    @OneToMany(mappedBy = "nhaCungCap", cascade = CascadeType.ALL)
    private List<DienThoai> dienThoais;

	public int getMancc() {
		return mancc;
	}

	public void setMancc(int mancc) {
		this.mancc = mancc;
	}

	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}

	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public List<DienThoai> getDienThoais() {
		return dienThoais;
	}

	public void setDienThoais(List<DienThoai> dienThoais) {
		this.dienThoais = dienThoais;
	}

	public NhaCungCap(int mancc, String tenNhaCungCap, String diaChi, String soDienThoai, List<DienThoai> dienThoais) {
		super();
		this.mancc = mancc;
		this.tenNhaCungCap = tenNhaCungCap;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.dienThoais = dienThoais;
	}

	public NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}



    
}