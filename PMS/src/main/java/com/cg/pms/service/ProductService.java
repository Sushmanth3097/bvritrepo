package com.cg.pms.service;

import com.cg.pms.bean.Product;
import com.cg.pms.exception.ProductException;

public interface ProductService {
	public int addProduct(Product product) throws ProductException;
	public Product findProductById(int productid) throws ProductException;
}
