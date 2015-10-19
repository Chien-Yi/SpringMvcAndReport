package app.web.service;

import java.util.List;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.config.model.Product;
import app.web.dao.ProductDao;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	private final Logger logger = LogManager.getLogger();
	
	@Autowired
	ProductDao productDao;
	
	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return productDao.findById(id);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	@Override
	public void saveOrUpdate(Product product) {
		// TODO Auto-generated method stub
		if (findById(product.getProductId())==null) {
			productDao.save(product);
		} else {
			logger.debug("update");
			productDao.update(product);
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
		productDao.delete(findById(id));
	}
	
	public DefaultTableModel getModel() {
		DefaultTableModel model = new javax.swing.table.DefaultTableModel();
		String[] cols = new String[] {"name","productNumber","safetyStockLevel","reorderPoint","listPrice"};
		java.util.ArrayList<String[]> arrList = new java.util.ArrayList<String[]>();
		List<Product> list = productDao.findAll();
		if(list.size()>0) {
			for(int i = 0;i<list.size();i++) {
				Product map =  list.get(i);
				String rowArray[]=new String[cols.length];
				rowArray[0] = map.getName();
				rowArray[1] = map.getProductNumber();
				rowArray[2] = map.getSafetyStockLevel()+"";
				rowArray[3] = map.getReorderPoint()+"";
				rowArray[4] = map.getListPrice()+"";
				
				arrList.add(rowArray);
			}
			if (arrList!=null && arrList.size()>0) {
				String[][] rs = new String[0][0];
				rs = (String[][])arrList.toArray(rs);
				model.setDataVector(rs, cols);
			}	
		}
		return model;
	}

}
