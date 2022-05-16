package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.WorkingType;

public interface WorkingTypeService {
	Result add(WorkingType workingType);
	DataResult<List<WorkingType>> getAll();
}
