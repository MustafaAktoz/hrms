package kodlama.io.hrms.core.utilities.helpers.file.concretes;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.utilities.helpers.file.abstracts.FileHelper;

@Service
public class FakeImageFileHelper implements FileHelper{

	@Override
	public String upload(MultipartFile file) {
		return "default.png";
	}

	@Override
	public void delete(String imagePath) {
		// TODO Auto-generated method stub
		
	}

}
