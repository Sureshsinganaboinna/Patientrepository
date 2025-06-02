package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Products;
import com.example.demo.pojo.Items;

import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	
	
	@Autowired
	private ProductRepository productRepository;
	
	public void saveProductDetails(Items items)
	{
    	System.out.println(items.toString());
    	
    	Products products = new Products();
    	products.setProductName(items.getProductName());
    	products.setQuantity(items.getQuantity());
    	products.setPrice(items.getPrice());
    	
    	productRepository.save(products);
	
	}
	
	
	public List<Products> getIteamsBasedSorting(String field)
	{
		List<Products> iteams = productRepository.findAll(Sort.by(Direction.DESC,field));
		return iteams;
	}

	public Page<Products> findProductsWithPagenations(int offset, int pageSize)
	{
Page<Products> product	=  productRepository.findAll(PageRequest.of(offset, pageSize));
		return product;
				
		
	}
	
	
	
	
	
	
	
	
}
