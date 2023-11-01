package com.synex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synex.component.CarComponent;
import com.synex.component.ClaimComponent;
import com.synex.component.DocumentComponent;
import com.synex.component.InsuredComponent;
import com.synex.component.PaymentComponent;
import com.synex.component.PlanComponent;
import com.synex.component.PolicyComponent;
import com.synex.domain.User;
import com.synex.service.UserService;


@RestController
public class GatewayController {

	@Autowired InsuredComponent insuredComponent;
	@Autowired CarComponent carComponent;
	@Autowired PlanComponent planComponent;
	@Autowired PolicyComponent policyComponent;
	@Autowired DocumentComponent documentComponent;
	@Autowired ClaimComponent claimComponent;
	@Autowired UserService userService;
	@Autowired PaymentComponent paymentComponent;
	
	@Autowired PasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/saveInsured")
	public JsonNode saveInsured(@RequestBody JsonNode node) {
		return insuredComponent.saveInsured(node);
	}
	@GetMapping("/getInsuredById/{id}")
	public JsonNode getInsuredById(@PathVariable String id) {
		return insuredComponent.getInsuredById(Long.valueOf(id));
	}
	
	@PostMapping("/saveCar")
	public JsonNode saveCar(@RequestBody JsonNode node) {
		return carComponent.saveCar(node);
	}
	@GetMapping("/getCarById/{id}")
	public JsonNode getCarById(@PathVariable String id) {
		return carComponent.getCarById(Long.valueOf(id));
	}
	
	@GetMapping("/getPlans")
	public JsonNode getPlans() {
		return planComponent.getPlans();
	}
	@GetMapping("/getPlanByName/{name}")
	public JsonNode getPlans(@PathVariable String name) {
		return planComponent.getPlanByName(name);
	}
	@GetMapping("/getPlanById/{id}")
	public JsonNode getPlanById(@PathVariable String id) {
		System.out.println(Long.valueOf(id));
		return planComponent.getPlanById(Long.valueOf(id));
	}
	@PostMapping("/savePolicy")
	public JsonNode savePolicy(@RequestBody JsonNode node) {
		return policyComponent.savePolicy(node);
	}
	@PostMapping("/saveDocument")
	public JsonNode saveDocument(@RequestBody JsonNode node) {
		return documentComponent.saveDocument(node);
	}
	@PostMapping("/createClaim")
	public JsonNode createClaim(@RequestBody JsonNode node) {
		return claimComponent.createClaim(node);
	}
	@PostMapping("/getPolicy")
	public JsonNode getPolicy(@RequestBody JsonNode node)  {
		ObjectMapper mapper = new ObjectMapper();
		
		return policyComponent.getPolicyById(mapper.convertValue(node, Long.class));
	}
	@PostMapping("/signup")
	public User signup(@RequestBody User user) {
		//ObjectMapper mapper = new ObjectMapper();
		//User user = mapper.convertValue(node, User.class);
		user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
		return userService.save(user);

	} 
//	@PostMapping("/processPayment")
//	public JsonNode processPayment(@RequestBody String clientSecret) {
//		return paymentComponent.confirm(clientSecret);
//	}
}
