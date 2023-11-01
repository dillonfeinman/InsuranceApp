package com.synex.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.synex.component.CarComponent;
import com.synex.component.ClaimComponent;
import com.synex.component.PaymentComponent;
import com.synex.component.PolicyComponent;
import com.synex.service.UserService;

@Controller
public class WelcomeController {
	
	@Autowired PolicyComponent policyComponent;
	@Autowired CarComponent carComponent;
	@Autowired ClaimComponent claimComponent;
	@Autowired PaymentComponent paymentComponent;
	@Autowired UserService userService;

	
	
	@RequestMapping(value ="/",method = RequestMethod.GET)
	public String home(Principal principal, Model model) {
		if(principal != null) {
			model.addAttribute("principal", principal.getName());
		}
		return "Home";
	}
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String welcome(Principal principal, Model model) {
		if(principal != null) {
			model.addAttribute("principal", principal.getName());
		}

//		List<JsonNode> node = bookingComponent.findAll();
		
//		model.addAttribute("bookings", node);
//		System.out.println(node);
		
		
		return "Home";
	}
	@RequestMapping(value="/admin",method=RequestMethod.GET)
	public String admin(Principal principal, Model model) {
		model.addAttribute("principal", principal);
		return "Admin";
	}
	
	@RequestMapping(value="/policies",method=RequestMethod.GET)
	public String policies(Principal principal, Model model) {
		model.addAttribute("principal", principal!=null?principal.getName():null);
		JsonNode node = policyComponent.getPolicies();
		ObjectMapper mapper = new ObjectMapper();
		List<JsonNode> nodes = mapper.convertValue(node, List.class);
		model.addAttribute("policies", nodes);
		return "Policies";
	}
	
	@RequestMapping(value="/claims",method=RequestMethod.GET)
	public String claims(Principal principal, Model model) {
		model.addAttribute("principal", principal!=null?principal.getName():null);
		JsonNode node = claimComponent.getClaims();
		ObjectMapper mapper = new ObjectMapper();
		List<JsonNode> nodes = mapper.convertValue(node, List.class);
		model.addAttribute("claims", nodes);
		return "Claims";
	}
	
	
	@RequestMapping(value = "/userForm",method = RequestMethod.GET)
	public String userForm(Principal principal, Model model) {
		model.addAttribute("principal", principal!=null?principal.getName():null);

//		List<JsonNode> node = bookingComponent.findAll();
		
//		model.addAttribute("bookings", node);
//		System.out.println(node);
		
		
		return "UserForm";
	}
	@RequestMapping(value = "/carForm",method = RequestMethod.GET)
	public String carForm(Principal principal, Model model) {
		model.addAttribute("principal", principal!=null?principal.getName():null);

//		List<JsonNode> node = bookingComponent.findAll();
		
//		model.addAttribute("bookings", node);
//		System.out.println(node);
		
		
		return "CarForm";
	}
	
	@RequestMapping(value = "/planForm",method = RequestMethod.GET)
	public String planForm(Principal principal, Model model) {
		model.addAttribute("principal", principal!=null?principal.getName():null);

//		List<JsonNode> node = bookingComponent.findAll();
		
//		model.addAttribute("bookings", node);
//		System.out.println(node);
		
		
		return "PlanForm";
	}
	@RequestMapping(value = "/paymentForm",method = RequestMethod.GET)
	public String paymentForm(@RequestParam Long amount, Principal principal, Model model) {
		model.addAttribute("principal", principal!=null?principal.getName():null);
		
		model.addAttribute("clientSecret", paymentComponent.checkout(amount));

//		List<JsonNode> node = bookingComponent.findAll();
		
//		model.addAttribute("bookings", node);
//		System.out.println(node);
		
		
		return "PaymentForm";
	}
	@RequestMapping(value = "/policyForm",method = RequestMethod.GET)
	public String policyForm(@RequestParam(required = false) String success, Principal principal, Model model) {
		model.addAttribute("principal", principal!=null?principal.getName():null);

//		List<JsonNode> node = bookingComponent.findAll();
		
//		model.addAttribute("bookings", node);
//		System.out.println(node);
		
		if(success != null) {
			model.addAttribute(success);

		}
		
		return "PolicyForm";
	}
	@GetMapping("/acceptPolicy")
	public String acceptPolicy(@RequestParam Long policyNumber, Principal principal, Model model) {
		policyComponent.acceptPolicy(policyNumber);
		
		model.addAttribute("principal", principal);
		JsonNode node = policyComponent.getPolicies();
		ObjectMapper mapper = new ObjectMapper();
		List<JsonNode> nodes = mapper.convertValue(node, List.class);
		model.addAttribute("policies", nodes);
		
		return "Policies";
	}
	@GetMapping("/rejectPolicy")
	public String rejectPolicy(@RequestParam Long policyNumber, Principal principal, Model model) {
		policyComponent.rejectPolicy(policyNumber);
		
		model.addAttribute("principal", principal);
		JsonNode node = policyComponent.getPolicies();
		ObjectMapper mapper = new ObjectMapper();
		List<JsonNode> nodes = mapper.convertValue(node, List.class);
		model.addAttribute("policies", nodes);
		
		return "Policies";
	}
	
	@GetMapping("/claim")
	public String claim(Principal principal, Model model) {
		System.out.println(principal);
		model.addAttribute("principal", principal);
		model.addAttribute("policyNumber", userService.findByUserName(principal.getName()).getPolicyNumber());
		
		return "ClaimForm";
	}
	@GetMapping("/acceptClaim")
	public String acceptClaim(@RequestParam Long id, Principal principal, Model model) {
		claimComponent.acceptClaim(id);
		
		model.addAttribute("principal", principal);
		JsonNode node = claimComponent.getClaims();
		ObjectMapper mapper = new ObjectMapper();
		List<JsonNode> nodes = mapper.convertValue(node, List.class);
		model.addAttribute("claims", nodes);
		
		return "Claims";
	}
	@GetMapping("/rejectClaim")
	public String rejectClaim(@RequestParam Long id, Principal principal, Model model) {
		claimComponent.rejectClaim(id);
		
		model.addAttribute("principal", principal);
		JsonNode node = claimComponent.getClaims();
		ObjectMapper mapper = new ObjectMapper();
		List<JsonNode> nodes = mapper.convertValue(node, List.class);
		model.addAttribute("claims", nodes);
		
		return "Claims";
	}
//	
	
}
