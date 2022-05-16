package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.WorkingTypeService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.WorkingTypeDao;
import kodlama.io.hrms.entities.concretes.WorkingType;

@Service
public class WorkingTypeManager implements WorkingTypeService{

	private WorkingTypeDao workingTypeDao;
	@Autowired
	public WorkingTypeManager(WorkingTypeDao workingTypeDao) {
		this.workingTypeDao = workingTypeDao;
	}
	
	@Override
	public Result add(WorkingType workingType) {
		workingTypeDao.save(workingType);
		return new SuccessResult(Messages.ADDED);
	}

	@Override
	public DataResult<List<WorkingType>> getAll() {
		var result = workingTypeDao.findAll();
		return new SuccessDataResult<List<WorkingType>>(result, Messages.ADDED);
	}

}
