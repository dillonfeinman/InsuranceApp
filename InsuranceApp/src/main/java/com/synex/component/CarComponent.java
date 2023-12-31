package com.synex.component;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CarComponent {
	
	public JsonNode saveCar(JsonNode node) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<JsonNode> res = restTemplate.postForEntity("http://localhost:8383/saveCar", node, JsonNode.class);
		
		return res.getBody();
		
	}

	public JsonNode getCarById(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<JsonNode> res = restTemplate.getForEntity("http://localhost:8383/getCarById/" + id, JsonNode.class);
		System.out.println(res);
		return res.getBody();
		
	}
}
