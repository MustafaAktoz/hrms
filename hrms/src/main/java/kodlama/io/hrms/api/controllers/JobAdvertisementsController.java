package kodlama.io.hrms.api.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.hrms.business.abstracts.JobAdvertisementService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.JobAdvertisementDetailDto;
import kodlama.io.hrms.entities.dtos.UpdateStatusDto;

@RestController
@RequestMapping("/api/jobAdvertisements/")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return jobAdvertisementService.add(jobAdvertisement);
	}
	
	@PostMapping("updateStatus")
	public Result updateStatus(@RequestBody UpdateStatusDto updateStatusDto) {
		return jobAdvertisementService.updateStatus(updateStatusDto);
	}
	
	@GetMapping("getDetailsByStatus")
	public DataResult<List<JobAdvertisementDetailDto>> getDetailsByStatus(@RequestParam boolean status) {
		return jobAdvertisementService.getDetailsByStatus(status);
	}
	
	@GetMapping("getActiveDetailsByDate")
	public DataResult<List<JobAdvertisementDetailDto>> getActiveDetailsByDate(@RequestParam LocalDate date) {
		return jobAdvertisementService.getActiveDetailsByDate(date);
	}
	
	@GetMapping("getActiveDetailsByEmployerUserId")
	public DataResult<List<JobAdvertisementDetailDto>> getActiveDetailsByEmployerUserId(@RequestParam int employerUserId) {
		return jobAdvertisementService.getActiveDetailsByEmployerUserId(employerUserId);
	}
}