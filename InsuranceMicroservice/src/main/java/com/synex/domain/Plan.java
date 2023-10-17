package com.synex.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "insurance_plans")
public class Plan {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "plan_name")
	    private String planName;

	    @Column(name = "coverage_type")
	    private String coverageType;

	    @Column(name = "coverage_amount")
	    private BigDecimal coverageAmount;

	    @ManyToOne
	    private Policy policy;
	    
	    @Column(name = "premium")
	    private BigDecimal premium;

	    // Other fields, getters, setters, and constructors

	    public Plan() {
	        // Default constructor
	    }


		public Plan(Long id, String planName, String coverageType, BigDecimal coverageAmount, Policy policy,
				BigDecimal premium) {
			super();
			this.id = id;
			this.planName = planName;
			this.coverageType = coverageType;
			this.coverageAmount = coverageAmount;
			this.policy = policy;
			this.premium = premium;
		}



		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getPlanName() {
			return planName;
		}

		public void setPlanName(String planName) {
			this.planName = planName;
		}

		public String getCoverageType() {
			return coverageType;
		}

		public void setCoverageType(String coverageType) {
			this.coverageType = coverageType;
		}

		public BigDecimal getCoverageAmount() {
			return coverageAmount;
		}

		public void setCoverageAmount(BigDecimal coverageAmount) {
			this.coverageAmount = coverageAmount;
		}

		public BigDecimal getPremium() {
			return premium;
		}

		public void setPremium(BigDecimal premium) {
			this.premium = premium;
		}

		public Policy getPolicy() {
			return policy;
		}

		public void setPolicy(Policy policy) {
			this.policy = policy;
		}

	    
	
}
