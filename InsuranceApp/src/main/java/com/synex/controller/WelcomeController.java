package com.synex.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class WelcomeController {
	
	@RequestMapping(value ="/",method = RequestMethod.GET)
	public String home(Principal principal, Model model) {
		model.addAttribute("principal", principal.getName());

		return "Home";
	}
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String welcome(Principal principal, Model model) {
		System.out.println(principal.getName());
		model.addAttribute("principal", principal.getName());

//		List<JsonNode> node = bookingComponent.findAll();
		
//		model.addAttribute("bookings", node);
//		System.out.println(node);
		
		
		return "Home";
	}
	@RequestMapping(value = "/userForm",method = RequestMethod.GET)
	public String userForm(Principal principal, Model model) {
		System.out.println(principal.getName());
		model.addAttribute("principal", principal.getName());

//		List<JsonNode> node = bookingComponent.findAll();
		
//		model.addAttribute("bookings", node);
//		System.out.println(node);
		
		
		return "UserForm";
	}
	@RequestMapping(value = "/carForm",method = RequestMethod.GET)
	public String carForm(Principal principal, Model model) {
		System.out.println(principal.getName());
		model.addAttribute("principal", principal.getName());

//		List<JsonNode> node = bookingComponent.findAll();
		
//		model.addAttribute("bookings", node);
//		System.out.println(node);
		
		
		return "CarForm";
	}
	
	@RequestMapping(value = "/planForm",method = RequestMethod.GET)
	public String planForm(Principal principal, Model model) {
		System.out.println(principal.getName());
		model.addAttribute("principal", principal.getName());

//		List<JsonNode> node = bookingComponent.findAll();
		
//		model.addAttribute("bookings", node);
//		System.out.println(node);
		
		
		return "PlanForm";
	}
	@RequestMapping(value = "/policyForm",method = RequestMethod.GET)
	public String policyForm(Principal principal, Model model) {
		System.out.println(principal.getName());
		model.addAttribute("principal", principal.getName());

//		List<JsonNode> node = bookingComponent.findAll();
		
//		model.addAttribute("bookings", node);
//		System.out.println(node);
		
		
		return "PolicyForm";
	}
	
}
