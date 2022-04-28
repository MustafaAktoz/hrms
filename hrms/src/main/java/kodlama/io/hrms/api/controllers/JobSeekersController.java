package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
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
	public Result add(@RequestBody JobSeeker jobSeeker) {
		return jobSeekerService.add(jobSeeker);
	}
	
	@GetMapping("getAll")
	public DataResult<List<JobSeeker>> getAll(){
		return jobSeekerService.getAll();
	}
}
