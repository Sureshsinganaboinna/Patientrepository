package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	@Query("SELECT o FROM Order o WHERE o.user.id = :userId")
	List<Order> getOrderDetailsByUserId( @Param("userId")    Long userId);
	

}
