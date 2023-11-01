package com.synex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Claim;
import com.synex.repository.ClaimRepository;

@Service
public class ClaimService {
	@Autowired ClaimRepository claimRepository;
	
	public Claim createClaim(Claim claim) {
		return claimRepository.save(claim);
	}
	public List<Claim> findClaims() {
		return claimRepository.findAllByStatusLike("AWAITING");
	}
	public Claim findClaimById(Long claimNumber) {
		// TODO Auto-generated method stub
		var optClaim = claimRepository.findById(claimNumber);
		return optClaim.isPresent()?optClaim.get():null;
	}
}
