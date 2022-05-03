package kodlama.io.hrms.core.utilities.helpers.file.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;

public interface FileHelper {
	DataResult<String> upload(MultipartFile file);
	Result delete(String imagePath);
}
