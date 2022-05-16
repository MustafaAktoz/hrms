package kodlama.io.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.JobAdvertisementDetailDto;
import kodlama.io.hrms.entities.dtos.UpdateConfirmationDto;
import kodlama.io.hrms.entities.dtos.UpdateStatusDto;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
	Result updateStatus(UpdateStatusDto updateStatusDto);
	Result updateConfirmation(UpdateConfirmationDto updateConfirmationDto);
	DataResult<JobAdvertisement> getById(int id);
	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<JobAdvertisementDetailDto> getDetailById(int id);
	DataResult<List<JobAdvertisementDetailDto>> getDetails();
	DataResult<List<JobAdvertisementDetailDto>> getActiveDetails();
	DataResult<List<JobAdvertisementDetailDto>> getPassiveDetails();
	DataResult<List<JobAdvertisementDetailDto>> getUnconfirmedDetails();
	DataResult<List<JobAdvertisementDetailDto>> getActiveDetailsByDate(LocalDate date);
	DataResult<List<JobAdvertisementDetailDto>> getActiveDetailsByEmployerUserId(int employerUserId);
}
