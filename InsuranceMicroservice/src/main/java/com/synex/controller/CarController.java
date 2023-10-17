package com.synex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synex.domain.Car;
import com.synex.service.CarService;

@RestController
public class CarController {
	@Autowired CarService carService;
	
	@PostMapping("/saveCar")
	public Car saveCar(@RequestBody JsonNode node) {
		ObjectMapper mapper = new ObjectMapper();
		Car car = mapper.convertValue(node, Car.class);
		return carService.saveCar(car);
	}
}
