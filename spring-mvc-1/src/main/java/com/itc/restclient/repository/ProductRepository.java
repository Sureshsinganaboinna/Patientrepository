package com.itc.restclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itc.restclient.entities.Products;




public interface ProductRepository extends JpaRepository<Products, Integer> {

}
