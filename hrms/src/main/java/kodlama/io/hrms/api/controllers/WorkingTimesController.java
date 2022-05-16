package kodlama.io.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.WorkingTimeService;
import kodlama.io.hrms.entities.concretes.WorkingTime;

@RestController
@RequestMapping("/api/workingTimes/")
@CrossOrigin
public class WorkingTimesController {
	
	private WorkingTimeService workingTimeService;
	@Autowired
	public WorkingTimesController(WorkingTimeService workingTimeService) {
		this.workingTimeService = workingTimeService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody WorkingTime workingTime){
		var result = workingTimeService.add(workingTime);
		if(!result.isSuccess()) return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<?> getAll(){
		var result = workingTimeService.getAll();
		if(!result.isSuccess()) return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
}
