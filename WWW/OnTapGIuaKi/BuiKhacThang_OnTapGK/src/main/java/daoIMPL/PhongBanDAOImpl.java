package daoIMPL;

import java.util.List;

import dao.PhongBanDAO;
import enitties.PhongBan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class PhongBanDAOImpl implements PhongBanDAO{
	private EntityManager em;

	public PhongBanDAOImpl(EntityManager em) {
		super();
		// TODO Auto-generated constructor stub
		this.em =em;
	}

	@Override
	public List<PhongBan> findAll() {
		// TODO Auto-generated method stub
		String query = "select * from phongban";
		return em.createNativeQuery(query,PhongBan.class).getResultList();
	}
	
}
