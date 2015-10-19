package app.web.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import app.config.model.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//@Autowired
	//private SessionFactory sessionFactory;

	private final Logger logger = LogManager.getLogger();
	
	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Product.class, id);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return hibernateTemplate.loadAll(Product.class);
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(product);
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		hibernateTemplate.clear();
		logger.debug(product.getProductId());
		logger.debug(product.getName());
		hibernateTemplate.saveOrUpdate(product);
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(product);
	}

}
