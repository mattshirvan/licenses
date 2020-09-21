package com.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
	List<License> findAll();
	
	License findByPersonId(Long id);
	
	License findByNumber(int search);
	
	License findTopByOrderByNumberDesc();
}
