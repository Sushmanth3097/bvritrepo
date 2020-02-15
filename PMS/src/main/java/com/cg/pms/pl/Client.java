package com.cg.pms.pl;

import java.util.List;
import java.util.Scanner;


import com.cg.pms.bean.Product;
import com.cg.pms.exception.ProductException;
import com.cg.pms.service.ProductService;
import com.cg.pms.service.ProductServiceImpl;

public class Client {
	public static void main(String[] args) {
		 Scanner scanner=new Scanner(System.in);
		 ProductService productservice=new ProductServiceImpl();
		 int choice=0;
		 Product product=null;
		 List<Product> list=null;
		 while(choice!=5) {
			 System.out.println("1. Add Product");
			 System.out.println("2. Search Product");
			 System.out.println("3. Delete Product");
			 System.out.println("4. List All products");
			 System.out.println("5. Exit");
			 System.out.println("Enter your choice");
			 choice=scanner.nextInt();
			 switch(choice) {
			 case 1:
		            System.out.println("Enter name");
		            scanner.nextLine();
		            String name =scanner.nextLine();
		            System.out.println("Enter price");
		            double price=scanner.nextDouble();
		            product=new Product();
		            product.setProductname(name);
		            product.setPrice(price);
		            try {
				    int id=productservice.addProduct(product);
				    System.out.println("Product id="+id);
		            }catch(Exception e) {
		            	System.err.println(e.getMessage());
		            }
				 break;
			 case 2:
				 System.out.println("Enter Product Id");
				 int id=scanner.nextInt();
				 try {
				 product=productservice.findProductById(id);
				 System.out.println("name="+product.getProductname());
				 System.out.println("price="+product.getPrice());
				 }catch(Exception e) {
					 System.err.println(e.getMessage());
				 }
				 break;
	}

		 }
	}
}
