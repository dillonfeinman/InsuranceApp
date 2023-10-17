package com.synex.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Policy {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long policyNumber;
	
	//User information
	@OneToOne
	Insured insured;
	
	//Car information
	@OneToOne
	Car car;
	
	//Plan information
	@OneToMany(mappedBy = "policy", cascade = CascadeType.ALL)
    private List<Plan> plans;
	
	private LocalDate startDate;
	private LocalDate endDate;
	
	
	
	
	
}
