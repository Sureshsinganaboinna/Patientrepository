package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Order;
@Repository
public interface ReportRepository extends JpaRepository<Order, Long> {
	
	 @Procedure(procedureName = "getMonthlyReport")
	    void getMonthlyReport(@Param("monthParam") int month, @Param("yearParam") int year);

}
