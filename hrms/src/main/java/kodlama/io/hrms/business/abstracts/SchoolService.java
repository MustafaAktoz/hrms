package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.School;

public interface SchoolService {
	Result add(School school);
	DataResult<List<School>> getAll();
	DataResult<List<School>> getAllAndSortByEndYearInReverse();
}
