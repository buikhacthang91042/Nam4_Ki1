package daoIMPL;

import java.util.ArrayList;
import java.util.List;

import dao.DienThoaiDAO;
import entities.DienThoai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transaction;

public class DienThoaiDAOIMPL implements DienThoaiDAO {
	private EntityManager em;
	
	public DienThoaiDAOIMPL(EntityManager em) {
		this.em=em;
	}

	@Override
	public List<DienThoai> findAll() {
		String query ="Select d from DienThoai d";
		return em.createQuery(query).getResultList();
	
	}

	@Override
	public void addDienThoai(DienThoai d) {
		// TODO Auto-generated method stub
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(d);
			
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void deleteDienThoai(int maDT) {
		// TODO Auto-generated method stub
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			DienThoai dt = em.find(DienThoai.class, maDT);
			em.remove(dt);
			trans.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
