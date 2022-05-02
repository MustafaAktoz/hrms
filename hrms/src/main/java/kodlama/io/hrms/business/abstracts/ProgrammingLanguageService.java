package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.ProgrammingLanguage;

public interface ProgrammingLanguageService {
	Result add(ProgrammingLanguage programmingLanguage);
	DataResult<List<ProgrammingLanguage>> getAll();
}
