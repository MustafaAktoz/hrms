package kodlama.io.hrms.api.controllers;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.UpdateStatusDto;

@CrossOrigin
@RestController
@RequestMapping("/api/jobAdvertisements/")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement) {
		var result = jobAdvertisementService.add(jobAdvertisement);
		if(!result.isSuccess())return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("updateStatus")
	public ResponseEntity<?> updateStatus(@Valid @RequestBody UpdateStatusDto updateStatusDto) {
		var result = jobAdvertisementService.updateStatus(updateStatusDto);
		if(!result.isSuccess())return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("getById")
	public ResponseEntity<?> getById(@RequestParam int id) {
		var result = jobAdvertisementService.getById(id);
		if(!result.isSuccess())return ResponseEntity.badRequest().body(result);
			
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("getAll")
	public ResponseEntity<?> getAll() {
		var result = jobAdvertisementService.getAll();
		if(!result.isSuccess())return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("getDetails")
	public ResponseEntity<?> getDetails() {
		var result = jobAdvertisementService.getDetails();
		if(!result.isSuccess())return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("getDetailsByStatus")
	public ResponseEntity<?> getDetailsByStatus(@RequestParam boolean status) {
		var result = jobAdvertisementService.getDetailsByStatus(status);
		if(!result.isSuccess())return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("getActiveDetailsByDate")
	public ResponseEntity<?> getActiveDetailsByDate(@RequestParam LocalDate date) {
		var result = jobAdvertisementService.getActiveDetailsByDate(date);
		if(!result.isSuccess())return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("getActiveDetailsByEmployerUserId")
	public ResponseEntity<?> getActiveDetailsByEmployerUserId(@RequestParam int employerUserId) {
		var result = jobAdvertisementService.getActiveDetailsByEmployerUserId(employerUserId);
		if(!result.isSuccess())return ResponseEntity.badRequest().body(result);
		
		return ResponseEntity.ok(result);
	}
}