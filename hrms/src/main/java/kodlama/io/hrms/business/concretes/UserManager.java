package kodlama.io.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.dataAccess.abstracts.UserDao;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	@Autowired
	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public Result checkIfEmailAlreadyExists(String email) {
		var result = userDao.getByEmail(email);
		if(result!=null) return new ErrorResult(Messages.EMAIL_ALREADY_EXIST);
		
		return new SuccessResult();
	}
}