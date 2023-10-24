package com.synex.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synex.domain.Plan;
import com.synex.service.PlanService;

@RestController
public class PlanController {
	@Autowired PlanService planService;
	
	@PostMapping("/savePlan")
	public Plan savePlan(@RequestBody JsonNode node) {
		ObjectMapper mapper = new ObjectMapper();
		Plan plan = mapper.convertValue(node, Plan.class);
		return planService.savePlan(plan);
	}
	@GetMapping("/getPlans")
	public List<Plan> getPlans(){
		return planService.findAll();
	}
	@GetMapping("/getPlanByName/{name}")
	public Plan getPlanByName(@PathVariable String name){
		System.out.println(name);
		return planService.findPlanByName(name);
	}
	@GetMapping("/getPlanById/{id}")
	public Plan getPlanById(@PathVariable String id){
		System.out.println(id);
		return planService.findPlanById(Long.valueOf(id));
	}
	
}
