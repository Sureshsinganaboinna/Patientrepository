package com.itc.restclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itc.restclient.entities.Address;



public interface AddressRepository extends JpaRepository<Address, Long> {
	/*  @Query("select i from Instructer i LEFT JOIN i.courses where i.id = :id")
    Instructer getInstructerDataById(@Param("id") Long id);*/
 
/* @Query(value = "select * from instructers as i LEFT JOIN courses as c ON i.id = c.instructer_id WHERE i.id  = :id", nativeQuery = true)
    Instructer getInstructerDataById(@Param("id") Long id);
 
 */
 
/*	 @Query(value = "select * from employee_details LEFT JOIN address ON \r\n"
	 		+ "employee_details.emp_id = address.fk_emp_id WHERE employee_details.emp_id = :id", nativeQuery = true)
	    Employee getInstructerDataById(@Param("id") Long id);
 */
 /*   @Query(value = "select * from instructers i LEFT JOIN  i.courses where i.instructer_id = ?1", nativeQuery = true)
    Instructer getInstructerDataById( Long id);
*/
	/*
	//Native SQL queries with names parameters
	@Query(value= "select * from users where email = :emailid and password =  :pword" , nativeQuery = true)
	Optional<User> dbloginwithquery(@Param("emailid")  String email, @Param("pword")String password);
	*/
}
