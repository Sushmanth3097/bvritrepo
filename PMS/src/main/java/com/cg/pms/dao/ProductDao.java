package com.cg.pms.dao;

import com.cg.pms.bean.Product;
import com.cg.pms.exception.ProductException;

public interface ProductDao {
	public int addProduct(Product product) throws ProductException ;
	public Product findProductById(int productid) throws ProductException ;
}
