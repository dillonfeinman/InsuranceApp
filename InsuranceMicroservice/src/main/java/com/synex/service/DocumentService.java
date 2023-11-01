package com.synex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synex.domain.Document;
import com.synex.domain.Insured;
import com.synex.repository.DocumentRepository;
import com.synex.repository.InsuredRepository;

@Service
public class DocumentService {
	@Autowired DocumentRepository documentRepository;
	
	public Document saveDocument(Document document) {
		return documentRepository.save(document);
	}
	public Document findInsuredById(Long id) {
		var optDocument = documentRepository.findById(id);
		return optDocument.isPresent() ? optDocument.get() : null; 
	}
}
