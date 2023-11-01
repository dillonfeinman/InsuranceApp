package com.synex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Policy;
import com.synex.repository.PolicyRepository;

@Service
public class PolicyService {
	@Autowired PolicyRepository policyRepository;
	
	public Policy savePolicy(Policy Policy) {
		return policyRepository.save(Policy);
	}
	public Policy findPolicyById(Long id) {
		var optPolicy = policyRepository.findById(id);
		
		return optPolicy.isPresent() ? optPolicy.get() : null; 
	}
	public List<Policy> findAll() {
		return policyRepository.findAllByStatusLike("AWAITING");
	}
}
