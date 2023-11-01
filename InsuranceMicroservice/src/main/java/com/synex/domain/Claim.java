package com.synex.domain;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Claim {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate accidentDate;
    
    private String description;
    
    private String status;
    
    private double repairPrice;
    

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_id")
    private Car car;
    
    @ManyToOne
    private Policy policy;
    
    private byte[] policeReport;
    private byte[][] photos;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getAccidentDate() {
		return accidentDate;
	}
	public void setAccidentDate(LocalDate accidentDate) {
		this.accidentDate = accidentDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getRepairPrice() {
		return repairPrice;
	}
	public void setRepairPrice(double repairPrice) {
		this.repairPrice = repairPrice;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Policy getPolicy() {
		return policy;
	}
	public void setPolicy(Policy policy) {
		this.policy = policy;
	}
	public byte[] getPoliceReport() {
		return policeReport;
	}
	public void setPoliceReport(byte[] policeReport) {
		this.policeReport = policeReport;
	}
	public byte[][] getPhotos() {
		return photos;
	}
	public void setPhotos(byte[][] photos) {
		this.photos = photos;
	}
	public Claim(Long id, LocalDate accidentDate, String description, String status, double repairPrice, Car car,
			Policy policy, byte[] policeReport, byte[][] photos) {
		super();
		this.id = id;
		this.accidentDate = accidentDate;
		this.description = description;
		this.status = status;
		this.repairPrice = repairPrice;
		this.car = car;
		this.policy = policy;
		this.policeReport = policeReport;
		this.photos = photos;
	}
	public Claim() {
		super();
	}
    
    
    
}
