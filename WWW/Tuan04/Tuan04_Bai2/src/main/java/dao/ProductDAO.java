package dao;

import java.util.List;

import model.Product;

public interface ProductDAO {
	public List<Product> findAll();
	public Product getById(int id);
	public void addProduct(Product p);

}