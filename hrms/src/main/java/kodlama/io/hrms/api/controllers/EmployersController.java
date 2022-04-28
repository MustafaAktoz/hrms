package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
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
	public Result add(@RequestBody Employer employer) {
		return employerService.add(employer);
	}
	
	@GetMapping("getAll")
	public DataResult<List<Employer>> getAll(){
		return employerService.getAll();
	}
}
