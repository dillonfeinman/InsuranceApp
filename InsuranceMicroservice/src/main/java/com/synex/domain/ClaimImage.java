package com.synex.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
public class ClaimImage {
	@Lob
	private String binaryData;
	
	public ClaimImage(String str){
		binaryData = str;
	}
	public ClaimImage(){
		super();
	}
	public String getBinaryData() {
		return binaryData;
	}
	public void setBinaryData(String binaryData) {
		this.binaryData = binaryData;
	}
	
	
	
}
