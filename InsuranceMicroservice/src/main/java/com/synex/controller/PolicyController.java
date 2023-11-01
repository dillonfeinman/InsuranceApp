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
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.synex.domain.Policy;
import com.synex.service.PolicyService;

@RestController
public class PolicyController {
	@Autowired PolicyService policyService;
	
	@PostMapping("/savePolicy")
	public Policy savePolicy(@RequestBody JsonNode node) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		Policy policy = mapper.convertValue(node, Policy.class);
		return policyService.savePolicy(policy);
	}
	@GetMapping("/getPolicies")
	public List<Policy> getPolicies(){
		return policyService.findAll();
	}
	
	@GetMapping("/getPolicyById/{id}")
	public Policy getPolicyById(@PathVariable String id){
		System.out.println(policyService.findPolicyById(Long.valueOf(id)));
		return policyService.findPolicyById(Long.valueOf(id));
		
	}
	@PostMapping("/acceptPolicy")
	public Policy acceptPolicy(@RequestBody Long policyNumber) {
		Policy old = policyService.findPolicyById(policyNumber);
		old.setStatus("ACCEPTED");
		return policyService.savePolicy(old);
	}
	@PostMapping("/rejectPolicy")
	public Policy rejectPolicy(@RequestBody Long policyNumber) {
		Policy old = policyService.findPolicyById(policyNumber);
		old.setStatus("REJECTED");
		return policyService.savePolicy(old);
	}
}
