package com.synex.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Car;
import com.synex.domain.Insured;
import com.synex.domain.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long>{
	List<Plan> findByPlanName(String name);
}
