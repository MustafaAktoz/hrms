package kodlama.io.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CurriculumVitae;

public interface CurriculumVitaeService {
	Result add(CurriculumVitae curriculumVitae, MultipartFile file);
	Result delete(CurriculumVitae curriculumVitae);
	DataResult<List<CurriculumVitae>> getAll();
	DataResult<List<CurriculumVitae>> getByJobSeekerId(int jobSeekerId);
}
