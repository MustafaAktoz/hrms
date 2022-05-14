package kodlama.io.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/jobSeekers/")
public class JobSeekersController {

	private JobSeekerService jobSeekerService;
	@Autowired
	public JobSeekersController(JobSeekerService jobSeekerService) {
		this.jobSeekerService=jobSeekerService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody JobSeeker jobSeeker) {
		var result = jobSeekerService.add(jobSeeker);
		if(!result.isSuccess())return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<?> getAll(){
		var result = jobSeekerService.getAll();
		if(!result.isSuccess())return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
}
