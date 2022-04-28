package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobPositions/")
public class JobPositionsController {
	
	private JobPositionService jobPositionService;
	@Autowired
	public JobPositionsController(JobPositionService jobPositionService) {
		this.jobPositionService = jobPositionService;
	}
	
	@GetMapping("add")
	public Result add(JobPosition jobPosition){
		 return jobPositionService.add(jobPosition);
	}
	
	@GetMapping("getAll")
	public DataResult<List<JobPosition>> getAll(){
		 return jobPositionService.getAll();
	}
}