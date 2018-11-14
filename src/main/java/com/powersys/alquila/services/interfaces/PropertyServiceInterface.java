package com.powersys.alquila.services.interfaces;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.powersys.alquila.domain.PlaceType;
import com.powersys.alquila.domain.Property;

@Service
public interface PropertyServiceInterface {
	
	public Property  findOne(@Param("idProperty") Long idProperty);
	public List <Property> findAll();
	public List<Property> findByPrice(@Param("price") Integer price);
	public List<Property> findByType(PlaceType type);

}
