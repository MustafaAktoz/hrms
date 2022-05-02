package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.SchoolService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.SchoolDao;
import kodlama.io.hrms.entities.concretes.School;

@Service
public class SchoolManager implements SchoolService{

	private SchoolDao schoolDao;
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}

	@Override
	public Result add(School school) {
		schoolDao.save(school);
		return new SuccessResult(Messages.ADDED);
	}

	@Override
	public DataResult<List<School>> getAll() {
		var result = schoolDao.findAll();
		return new SuccessDataResult<List<School>>(result, Messages.LISTED);
	}

	@Override
	public DataResult<List<School>> getAllAndSortByEndYearInReverse() {
		var sort = Sort.by(Sort.Direction.DESC,"endYear");
		var result = schoolDao.findAll(sort);
		
		for (School school : result) 
			if(school.getEndYear()==null) school.setEndYear(Messages.CONTINUES);
		
		return new SuccessDataResult<List<School>>(result, Messages.LISTED);
	}

}
