package com.synex.controller;

import java.util.Base64;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synex.domain.Document;
import com.synex.service.DocumentService;

@RestController
public class DocumentController {
	@Autowired
	DocumentService documentService;
	
	@PostMapping("/saveDocument")
	public Document saveDocument(@RequestBody JsonNode node) {
		ObjectMapper mapper = new ObjectMapper();
		
	
		Document doc = mapper.convertValue(node, Document.class);
		
//			byte[] decodedData = Base64.getDecoder().decode(doc.getDriverLicense());
//			
//			doc.setDriverLicense(decodedData);
//			
		return documentService.saveDocument(doc);
		
		
	}
}
