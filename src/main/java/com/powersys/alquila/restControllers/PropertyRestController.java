package com.powersys.alquila.restControllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.ListUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.powersys.alquila.domain.PlaceType;
import com.powersys.alquila.domain.Property;
import com.powersys.alquila.services.implementations.PropertyServiceImp;

@RestController
@RequestMapping("/api/")
public class PropertyRestController {
	
	@Autowired
	private PropertyServiceImp propertyServiceImp;
	
				
	@GetMapping("/showProperties")
	public Map getProperties(){
		List<Property> listProperties= this.propertyServiceImp.findAll();
		Map<String, Object> result = new HashMap<>();
		
		//Key : value
		
		result.put("timestamp", System.currentTimeMillis());
        result.put("status", listProperties.size() > 0 ? 200 : 404);
        result.put("message", listProperties.size() > 0 ? "Data was found" : "No Data Found");
        result.put("data", listProperties);
        
        return result;
	}
	
	@GetMapping("/showProperties/byPrice")
	public Map getPropertiesByPrice(Integer price){
		List<Property> listPropertiesByPrice= this.propertyServiceImp.findByPrice(price); 
		Map<String, Object> result = new HashMap<>();
		
		//Key : value
		
		result.put("timestamp", System.currentTimeMillis());
        result.put("status", listPropertiesByPrice.size() > 0 ? 200 : 404);
        result.put("message", listPropertiesByPrice.size() > 0 ? "Data was found" : "No Data Found");
        result.put("data", listPropertiesByPrice);
        
        return result;
	}
	
	@GetMapping("/showProperties/byType")
	public Map getPropertiesByType(PlaceType type){
		
		List<Property> listPropertiesByType= this.propertyServiceImp.findByType(type); 
		Map<String, Object> result = new HashMap<>();
		
		//Key : value
		
		result.put("timestamp", System.currentTimeMillis());
        result.put("status", listPropertiesByType.size() > 0 ? 200 : 404);
        result.put("message", listPropertiesByType.size() > 0 ? "Data was found" : "No Data Found");
        result.put("data", listPropertiesByType);
        
        return result;
	}
	
	@GetMapping("/showProperties/byPriceType")
	public Map getPropertiesByPriceType(Integer price, PlaceType type){
		List<Property> listPropertiesByType= this.propertyServiceImp.findByType(type);
		List<Property> listPropertiesByPrice= this.propertyServiceImp.findByPrice(price);
		List<Property> listaUnion = ListUtils.union(listPropertiesByPrice, listPropertiesByType);
		Map<String, Object> result = new HashMap<>();
		
		//Key : value
		
		result.put("timestamp", System.currentTimeMillis());
        result.put("status", listaUnion.size() > 0 ? 200 : 404);
        result.put("message", listaUnion.size() > 0 ? "Data was found" : "No Data Found");
        result.put("data", listaUnion);
        
        return result;
	}
	
	

}
