package com.synex.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

@Entity
public class Document {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Lob
	private byte[] driverLicense;

    private String fileName;
    
	@OneToOne(cascade = CascadeType.MERGE)
    private Insured insured;

	public Document(Long id, byte[] driverLicense, String fileName) {
		super();
		this.id = id;
		this.driverLicense = driverLicense;
		this.fileName = fileName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getDriverLicense() {
		return driverLicense;
	}

	public void setDriverLicense(byte[] driverLicense) {
		this.driverLicense = driverLicense;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Document() {
		super();
	}
    
    
    
}
