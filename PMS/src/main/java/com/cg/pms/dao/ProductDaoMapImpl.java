package com.cg.pms.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.cg.pms.bean.Product;
import com.cg.pms.exception.ProductException;
public class ProductDaoMapImpl implements ProductDao {
private Map<Integer,Product> map;
public ProductDaoMapImpl() {
	Map<Integer,Product> map=new HashMap();
}
@Override
public int addProduct(Product product) throws ProductException {
	// TODO Auto-generated method stub
	boolean flag=map.containsKey(product.getProductid());
	if(flag) {
		throw new ProductException("Id Already Exists ");
	}
	map.put(product.getProductid(),product);
	return product.getProductid();
}
@Override
public Product findProductById(int productid) throws ProductException {
	boolean flag=map.containsKey(productid);
	Product product=null;
	if(flag) {
		product=map.get(productid);
	}
	else {
		throw new ProductException("Id Not Found");
	}
	return product;
}

}
