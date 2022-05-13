package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobExperienceService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobExperienceDao;
import kodlama.io.hrms.entities.concretes.JobExperience;

@Service
public class JobExperienceManager implements JobExperienceService {
	
	private JobExperienceDao jobExperienceDao;
	@Autowired
	public JobExperienceManager(JobExperienceDao jobExperienceDao) {
		this.jobExperienceDao = jobExperienceDao;
	}

	@Override
	public Result add(JobExperience jobExperience) {
		jobExperienceDao.save(jobExperience);
		return new SuccessResult(Messages.ADDED);
	}
	
	@Override
	public DataResult<List<JobExperience>> getAll() {
		var result = jobExperienceDao.findAll();
		return new SuccessDataResult<List<JobExperience>>(result,Messages.LISTED);
	}

	@Override
	public DataResult<List<JobExperience>> getAllAndSortByEndYearInReverse() {
		var sort = Sort.by(Sort.Direction.DESC,"endYear");
		var result = jobExperienceDao.findAll(sort);
		
		for (JobExperience jobExperience : result)
			if(jobExperience.getEndYear()==null) jobExperience.setEndYear(Messages.CONTINUES);
		
		return new SuccessDataResult<List<JobExperience>>(result,Messages.LISTED);
	}
}