package com.itc.restclient.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itc.restclient.entities.InstaEntity;


public interface InstaEntityRepository extends JpaRepository<InstaEntity, Long> {
	
	@Query("select i from InstaEntity i inner join i.courEntity c where c.id = :id")
	List<InstaEntity>getInstaDbData(@Param("id") Long id);
	
	@Query("SELECT i FROM InstaEntity i left join i.courEntity c where c.id>1")
	List<InstaEntity> findAllCoursesWithOptionalInsta();

}



