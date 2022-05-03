package kodlama.io.hrms.core.utilities.helpers.file.concretes;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.constants.Messages;
import kodlama.io.hrms.core.utilities.helpers.file.abstracts.FileHelper;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;

public class FakeImageFileHelper implements FileHelper{

	@Override
	public DataResult<String> upload(MultipartFile file) {
		return new SuccessDataResult<String>("default.png", Messages.ImageUploded) ;
	}

	@Override
	public Result delete(String imagePath) {
		return new SuccessResult(Messages.ImageDeleted);
	}
}