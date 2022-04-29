package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.business.BusinessRules;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.io.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}
	
	@Override
	public Result add(JobPosition jobPosition) {
		var result = BusinessRules.Run(checkIfNameAlreadyExists(jobPosition.getName()));
		if(!result.isSuccess()) return result;
		
		jobPositionDao.save(jobPosition);
		return new SuccessResult(Messages.ADDED);
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		var result = jobPositionDao.findAll();
		return new SuccessDataResult<List<JobPosition>>(result, Messages.LISTED);
	}

	
	private Result checkIfNameAlreadyExists(String name) {
		var result = jobPositionDao.getByName(name);
		if(result!=null) return new ErrorResult(Messages.NAME_ALREADY_EXIST);
		
		return new SuccessResult();
	}
}