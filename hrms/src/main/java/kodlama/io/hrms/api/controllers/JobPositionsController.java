package kodlama.io.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobPositions/")
@CrossOrigin
public class JobPositionsController {
	
	private JobPositionService jobPositionService;
	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		this.jobPositionService = jobPositionService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody JobPosition jobPosition){
		var result = jobPositionService.add(jobPosition);
		if(!result.isSuccess())return ResponseEntity.badRequest().body(result);
			
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<?> getAll(){
		var result = jobPositionService.getAll();
		if(!result.isSuccess())return ResponseEntity.badRequest().body(result);
			
		return ResponseEntity.ok(result);
	}
}