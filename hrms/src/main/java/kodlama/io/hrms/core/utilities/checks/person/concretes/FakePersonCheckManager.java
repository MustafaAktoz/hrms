package kodlama.io.hrms.core.utilities.checks.person.concretes;

import kodlama.io.hrms.core.utilities.checks.person.Person;
import kodlama.io.hrms.core.utilities.checks.person.asbtracts.PersonCheckService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;

public class FakePersonCheckManager implements PersonCheckService{

	@Override
	public Result check(Person person) {
		return new SuccessResult();
	}

}
