package kodlama.io.hrms.business.utilities.check.employer.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.utilities.check.employer.abstracts.HrmsEmployerCheckService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.entities.concretes.Employer;

@Service
public class FakeHrmsEmployerCheckManager implements HrmsEmployerCheckService {

	@Override
	public Result check(Employer employer) {
		return new SuccessResult();
	}
}