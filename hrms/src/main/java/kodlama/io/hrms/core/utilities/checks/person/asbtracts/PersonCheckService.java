package kodlama.io.hrms.core.utilities.checks.person.asbtracts;

import kodlama.io.hrms.core.utilities.checks.person.Person;
import kodlama.io.hrms.core.utilities.results.Result;

public interface PersonCheckService {
	Result check(Person person);
}
