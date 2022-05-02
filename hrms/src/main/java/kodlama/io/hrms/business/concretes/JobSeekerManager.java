package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.business.BusinessRules;
import kodlama.io.hrms.core.utilities.checks.email.abstracts.EmailCheckService;
import kodlama.io.hrms.core.utilities.checks.person.Person;
import kodlama.io.hrms.core.utilities.checks.person.asbtracts.PersonCheckService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private UserService userService;
	private PersonCheckService personCheckService;
	private EmailCheckService emailCheckService;
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserService userService ,PersonCheckService personCheckService,EmailCheckService emailCheckService) {
		this.jobSeekerDao = jobSeekerDao;
		this.userService=userService;
		this.personCheckService=personCheckService;
		this.emailCheckService=emailCheckService;
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		
		var result = BusinessRules.Run(
				userService.checkIfEmailAlreadyExists(jobSeeker.getEmail()),
				checkIfNationalityIdentityAlreadyExists(jobSeeker.getNationalityIdentity()));
		if(!result.isSuccess()) return result;
		
		var personCheckResult=personCheckService.check(new Person(jobSeeker.getFirstName(),jobSeeker.getLastName(),jobSeeker.getNationalityIdentity(),jobSeeker.getYearOfBirth()));
		if(!personCheckResult.isSuccess()) return personCheckResult;
		
		var emailCheckResult=emailCheckService.check(jobSeeker.getEmail());
		if(!emailCheckResult.isSuccess()) return emailCheckResult;
		
		jobSeekerDao.save(jobSeeker);
		return new SuccessResult(Messages.ADDED);
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		var result = jobSeekerDao.findAll();
		return new SuccessDataResult<List<JobSeeker>>(result,Messages.LISTED);
	}
	

	private Result checkIfNationalityIdentityAlreadyExists(String nationalityIdentity) {
		var result = jobSeekerDao.getByNationalityIdentity(nationalityIdentity);
		if(result!=null) return new ErrorResult(Messages.NATIONALITY_IDENTITY_ALREADY_EXIST);
		
		return new SuccessResult();
	}
}