package com.synex.component;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ClaimComponent {
	
	public JsonNode createClaim(JsonNode node) {
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(node);

		ResponseEntity<JsonNode> res = restTemplate.postForEntity("http://localhost:8383/createClaim", node, JsonNode.class);
		System.out.println(res.getBody());
		return res.getBody();
		
	}

	public JsonNode getClaims() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<JsonNode> res = restTemplate.getForEntity("http://localhost:8383/getClaims", JsonNode.class);
		System.out.println(res);
		return res.getBody();
		
	}
	
	public JsonNode acceptClaim(Long claimNumber) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<JsonNode> res = restTemplate.postForEntity("http://localhost:8383/acceptClaim", claimNumber, JsonNode.class);
		return res.getBody();
	}
	public JsonNode rejectClaim(Long claimNumber) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<JsonNode> res = restTemplate.postForEntity("http://localhost:8383/rejectClaim", claimNumber, JsonNode.class);
		return res.getBody();
	}
	
	public JsonNode getClaimsByPolicyNumber(Long policyNumber) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<JsonNode> res = restTemplate.getForEntity("http://localhost:8383/getClaimsByPolicyNumber?pn="+policyNumber, JsonNode.class);
		return res.getBody();
	}
}
