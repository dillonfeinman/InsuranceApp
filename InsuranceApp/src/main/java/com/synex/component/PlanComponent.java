package com.synex.component;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

@Component
public class PlanComponent {
	public JsonNode getPlans() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<JsonNode> res = restTemplate.getForEntity("http://localhost:8383/getPlans", JsonNode.class);
		
		return res.getBody();
		
	}
	public JsonNode getPlanByName(String name) {
		System.out.println(name);
		RestTemplate  restTemplate = new RestTemplate();
		ResponseEntity<JsonNode> res = restTemplate.getForEntity("http://localhost:8383/getPlanByName/" + name, JsonNode.class);
//		System.out.println(res.getBody());
		return res.getBody();
	}
	public JsonNode getPlanById(Long id) {
		// TODO Auto-generated method stub
		RestTemplate  restTemplate = new RestTemplate();
		ResponseEntity<JsonNode> res = restTemplate.getForEntity("http://localhost:8383/getPlanById/" + id, JsonNode.class);
		System.out.println(res);
		return res.getBody();
	}
	
}
