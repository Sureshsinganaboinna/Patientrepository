package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

import jakarta.transaction.Transactional;



@RestController
public class ProductController {
	
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/productinfo/{threshold}")
	public List<Product> getProductDetails(@PathVariable int threshold)
	{
	      List<Product> products  =	productService.getListOfProducts(threshold);
	      return products;
	}
	
	@GetMapping("/getProdById/{prodid}")
	public Optional<Product> getProductById(@PathVariable Long prodid)
	{
Optional<Product> ddd	=	productService.productId(prodid);

return ddd;
	}

	@GetMapping("/totalproductcount")
	public Integer getMethodName() {
		Integer count = productService.getTotalProductCounts();
		return count;
	}
	
	@GetMapping("/getProduct")
	public List<Product> getProductsOfWordMatch(@RequestParam String word)
	{
		List<Product> products = productService.getTotalProducts(word);
		return products;
	}
	
	@GetMapping("/reduceStocks/{Id}/{quty}")
	public String reducingStocksAfterSold(@PathVariable Long Id, @PathVariable int quty)
	{
      	productService.reduceStcokInDb(Id, quty);
		return "Stocks got successfully modified";
	}
	

}
