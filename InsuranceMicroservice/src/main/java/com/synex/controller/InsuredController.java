package com.synex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.synex.domain.Insured;
import com.synex.service.InsuredService;

@RestController
public class InsuredController {
	@Autowired InsuredService insuredService;
	
	@PostMapping("/saveInsured")
	public Insured saveInsured(@RequestBody JsonNode node) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		
		Insured insured = mapper.convertValue(node, Insured.class);
		return insuredService.saveInsured(insured);
	}
	@GetMapping("/getInsuredById/{id}")
	public Insured getInsuredById(@PathVariable String id) {
		Insured insured = insuredService.findInsuredById(Long.valueOf(id));
		return insured;
	}
}
