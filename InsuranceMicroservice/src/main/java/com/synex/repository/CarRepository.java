package com.synex.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.synex.domain.Car;
import com.synex.domain.Insured;

public interface CarRepository extends JpaRepository<Car, Long>{
	
}
