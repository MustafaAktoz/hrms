package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.business.utilities.check.employer.abstracts.HrmsEmployerCheckService;
import kodlama.io.hrms.core.utilities.business.BusinessRules;
import kodlama.io.hrms.core.utilities.checks.email.abstracts.EmailCheckService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.EmployerDao;
import kodlama.io.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private UserService userService;
	private EmailCheckService emailCheckService;
	private HrmsEmployerCheckService hrmsEmployerCheckService;
	@Autowired
	public EmployerManager(EmployerDao employerDao,UserService userService,EmailCheckService emailCheckService,HrmsEmployerCheckService hrmsEmployerCheckService) {
		this.employerDao = employerDao;
		this.userService = userService;
		this.emailCheckService=emailCheckService;
		this.hrmsEmployerCheckService=hrmsEmployerCheckService;
	}

	@Override
	public Result add(Employer employer) {
		
		var result = BusinessRules.Run(
				tempValidationRules(employer),
				userService.checkIfEmailAlreadyExists(employer.getEmail()));
		if(!result.isSuccess()) return result;
		
		var emailCheckResult = emailCheckService.check(employer.getEmail());
		if(!emailCheckResult.isSuccess()) return emailCheckResult;
		
		var employerCheckResult = hrmsEmployerCheckService.check(employer);
		if(!employerCheckResult.isSuccess()) return employerCheckResult;

		employerDao.save(employer);
		return new SuccessResult(Messages.ADDED);
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		var result = employerDao.findAll();
		return new SuccessDataResult<List<Employer>>(result,Messages.LISTED);
	}
	

	private Result tempValidationRules(Employer employer) {
		if(employer.getCompanyName()==null)return new ErrorResult("Şirket adı boş olamaz");
		if(employer.getWebAddress()==null)return new ErrorResult("Web adresi boş olamaz");
		if(employer.getEmail()==null)return new ErrorResult("Email boş olamaz");
		if(employer.getPassword()==null)return new ErrorResult("Şifre boş olamaz");
		
		return new SuccessResult();
	}
}