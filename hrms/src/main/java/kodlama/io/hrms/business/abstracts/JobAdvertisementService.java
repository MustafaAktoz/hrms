package kodlama.io.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.JobAdvertisementDetailDto;
import kodlama.io.hrms.entities.dtos.UpdateStatusDto;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
	Result updateStatus(UpdateStatusDto updateStatusDto);
	DataResult<List<JobAdvertisementDetailDto>> getDetailsByStatus(boolean status);
	DataResult<List<JobAdvertisementDetailDto>> getActiveDetailsByDate(LocalDate date);
	DataResult<List<JobAdvertisementDetailDto>> getActiveDetailsByEmployerUserId(int employerUserId);
}
