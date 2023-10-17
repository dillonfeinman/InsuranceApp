package com.synex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Insured;
import com.synex.repository.InsuredRepository;

@Service
public class InsuredService {
	@Autowired InsuredRepository insuredRepository;
	
	public Insured saveInsured(Insured insured) {
		return insuredRepository.save(insured);
	}
	public Insured findInsuredById(Long id) {
		var optInsured = insuredRepository.findById(id);
		return optInsured.isPresent() ? optInsured.get() : null; 
	}
}
