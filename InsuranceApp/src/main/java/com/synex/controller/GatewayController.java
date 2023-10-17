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


@RestController
public class GatewayController {

	@Autowired InsuredComponent insuredComponent;
	@Autowired CarComponent carComponent;
	
	@PostMapping("/saveInsured")
	public JsonNode saveInsured(@RequestBody JsonNode node) {
		return insuredComponent.saveInsured(node);
	}
	@PostMapping("/saveCar")
	public JsonNode saveCar(@RequestBody JsonNode node) {
		return carComponent.saveCar(node);
	}
	
	
}
