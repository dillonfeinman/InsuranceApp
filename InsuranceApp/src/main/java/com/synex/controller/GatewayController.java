package com.synex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.synex.component.InsuredComponent;
import com.synex.component.PlanComponent;


@RestController
public class GatewayController {

	@Autowired InsuredComponent insuredComponent;
	@Autowired CarComponent carComponent;
	@Autowired PlanComponent planComponent;
	
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
	
}
