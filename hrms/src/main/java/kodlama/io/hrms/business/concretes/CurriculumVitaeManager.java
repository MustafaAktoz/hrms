package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.business.abstracts.CurriculumVitaeService;
import kodlama.io.hrms.business.constants.Messages;
import kodlama.io.hrms.core.utilities.helpers.file.abstracts.FileHelper;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlama.io.hrms.entities.concretes.CurriculumVitae;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService{

	private CurriculumVitaeDao curriculumVitaeDao;
	private FileHelper fileHelper;
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao, FileHelper fileHelper) {
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.fileHelper = fileHelper;
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae, MultipartFile file) {
		var uploadImageResult = fileHelper.upload(file);
		if(!uploadImageResult.isSuccess()) return new ErrorResult(uploadImageResult.getMessage());
		
		curriculumVitae.setPhotoPath(uploadImageResult.getData());
		curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult(Messages.ADDED);
	}

	@Override
	public Result delete(CurriculumVitae curriculumVitae) {
		var result = curriculumVitaeDao.getById(curriculumVitae.getId());
		
		var deleteImageResult = fileHelper.delete(result.getPhotoPath());
		if(!deleteImageResult.isSuccess()) return deleteImageResult;
		
		curriculumVitaeDao.delete(result);
		return new SuccessResult(Messages.DELETED);
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		var result = curriculumVitaeDao.findAll();
		return new SuccessDataResult<List<CurriculumVitae>>(result,Messages.LISTED);
	}

	@Override
	public DataResult<List<CurriculumVitae>> getByJobSeekerId(int jobSeekerId) {
		var result = curriculumVitaeDao.getByJobSeekerId(jobSeekerId);
		return new SuccessDataResult<List<CurriculumVitae>>(result,Messages.LISTED);
	}
}