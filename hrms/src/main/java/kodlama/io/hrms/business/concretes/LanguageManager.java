package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.LanguageService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.LanguageDao;
import kodlama.io.hrms.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{

	private LanguageDao languageDao;
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		this.languageDao = languageDao;
	}
	
	@Override
	public Result add(Language language) {
		languageDao.save(language);
		return new SuccessResult(Messages.ADDED);
	}
	
	@Override
	public DataResult<List<Language>> getAll() {
		var result = languageDao.findAll();
		return new SuccessDataResult<List<Language>>(result, Messages.ADDED);
	}
}
