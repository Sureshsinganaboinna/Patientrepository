package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.apiresponse.ApiResponse;
import com.example.demo.entity.Products;
import com.example.demo.entity.Vechicle;
import com.example.demo.pojo.Items;
import com.example.demo.service.ProductService;
import com.example.demo.utils.ResponseData;


@RestController
@RequestMapping("/Products")
public class PageNationaAndSortingContorller {
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping("/Save")
	public void saveProductInfo(@RequestBody Items items)
	{
		System.out.println(items);
		   productService.saveProductDetails(items);
		   
		   
	}
	
	@GetMapping("/{field}")
	public List<Products> getProductDetailsByIteam(@PathVariable String field)
	{
	List<Products>  products =  	productService.getIteamsBasedSorting(field);
	return products;
		
	}
	@GetMapping("/{offset}/{pageSize}")
	public ResponseEntity<ApiResponse<Page<Products>>> findProductsUsingPagenations(@PathVariable int offset, @PathVariable int pageSize)
	{
		Page<Products> products	= productService.findProductsWithPagenations(offset, pageSize);
	/*	Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put(ResponseData.RESULT, ResponseData.SUCCESS);
		responseMap.put("response", products);
	*/	
		ApiResponse<Page<Products>> responses = new ApiResponse<>("success","OK", products);
	    return ResponseEntity.status(HttpStatus.OK).body(responses);
	}
	

}
