package com.synex.component;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

@Component

public class PolicyComponent {
	public JsonNode savePolicy(JsonNode node) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<JsonNode> res = restTemplate.postForEntity("http://localhost:8383/savePolicy", node, JsonNode.class);
		
		return res.getBody();
		
	}
	public JsonNode getPolicies() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<JsonNode> res = restTemplate.getForEntity("http://localhost:8383/getPolicies", JsonNode.class);
		
		return res.getBody();
		
	}
	public JsonNode getPolicyById(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<JsonNode> res = restTemplate.getForEntity("http://localhost:8383/getPolicyById/"+id, JsonNode.class);
		
		return res.getBody();
		
	}
	public JsonNode acceptPolicy(Long policyNumber) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<JsonNode> res = restTemplate.postForEntity("http://localhost:8383/acceptPolicy", policyNumber, JsonNode.class);
		return res.getBody();
	}
	public JsonNode rejectPolicy(Long policyNumber) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<JsonNode> res = restTemplate.postForEntity("http://localhost:8383/rejectPolicy", policyNumber, JsonNode.class);
		return res.getBody();
	}
	public JsonNode getCars(Long policyNumber) {
		// TODO Auto-generated method stub
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<JsonNode> res = restTemplate.postForEntity("http://localhost:8383/getCars", policyNumber, JsonNode.class);
		return res.getBody();
	}
	
	
}
