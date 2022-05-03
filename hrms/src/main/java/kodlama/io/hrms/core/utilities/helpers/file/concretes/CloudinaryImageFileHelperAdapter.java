package kodlama.io.hrms.core.utilities.helpers.file.concretes;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import kodlama.io.hrms.core.constants.Messages;
import kodlama.io.hrms.core.utilities.helpers.file.abstracts.FileHelper;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorDataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;

@Service
public class CloudinaryImageFileHelperAdapter implements FileHelper{

	private Cloudinary cloudinary;
    public CloudinaryImageFileHelperAdapter() {
    	cloudinary = new Cloudinary(ObjectUtils.asMap(
    			  "cloud_name", "dk0uttd5y",
    			  "api_key", "654643122756831",
    			  "api_secret", "JkYxXN-tG7by-j5EeZHKfv65gmY"));
    }
	
	@Override
	public DataResult<String> upload(MultipartFile file){
		try {
			var uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
			String imagePath = uploadResult.get("url").toString();
			System.out.println(uploadResult.get("public_id"));
			return new SuccessDataResult<String>(imagePath, Messages.ImageUploded);
		} catch (Exception e) {
			return new ErrorDataResult<String>(null, Messages.ImageFailedToLoad);
		}
	}

	@Override
	public Result delete(String imagePath) {
		try {
			int beginIndex = imagePath.lastIndexOf('/')+1;
			int endIndex = imagePath.lastIndexOf('.');
			var publicId = imagePath.substring(beginIndex, endIndex);
			cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
			return new SuccessResult(Messages.ImageDeleted);
		} catch (Exception e) {
			return new ErrorDataResult<String>(null, Messages.ImageCouldNotBeDeleted);
		}
	}
}
