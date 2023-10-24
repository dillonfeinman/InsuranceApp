package com.synex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.synex.domain.Car;
import com.synex.domain.Insured;
import com.synex.repository.CarRepository;

@Service
public class CarService {
	@Autowired CarRepository CarRepository;
	
	public Car saveCar(Car Car) {
		return CarRepository.save(Car);
	}
	public Car findCarById(Long id) {
		var optCar = CarRepository.findById(id);
		return optCar.isPresent() ? optCar.get() : null; 
	}
	
}
