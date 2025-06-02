package com.itc.restclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itc.restclient.entities.SubEntity;




public interface SubEntityRepository extends JpaRepository<SubEntity, Long> {

}
