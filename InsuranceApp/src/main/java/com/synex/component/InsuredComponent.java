package com.synex.component;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class InsuredComponent {
	
	public JsonNode saveInsured(JsonNode node) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<JsonNode> res = restTemplate.postForEntity("http://localhost:8383/saveInsured", node, JsonNode.class);
		
		return res.getBody();
		
	}
}
