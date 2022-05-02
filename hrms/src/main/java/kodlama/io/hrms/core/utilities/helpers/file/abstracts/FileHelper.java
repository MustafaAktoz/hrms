package kodlama.io.hrms.core.utilities.helpers.file.abstracts;

import org.springframework.web.multipart.MultipartFile;

public interface FileHelper {
	String upload(MultipartFile file);
	void delete(String imagePath);
}
