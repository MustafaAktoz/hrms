package kodlama.io.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.ProgrammingLanguageService;
import kodlama.io.hrms.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programmingLanguages/")
public class ProgrammingLanguagesController {
	
	private ProgrammingLanguageService programmingLanguageService;
	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody ProgrammingLanguage programmingLanguage){
		var result = programmingLanguageService.add(programmingLanguage);
		if(!result.isSuccess()) return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<?> getAll(){
		var result = programmingLanguageService.getAll();
		if(!result.isSuccess()) return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
}
