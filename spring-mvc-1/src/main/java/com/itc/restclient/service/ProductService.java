package com.itc.restclient.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.itc.restclient.entities.Products;
import com.itc.restclient.pojo.Items;
import com.itc.restclient.repository.ProductRepository;


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
		List<Products> iteams = productRepository.findAll(Sort.by(Direction.ASC,field));
		return iteams;
	}

	public Page<Products> findProductsWithPagenations(int offset, int pageSize)
	{
Page<Products> product	=  productRepository.findAll(PageRequest.of(offset, pageSize));
		return product;
	}
	
	public List<Products> getAllIteamsBasedOnSortingField(String field)
	{
		List<Products> products = productRepository.findAll(Sort.by(field).descending());
		return products;
	}
	
}
