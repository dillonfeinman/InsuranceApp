package com.synex.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

public class Car {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long car_id;

	    @Column(name = "vin_number", unique = true)
	    private String vinNumber;

	    private String make;
	    private String model;
	    private int year;
	    private String color;
	    private String licensePlate;

	    @Column(name = "engine_number")
	    private String engineNumber;

	    @Column(name = "registration_date")
	    private LocalDate registrationDate;

	    @OneToMany(mappedBy = "car")
	    private List<AccidentHistory> accidentHistory;

		public Car(Long id, String vinNumber, String make, String model, int year, String color, String licensePlate,
				String engineNumber, LocalDate registrationDate, List<AccidentHistory> accidentHistory) {
			super();
			this.car_id = id;
			this.vinNumber = vinNumber;
			this.make = make;
			this.model = model;
			this.year = year;
			this.color = color;
			this.licensePlate = licensePlate;
			this.engineNumber = engineNumber;
			this.registrationDate = registrationDate;
			this.accidentHistory = accidentHistory;
		}

		public Car() {
			super();
		}

		public Long getId() {
			return car_id;
		}

		public void setId(Long id) {
			this.car_id = id;
		}

		public String getVinNumber() {
			return vinNumber;
		}

		public void setVinNumber(String vinNumber) {
			this.vinNumber = vinNumber;
		}

		public String getMake() {
			return make;
		}

		public void setMake(String make) {
			this.make = make;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getLicensePlate() {
			return licensePlate;
		}

		public void setLicensePlate(String licensePlate) {
			this.licensePlate = licensePlate;
		}

		public String getEngineNumber() {
			return engineNumber;
		}

		public void setEngineNumber(String engineNumber) {
			this.engineNumber = engineNumber;
		}

		public LocalDate getRegistrationDate() {
			return registrationDate;
		}

		public void setRegistrationDate(LocalDate registrationDate) {
			this.registrationDate = registrationDate;
		}

		public List<AccidentHistory> getAccidentHistory() {
			return accidentHistory;
		}

		public void setAccidentHistory(List<AccidentHistory> accidentHistory) {
			this.accidentHistory = accidentHistory;
		}
	    
	    
}
