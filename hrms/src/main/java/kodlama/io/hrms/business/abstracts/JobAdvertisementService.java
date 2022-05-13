package kodlama.io.hrms.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobAdvertisement;
import kodlama.io.hrms.entities.dtos.JobAdvertisementDto;
import kodlama.io.hrms.entities.dtos.UpdateStatusDto;

public interface JobAdvertisementService {
	Result add(JobAdvertisement jobAdvertisement);
	Result updateStatus(UpdateStatusDto updateStatusDto);
	DataResult<JobAdvertisement> getById(int id);
	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisementDto>> getDetails();
	DataResult<List<JobAdvertisementDto>> getDetailsByStatus(boolean status);
	DataResult<List<JobAdvertisementDto>> getActiveDetailsByDate(LocalDate date);
	DataResult<List<JobAdvertisementDto>> getActiveDetailsByEmployerUserId(int employerUserId);
}
