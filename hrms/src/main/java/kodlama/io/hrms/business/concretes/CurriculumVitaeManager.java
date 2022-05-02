package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.CurriculumVitaeService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlama.io.hrms.entities.concretes.CurriculumVitae;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService{

	private CurriculumVitaeDao curriculumVitaeDao;
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {
		this.curriculumVitaeDao = curriculumVitaeDao;
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult(Messages.ADDED);
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		var result = curriculumVitaeDao.findAll();
		return new SuccessDataResult<List<CurriculumVitae>>(result,Messages.LISTED);
	}
}
