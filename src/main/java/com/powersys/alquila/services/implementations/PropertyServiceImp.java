package com.powersys.alquila.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powersys.alquila.domain.PlaceType;
import com.powersys.alquila.domain.Property;
import com.powersys.alquila.repositories.PropertyRepository;
import com.powersys.alquila.services.interfaces.PropertyServiceInterface;

@Service
public class PropertyServiceImp implements PropertyServiceInterface {
	@Autowired
	private PropertyRepository propertyRepository;
	
	@Override
	public Property findOne(Long idProperty) {
		return this.propertyRepository.findOne(idProperty);
	}	

	@Override
	public List<Property> findAll() {
		return (List<Property>) this.propertyRepository.findAll();
	}

	
	@Override
	public List<Property> findByPrice(Integer price) {
		return (List<Property>)this.propertyRepository.findByPrice(price);
	}

	@Override
	public List<Property> findByType(PlaceType type) {
		return (List<Property> )this.propertyRepository.findByType(type);
	}



	

}
