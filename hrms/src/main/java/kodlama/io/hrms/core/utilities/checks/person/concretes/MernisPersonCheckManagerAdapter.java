package kodlama.io.hrms.core.utilities.checks.person.concretes;

import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.checks.person.Person;
import kodlama.io.hrms.core.utilities.checks.person.asbtracts.PersonCheckService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;

@Service
public class MernisPersonCheckManagerAdapter implements PersonCheckService {

	@Override
	public Result check(Person person) {
		if(person.getNationalityIdentity().hashCode()!= "12345678910".hashCode())
			return new ErrorResult(Messages.CHECK_YOUR_CREDENTIALS);
		
		return new SuccessResult();
	}

}
