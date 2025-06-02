package com.itc.restclient.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itc.restclient.entities.Video;


@Repository
public interface VideoRepository extends JpaRepository<Video, Integer> {
	
    //select * from videos where title like '%fix%'
	@Query("SELECT v FROM Video v WHERE v.title LIKE %:searchword%")
	//@Query(value = "SELECT * FROM Video WHERE title LIKE' %:searchword%'", nativeQuery = true)
	List<Video> searchWord(@Param("searchword") String searchword);
	
	/*   @Query(value = "SELECT * FROM video WHERE title LIKE %:searchword%", nativeQuery = true)
	    List<Video> searchWord(@Param("searchword") String searchword);*/
}
