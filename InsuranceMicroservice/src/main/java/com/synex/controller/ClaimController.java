package com.synex.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.synex.domain.Claim;
import com.synex.domain.Insured;
import com.synex.domain.Claim;
import com.synex.service.ClaimService;

@RestController
public class ClaimController {
	
	@Autowired ClaimService claimService;
	
	@GetMapping("/getClaims")
	public List<Claim> getClaims() {
		return claimService.findClaims();
	}
	@PostMapping("/createClaim")
	public Claim createClaim(@RequestBody JsonNode node) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		
		System.out.println(node);
		
		Claim claim = mapper.convertValue(node, Claim.class);
		
		return claimService.createClaim(claim);
	}
	
	@PostMapping("/acceptClaim")
	public Claim acceptClaim(@RequestBody Long claimNumber) {
		Claim old = claimService.findClaimById(claimNumber);
		old.setStatus("ACCEPTED");
		return claimService.createClaim(old);
	}
	@PostMapping("/rejectClaim")
	public Claim rejectClaim(@RequestBody Long claimNumber) {
		Claim old = claimService.findClaimById(claimNumber);
		old.setStatus("REJECTED");
		return claimService.createClaim(old);
	}
	@GetMapping("/getClaimsByPolicyNumber")
	public List<Claim> getClaimsByPolicyNumber(@RequestParam Long pn) {
		System.out.println(pn);
		return claimService.findClaimsByPolicyNumber(pn);
	}
}
