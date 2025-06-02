package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Product;

import jakarta.transaction.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT * FROM Products WHERE stock < :threshold", nativeQuery = true)
	List<Product> getAllTheProductsWithBelowThresold(@Param("threshold") int threshold);

	
	
	@Procedure(procedureName = "get_total_products")
	Integer getTotalProducts();
	
//	@Query(value = "SELECT COUNT(*) FROM Products",nativeQuery = true)
//	Integer getTotalPro();

	
	 @Procedure(procedureName = "GetProductsForMatchingWord")
	 List<Product> getProductsIfMatchWord(String word);
	 
	 
	 @Modifying
	 @Transactional
	 @Query("UPDATE Product p SET p.stock = p.stock-:quantity WHERE p.Id = :productId")
	 void reduceStock(@Param("productId") Long Id, @Param("quantity") int quty);
	 
	 
	
	
}
