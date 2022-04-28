package kodlama.io.hrms.business.utilities.check.employer.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;

public interface HrmsEmployerCheckService {
	Result check(Employer employer);
}
