package com.cg.pms.service;

import java.util.Random;
import com.cg.pms.bean.Product;
import com.cg.pms.dao.ProductDao;
import com.cg.pms.exception.ProductException;
public class ProductServiceImpl implements ProductDao, ProductService {
private ProductDao productdao;
	public ProductServiceImpl()
	{
	productdao=new ProductServiceImpl();
	}
	private boolean validateName(String name) {
		// TODO Auto-generated method stub
		boolean flag=false;
		flag=name.matches("[a-zA-Z]+");
		return flag;
	}
	@Override
	public int addProduct(Product product) throws ProductException {
		// TODO Auto-generated method stub
		String name=product.getProductname();
		boolean flag=validateName(name);
		if(!flag) {
			throw new ProductException("name should contain only characters");
		}
		Random random=new Random();
		int id=random.nextInt(100)+1000;
		product.setProductid(id);
		id=productdao.addProduct(product);
		return id;
	}
	@Override
	public Product findProductById(int productid) throws ProductException {
		String proid=String.valueOf(productid);
		boolean flag=proid.matches("[0-9]{4}");
		if(!flag) {
			throw new ProductException("Id should be 4 digit");
		}
		Product product=productdao.findProductById(productid);
		return product;
		
	}
	


}
