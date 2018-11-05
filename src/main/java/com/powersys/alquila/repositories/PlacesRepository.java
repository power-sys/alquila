package com.powersys.alquila.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.powersys.alquila.domain.Property;

@Repository
public interface PlacesRepository extends CrudRepository<Property, Long> {
	Property findById(Long id);
}
