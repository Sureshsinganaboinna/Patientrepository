package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> getListOfProducts(int threshold)
	{
	  List<Product> productss =	productRepository.getAllTheProductsWithBelowThresold(threshold);
	  return productss;
	}
	
	
	public Optional<Product> productId(Long prodid)
	{
		 Optional<Product> dbb  = productRepository.findById(prodid);
		 return dbb;
	}
	
	
	public Integer getTotalProductCounts()
	{
		   Integer productcount = productRepository.getTotalProducts();
		   
		   return productcount;
	}
	
	
	@Transactional
	public List<Product> getTotalProducts(String word)
	{
	     List<Product> WordMatchProducts  = productRepository.getProductsIfMatchWord(word);
	     return WordMatchProducts;
	}
	
	public void reduceStcokInDb(Long Id, int quty)
	{
		
	   productRepository.reduceStock(Id, quty);
		
	}
	

}
