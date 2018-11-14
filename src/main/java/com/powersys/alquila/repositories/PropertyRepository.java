package com.powersys.alquila.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.powersys.alquila.domain.PlaceType;
import com.powersys.alquila.domain.Property;

@Repository
public interface PropertyRepository extends CrudRepository<Property, String> {
		
	@Query("select p from Property p where p.id = :idProperty")
	public Property  findOne(@Param("idProperty") Long idProperty);
	
	@Query("select p from Property p where p.price <= :price")
	public List<Property> findByPrice(@Param("price") Integer price);
	
	
	public List<Property> findByType(PlaceType type);
	
	
	
	
}

	

