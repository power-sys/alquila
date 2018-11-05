package com.powersys.alquila.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.powersys.alquila.domain.Address;
import com.powersys.alquila.domain.Detail;
import com.powersys.alquila.domain.PlaceType;
import com.powersys.alquila.domain.Property;
import com.powersys.alquila.dtos.InmuebleDTO;
import com.powersys.alquila.repositories.PlacesRepository;
import com.powersys.alquila.services.interfaces.InmuebleServiceInterface;

/**
 *
 * @author Amadeo F. Garcia
 * userGit{AmadeoO}
 * emailGit{amadeo.fgarcia@gmail.com}
 */

@Service
public class InmuebleService implements InmuebleServiceInterface{

	@Autowired
	private PlacesRepository propertyRepository;

	@Override
	public boolean insertInmueble(InmuebleDTO inmueble) {
		Property p = new Property();
		
		List<Detail> details = new ArrayList<>();
		List<Detail> legals = new ArrayList<>();
		p.setDetails(details);
		p.setLegals(legals);
		Address a = new Address();
		
		a.setNumber(inmueble.getDireccion());
		p.setPrice(inmueble.getPrecio());
		Detail d = new Detail();
		d.setName(inmueble.getDetallesInmueble());
		p.getDetails().add(d);
		Detail d2 = new Detail();
		d2.setName(inmueble.getOtrosDetalles());
		p.getDetails().add(d2);
		p.setAdress(a);
		p.setType(PlaceType.DEPARMENT);
		p.setDescription(inmueble.getDetallesLegales());
		this.propertyRepository.save(p);
		return true;
	}

	@Override
	public List<Property> findAll() {
		return (List<Property>) this.propertyRepository.findAll();
	}

}
