package kodlama.io.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers/")
public class EmployersController {

	private EmployerService employerService;
	@Autowired
	public EmployersController(EmployerService employerService) {
		this.employerService = employerService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody Employer employer) {
		var result = employerService.add(employer);
		if(!result.isSuccess()) ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<?> getAll(){
		var result = employerService.getAll();
		if(!result.isSuccess()) ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
		
	}
}
