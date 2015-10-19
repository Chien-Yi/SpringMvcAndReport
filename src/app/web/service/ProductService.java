package app.web.service;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import app.config.model.Product;

public interface ProductService {
	
	Product findById(Integer id);
	
	List<Product> findAll();
	
	void saveOrUpdate(Product product);
	
	void delete(int id);
	
	public DefaultTableModel getModel();

}
