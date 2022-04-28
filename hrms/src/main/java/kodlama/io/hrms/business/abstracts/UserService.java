package kodlama.io.hrms.business.abstracts;

import kodlama.io.hrms.core.utilities.results.Result;

public interface UserService {
	Result checkIfEmailAlreadyExists(String email);
}
