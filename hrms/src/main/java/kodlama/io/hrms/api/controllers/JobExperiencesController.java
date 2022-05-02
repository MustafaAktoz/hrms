package kodlama.io.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.entities.concretes.JobExperience;

@RestController
@RequestMapping("/api/jobExperiences/")
public class JobExperiencesController {

	private JobExperienceService jobExperienceService;
	@Autowired
	public JobExperiencesController(JobExperienceService jobExperienceService) {
		this.jobExperienceService = jobExperienceService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody JobExperience jobExperience){
		var result = jobExperienceService.add(jobExperience);
		if(!result.isSuccess()) return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<?> getAll(){
		var result = jobExperienceService.getAll();
		if(!result.isSuccess()) return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("getAllAndSortByEndYearInReverse")
	public ResponseEntity<?> getAllAndSortByEndYearInReverse(){
		var result = jobExperienceService.getAllAndSortByEndYearInReverse();
		if(!result.isSuccess()) return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
}
