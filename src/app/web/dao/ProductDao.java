package app.web.dao;

import java.util.List;

import app.config.model.Product;

public interface ProductDao {
	
	Product findById(Integer id);
	
	List<Product> findAll();
	
	void save(Product product);
	
	void update(Product product);
	
	void delete(Product product);

}
