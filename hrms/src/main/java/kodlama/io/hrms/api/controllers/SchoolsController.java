package kodlama.io.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.SchoolService;
import kodlama.io.hrms.entities.concretes.School;

@RestController
@RequestMapping("/api/schools/")
public class SchoolsController {

	private SchoolService schoolService;
	@Autowired
	public SchoolsController(SchoolService schoolService) {
		this.schoolService = schoolService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody School school){
		var result = schoolService.add(school);
		if(!result.isSuccess()) return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<?> getAll(){
		var result = schoolService.getAll();
		if(!result.isSuccess()) return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("getAllAndSortByEndDateInReverse")
	public ResponseEntity<?> getAllAndSortByEndDateInReverse(){
		var result = schoolService.getAllAndSortByEndYearInReverse();
		if(!result.isSuccess()) return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
}
