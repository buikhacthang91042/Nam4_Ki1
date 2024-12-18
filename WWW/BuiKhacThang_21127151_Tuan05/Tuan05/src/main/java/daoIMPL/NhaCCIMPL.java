package daoIMPL;

import java.util.List;

import dao.NhaCCDAO;

import entities.NhaCungCap;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class NhaCCIMPL implements NhaCCDAO {
	private EntityManager em;

	public NhaCCIMPL(EntityManager em) {
		this.em=em;
	}

	@Override
	public List<NhaCungCap> findAll() {
		// TODO Auto-generated method stub
		String query = "Select c from NhaCungCap c";
		List<NhaCungCap> result = em.createQuery(query, NhaCungCap.class).getResultList();
		return result;
	}

	@Override
	public void addNCC(NhaCungCap ncc) {
		// TODO Auto-generated method stub
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(ncc);
			trans.commit();
			System.out.println("Thêm thành cônng");
		} catch (Exception e) {
			if (trans.isActive()) {
				trans.rollback();
            }
            e.printStackTrace();
		}
	}
	
}
