package kodlama.io.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.CurriculumVitaeService;
import kodlama.io.hrms.entities.concretes.CurriculumVitae;

@RestController
@RequestMapping("/api/curriculumVitaes/")
public class CurriculumVitaesController {
	
	private CurriculumVitaeService curriculumVitaeService;
	@Autowired
	public CurriculumVitaesController(CurriculumVitaeService curriculumVitaeService) {
		this.curriculumVitaeService = curriculumVitaeService;
	}

	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody CurriculumVitae curriculumVitae, @RequestParam MultipartFile file){
		var result = curriculumVitaeService.add(curriculumVitae, file);
		if(!result.isSuccess()) return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<?> getAll(){
		var result = curriculumVitaeService.getAll();
		if(!result.isSuccess()) return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("getByJobSeekerId")
	public ResponseEntity<?> getByJobSeekerId(@RequestParam int jobSeekerId){
		var result = curriculumVitaeService.getByJobSeekerId(jobSeekerId);
		if(!result.isSuccess()) return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
}
