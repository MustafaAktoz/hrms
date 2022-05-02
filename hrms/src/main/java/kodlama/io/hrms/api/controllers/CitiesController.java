package kodlama.io.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import kodlama.io.hrms.business.abstracts.CityService;
import kodlama.io.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities/")
public class CitiesController {
	
	private CityService cityService;
	@Autowired
	public CitiesController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody City city) {
		var result = cityService.add(city);
		if(!result.isSuccess()) ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<?> getAll(){
		var result = cityService.getAll();
		if(!result.isSuccess()) ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
}
