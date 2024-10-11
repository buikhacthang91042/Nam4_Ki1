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
	
}
