package kodlama.io.hrms.core.utilities.checks.email.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;

public interface EmailCheckService {
	Result check(String email);
}