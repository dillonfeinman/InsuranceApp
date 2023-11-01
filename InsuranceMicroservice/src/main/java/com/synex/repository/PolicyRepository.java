package com.synex.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Car;
import com.synex.domain.Insured;
import com.synex.domain.Plan;
import com.synex.domain.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long>{
	List<Policy> findAllByStatusLike(String status);

}
