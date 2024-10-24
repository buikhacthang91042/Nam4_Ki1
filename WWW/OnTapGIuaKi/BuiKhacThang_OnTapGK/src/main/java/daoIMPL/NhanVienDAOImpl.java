package daoIMPL;

import java.util.List;

import dao.NhanVienDAO;
import enitties.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class NhanVienDAOImpl implements NhanVienDAO{
	private EntityManager em;
	public NhanVienDAOImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<NhanVien> hienThiDSNhanVienTheoPhongBan(String maPhongBan) {
		// TODO Auto-generated method stub
		String query = "select * from nhanvien where maPhongBan = ?";
		return em.createNativeQuery(query,NhanVien.class).setParameter(1, maPhongBan).getResultList();
	}

	@Override
	public void themNhanVienMoi(NhanVien nv) {
		// TODO Auto-generated method stub
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(nv);
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void xoaNhanVien(String maNhanVien) {
		// TODO Auto-generated method stub
				EntityTransaction trans = em.getTransaction();
				try {
					trans.begin();
					NhanVien nv = em.find(NhanVien.class, maNhanVien);
					em.remove(nv);
					trans.commit();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					trans.rollback();
				}
	}

	@Override
	public List<NhanVien> findAll() {
		// TODO Auto-generated method stub
		String query = "select * from nhanvien";
		return em.createNativeQuery(query, NhanVien.class).getResultList();
	}
	
}
