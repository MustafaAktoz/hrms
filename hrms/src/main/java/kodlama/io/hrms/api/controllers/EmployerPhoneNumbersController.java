package kodlama.io.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.hrms.business.abstracts.EmployerPhoneNumberService;
import kodlama.io.hrms.core.utilities.results.Result;
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
	public Result add(@RequestBody EmployerPhoneNumber employerPhoneNumber) {
		return employerPhoneNumberService.add(employerPhoneNumber);
	}
	
	@GetMapping("getAll")
	public Result getAll() {
		return employerPhoneNumberService.getAll();
	}
}
