package kodlama.io.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import kodlama.io.hrms.business.abstracts.EmployerPhoneNumberService;
import kodlama.io.hrms.entities.concretes.EmployerPhoneNumber;

@RestController
@RequestMapping("/api/employerPhoneNumbers/")
public class EmployerPhoneNumbersController {

	private EmployerPhoneNumberService employerPhoneNumberService;
	@Autowired
	public EmployerPhoneNumbersController(EmployerPhoneNumberService employerPhoneNumberService) {
		this.employerPhoneNumberService = employerPhoneNumberService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody EmployerPhoneNumber employerPhoneNumber) {
		var result = employerPhoneNumberService.add(employerPhoneNumber);
		if(!result.isSuccess())return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<?> getAll() {
		var result = employerPhoneNumberService.getAll();
		if(!result.isSuccess())return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
}
