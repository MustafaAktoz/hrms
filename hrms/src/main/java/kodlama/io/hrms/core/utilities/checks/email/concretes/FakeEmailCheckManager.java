package kodlama.io.hrms.core.utilities.checks.email.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.core.utilities.checks.email.abstracts.EmailCheckService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;

@Service
public class FakeEmailCheckManager implements EmailCheckService {
	@Override
	public Result check(String email) {
		return new SuccessResult();
	}
}