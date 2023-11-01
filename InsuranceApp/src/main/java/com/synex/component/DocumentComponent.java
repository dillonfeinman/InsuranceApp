package com.synex.component;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;

@Component
public class DocumentComponent {
	public JsonNode saveDocument(JsonNode node) {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(node);
		ResponseEntity<JsonNode> res = restTemplate.postForEntity("http://localhost:8383/saveDocument", node, JsonNode.class);
		
		return res.getBody();
	}
}
