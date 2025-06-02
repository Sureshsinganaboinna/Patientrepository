package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	 @Query(value = "select * from employee_details LEFT JOIN address ON \r\n"
	 		+ "employee_details.emp_id = address.fk_emp_id WHERE employee_details.emp_id = :id", nativeQuery = true)
	    Employee getInstructerDataById(@Param("id") Long id);
}
