package daoImplement;

import java.util.List;
import dao.ProductDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import model.Product;

public class ProductDAOIMPL implements ProductDAO {
    private EntityManager entityManager;

    public ProductDAOIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Product> findAll() {
        
        Query query = entityManager.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }

    @Override
    public Product getById(int id) {
        // Tìm sản phẩm theo ID
        return entityManager.find(Product.class, id);
    }

    @Override
    public void addProduct(Product p) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(p); 
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
