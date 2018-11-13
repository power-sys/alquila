package com.powersys.alquila.listeners;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.devskiller.jfairy.Fairy;
import com.devskiller.jfairy.producer.BaseProducer;
import com.devskiller.jfairy.producer.person.Person;
import com.devskiller.jfairy.producer.text.TextProducer;

import com.powersys.alquila.domain.Address;
import com.powersys.alquila.domain.Detail;
import com.powersys.alquila.domain.Owner;
import com.powersys.alquila.domain.PlaceType;
import com.powersys.alquila.domain.Property;
import com.powersys.alquila.repositories.PropertyRepository;
/****
 * 
 * @author Amadeo F. Garcia
 * userGit{AmadeoO}
 * email{amadeo.fgarcia@gmail.com}
 */

@Component
public class DataGenerator {

	@Autowired
	private PropertyRepository propertyRepository;
	
	@EventListener
	public void seed(ContextRefreshedEvent event) {
		System.out.println("::::::::::::::::::::::::GENARATING DB:::::::::::::::::::::::::");
			
		for (int i=0; i<6; i++) {
			//-->this variables are the that generate the datas
			Fairy fairy =  Fairy.create();
			BaseProducer baseProducer = fairy.baseProducer();
			Person person = fairy.person();
			TextProducer text = fairy.textProducer();
			
			//-->initializing the variables from domain
			Address address = new Address();
			address.setStreet(text.word(3));
			address.setNumber(Integer.toString(baseProducer.randomBetween(2, 1000)));
			
			Owner owner = new Owner();
			owner.setAdress(person.getAddress().getAddressLine1());
			owner.setEmail(person.getEmail());
			owner.setLastName(person.getLastName());
			owner.setName(person.getFirstName());
			owner.setPhone(person.getTelephoneNumber());
			
			List<Detail> details = new ArrayList<>();
			details.add(new Detail());
			details.get(0).setName(text.randomString(15));
			
			List<Detail> legalDetails = new ArrayList<>();
			legalDetails.add(new Detail());
			legalDetails.get(0).setName(text.randomString(15));
			
			Integer price = baseProducer.randomBetween(2000, 20000);
			
			//-->we save the datas in the property class
			
			Property property = new Property();
			property.setAdress(address);
			property.setDescription(text.randomString(15));
			property.setDetails(details);
			property.setLegals(legalDetails);
			property.setOwner(owner);
			property.setPrice(price);
			property.setType((i % 2 == 0)? PlaceType.DEPARMENT : PlaceType.HOUSE);
			property.addImage(text.randomString(15));
			
			propertyRepository.save(property);
			
			
			
			
		}		
	}

}