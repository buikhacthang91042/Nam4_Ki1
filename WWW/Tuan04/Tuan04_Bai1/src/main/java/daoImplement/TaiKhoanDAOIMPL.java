package daoImplement;

import java.util.List;

import dao.TaiKhoanDAO;
import entities.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TaiKhoanDAOIMPL implements TaiKhoanDAO{
	private EntityManager entityManager;
	public TaiKhoanDAOIMPL(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public TaiKhoan save(TaiKhoan tk) {
		// TODO Auto-generated method stub
		EntityTransaction trans = null;
		try {
			trans = entityManager.getTransaction();
			trans.begin();
			entityManager.persist(tk);
			trans.commit();
			return tk;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<TaiKhoan> findAll() {
		// TODO Auto-generated method stub
		try {
			return entityManager.createQuery("FROM TaiKhoan").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
}
