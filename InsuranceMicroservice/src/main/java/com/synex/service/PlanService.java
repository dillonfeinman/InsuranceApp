package com.synex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Plan;
import com.synex.repository.PlanRepository;

@Service
public class PlanService {
	@Autowired PlanRepository planRepository;
	
	public Plan savePlan(Plan Plan) {
		return planRepository.save(Plan);
	}
	public Plan findPlanById(Long id) {
		var optPlan = planRepository.findById(id);
		
		return optPlan.isPresent() ? optPlan.get() : null; 
	}
	public List<Plan> findAll() {
		return planRepository.findAll();
	}
	public Plan findPlanByName(String name) {
		System.out.println("name " + name);
		var listPlan = planRepository.findByPlanName(name);
		return listPlan.size() > 0 ? listPlan.get(0) : null; 

	}
}
