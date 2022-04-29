package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerPhoneNumberService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerPhoneNumberDao;
import kodlama.io.hrms.entities.concretes.EmployerPhoneNumber;

@Service
public class EmployerPhoneNumberManager implements EmployerPhoneNumberService {

	private EmployerPhoneNumberDao employerPhoneNumberDao;
	@Autowired
	public EmployerPhoneNumberManager(EmployerPhoneNumberDao employerPhoneNumberDao) {
		this.employerPhoneNumberDao = employerPhoneNumberDao;
	}

	@Override
	public Result add(EmployerPhoneNumber employerPhoneNumber) {
		employerPhoneNumberDao.save(employerPhoneNumber);
		return new SuccessResult(Messages.ADDED);
	}

	@Override
	public DataResult<List<EmployerPhoneNumber>> getAll() {
		var result=employerPhoneNumberDao.findAll();
		return new SuccessDataResult<List<EmployerPhoneNumber>>(result, Messages.LISTED);
	}
}