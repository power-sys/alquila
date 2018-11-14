package com.powersys.alquila.webControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.powersys.alquila.dtos.InmuebleDTO;

import com.powersys.alquila.services.implementations.InmuebleService;

@Controller
public class InmuebleWebVC {

	private InmuebleService inmuebleService;

	public InmuebleWebVC(InmuebleService service) {
		this.inmuebleService = service;
	}

	@RequestMapping(value = "/cargarInmueble", method = RequestMethod.GET)
	public String cargarInmuebleForm(Model model) {
		model.addAttribute("inmueble", new InmuebleDTO());
		return "form3";
	}
	
	@PostMapping("/cargarInmueble")
	public String altaInmueble(@ModelAttribute InmuebleDTO inmuebleDTO, Model model) {
		this.inmuebleService.insertInmueble(inmuebleDTO);
		return "redirect:/";
	}

	@GetMapping(value = "/")
	public String home(Model model) {
		model.addAttribute("inmueble", this.inmuebleService.findAll());
		return "home1";
	}
	
	@RequestMapping (value= "/terminosYcondic", method = RequestMethod.GET)
		
		public String terminos (Model model) {
			return "terminosYcondic";
		}
}
