package kodlama.io.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.WorkingTypeService;
import kodlama.io.hrms.entities.concretes.WorkingType;

@RestController
@RequestMapping("/api/workingTypes/")
@CrossOrigin
public class WorkingTypesController {

	private WorkingTypeService workingTypeService;
	@Autowired
	public WorkingTypesController(WorkingTypeService workingTypeService) {
		this.workingTypeService = workingTypeService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody WorkingType workingType){
		var result = workingTypeService.add(workingType);
		if(!result.isSuccess()) return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<?> getAll(){
		var result = workingTypeService.getAll();
		if(!result.isSuccess()) return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
}
