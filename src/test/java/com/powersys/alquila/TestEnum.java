package com.powersys.alquila;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.powersys.alquila.domain.PlaceType;

public class TestEnum {
	
	
	
	@Test
	public void value() {
		String type = "HOUSE";
		assertEquals(PlaceType.HOUSE, PlaceType.valueOf(type));
	}

}
